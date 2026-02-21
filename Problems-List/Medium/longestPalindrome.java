class Solution {
    int maxLen = 0;
    int start = 0;

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        for (int i = 0; i < s.length(); i++) {
            expandAroundCenter(s, i, i);
            expandAroundCenter(s, i, i + 1);
        }
        return s.substring(start, start + maxLen);
    }

    private void expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        if (right - left - 1 > maxLen) {
            maxLen = right - left - 1;
            start = left + 1;
        }
    }
}
