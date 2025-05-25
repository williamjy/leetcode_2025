class MedianFinder {
private:
    priority_queue<int, vector<int>, less<int>> left;
    priority_queue<int, vector<int>, greater<int>> right;

public:
    MedianFinder() {
    }
    
    void addNum(int num) {
        if (left.empty()) {
            left.push(num);
        } else {
            if (num > left.top()) {
                right.push(num);
            } else {
                left.push(num);
            }
            int size_diff = left.size() - right.size();
            if (size_diff > 1) {
                while (left.size() > right.size()) {
                    int left_top = left.top();
                    left.pop();
                    right.push(left_top);
                }
            } else if (size_diff < 0) {
                while (right.size() > left.size()) {
                    int right_top = right.top();
                    right.pop();
                    left.push(right_top);
                }
            }
        }
    }
    
    double findMedian() {
        if (left.size() == right.size()) {
            return (double(left.top()) + double(right.top())) / 2;
        } else {
            return left.top();
        }
    }
};

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder* obj = new MedianFinder();
 * obj->addNum(num);
 * double param_2 = obj->findMedian();
 */