class Solution {
public:
    int n;
    vector<array<int,3>> fact;
    array<int,3> target;
    map<tuple<int,int,int,int>, long long> memo;

    long long dfs(int i, int a, int b, int c) {

        if (i == n)
            return (a == target[0] && b == target[1] && c == target[2]);

        auto key = make_tuple(i,a,b,c);
        if (memo.count(key)) return memo[key];

        // remaining numbers max effect
        int rem = n - i;

        // pruning
        if (abs(a - target[0]) > rem*3) return 0;
        if (abs(b - target[1]) > rem*3) return 0;
        if (abs(c - target[2]) > rem*3) return 0;

        long long ans = 0;

        // multiply
        ans += dfs(i+1,
                   a + fact[i][0],
                   b + fact[i][1],
                   c + fact[i][2]);

        // divide
        ans += dfs(i+1,
                   a - fact[i][0],
                   b - fact[i][1],
                   c - fact[i][2]);

        // skip
        ans += dfs(i+1, a, b, c);

        return memo[key] = ans;
    }

    int countSequences(vector<int>& nums, long long k) {
        n = nums.size();
        fact.clear();

        for (int x : nums) {
            array<int,3> f = {0,0,0};
            while (x%2==0){f[0]++; x/=2;}
            while (x%3==0){f[1]++; x/=3;}
            while (x%5==0){f[2]++; x/=5;}
            fact.push_back(f);
        }

        target = {0,0,0};
        long long temp = k;

        while (temp%2==0){target[0]++; temp/=2;}
        while (temp%3==0){target[1]++; temp/=3;}
        while (temp%5==0){target[2]++; temp/=5;}

        if (temp != 1) return 0;

        memo.clear();
        return dfs(0,0,0,0);
    }
};
