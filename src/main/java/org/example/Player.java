package org.example;

import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

@Getter
public class Player extends JPanel {
    private Image img;

    private int speed;
    private int maxSpeed = 200;
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
        this.speed += this.deltaSpeed;

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
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                this.posY -= 10;
                this.img = new ImageIcon("src/main/resources/car_up.png").getImage();
                break;

            case KeyEvent.VK_DOWN:
                this.posY += 10;
                this.img = new ImageIcon("src/main/resources/car_down.png").getImage();
                break;

            case KeyEvent.VK_RIGHT:
                if (this.speed < maxSpeed) {
                    this.speed += 1;
                    System.out.println(this.speed);
                }
                break;

            case KeyEvent.VK_LEFT:
                if (this.speed > 0) {
                    this.speed -= 1;
                    System.out.println(this.speed);
                }
                break;
        }
    }

    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
            case KeyEvent.VK_DOWN:
                this.img = new ImageIcon("src/main/resources/car.png").getImage();
                break;
        }
    }
}
