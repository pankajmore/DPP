/** https://leetcode.com/problems/can-place-flowers/ Created by pankaj on 04/06/17. */
class CanPlaceFlowers {
  boolean canPlaceFlowers(final int[] flowerbed, final int n) {
    int r = n;
    for (int i = 0; i < flowerbed.length && r > 0; i++) {
      if ((i == 0 || flowerbed[i - 1] == 0)
          && flowerbed[i] == 0
          && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
        flowerbed[i] = 1;
        r--;
      }
    }
    return r == 0;
  }
}
