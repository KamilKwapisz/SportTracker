import unittest
import hashlib as hasher
from blockchain import Blockchain


class TestBlockchain(unittest.TestCase):

    blockchain = Blockchain()

    def test_new_block(self):
        """
        Test created block in blockchain
        """
        block = self.blockchain.new_block(proof=33, previous_hash="000000")
        self.assertEqual(type(block), dict, "checking block type")
        self.assertEqual(block['index'], len(self.blockchain.chain), "checking created block id")
        self.assertEqual(block['proof'], 33, "checking proof")

    def test_add_training(self):
        user: str = "admin"
        training_type: str = "running"
        reps: int = 0
        training_time: float = 30.5
        distance: int = 6500

        index = self.blockchain.add_training(user, training_type, reps, training_time, distance)

        self.assertEqual(index, len(self.blockchain.trainings)+1, "checking to which block training will be added")
        training = self.blockchain.trainings[-1]
        self.assertEqual(type(training), dict, "assuring that training is a dict")
        self.assertEqual(training['user'], user, "checking training's username")
        self.assertEqual(training['training_type'], training_type, "checking training's type")
        self.assertEqual(training['reps'], reps, "checking training's reps")
        self.assertEqual(training['training_time'], training_time, "checking training's time")
        self.assertEqual(training['distance'], distance, "checking training's distance")

    def test_hash(self):
        testing_dict: dict = {
                            "1": 1,
                            "2": 2,
                            "3": 3
                              }
        hash1 = self.blockchain.hash(testing_dict)
        hash2 = self.blockchain.hash({"1": 1, "2": 2, "3": 3})

        self.assertEqual(len(hash1), 64, "checking hashes len")
        self.assertEqual(hash1, hash2, "checking if same dict has same hash")

    def test_proof_of_work_algorithm(self):
        proof_value = self.blockchain.proof_of_work(33)
        guess = f'33{proof_value}'.encode()
        guess_hash = hasher.sha256(guess).hexdigest()

        self.assertEqual(guess_hash[:4], "0000", "checking if proof of work algorithm works properly")

    def test_node_registering(self):
        self.blockchain.nodes = []
        node_url = "http://www.ee.pw.edu.pl/"
        node2_url = "pw.edu.pl"
        self.blockchain.register_node(node_url)
        self.blockchain.register_node(node2_url)

        self.assertEqual(len(self.blockchain.nodes), 1, "checking if node was correctly added")
        self.assertIn("www.ee.pw.edu.pl", self.blockchain.nodes, "check if valid url was added")
        self.assertNotIn("www.pw.edu.pl", self.blockchain.nodes, "check if invalid url wasn't added ")

    def test_calculate_points(self):
        user: str = "admin"
        training_type: str = "running"
        reps: int = 12
        training_time: float = 30
        distance: int = 6000

        training = {"user": user,
                    "training_type": training_type,
                    "reps": reps,
                    "training_time": training_time,
                    "distance": distance}

        pts = self.blockchain.calculate_points(training)

        self.assertEqual(pts, 15, "checking if pts calculator works fine")

    def test_resolve_conflict(self):
        self.assertTrue(self.blockchain.resolve_conflict(), "testing if chain is found to be authoritative")

    def test_chain_validation(self):
        self.assertTrue(self.blockchain.is_chain_valid(self.blockchain.chain), "validation on a valid chain")

        # spoiling chain
        self.blockchain.new_block(proof=33, previous_hash="000000")
        self.blockchain.new_block(proof=213, previous_hash="33")
        self.blockchain.chain[0]['proof'] = 99999

        self.assertFalse(self.blockchain.is_chain_valid(self.blockchain.chain), "validation on an invalid chain")


if __name__ == "__main__":
    unittest.main()
