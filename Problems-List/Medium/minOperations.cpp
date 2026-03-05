class Solution {
public:
    int minOperations(string s) {
        int n = s.size();
        int change1 = 0, change2 = 0;

        for (int i = 0; i < n; i++) {
            char expected1 = (i % 2 == 0) ? '0' : '1'; // 0101...
            char expected2 = (i % 2 == 0) ? '1' : '0'; // 1010...

            if (s[i] != expected1) change1++;
            if (s[i] != expected2) change2++;
        }

        return min(change1, change2);
    }
};
