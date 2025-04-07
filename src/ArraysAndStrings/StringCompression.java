package ArraysAndStrings;
/*
* 1.6 String Compression: Implement a method to perform basic string compression using the counts of repeated characters.
* For example, the string aabcccccaaa would become a2b1c5a3. If the "compressed" string would not become smaller than the
* original string, your method should return the original string. You can assume the string has only uppercase and lowercase
* letters (a - z).
Hints:#92, #110
* */
public class StringCompression {

    public static void main(String[] args) {
        System.out.println(stringCompression("aaccccVcddd"));
    }
    private static String stringCompression(String originalString) {
        if(originalString.length() <= 2)
            return originalString;

        char current = originalString.charAt(0);
        int count = 1;
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i < originalString.length(); i++) {
            if(current == originalString.charAt(i)) {
                count++;
            } else {
                sb.append(current +""+count);
                current = originalString.charAt(i);
                count = 1;
            }
        }
        sb.append(current +""+count);

        if(originalString.length() <= sb.toString().length())
            return originalString;

        return sb.toString();
    }
}
