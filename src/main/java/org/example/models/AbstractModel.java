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
}
