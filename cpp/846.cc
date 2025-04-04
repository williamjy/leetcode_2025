class Solution {
    public:
        bool isNStraightHand(vector<int>& hand, int groupSize) {
            map<int, int> hand_count;
            sort(hand.begin(), hand.end());
            for (int i = 0; i < hand.size(); i++) {
                hand_count[hand[i]]++;
            }
            for (int i = 0; i < hand.size(); i++) {
                if (hand_count[hand[i]] < 0) {
                    return false;
                } else if (hand_count[hand[i]] > 0) {
                    int count = hand_count[hand[i]];
                    for (int j = 0; j < groupSize; j++) {
                        if (hand_count.count(hand[i] + j) <= 0) {
                            return false;
                        }
                        hand_count[hand[i] + j] -= count;
                    }
                }
            }
            return true;
        }
    };
    