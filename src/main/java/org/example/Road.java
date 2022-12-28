package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Road extends JPanel implements ActionListener {
    private Timer mainTimer;
    private final Image img;
    private final Player player;

    public Road() {
        this.img = new ImageIcon("src/main/resources/road.png").getImage();
        this.player = new Player();
        this.mainTimer = new Timer(29, this);
        this.mainTimer.start();
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(this.img, this.player.getLayer1(), 0, null);
        g.drawImage(this.player.getImg(), this.player.getPosX(), this.player.getPosY(), null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.player.move();
        repaint();
    }
}
