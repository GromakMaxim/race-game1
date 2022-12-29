package org.example;

import lombok.Getter;
import org.example.models.Enemy;
import org.example.models.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

import static java.util.Objects.requireNonNull;

public class Road extends JPanel implements ActionListener, Runnable {
    private final Image img;
    @Getter
    private final Player player;
    private final CopyOnWriteArrayList<Enemy> enemies;
    private final Timer mainTimer;
    private final Thread enemiesFactory;
    private final Thread musicWorker;

    public Road() {
        this.img = new ImageIcon(requireNonNull(this.getClass().getResource("/scene/road.png"))).getImage();

        this.player = new Player();
        this.enemies = new CopyOnWriteArrayList(new ArrayList<Enemy>());
        this.enemiesFactory = new Thread(this);
        this.musicWorker = new Thread(new Audio());

        this.mainTimer = new Timer(20, this);
        this.mainTimer.start();
        this.enemiesFactory.start();
        this.musicWorker.start();

        addKeyListener(new MyKeyAdapter());
        setFocusable(true);
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(this.img, this.player.getLayer1(), 0, null);
        g.drawImage(this.img, this.player.getLayer2(), 0, null);
        g.drawImage(this.player.getImg(), this.player.getPosX(), this.player.getPosY(), null);

        int displayingSpeed = (200 / this.player.getMaxSpeed()) * this.player.getSpeed();
        g.setColor(Color.WHITE);
        Font font = new Font("Arial", Font.ITALIC, 20);
        g.setFont(font);
        g.drawString("Скорость: " + displayingSpeed + " км/ч", 30, 20);

        for (Enemy enemy : this.enemies) {
            if (enemy.getPosX() >= 2400 || enemy.getPosX() <= -2400) {
                this.enemies.remove(enemy);
            } else {
                g.drawImage(enemy.getImg(), enemy.getPosX(), enemy.getPosY(), null);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.player.move();
        this.enemies.forEach(Enemy::move);
        this.findCollisionWithEnemies();
        this.checkWinningCondition();
        repaint();
    }

    private void checkWinningCondition() {
        if (this.player.getDistance() > 20_000) {
            JOptionPane.showMessageDialog(null, "Вы победитель!");
            System.exit(0);
        }
    }

    private void findCollisionWithEnemies() {
        this.enemies.forEach(enemy -> {
            if (this.player.getRectangle().intersects(enemy.getRectangle())) {
                JOptionPane.showMessageDialog(null, "Вы проиграли!");
                System.exit(1);
            }
        });
    }

    @Override
    public void run() {
        while (true) {
            Random rnd = new Random();
            try {
                Thread.sleep(rnd.nextInt(2_000));
                this.enemies.add(
                        new Enemy(1600,
                                  rnd.nextInt(550),
                                  0,
                                  this)
                );

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
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
