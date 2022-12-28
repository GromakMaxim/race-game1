package org.example;

import lombok.Getter;

import javax.swing.*;
import java.awt.*;

@Getter
public class Player extends JPanel {
    private Image img;

    private int speed;
    private int deltaSpeed;
    private int maxDistance;


    private int posX;
    private int posY;

    private int layer1;


    public Player() {
        this.img = new ImageIcon("src/main/resources/car.png").getImage();
        this.speed = 10;
        this.deltaSpeed = 0;
        this.maxDistance = 0;

        this.posX = 100;
        this.posY = 30;

        this.layer1 = 0;
    }

    public void move(){
        this.maxDistance += this.speed;
        this.layer1 -= this.speed;
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(this.img, 100, 100, null);
    }
}
