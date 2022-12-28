package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Road extends JPanel implements ActionListener {
    private final Image img;
    private final Player player;
    private Timer mainTimer;

    public Road() {
        this.img = new ImageIcon("src/main/resources/road.png").getImage();
        this.player = new Player();
        this.mainTimer = new Timer(29, this);
        this.mainTimer.start();

        addKeyListener(new MyKeyAdapter());
        setFocusable(true);
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(this.img, this.player.getLayer1(), 0, null);
        g.drawImage(this.img, this.player.getLayer2(), 0, null);
        g.drawImage(this.player.getImg(), this.player.getPosX(), this.player.getPosY(), null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.player.move();
        repaint();
    }

    private class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            player.keyPressed(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            player.keyReleased(e);
        }
    }
}
