package Q25;

import java.util.Scanner;

public class Main25 {
    public static void main(String[] args) {
        MyHashMap<String, String> myHashMap = new MyHashMap<String, String>();
        characterDictionary(myHashMap);

        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter Marley sentence: ");
        String inputtedString = keyboard.nextLine();

        String decryptedString = decryptString(inputtedString, myHashMap);

        System.out.println("Your Paradis word is: " + decryptedString);
    }

    public static String decryptString(String inputtedString, MyHashMap<String, String> myHashMap) {
        char[] inputtedStringArray = inputtedString.toCharArray();
        StringBuilder encryptedString = new StringBuilder();
        boolean capitalize = false;

        // for normal decryptions
        for (Character character : inputtedStringArray) {
            String retrievedCharacter = myHashMap.get(String.valueOf(character));

            if (capitalize) {
                retrievedCharacter = retrievedCharacter.toUpperCase();
            }

            capitalize = character == '^';

            encryptedString.append(retrievedCharacter);
        }


        // to check for brackets, for reversal
        for (int i = 0; i < encryptedString.length(); i++) {
            if (encryptedString.charAt(i) == ')' && inputtedString.contains("(")) {
                StringBuilder reverseStringBuilder = new StringBuilder();
                int firstBracket = encryptedString.indexOf("(");
                int secondBracket = encryptedString.indexOf(")");
                reverseStringBuilder.append(encryptedString.substring(firstBracket + 1, secondBracket));
                reverseStringBuilder = reverseStringBuilder.reverse();
                encryptedString.replace(firstBracket + 1, secondBracket, reverseStringBuilder.toString());
                encryptedString.deleteCharAt(firstBracket);
                encryptedString.deleteCharAt(secondBracket - 1);
            }
        }
        return encryptedString.toString();
    }

    public static void characterDictionary(MyHashMap<String, String> myHashMap) {
        myHashMap.put("a", "j");
        myHashMap.put("b", "c");
        myHashMap.put("c", "t");
        myHashMap.put("d", "a");
        myHashMap.put("e", "k");
        myHashMap.put("f", "z");
        myHashMap.put("g", "s");
        myHashMap.put("h", "i");
        myHashMap.put("i", "w");
        myHashMap.put("j", "x");
        myHashMap.put("k", "o");
        myHashMap.put("l", "n");
        myHashMap.put("m", "g");
        myHashMap.put("n", "b");
        myHashMap.put("o", "f");
        myHashMap.put("p", "h");
        myHashMap.put("q", "l");
        myHashMap.put("r", "d");
        myHashMap.put("s", "e");
        myHashMap.put("t", "y");
        myHashMap.put("u", "m");
        myHashMap.put("v", "v");
        myHashMap.put("w", "u");
        myHashMap.put("x", "p");
        myHashMap.put("y", "q");
        myHashMap.put("z", "r");
        myHashMap.put("$", " ");
        myHashMap.put(",", ",");
        myHashMap.put("^", "");
        myHashMap.put("(", "(");
        myHashMap.put(")", ")");
    }
}
