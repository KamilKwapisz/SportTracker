from uuid import uuid4
from flask import Flask, jsonify, request
from blockchain import Blockchain

node = Flask(__name__)

node_identifier = str(uuid4()).replace('-', '')  # creating unique node ID

blockchain = Blockchain()


@node.route('/mine', methods=['GET'])
def mine():
    last_block = blockchain.last_block
    last_proof = last_block['proof']
    proof = blockchain.proof_of_work(last_proof)

    blockchain.add_training(
        user="admin",
        training_type="None",
        training_time=0,
        reps=0,
        distance=0
    )

    previous_hash = blockchain.hash(last_block)
    block = blockchain.new_block(proof, previous_hash)

    response = {
        'message': "New block was mined!",
        'index': block['index'],
        'transactions': block['trainings'],
        'proof': block['proof'],
        'previous_hash': block['previous_hash'],
    }

    return jsonify(response), 200


@node.route('/trainings/new', methods=['POST'])
def new_transaction():
    values = request.get_json()

    # Assuring that the required fields are in the POST'ed data
    required = ['user', 'training_type', 'training_time', 'reps', 'distance']
    if not all(value in values for value in required):
        return 'Missing values', 400

    # Create a new training from values given in POST method
    index = blockchain.add_training(values['user'],
                                    values['training_type'],
                                    values['reps'],
                                    values['training_time'],
                                    values['distance']
                                    )

    # now we can calculate how many points user should get for accomplishing this training
    given_points = blockchain.calculate_points(values)

    return str(given_points), 201  # return user's points and 201 code


@node.route('/chain', methods=['GET'])
def full_chain():
    response = {
        'chain': blockchain.chain,
        'length': len(blockchain.chain),
    }
    return jsonify(response), 200


@node.route('/nodes/register', methods=['POST'])
def register_nodes():
    values = request.get_json()
    nodes = values.get('nodes')

    if not nodes:
        return "Error: Please supply a valid list of nodes", 400

    for single_node in nodes:
        blockchain.register_node(single_node)

    response = {
        'message': 'New nodes have been added',
        'total_nodes': list(blockchain.nodes),
    }
    return jsonify(response), 201


@node.route('/nodes/resolve', methods=['GET'])
def consensus():
    replaced = blockchain.resolve_conflict()

    if replaced:
        response = {
            'message': 'Our chain was replaced',
            'new_chain': blockchain.chain
        }
    else:
        response = {
            'message': 'Our chain is authoritative',
            'chain': blockchain.chain
        }

    return jsonify(response), 200

if __name__ == '__main__':
    node.run()
