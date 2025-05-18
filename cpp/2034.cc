struct map_cmp {
    bool operator() (const int& left, const int& right) const {
        return left < right;
    }
};

class StockPrice {
private:
    int maxPrice;
    int minPrice;
    map<int, int, map_cmp> timestamp_map;
    map<int, int, map_cmp> price_map;
public:
    StockPrice() {
    }
    
    void update(int timestamp, int price) {
        if (timestamp_map.count(timestamp) > 0) {
            int old_price = timestamp_map[timestamp];
            price_map[old_price]--;
            if (price_map[old_price] == 0) {
                price_map.erase(old_price);
            }
        }
        timestamp_map[timestamp] = price;
        price_map[price]++;
    }
    
    int current() {
        auto it = timestamp_map.end();
        it--;
        return it->second;
    }
    
    int maximum() {
        auto it = price_map.end();
        it--;
        return it->first;
    }
    
    int minimum() {
        auto it = price_map.begin();
        return it->first;
    }
};

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice* obj = new StockPrice();
 * obj->update(timestamp,price);
 * int param_2 = obj->current();
 * int param_3 = obj->maximum();
 * int param_4 = obj->minimum();
 */