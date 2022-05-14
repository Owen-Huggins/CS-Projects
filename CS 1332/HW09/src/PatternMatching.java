import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Your implementations of various string searching algorithms.
 *
 * @author Owen Huggins
 * @version 1.0
 * @userid ohuggins3
 * @GTID 903591787
 *
 * Collaborators: LIST ALL COLLABORATORS YOU WORKED WITH HERE
 *
 * Resources: LIST ALL NON-COURSE RESOURCES YOU CONSULTED HERE
 */
public class PatternMatching {

    /**
     * Knuth-Morris-Pratt (KMP) algorithm relies on the failure table (also
     * called failure function). Works better with small alphabets.
     * <p>
     * Make sure to implement the buildFailureTable() method before implementing
     * this method.
     *
     * @param pattern    the pattern you are searching for in a body of text
     * @param text       the body of text where you search for pattern
     * @param comparator you MUST use this to check if characters are equal
     * @return list containing the starting index for each match found
     * @throws java.lang.IllegalArgumentException if the pattern is null or has
     *                                            length 0
     * @throws java.lang.IllegalArgumentException if text or comparator is null
     */
    public static List<Integer> kmp(CharSequence pattern, CharSequence text,
                                    CharacterComparator comparator) {
        if (pattern == null || pattern.length() == 0) {
            throw new java.lang.IllegalArgumentException("The pattern cannot be null or have a length of zero");
        }
        if (text == null || comparator == null) {
            throw new java.lang.IllegalArgumentException("The text cannot be null and the comparator cannot be null");
        } else {
            List<Integer> indexList = new ArrayList<>();
            int j = 0;
            int k = 0;
            int n = text.length();
            int m = pattern.length();

            if (m > n) {
                return indexList;
            }
            int[] fTable = buildFailureTable(pattern, comparator);

            while (k <= n - m) {
                while (j < m && comparator.compare(text.charAt(k + j), pattern.charAt(j)) == 0) {
                    j++;
                }
                if (j == 0) {
                    k++;
                } else {
                    if (j == m) {
                        indexList.add(k);
                    }
                    k = k + j - fTable[j - 1];
                    j = fTable[j - 1];

                }
            }
            return indexList;
        }

    }


    /**
     * Builds failure table that will be used to run the Knuth-Morris-Pratt
     * (KMP) algorithm.
     * <p>
     * The table built should be the length of the input pattern.
     * <p>
     * Note that a given index i will contain the length of the largest prefix
     * of the pattern indices [0..i] that is also a suffix of the pattern
     * indices [1..i]. This means that index 0 of the returned table will always
     * be equal to 0
     * <p>
     * Ex. pattern = ababac
     * <p>
     * table[0] = 0
     * table[1] = 0
     * table[2] = 1
     * table[3] = 2
     * table[4] = 3
     * table[5] = 0
     * <p>
     * If the pattern is empty, return an empty array.
     *
     * @param pattern    a pattern you're building a failure table for
     * @param comparator you MUST use this to check if characters are equal
     * @return integer array holding your failure table
     * @throws java.lang.IllegalArgumentException if the pattern or comparator
     *                                            is null
     */
    public static int[] buildFailureTable(CharSequence pattern,
                                          CharacterComparator comparator) {
        if (pattern == null || comparator == null) {
            throw new java.lang.IllegalArgumentException("The pattern cannot be null "
                    + "and the comparator cannot be null");
        }

        int i = 0;
        int j = 1;
        int m = pattern.length();
        int[] failureTable = new int[m];
        while (j < m) {
            if (comparator.compare(pattern.charAt(i), pattern.charAt(j)) == 0) {
                failureTable[j++] = ++i;
            } else {
                if (i == 0) {
                    failureTable[j++] = i;
                } else {
                    i = failureTable[i - 1];
                }
            }
        }
        return failureTable;
    }

    /**
     * Boyer Moore algorithm that relies on last occurrence table. Works better
     * with large alphabets.
     * <p>
     * Make sure to implement the buildLastTable() method before implementing
     * this method.
     * <p>
     * Note: You may find the getOrDefault() method from Java's Map class
     * useful.
     *
     * @param pattern    the pattern you are searching for in a body of text
     * @param text       the body of text where you search for the pattern
     * @param comparator you MUST use this to check if characters are equal
     * @return list containing the starting index for each match found
     * @throws java.lang.IllegalArgumentException if the pattern is null or has
     *                                            length 0
     * @throws java.lang.IllegalArgumentException if text or comparator is null
     */
    public static List<Integer> boyerMoore(CharSequence pattern,
                                           CharSequence text,
                                           CharacterComparator comparator) {
        if (pattern == null || pattern.length() == 0) {
            throw new java.lang.IllegalArgumentException("The pattern cannot be null or have a length of zero");
        }
        if (text == null || comparator == null) {
            throw new java.lang.IllegalArgumentException("The text cannot be null and the comparator cannot be null");
        }
        Map<Character, Integer> last = buildLastTable(pattern);
        List<Integer> mooreList = new ArrayList<>();
        int i = 0;
        int j = 0;
        int p = pattern.length();
        int t = text.length();
        while (i <= t - p) {
            j = p - 1;
            while (j >= 0 && comparator.compare(text.charAt(i + j), pattern.charAt(j)) == 0) {
                j--;
            }
            if (j < 0) {
                mooreList.add(i);
                i++;
            } else {
                int shift = last.getOrDefault(text.charAt(i + p - 1), -1);
                if (shift < j) {
                    i = i + (j - shift);
                } else {
                    i++;
                }
            }
        }
        return mooreList;

    }

    /**
     * Builds last occurrence table that will be used to run the Boyer Moore
     * algorithm.
     * <p>
     * Note that each char x will have an entry at table.get(x).
     * Each entry should be the last index of x where x is a particular
     * character in your pattern.
     * If x is not in the pattern, then the table will not contain the key x,
     * and you will have to check for that in your Boyer Moore implementation.
     * <p>
     * Ex. pattern = octocat
     * <p>
     * table.get(o) = 3
     * table.get(c) = 4
     * table.get(t) = 6
     * table.get(a) = 5
     * table.get(everything else) = null, which you will interpret in
     * Boyer-Moore as -1
     * <p>
     * If the pattern is empty, return an empty map.
     *
     * @param pattern a pattern you are building last table for
     * @return a Map with keys of all of the characters in the pattern mapping
     * to their last occurrence in the pattern
     * @throws java.lang.IllegalArgumentException if the pattern is null
     */
    public static Map<Character, Integer> buildLastTable(CharSequence pattern) {
        if (pattern == null) {
            throw new java.lang.IllegalArgumentException("The pattern cannot be null");
        }
        int m = pattern.length();
        Map<Character, Integer> last = new HashMap<>();
        for (int i = 0; i <= m - 1; i++) {
            last.put(pattern.charAt(i), i);
        }
        return last;

    }

    /**
     * Prime base used for Rabin-Karp hashing.
     * DO NOT EDIT!
     */
    private static final int BASE = 113;

    /**
     * Runs the Rabin-Karp algorithm. This algorithms generates hashes for the
     * pattern and compares this hash to substrings of the text before doing
     * character by character comparisons.
     * <p>
     * When the hashes are equal and you do character comparisons, compare
     * starting from the beginning of the pattern to the end, not from the end
     * to the beginning.
     * <p>
     * You must use the Rabin-Karp Rolling Hash for this implementation. The
     * formula for it is:
     * <p>
     * sum of: c * BASE ^ (pattern.length - 1 - i)
     * c is the integer value of the current character, and
     * i is the index of the character
     * <p>
     * We recommend building the hash for the pattern and the first m characters
     * of the text by starting at index (m - 1) to efficiently exponentiate the
     * BASE. This allows you to avoid using Math.pow().
     * <p>
     * Note that if you were dealing with very large numbers here, your hash
     * will likely overflow; you will not need to handle this case.
     * You may assume that all powers and calculations CAN be done without
     * overflow. However, be careful with how you carry out your calculations.
     * For example, if BASE^(m - 1) is a number that fits into an int, it's
     * possible for BASE^m will overflow. So, you would not want to do
     * BASE^m / BASE to calculate BASE^(m - 1).
     * <p>
     * Ex. Hashing "bunn" as a substring of "bunny" with base 113
     * = (b * 113 ^ 3) + (u * 113 ^ 2) + (n * 113 ^ 1) + (n * 113 ^ 0)
     * = (98 * 113 ^ 3) + (117 * 113 ^ 2) + (110 * 113 ^ 1) + (110 * 113 ^ 0)
     * = 142910419
     * <p>
     * Another key point of this algorithm is that updating the hash from
     * one substring to the next substring must be O(1). To update the hash,
     * subtract the oldChar times BASE raised to the length - 1, multiply by
     * BASE, and add the newChar as shown by this formula:
     * (oldHash - oldChar * BASE ^ (pattern.length - 1)) * BASE + newChar
     * <p>
     * Ex. Shifting from "bunn" to "unny" in "bunny" with base 113
     * hash("unny") = (hash("bunn") - b * 113 ^ 3) * 113 + y
     * = (142910419 - 98 * 113 ^ 3) * 113 + 121
     * = 170236090
     * <p>
     * Keep in mind that calculating exponents is not O(1) in general, so you'll
     * need to keep track of what BASE^(m - 1) is for updating the hash.
     * <p>
     * Do NOT use Math.pow() in this method.
     *
     * @param pattern    a string you're searching for in a body of text
     * @param text       the body of text where you search for pattern
     * @param comparator you MUST use this to check if characters are equal
     * @return list containing the starting index for each match found
     * @throws java.lang.IllegalArgumentException if the pattern is null or has
     *                                            length 0
     * @throws java.lang.IllegalArgumentException if text or comparator is null
     */
    public static List<Integer> rabinKarp(CharSequence pattern,
                                          CharSequence text,
                                          CharacterComparator comparator) {
        if (pattern == null || pattern.length() == 0) {
            throw new java.lang.IllegalArgumentException("The pattern cannot be null or have a length of zero");
        }
        if (text == null || comparator == null) {
            throw new java.lang.IllegalArgumentException("The text cannot be null and the comparator cannot be null");
        } else {
            List<Integer> karpList = new ArrayList<>();
            int p = pattern.length();
            int t = text.length();
            if (p > t) {
                return karpList;
            }
            int correctPattern = hashHelper(pattern);
            int correctText = hashHelper(text.subSequence(0, p));
            if (correctPattern == correctText
                    && compareHelper(pattern, text.subSequence(0, p), comparator)) {
                karpList.add(0);
            }
            for (int i = 1; i <= t - p; i++) {
                correctText = (correctText - (text.charAt(i - 1) * mathHelper(BASE, p - 1)))
                        * BASE + text.charAt(i + p - 1);
                if (correctText == correctPattern
                        && compareHelper(pattern, text.subSequence(i, i + p), comparator)) {
                    karpList.add(i);
                }
            }
            return karpList;
        }


    }


    /**
     * Helper method for rabinKarp. It computes the hash code
     * @param text the string to be computed into an int
     * @return the hash value
     */

    private static int hashHelper(CharSequence text) {
        int num = 0;
        int t = text.length();
        for (int i = 0; i < t; i++) {
            num = num + (text.charAt(i) * mathHelper(BASE, t - i - 1));
        }
        return num;
    }


    /**
     * Helper method for rabinKarp. determines if two strings that have same hashcode are equal
     * @param first first string
     * @param second second string
     * @param comparator the character comparator
     * @return boolean value representing equality of strings
     */

    private static boolean compareHelper(CharSequence first, CharSequence second, CharacterComparator comparator) {
        int f = first.length();
        for (int i = 0; i < f; i++) {
            if (comparator.compare(first.charAt(i), second.charAt(i)) != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Helper method for rabinKarp. Computes the number raised to the power
     * @param b the base number
     * @param x the power we raise the base number to
     * @return the exponential integer value
     */

    private static int mathHelper(int b, int x) {
        if (x == 0) {
            return 1;
        } else {
            return b * mathHelper(b, x - 1);
        }
    }


}