import hashlib as hasher
import json
from time import time
from urllib.parse import urlparse
import requests


class Blockchain(object):

    def __init__(self):
        self.chain: list = []
        self.transactions: list = []
        self.nodes: set = set()
        self.new_block(previous_hash=1, proof=100)  # genesis block

    def new_block(self, proof: int, previous_hash=None) -> dict:
        """
        Method creates new block 
        :param proof: int
        :param previous_hash: 
        :return: 
        """
        block: dict = {
            'index': len(self.chain) + 1,
            'timestamp': time(),
            'transactions': self.transactions,
            'proof': proof,
            'previous_hash': previous_hash or self.hash(self.chain[-1]),
        }

        # Reset the current list of transactions
        self.transactions = []

        self.chain.append(block)
        return block

    def add_transaction(self, sender: str, receiver: str, amount: int):
        """
        Method add transaction to a blockchain
        :param sender: str
        :param receiver: str
        :param amount: int
        :return: 
        """
        # Adds a new transaction to the list of transactions
        self.transactions.append({
            'sender': sender,
            'receiver': receiver,
            'amount': amount,
        })

        return self.last_block['index'] + 1

    @staticmethod
    def hash(block: dict):
        """
        Hashes a Block. Sort keys have to be true in order to prevent data inconsistency
        :param block: dict with block's data
        :return: hash created with sha256 algorithm
        """
        block_str: str = json.dumps(block, sort_keys=True).encode()
        return hasher.sha256(block_str).hexdigest()

    @property
    def last_block(self):
        """
        :return: last Block in the chain
        """
        return self.chain[-1]

    def proof_of_work(self, last_proof: int):
        """
        Method increments proof int value in order to find the one that has hash which ends with 0000
        :param last_proof: last proof of work integer, it's hash ends with 0000
        :return: validated proof of work integer
        """
        proof: int = 0

        while not self.proof_validation(last_proof, proof):
            proof += 1

        return proof

    @staticmethod
    def proof_validation(last_proof: int, proof: int) -> bool:
        """
        Mehod is validating if proof of work was completed and hashed value ends with 0000
        :param last_proof: last proof of work integer, it's hash ends with 0000
        :param proof: integer, hash of validated proof should end with 0000 
        :return: bool
        """
        guess = f'{last_proof}{proof}'.encode()
        guess_hash = hasher.sha256(guess).hexdigest()
        return guess_hash[:4] == "0000"

    def register_node(self, address: str):
        """
        Parses url from given adress and adds it to nodes set
        :param address: string containing node adress
        :raise: 
        """
        parsed_url = urlparse(address)
        self.nodes.add(parsed_url.netloc)

    def is_chain_valid(self, chain: list) -> bool:
        """
        Validates chain
        :param chain: list containing all valid blocks
        :return: true if chain is valid
        """
        last_block = chain[0]
        current_index = 1

        while current_index < len(chain):
            block = chain[current_index]
            print(f'{last_block}')
            print(f'{block}')
            print("\n-----------\n")
            if block['previous_hash'] != self.hash(last_block):
                return False

            if not self.proof_validation(last_block['proof'], block['proof']):
                return False

            last_block = block
            current_index += 1

        return True

    def resolve_conflict(self):
        """
        Consensus implementation
        method resolve conflict and decide whether chain is the authoritative or not
        :return: true if chain is authoritative
        """
        neighbours: set = self.nodes
        new_chain = None

        max_len = len(self.chain)

        for node in neighbours:
            r = requests.get(f'http://{node}/chain')

            if r.status_code == 200:
                length = r.json()['length']
                chain = r.json()['chain']

                if length > max_len and self.is_chain_valid(chain):
                    max_len = length
                    new_chain = chain

        if new_chain:
            self.chain = new_chain
            return True

        return False
