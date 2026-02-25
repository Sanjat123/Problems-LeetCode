import java.util.*;

class Solution {

    int n;
    int[][] fact;
    int[] target;
    HashMap<String, Long> memo = new HashMap<>();

    long dfs(int i, int a, int b, int c) {

        if (i == n)
            return (a == target[0] && b == target[1] && c == target[2]) ? 1 : 0;

        String key = i + "," + a + "," + b + "," + c;
        if (memo.containsKey(key)) return memo.get(key);

        int rem = n - i;

        // pruning
        if (Math.abs(a - target[0]) > rem * 3) return 0;
        if (Math.abs(b - target[1]) > rem * 3) return 0;
        if (Math.abs(c - target[2]) > rem * 3) return 0;

        long ans = 0;

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

        memo.put(key, ans);
        return ans;
    }

    public int countSequences(int[] nums, long k) {

        n = nums.length;
        fact = new int[n][3];

        for (int i = 0; i < n; i++) {
            int x = nums[i];

            while (x % 2 == 0) { fact[i][0]++; x /= 2; }
            while (x % 3 == 0) { fact[i][1]++; x /= 3; }
            while (x % 5 == 0) { fact[i][2]++; x /= 5; }
        }

        target = new int[3];
        long temp = k;

        while (temp % 2 == 0) { target[0]++; temp /= 2; }
        while (temp % 3 == 0) { target[1]++; temp /= 3; }
        while (temp % 5 == 0) { target[2]++; temp /= 5; }

        if (temp != 1) return 0;

        memo.clear();
        return (int)dfs(0,0,0,0);
    }
}
