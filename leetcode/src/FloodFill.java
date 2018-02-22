/** https://leetcode.com/problems/flood-fill/description/ */
class FloodFill {
  int[][] floodFill(int[][] image, int x, int y, int newColor) {
    int m = image.length;
    int n = image[0].length;
    int color = image[x][y];
    return floodFillInternal(image, x, y, m, n, color, newColor);
  }

  private int[][] floodFillInternal(
      int[][] image, int x, int y, int m, int n, int color, int newColor) {
    if (x < 0 || x >= m || y < 0 || y >= n || image[x][y] != color || image[x][y] == newColor) {
      return image;
    }
    image[x][y] = newColor;
    floodFillInternal(image, x - 1, y, m, n, color, newColor);
    floodFillInternal(image, x + 1, y, m, n, color, newColor);
    floodFillInternal(image, x, y - 1, m, n, color, newColor);
    floodFillInternal(image, x, y + 1, m, n, color, newColor);
    return image;
  }
}
