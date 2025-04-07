package ArraysAndStrings;

import java.util.HashMap;
import java.util.Map;

/*
* 1.1 Is Unique: Implement an algorithm to determine if a string has all unique characters.
      What if you cannot use additional data structures?
      Hints: #44, #117, #132
* */
public class IsUnique {
    // [p, u, b, l, i, c]
    /*
    * for(cero -> string.length())
    *   capture character in current position
    *   check if character exists in hashtable. Is exist return NoUnique, if not insert characther as a key and value in a hashtable
    *
    * return IsUnique
    * */

    public static void main(String[] args) {
        System.out.println("frequencies: " + isUnique("frequencies"));
        System.out.println("NoUnique: " + isUnique("NoUnique"));
    }

    private static boolean isUnique(String string) {
        Map<Character, Character> frequencies = new HashMap<>();

        for(Character character : string.toCharArray()) {
            if(frequencies.containsKey(character))
                return false;
            frequencies.put(character, character);
        }
        return true;
    }

}

