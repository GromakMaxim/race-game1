package org.example.models;

import org.example.Road;

import javax.swing.*;
import java.util.List;
import java.util.Random;

public class Enemy extends AbstractModel {
    private Road road;

    private List<String> imgPaths = List.of("src/main/resources/enemy/enemy_car_1.png",
                                            "src/main/resources/enemy/enemy_car_2.png",
                                            "src/main/resources/enemy/enemy_car_3.png",
                                            "src/main/resources/enemy/enemy_car_4.png");

    public Enemy(int posX, int posY, int speed, Road road) {
        Random random = new Random();

        this.img = new ImageIcon(this.imgPaths.get(random.nextInt(this.imgPaths.size()))).getImage();

        this.posX = posX;
        this.posY = posY;
        this.road = road;
    }

    public void move() {
        this.posX = this.posX - this.road.getPlayer().getSpeed();
    }
}
