class Solution {
public:
    string maximumXor(string s, string t) {
        int n = s.size();

        int ones = count(t.begin(), t.end(), '1');
        int zeros = n - ones;

        string ans(n, '0');

        for (int i = 0; i < n; i++) {
            if (s[i] == '0') {
                if (ones > 0) {
                    ans[i] = '1';
                    ones--;
                } else {
                    ans[i] = '0';
                    zeros--;
                }
            } else { // s[i] == '1'
                if (zeros > 0) {
                    ans[i] = '1';
                    zeros--;
                } else {
                    ans[i] = '0';
                    ones--;
                }
            }
        }
        return ans;
    }
};
