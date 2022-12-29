package org.example.models;

import org.example.Road;

import javax.swing.*;
import java.util.List;
import java.util.Random;

import static java.util.Objects.requireNonNull;

public class Enemy extends AbstractModel {
    private final Road road;

    private final List<String> imgPaths = List.of("/enemy/enemy_car_1.png",
                                                  "/enemy/enemy_car_2.png",
                                                  "/enemy/enemy_car_3.png",
                                                  "/enemy/enemy_car_4.png");

    public Enemy(int posX, int posY, int speed, Road road) {
        Random random = new Random();

        var rndImgPath = this.imgPaths.get(random.nextInt(this.imgPaths.size()));
        this.img = new ImageIcon(requireNonNull(this.getClass().getResource(rndImgPath))).getImage();

        this.posX = posX;
        this.posY = posY;
        this.road = road;
    }

    public void move() {
        this.posX = this.posX - this.road.getPlayer().getSpeed();
    }
}
