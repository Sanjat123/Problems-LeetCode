class Solution {
public:
    bool isDigitorialPermutation(int n) {
        vector<int> fact = {1,1,2,6,24,120,720,5040,40320,362880};

        string s = to_string(n);
        vector<int> cnt1(10,0);

        int sum = 0;
        for(char c : s){
            int d = c - '0';
            sum += fact[d];
            cnt1[d]++;
        }

        string t = to_string(sum);
        if (s.size() != t.size()) return false;

        vector<int> cnt2(10,0);
        for(char c : t) cnt2[c-'0']++;

        return cnt1 == cnt2;
    }
};
