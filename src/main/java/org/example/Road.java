package org.example;

import javax.swing.*;
import java.awt.*;

public class Road extends JPanel {
    private final Image img;

    public Road() {
        this.img = new ImageIcon("src/main/resources/road.png").getImage();
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(this.img, 0, 0, null);
    }

}
