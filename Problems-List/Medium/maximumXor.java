class Solution {
    public String maximumXor(String s, String t) {
        int n = s.length();

        int ones = 0;
        for (char c : t.toCharArray())
            if (c == '1') ones++;

        int zeros = n - ones;

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < n; i++) {

            if (s.charAt(i) == '0') {
                if (ones > 0) {
                    ans.append('1');
                    ones--;
                } else {
                    ans.append('0');
                    zeros--;
                }
            } else { // s[i] == 1
                if (zeros > 0) {
                    ans.append('1');
                    zeros--;
                } else {
                    ans.append('0');
                    ones--;
                }
            }
        }

        return ans.toString();
    }
}
