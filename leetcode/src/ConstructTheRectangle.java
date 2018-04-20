/** https://leetcode.com/problems/construct-the-rectangle/ Created by pankaj on 22/01/17. */
public class ConstructTheRectangle {
  public int[] constructRectangle(int area) {
    int w = (int) Math.sqrt(area);
    while (area % w != 0) w--;
    return new int[] {area / w, w};
  }
}
