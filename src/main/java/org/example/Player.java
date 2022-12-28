package org.example;

import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

@Getter
public class Player extends JPanel {
    private Image img;

    private int speed;
    private int deltaSpeed;
    private int maxDistance;


    private int posX;
    private int posY;

    private int layer1;
    private int layer2;


    public Player() {
        this.img = new ImageIcon("src/main/resources/car.png").getImage();
        this.speed = 10;
        this.deltaSpeed = 0;
        this.maxDistance = 0;

        this.posX = 100;
        this.posY = 30;

        this.layer1 = 0;
        this.layer2 = 1600;
    }

    public void move() {
        this.maxDistance += this.speed;

        if (this.layer2 - this.speed <= 0) {
            this.layer1 = 0;
            this.layer2 = 1600;
        } else {
            this.layer1 -= this.speed;
            this.layer2 -= this.speed;
        }
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(this.img, 100, 100, null);
    }

    public void keyPressed(KeyEvent e) {
        JOptionPane.showMessageDialog(null, "key pressed");
    }

    public void keyReleased(KeyEvent e) {
        JOptionPane.showMessageDialog(null, "key released");
    }
}
