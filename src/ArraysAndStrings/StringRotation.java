package ArraysAndStrings;

/*
* 1.9 String Rotation:Assume you have a method isSubstringwhich checks if one word is a substring of another.
* Given two strings, sl and s2, write code to check if s2 is a rotation of sl using only one call to isSubstring
* (e.g.,"waterbottle" is a rotation of"erbottlewat").

Hints:#34,#88, #704
* */
public class StringRotation {

    public static void main(String[] args) {
        testIsStringRotation("waterbottle", "erbottlewat", true);
        testIsStringRotation("abc", "bca", true);
        testIsStringRotation("hello", "olelh", false);
        testIsStringRotation("abcd", "abcd", true);
        testIsStringRotation("a", "a", true);
        testIsStringRotation("hello", "helloo", false);
        testIsStringRotation("", "", true);
        testIsStringRotation("", "a", false);
        testIsStringRotation(null, "abc", false);
        testIsStringRotation("abcd", "dcba", false);
    }
    private static boolean isStringRotation(String s1, String s2) {

        if (s1 == null || s2 == null || s1.length() != s2.length())
            return false;
        int s1Index = 0;
        int s2Index = 0;
        int countEquals = 0;

        while(s2Index < s2.length()) {
            if(s1.charAt(s1Index) == s2.charAt(s2Index)) {
                s1Index++;
                s2Index++;
                countEquals++;
                continue;
            }

            if(s1Index > 0) {
                s1Index = 0;
                s2Index = s2Index - (countEquals - 1);
                countEquals = 0;
                continue;
            }
            s2Index++;
        }

        return isSubString(s1.substring(s1Index, s1.length()), s2);

    }

    private static boolean isStringRotationBookSolution(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }
        String concatenated = s1 + s1;
        return concatenated.contains(s2);
    }
    private static boolean isSubString(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false; // Handle null cases
        }
        return s2.contains(s1); // Check if s1 is a substring of s2
    }


    private static void testIsStringRotation(String s1, String s2, boolean expected) {
        boolean result = isStringRotation(s1, s2);
        if (result == expected) {
            System.out.println("✅ Passed: isStringRotation(\"" + s1 + "\", \"" + s2 + "\") = " + result);
        } else {
            System.out.println("❌ Failed: isStringRotation(\"" + s1 + "\", \"" + s2 + "\") expected " + expected + " but got " + result);
        }
    }
}
