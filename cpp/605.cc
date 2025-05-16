class Solution {
public:
    bool canPlaceFlowers(vector<int>& flowerbed, int n) {
        for (int i = 0; i < flowerbed.size() && n > 0; i++) {
            if (flowerbed[i] == 0) {
                bool isPlacable = true;
                if (i - 1 >= 0 && flowerbed[i - 1] == 1) {
                    isPlacable = false;
                }
                if (i + 1 < flowerbed.size() && flowerbed[i + 1] == 1) {
                    isPlacable = false;
                }
                if (isPlacable) {
                    flowerbed[i] = 1;
                    n--;
                }
            }
        }
        return n == 0;
    }
};