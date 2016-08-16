package pramp;

import java.awt.*;

/**
 * Created by pankaj on 8/13/16.
 */
public class HTree extends Canvas {
    private void drawLine(double x1, double y1, double x2, double y2) {
        System.out.println(String.format("(%f,%f) -> (%f,%f)", x1, y1, x2, y2));
    }

    public void drawHTree(double x, double y, double len, int depth) {
        if (depth == 0) return;
        double x0 = x - len / 2;
        double y0 = y - len / 2;
        double x1 = x + len / 2;
        double y1 = y + len / 2;
        double newLen = len / Math.sqrt(2);
        drawLine(x0, y, x1, y);
        drawLine(x0, y0, x0, y1);
        drawLine(x1, y0, x1, y1);
        drawHTree(x0, y0, newLen, depth - 1);
        drawHTree(x0, y1, newLen, depth - 1);
        drawHTree(x1, y0, newLen, depth - 1);
        drawHTree(x1, y1, newLen, depth - 1);
    }
}
