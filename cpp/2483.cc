class Solution {
public:
    int bestClosingTime(string customers) {
        vector<int> left_count(customers.size() + 1, 0);
        vector<int> right_count(customers.size() + 1, 0);        
        for (int i = 1; i <= customers.size(); i++) {
            if (customers[i - 1] == 'N') {
                left_count[i] = left_count[i - 1] + 1;
            } else {
                left_count[i] = left_count[i - 1];
            }
        }
        for (int j = customers.size() - 1; j >= 0; j--) {
            if (customers[j] == 'Y') {
                right_count[j] = right_count[j + 1] + 1;
            } else {
                right_count[j] = right_count[j + 1];
            }
        }
        int min_penalty = INT_MAX;
        int min_time = customers.size() - 1;
        for (int i = left_count.size() - 1; i >= 0; i--) {
            if (left_count[i] + right_count[i] <= min_penalty) {
                min_penalty = left_count[i] + right_count[i];
                min_time = i;
            }
        }
        return min_time;
    }
};