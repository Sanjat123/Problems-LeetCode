class Solution {
public:
    int scoreDifference(vector<int>& nums) {
        long long p1 = 0, p2 = 0;
        bool firstActive = true;   
        for (int i = 0; i < nums.size(); i++) {

            if (nums[i] % 2 == 1)
                firstActive = !firstActive;

            if (i % 6 == 5)
                firstActive = !firstActive;

           
            if (firstActive)
                p1 += nums[i];
            else
                p2 += nums[i];
        }

        return (int)(p1 - p2);
    }
};
