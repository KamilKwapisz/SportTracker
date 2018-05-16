package tests;
import core.Hasher;
import static org.assertj.core.api.Assertions.*;

public class TestHasher {

    private static void testHash() {
        String str1 = "TestoweHasloDoHashowania";
        String str2 = "Testowe" + "Haslo" + "Do" + "Hashowania";

        Hasher hasher = new Hasher();

        assertThat( hasher.hash(str1) )
                .as("Checking if 2 same strings has same hashes")
                .isEqualTo( hasher.hash(str2) );

        assertThat( hasher.hash(str1) )
                .as("Checking if 2 different strings doesn't have same hashes")
                .isNotEqualTo( hasher.hash("not") );

        assertThat( hasher.hash("0") )
                .as("checking if hashes length is equal 64")
                .hasSize(64);

    }

    public static void main(String[] args) {
        testHash();
    }

}
