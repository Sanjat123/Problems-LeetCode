class Solution {
public:
    bool isDigitorialPermutation(int n) {
        vector<int> fact = {1,1,2,6,24,120,720,5040,40320,362880};

        int sum = 0;
        int temp = n;

        string s1 = to_string(n);
        sort(s1.begin(), s1.end());

        while (temp > 0) {
            sum += fact[temp % 10];
            temp /= 10;
        }

        string s2 = to_string(sum);
        sort(s2.begin(), s2.end());

        return s1 == s2;
    }
};
