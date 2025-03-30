class Solution {
    public:
        int canCompleteCircuit(vector<int>& gas, vector<int>& cost) {
            int total = 0;
            int curr = 0;
            int result = 0;
            for (int i = 0; i < gas.size(); i++) {
                total += gas[i];
                total -= cost[i];
                curr += gas[i];
                curr -= cost[i];
                if (curr < 0) {
                    result = (i + 1) % gas.size();
                    curr = 0;
                }
            }
            if (total < 0) {
                return -1;
            }
            return result;
        }
    };