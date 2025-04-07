package ArraysAndStrings;


/*
* URLify: Write a method to replace all spaces in a string with '%20'.
* You may assume that the string has sufficient space at the end to hold the additional characters,
* and that you are given the "true" length of the string.
* (Note: If implementing in Java,please use a character array so that you can perform this operation in place.)
EXAMPLE
Input: "Mr John Smith ", 13 Output: "Mr%20John%20Smith"
* */
public class URLify {

    public static void main(String[] args) {
        Character[] characters = new Character[]{'M', 'r', ' ', 'J', 'o', 'h', 'n', ' ', 'S', 'm', 'i', 't', 'h', ' ', ' ', ' ', ' '};

        URLify(characters, 13);
        System.out.println(characters);

    }

    //O(N)
    private static void URLify(Character[] characters, int length) {
        //count spaces
        int numberSpaces = 0;
        //O(N)
        for (int i = 0; i < length; i++) {
            if (characters[i] == ' ')
                numberSpaces++;
        }

        int lastMovePosition = length + numberSpaces * 2;

        // O(N)
        for (int i = length - 1; i >= 0; i--) {
            Character character = characters[i];

            if (character.equals(' ')) {
                characters[lastMovePosition - 1] = '0';
                characters[lastMovePosition - 2] = '2';
                characters[lastMovePosition - 3] = '%';
                lastMovePosition = lastMovePosition - 3;
            } else {
                characters[lastMovePosition - 1] = character;
                lastMovePosition--;
            }

        }

    }


}
