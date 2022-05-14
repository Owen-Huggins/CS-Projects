/**
 * CS 2110 Spring 2022 HW1
 * Part 2 - Coding with bases
 *
 * @author Owen Huggins
 *
 * Global rules for this file:
 * - You may not use more than 2 conditionals per method. Conditionals are
 *   if-statements, if-else statements, or ternary expressions. The else block
 *   associated with an if-statement does not count toward this sum.
 * - You may not use more than 2 looping constructs per method. Looping
 *   constructs include for loops, while loops and do-while loops.
 * - You may not use nested loops.
 * - You may not declare any file-level variables.
 * - You may not use switch statements.
 * - You may not use the unsigned right shift operator (>>>)
 * - You may not write any helper methods, or call any method from this or
 *   another file to implement any method. Recursive solutions are not
 *   permitted.
 * - The only Java API methods you are allowed to invoke are:
 *     String.length()
 *     String.charAt()
 * - You may not invoke the above methods from string literals.
 *     Example: "12345".length()
 * - When concatenating numbers with Strings, you may only do so if the number
 *   is a single digit.
 *
 * Method-specific rules for this file:
 * - You may not use multiplication, division or modulus in any method, EXCEPT
 *   decimalStringToInt (where you may use multiplication only)
 * - You may declare exactly one String variable each in intToOctalString and
 *   and binaryStringToHexString.
 */
public class Bases
{
    /**
     * Convert a string containing ASCII characters (in binary) to an int.
     *
     * You do not need to handle negative numbers. The Strings we will pass in
     * will be valid binary numbers, and able to fit in a 32-bit signed integer.
     *
     * Example: binaryStringToInt("111"); // => 7
     */
    public static int binaryStringToInt(String binary)  {
        int finalNumber = 0;
        int stringLength = binary.length();
        for (int i = 0; i < stringLength; i++) {
            finalNumber = finalNumber << 1;
            finalNumber = finalNumber + binary.charAt(i) - '0';
        }
        return finalNumber;

    }

    /**
     * Convert a string containing ASCII characters (in decimal) to an int.
     *
     * You do not need to handle negative numbers. The Strings we will pass in
     * will be valid decimal numbers, and able to fit in a 32-bit signed integer.
     *
     * Example: decimalStringToInt("46"); // => 46
     *
     * You may use multiplication in this method.
     */
    public static int decimalStringToInt(String decimal) {
        int finalNumber = 0;
        int stringLength = decimal.length();
        int multiplier = 1;
        for (int i = stringLength - 1; i >= 0; i--) {
            finalNumber = finalNumber + (decimal.charAt(i) - '0') * multiplier;
            multiplier *= 10;
        }
        return finalNumber;
    }

    /**
     * Convert a string containing ASCII characters (in hex) to an int.
     * The input string will only contain numbers and uppercase letters A-F.
     * You do not need to handle negative numbers. The Strings we will pass in will be
     * valid hexadecimal numbers, and able to fit in a 32-bit signed integer.
     *
     * Example: hexStringToInt("A6"); // => 166
     */
    public static int hexStringToInt(String hex) {
        int finalNumber = 0;
        int stringLength = hex.length();
        int holder = 0;
        for (int i = 0; i < stringLength; i++) {
            finalNumber = finalNumber << 4;
            if (hex.charAt(i) < 'A') {
                holder = hex.charAt(i) - '0';
            } else {
                holder = hex.charAt(i) - '7';
            }
            finalNumber = finalNumber + holder;
        }
        return finalNumber;

    }

    /**
     * Convert a int into a String containing ASCII characters (in octal).
     *
     * You do not need to handle negative numbers.
     * The String returned should contain the minimum number of characters
     * necessary to represent the number that was passed in.
     *
     * Example: intToOctalString(166); // => "246"
     *
     * You may declare one String variable in this method.
     */
    public static String intToOctalString(int octal) {
        String finalString = "";
        while (octal != 0) {
            int holder = 7 & octal;
            finalString = holder + finalString;
            octal = octal >> 3;
        }
        return finalString;


    }

    /**
     * Convert a String containing ASCII characters representing a number in
     * binary into a String containing ASCII characters that represent that same
     * value in hex.
     *
     * The output string should only contain numbers and capital letters.
     * You do not need to handle negative numbers.
     * All binary strings passed in will contain exactly 32 characters.
     * The octal string returned should contain exactly 8 characters.
     *
     * Example: binaryStringToHexString("00001111001100101010011001011100"); // => "0F32A65C"
     *
     * You may declare one String variable in this method.
     */
    public static String binaryStringToHexString(String binary) {
        int finalNumber = 0;
        int stringLength = binary.length();
        for (int i = 0; i < stringLength; i++) {
            finalNumber = finalNumber << 1;
            finalNumber = finalNumber + binary.charAt(i) - '0';
        }
        String finalString = "";
        char letter;
        int holder;
        for (int i = 0; i < 8; i++) {
            holder = 15 & finalNumber;
            finalNumber = finalNumber >> 4;
           if (holder < 10) {
                letter = (char) (holder + '0');
           } else if (holder >= 10) {
               letter = (char) (holder + '7');
           } else {
               letter = '0';
           }
           finalString = letter + finalString;
        }

        return finalString;
    }
}
