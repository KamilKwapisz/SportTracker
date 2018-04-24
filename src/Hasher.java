
public class Hasher {
    public static String hash(String word){
        // commons-codec-1.11.jat library is required
        String hashed = org.apache.commons.codec.digest.DigestUtils.sha256Hex( word );
        return hashed;
    }

    public static void main( String [] args ) {
        String word = "Hello World!";
        System.out.println("Word: " + word);
        word = hash(word);
        System.out.println("Hashed word: " + word);
    }
}
