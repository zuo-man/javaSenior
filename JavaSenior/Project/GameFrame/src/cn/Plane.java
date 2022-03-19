package cn;

import javax.swing.*;
import java.awt.*;

/**
 * @create 2021-11-12 17:12
 */
public class Plane {
    int x = 230 ,y = 600;
    int width = 50, heigth = 50;

    Image img = new ImageIcon("img/fj.png").getImage();

    public Plane() {
    }

    public Plane(int x, int y, int width, int heigth) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.heigth = heigth;
    }
}
