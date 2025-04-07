package ArraysAndStrings;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
* 1.2
  Check Permutation: Given two strings,write a method to decide if one is a permutation of the other.
  Hints: #7, #84, #722, #737
* */
public class CheckPermutation {
    /*
     Examples:
     s1: casa
     s2: saca
     return true.

     Initial approach

     Check string length. If lengths are different return false
     Calculate characters frequency for string s1 (Using a HashTable)
     Calculate characters frequency for string s2 (Using a HashTable)
     Check s1 frequencies equals to s2 frequencies. Return false if any frequencies are no equals.
     Return true
    *
    * */

    public static void main(String[] args) {
        System.out.println(checkPermutation("casa", "saca"));
        System.out.println(checkPermutation("amor", "roma"));
        System.out.println(checkPermutation("perro", "porre"));
        System.out.println(checkPermutation("gato", "toga"));
        System.out.println(checkPermutation("luz", "zul"));
        System.out.println(checkPermutation("mesa", "same"));
        System.out.println(checkPermutation("raton", "tonar"));
        System.out.println(checkPermutation("sol", "los"));
        System.out.println(checkPermutation("piedra", "diapre"));
        System.out.println(checkPermutation("nube", "bune"));
        System.out.println(checkPermutation("java", "c++"));
    }
    private static boolean checkPermutation(String s1, String s2) {
        if(s1.length() != s2.length())
            return false;

        Map<Character, Long> s1Frequencies = calculateFrequencies(s1); //O(N)
        Map<Character, Long> s2Frequencies = calculateFrequencies(s2); //O(N)

        boolean anyDiff = s1Frequencies.keySet().stream()
                .anyMatch(character -> (s1Frequencies.get(character) != s2Frequencies.get(character))); //O(N)

        return !anyDiff;
    }

    private static Map<Character, Long> calculateFrequencies(String s2) {
        return s2.chars().mapToObj(character -> Character.valueOf((char) character))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

}
