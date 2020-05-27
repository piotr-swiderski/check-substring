package com.swiderski.app.utils;

/**
 * This class implements KMP algorithm to check that string
 * is a substring other string.
 */

public class KMPSubstringUtil implements SubstringUtil {

    /**
     * This method is used to compare two texts based on the conditions.
     * <p>
     * conditions:
     * '*'  in substring replaces zero or more characters
     * '\*' in substring is treated as a single '*' character
     * '\'  in substring is treated as a '\' character
     *
     * @return boolean This return that {@param substring} parameter is substring of {@param string})).
     */

    @Override
    public boolean isSubstring(String string, String substring) {

        if (substring == null || substring.length() == 0) {
            return false;
        }

        if (string == null) {
            return false;
        }

        int[] prefixTable = getPrefixTable(substring);

        int currentSubIndex = 0;
        for (int i = 0; i < string.length(); i++) {

            if (currentSubIndex < substring.length() && isAsterisk(substring.charAt(currentSubIndex)) && currentSubIndex + 1 != substring.length()) {
                if (isAsterisk(substring.charAt(currentSubIndex + 1))) {
                    currentSubIndex++;
                } else {
                    int count = -1;
                    for (int k = i; k < string.length(); k++) {
                        if (isBackslash(substring.charAt(currentSubIndex + 1))) {
                            currentSubIndex++;
                        }
                        if (string.charAt(k) == substring.charAt(currentSubIndex + 1)) {
                            i = i + count;
                            currentSubIndex++;
                            break;
                        }
                        count++;
                    }
                }
            } else if (isBackslash(substring.charAt(currentSubIndex)) && currentSubIndex + 1 != substring.length() && isAsterisk(string.charAt(i))) {
                if (substring.charAt(currentSubIndex + 1) == string.charAt(i)) {
                    currentSubIndex++;
                }
            } else if ((string.charAt(i) == substring.charAt(currentSubIndex) || isAsterisk(substring.charAt(currentSubIndex)))) {
                if (++currentSubIndex == substring.length()) {
                    return true;
                }
            } else if (currentSubIndex > 0) {
                currentSubIndex = prefixTable[currentSubIndex];
                i--;
            }
        }
        return false;
    }

    /**
     * That method created a table prefix based on input string
     *
     * @param substring The String on the basis of which the table prefix is created
     * @return int[]  Returned prefix table
     */
    private int[] getPrefixTable(String substring) {
        char[] chars = substring.toCharArray();

        int[] prefixTable = new int[substring.length() + 1];
        for (int i = 1; i < substring.length(); i++) {

            int j = prefixTable[i + 1];

            while (j > 0 && chars[j] != chars[i])
                j = prefixTable[j];

            if (j > 0 || chars[j] == chars[i])
                prefixTable[i + 1] = j + 1;
        }
        return prefixTable;
    }

    private boolean isBackslash(char c) {
        return c == '\\';
    }

    private boolean isAsterisk(char c) {
        return c == '*';
    }

}
