class Solution {
public:
    long long minNumberOfSeconds(int mountainHeight, vector<int>& workerTimes) {
        long long left = 1, right = 1e18;
        long long ans = right;

        auto can = [&](long long T) {
            long long total = 0;

            for (long long t : workerTimes) {
                long long l = 0, r = 1e6;

                while (l <= r) {
                    long long mid = (l + r) / 2;
                    long long timeNeeded = t * mid * (mid + 1) / 2;

                    if (timeNeeded <= T) {
                        total += mid;
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }

                    if (total >= mountainHeight)
                        return true;
                }
            }

            return total >= mountainHeight;
        };

        while (left <= right) {
            long long mid = (left + right) / 2;

            if (can(mid)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }
};
