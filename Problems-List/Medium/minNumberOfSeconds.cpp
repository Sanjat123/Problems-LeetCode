class Solution {
public:
    long long minNumberOfSeconds(int mountainHeight, vector<int>& workerTimes) {
        long long left = 0, right = 1e18;

        while (left < right) {
            long long mid = (left + right) / 2;
            long long total = 0;

            for (long long t : workerTimes) {
                long long val = (2 * mid) / t;
                long long x = (sqrt(1 + 4 * val) - 1) / 2;
                total += x;

                if (total >= mountainHeight)
                    break;
            }

            if (total >= mountainHeight)
                right = mid;
            else
                left = mid + 1;
        }

        return left;
    }
};
