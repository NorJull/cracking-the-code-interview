package ArraysAndStrings;

/*
* 1.5. One Away: There are three types of edits that can be performed on strings:
* insert a character,
* remove a character,
* or replace a character.
* Given two strings, write a function to check if they are one edit (or zero edits) away.
EXAMPLE
* pale, ple -> true          c, v bple
* pales, pale -> true
* pale, bale -> true
* pale, bake -> false
*
* */
public class OneAway {
    /*
    *
    *
    * */


    public static void main(String[] args) {
        System.out.println(onWay("pale", "plle")); //ERRORRRRRRR
 /*       System.out.println(onWay("pales", "pale"));
        System.out.println(onWay("pale", "bale"));
        System.out.println(onWay("pale", "bake"));
        System.out.println(onWay("bake", "bake"));
        System.out.println(onWay("bales", "bake"));*/

    }

    private static boolean onWay(String s1, String s2) {
        if(Math.abs(s1.length() - s2.length()) > 1)
            return false;

        String smallestString = determineSmallestOrFirst(s1, s2);
        String largestString = determineLargestSecond(s1, s2);

        int smallestIndex = smallestString.length() - 1;
        int largestIndex = largestString.length() - 1;
        int editCount = 0;

        while(smallestIndex >= 0 && largestIndex >= 0) {
            if(smallestString.charAt(smallestIndex) == largestString.charAt(largestIndex)) {
                smallestIndex--;
                largestIndex--;
            } else {
                editCount++;
                if(editCount > 1)
                    return false;
                largestIndex--;
                if(smallestString.length() == largestString.length())
                    smallestIndex--;
            }
        }

       return true;
    }

    private static String determineSmallestOrFirst(String s1, String s2) {
        if(s1.length() > s2.length()) {
            return s2;
        } else if (s2.length() > s1.length() ) {
            return s1;
        } else {
            return s1;
        }
    }

    private static String determineLargestSecond(String s1, String s2) {
        if(s1.length() > s2.length()) {
            return s1;
        } else if (s2.length() > s1.length() ) {
            return s2;
        } else {
            return s2;
        }
    }
}
