package com.swiderski.app.utils;
/**
 * This class implements Naive algorithm to check string
 * is a substring other string.
 */

public class NaiveSubstringUtil implements SubstringUtil {

    /**
     * This method is used to check that string is a substring other
     * string
     * @param string Text
     * @param substring  This is potential substring
     * @return boolean This return that {@code substring} parameter is substring of {@code string})).
     */

    @Override
    public boolean isSubstring(String string, String substring) {

        if (string == null || substring == null) {
            return false;
        }

        int substringSignLength = substring.replace("\\*", "*").length();
        int strLength = string.length();
        if (strLength < substringSignLength) {
            return false;
        }

        if (substring.equals("*")) {
            return true;
        }

        return compareStrings(string, substring);
    }

    /**
     * This method is used to compare two texts based on the conditions.
     *
     *  conditions:
     * '*' in substring replaces zero or more characters
     * '\*' in substring is treated as a single '*' character
     * '\' in substring is treated as a '\' character
     *
     * @return boolean This return that {@code substring} parameter is substring of {@code string})).
     */

    private boolean compareStrings(String string, String substring) {
        int strLength = string.length();
        int subLength = substring.length();

        for (int i = 0; i < strLength; i++) {
            if (string.charAt(i) == substring.charAt(0) || substring.charAt(0) == '*') {
                int substringCurrentIndex = 0;
                int stringCurrentIndex = i;

                for (int j = 0; substringCurrentIndex < subLength; j++) {
                    stringCurrentIndex = j + i;

                    if (stringCurrentIndex == strLength) {
                        return false;
                    }
                    // when current substring char is '\*' or '*'
                    if (substring.charAt(substringCurrentIndex) == '\\' && substringCurrentIndex != subLength - 1) {
                        if (substring.charAt(substringCurrentIndex + 1) == string.charAt(stringCurrentIndex)) {
                            substringCurrentIndex += 2;
                            continue;
                        }
                    } else if (substring.charAt(substringCurrentIndex) == '*') {
                        if (substringCurrentIndex == subLength - 1) {
                            return true;
                        }
                        if (substring.charAt(substringCurrentIndex + 1) == '*') {
                            substringCurrentIndex++;
                            continue;
                        }
                        int count = -1;
                        for (int k = stringCurrentIndex; k < strLength; k++) {
                            if (substring.charAt(substringCurrentIndex + 1) == '\\') {
                                substringCurrentIndex++;
                            }
                            if (string.charAt(k) == substring.charAt(substringCurrentIndex + 1)) {
                                i = i + count;
                                substringCurrentIndex++;
                                break;
                            }
                            count++;
                        }
                        continue;
                    }
                    // when chars not equal
                    if (string.charAt(stringCurrentIndex) != substring.charAt(substringCurrentIndex)) {
                        break;
                    }
                    substringCurrentIndex++;
                }
                if (substringCurrentIndex == subLength) {
                    return true;
                }
            }
        }
        return false;
    }


}
