package org.example;
//Ex2

public class StringUtils {
    public static boolean isPalindrome(String str) {
        boolean result = Boolean.parseBoolean(null);
        if (str == null||str.isEmpty()||str.isBlank()) {
            result = false;
        }else{
            String reversed = reverseString(str);
            result = str.equalsIgnoreCase(reversed);
        }
        return result;
    }
    private static String reverseString(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }
}
