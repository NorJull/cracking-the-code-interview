package ArraysAndStrings;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
* 1.4. Palindrome Permutation: Given a string, write a function to check if it is a permutation of a Palindrome.
* A palindrome is a word or phrase that is the same forwards and backwards.
* A permutation is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.
EXAMPLE
Input: Tact Coa
Output: True (permutations: "taco cat", "atco eta", etc.) Hints:#106,#121,#134,#136
* */
public class PalindromePermutation {
    /*
     Lowercase the string
     Check if the phrase itself is a palindrome, if it is then return false.



    * Count letters frequency [just Letters]
    Make sure that only one letters has a odd frequency while the rest of letters have evens frequencies
    * */

    private static boolean palindromePermutation(String phrase) {
        phrase.toLowerCase();

        Map<Character, Long> frequencies = phrase.chars()
                .mapToObj(c -> Character.valueOf((char) c))
                .filter(c -> Character.isLetter(c))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        int numberOfOdds = 0;

        for (Long frequency : frequencies.values()){
            if (frequency % 2 != 0)
                numberOfOdds++;
        }

        return numberOfOdds <= 1;
    }
}
