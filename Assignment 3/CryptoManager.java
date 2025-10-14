package application; 
/**
 * This is a utility class that encrypts and decrypts a phrase using three
 * different approaches. 
 * 
 * The first approach is called the Vigenere Cipher.Vigenere encryption 
 * is a method of encrypting alphabetic text based on the letters of a keyword.
 * 
 * The second approach is Playfair Cipher. It encrypts two letters (a digraph) 
 * at a time instead of just one.
 * 
 * The third approach is Caesar Cipher. It is a simple replacement cypher. 
 * 
 * @author Huseyin Aygun
 * @version 8/3/2025
 */

public class CryptoManager { 

    private static final char LOWER_RANGE = ' ';
    private static final char UPPER_RANGE = '_';
    private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;
    // Use 64-character matrix (8X8) for Playfair cipher  
    private static final String ALPHABET64 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789 !\"#$%&'()*+,-./:;<=>?@[\\]^_";
    public static boolean isStringInBounds(String plainText) {
        for (int i = 0; i < plainText.length(); i++) {
            if (!(plainText.charAt(i) >= LOWER_RANGE && plainText.charAt(i) <= UPPER_RANGE)) {
                return false;
            }
        }
        return true;
    }

	/**
	 * Vigenere Cipher is a method of encrypting alphabetic text 
	 * based on the letters of a keyword. It works as below:
	 * 		Choose a keyword (e.g., KEY).
	 * 		Repeat the keyword to match the length of the plaintext.
	 * 		Each letter in the plaintext is shifted by the position of the 
	 * 		corresponding letter in the keyword (A = 0, B = 1, ..., Z = 25).
	 */   

    public static String vigenereEncryption(String plainText, String key) {
         //to be implemented by students
   
    	String str ="";
    	String newKey = "";
    	int len1 = plainText.length(), len2 = key.length();
     	int[] arr1 = new int[len1];
     	int arr2[] = new int[len1];
     	int arr3[] = new int [len1];
    	int difference = len1 - len2; 
    	
    		for (int j = 0; j < (len1/len2);j++ ) {
    			newKey = newKey.concat(key);
    		}
    		 for(int i=0;i<(difference%len2);i++) {
    			 newKey+=key.charAt(i);
    		 }
    		 for(int k = 0; k<len1;k++) {
    			 arr1[k] = plainText.charAt(k) - 32;
    			 arr2[k] = newKey.charAt(k) - 32;
    			 arr3[k] = (arr1[k] + arr2[k]) % 64;
    			 str += (char)(arr3[k] + 32);
    		 }
    	return str;
    }

    // Vigenere Decryption
    public static String vigenereDecryption(String encryptedText, String key) {
         //to be implemented by students
    	String str = "";
        String newKey = "";
        int len1 = encryptedText.length(), len2 = key.length();
        int[] arr1 = new int[len1];
        int[] arr2 = new int[len1];
        int[] arr3 = new int[len1];
        int difference = len1 - len2;

        for (int j = 0; j < (len1 / len2); j++) {
            newKey = newKey.concat(key);
        }
        for (int i = 0; i < (difference % len2); i++) {
            newKey += key.charAt(i);
        }
        for (int k = 0; k < len1; k++) {
            arr1[k] = encryptedText.charAt(k) - 'A';
            arr2[k] = newKey.charAt(k) - 'A';
            arr3[k] = (arr1[k] - arr2[k] + 64) % 64;
            str += (char)(arr3[k] + 32);
        }

        return str;
    }
	/**
	 * Playfair Cipher encrypts two letters at a time instead of just one.
	 * It works as follows:
	 * A matrix (8X8 in our case) is built using a keyword
	 * Plaintext is split into letter pairs (e.g., ME ET YO UR).
	 * Encryption rules depend on the positions of the letters in the matrix:
	 *     Same row: replace each letter with the one to its right.
	 *     Same column: replace each with the one below.
	 *     Rectangle: replace each letter with the one in its own row but in the column of the other letter in the pair.
	 */    
 // Playfair Encryption
    public static String playfairEncryption(String plainText, String key) {
        String str = "";

        String fullKey = "";
        for (int i = 0; i < (key + ALPHABET64).length(); i++) {
            char ch = (key + ALPHABET64).charAt(i);
            if (fullKey.indexOf(ch) == -1) {
            	fullKey += ch;
            }
        }

        char[][] matrix = new char[8][8];
        int index = 0;
        for (int r = 0; r < 8; r++)
            for (int c = 0; c < 8; c++)
                matrix[r][c] = fullKey.charAt(index++);

        if (plainText.length() % 2 != 0) {
        	plainText += 'X';
        }
        for (int i = 0; i < plainText.length(); i += 2) {
            char a = plainText.charAt(i);
            char b = (i + 1 < plainText.length()) ? plainText.charAt(i + 1) : 'X';
            if (a == b) {
            	b = 'X';
            }

            int r1 = 0, c1 = 0, r2 = 0, c2 = 0;
            for (int r = 0; r < 8; r++)
                for (int c = 0; c < 8; c++) {
                    if (matrix[r][c] == a) { 
                    	r1 = r; 
                    	c1 = c; 
                    	}
                    if (matrix[r][c] == b) { 
                    	r2 = r; 
                    	c2 = c; 
                    	}
                }

            if (r1 == r2) { 
                str += matrix[r1][(c1 + 1) % 8];
                str += matrix[r2][(c2 + 1) % 8];
            } else if (c1 == c2) { 
                str += matrix[(r1 + 1) % 8][c1];
                str += matrix[(r2 + 1) % 8][c2];
            } else { 
                str += matrix[r1][c2];
                str += matrix[r2][c1];
            }
        }
        return str;
    }

    // Playfair Decryption
    public static String playfairDecryption(String encryptedText, String key) {
        String str = "";

        String fullKey = "";
        for (int i = 0; i < (key + ALPHABET64).length(); i++) {
            char ch = (key + ALPHABET64).charAt(i);
            if (fullKey.indexOf(ch) == -1) {
            	fullKey += ch;
            }
        }

        char[][] matrix = new char[8][8];
        int idx = 0;
        for (int r = 0; r < 8; r++)
            for (int c = 0; c < 8; c++)
                matrix[r][c] = fullKey.charAt(idx++);

        for (int i = 0; i < encryptedText.length(); i += 2) {
            char a = encryptedText.charAt(i);
            char b = encryptedText.charAt(i + 1);

            int r1 = 0, c1 = 0, r2 = 0, c2 = 0;
            for (int r = 0; r < 8; r++)
                for (int c = 0; c < 8; c++) {
                    if (matrix[r][c] == a) { 
                    	r1 = r; 
                    	c1 = c; 
                    	}
                    if (matrix[r][c] == b) { 
                    	r2 = r; 
                    	c2 = c; 
                    	}
                }

            if (r1 == r2) { 
                str += matrix[r1][(c1 + 7) % 8];
                str += matrix[r2][(c2 + 7) % 8];
            } else if (c1 == c2) { 
                str += matrix[(r1 + 7) % 8][c1];
                str += matrix[(r2 + 7) % 8][c2];
            } else { 
                str += matrix[r1][c2];
                str += matrix[r2][c1];
            }
        }
        return str;
    }
    /**
     * Caesar Cipher is a simple substitution cipher that replaces each letter in a message 
     * with a letter some fixed number of positions down the alphabet. 
     * For example, with a shift of 3, 'A' would become 'D', 'B' would become 'E', and so on.
     */    
    public static String caesarEncryption(String plainText, int key) {
    	//to be implemented by students
        	char c;
        	String str="";
        	for(int i = 0; i < plainText.length(); i++) {
        		if (plainText.charAt(i) + key > 95) {
        		    c = (char) (((plainText.charAt(i) + key - 32) % 64) + 32);
        		} else {
        		    c = (char) (plainText.charAt(i) + key);
        		}
        		str=str.concat(Character.toString(c));
        	}
        	return str;
        }

        // Caesar Decryption
    public static String caesarDecryption(String encryptedText, int key) {
        // to be implemented by students
	        char c;
	        String str = "";
	        for (int i = 0; i < encryptedText.length(); i++) {
	            if (encryptedText.charAt(i) - key < 32) {
	                c = (char) (((encryptedText.charAt(i) - key - 32 + 64) % 64) + 32);
	            } else {
	                c = (char) (encryptedText.charAt(i) - key);
	            }
	            str = str.concat(Character.toString(c));
        }
        return str;
    }
}

