package org.example.models;

import lombok.Getter;

import javax.swing.*;
import java.awt.*;

@Getter
public abstract class AbstractModel extends JFrame {
    protected Image img;
    protected int posX;
    protected int posY;
    protected int speed;

    public Rectangle getRectangle() {
        return new Rectangle(this.posX, this.posY, this.img.getWidth(null), this.img.getHeight(null));
    }
}
