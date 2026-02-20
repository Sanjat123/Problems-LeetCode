class Solution {
public:
    vector<int> twoSum(vector<int>& A, int target) {
        unordered_map<int, int> m;
        for (int i = 0; i < A.size(); ++i) {
            int t = target - A[i];
            if (m.count(t)) return { m[t], i };
            m[A[i]] = i;
        }
        return {};
    }
};