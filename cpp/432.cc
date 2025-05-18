class AllOne {
private:
    map<string, int> key_map;
    map<int, set<string>> count_map;
public:
    AllOne() {
        
    }
    
    void inc(string key) {
        if (key_map.count(key) == 0) {
            key_map[key] = 1;
            if (count_map.count(1) == 0) {
                set<string> new_set;
                count_map[1] = new_set;
            }
            count_map[1].insert(key);
        } else {
            int old_count = key_map[key];
            key_map[key]++;
            int new_count = key_map[key];
            count_map[old_count].erase(key);
            if (count_map[old_count].size() == 0) {
                count_map.erase(old_count);
            }
            if (count_map.count(new_count) == 0) {
                set<string> new_set;
                count_map[new_count] = new_set;
            }
            count_map[new_count].insert(key);
        }
    }
    
    void dec(string key) {
        int old_count = key_map[key];
        key_map[key]--;
        if (key_map[key] == 0) {
            key_map.erase(key);
        }
        int new_count = key_map[key];
        count_map[old_count].erase(key);
        if (count_map[old_count].size() == 0) {
            count_map.erase(old_count);
        }
        if (new_count > 0) {
            if (count_map.count(new_count) == 0) {
                set<string> new_set;
                count_map[new_count] = new_set;
            }
            count_map[new_count].insert(key);
        }
    }
    
    string getMaxKey() {
        if (count_map.size() == 0) {
            return "";
        }
        auto it = count_map.end();
        it--;
        return *(it->second.begin());
    }
    
    string getMinKey() {
        if (count_map.size() == 0) {
            return "";
        }
        auto it = count_map.begin();
        return *(it->second.begin());
    }
};

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne* obj = new AllOne();
 * obj->inc(key);
 * obj->dec(key);
 * string param_3 = obj->getMaxKey();
 * string param_4 = obj->getMinKey();
 */