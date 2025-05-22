class Solution {
public:
    int minEatingSpeed(vector<int>& piles, int h) {
        float predicted_speed = 0;
        for (auto pile : piles) {
            predicted_speed += pile / h;
        }
        int start = max(int(floor(predicted_speed)), 1);
        for (int speed = start; ; speed++) {
            int actual_hour = 0;
            for (auto pile : piles) {
                if (actual_hour <= INT_MAX - pile / speed) {
                    actual_hour += pile / speed;
                    if (pile % speed > 0) {
                        if (actual_hour < INT_MAX) {
                        actual_hour ++;
                        } else {
                            continue;
                        }
                    }
                } else {
                    continue;
                }
            }
            if (actual_hour <= h) {
                return speed;
            }
        }
        return 0;
    }
};