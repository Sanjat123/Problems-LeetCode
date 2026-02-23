class Solution {
public:
    int scoreDifference(vector<int>& nums) {
        int p1 = 0, p2 = 0;
        bool p1Active = true;

        for (int i = 0; i < nums.size(); i++) {

            if (nums[i] % 2 == 1) p1Active = !p1Active;
            if (i % 6 == 5) p1Active = !p1Active;

            if (p1Active) p1 += nums[i];
            else p2 += nums[i];
        }

        return p1 - p2;
    }
};
