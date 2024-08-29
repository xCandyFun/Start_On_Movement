package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main extends JPanel implements KeyListener, ActionListener {

    private int x = 100; // Initial x position of the object
    private int y = 100; // Initial y position of the object
    private final int objectWidth = 50;
    private final int objectHeight = 50;
    private final int moveStep = 30;

    private int x2 = 300; // Initial x position of the object
    private int y2 = 100; // Initial y position of the object
    private final int objectWidth2 = 50;
    private final int objectHeight2 = 50;
    private final int moveStep2 = 2;
    private Timer timer;

    public Main() {
        // Set the size of the JPanel
        this.setPreferredSize(new Dimension(800, 800));
        // Add the KeyListener to the JPanel
        this.setFocusable(true);
        this.addKeyListener(this);

        // Set up a timer to move the second object automatically
        timer = new Timer(30, this); // Timer will trigger every 100 milliseconds
        timer.start();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Move Object Example");
        Main panel = new Main();
        frame.add(panel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw the object (a rectangle in this case)
        g.setColor(Color.RED);
        g.fillRect(x, y, objectWidth, objectWidth);

        g.setColor(Color.BLUE);
        g.fillRect(x2, y2, objectWidth2, objectHeight2);

    }

    // Implement the KeyListener methods
    @Override
    public void keyPressed(KeyEvent e) {

        int panelWidth = this.getWidth();
        int panelHeight = this.getHeight();

        if (e.getKeyCode() == KeyEvent.VK_W) {
            if (y - moveStep >= 0) {
                y -= moveStep;
            }
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            if (x - moveStep >= 0) {
                x -= moveStep;
            }
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            if (y + moveStep + objectHeight <= panelHeight) {
                y += moveStep;
            }
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            if (x + moveStep + objectWidth <= panelWidth) {
                x += moveStep;
            }
        }

        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e){

        int deltaX = x - x2;
        int deltaY = y - y2;

        if (deltaX != 0){
            x2 += moveStep2 * (deltaX / Math.abs(deltaX));// Move x2 towards x1
        }
        if (deltaY != 0){
            y2 += moveStep2 * (deltaY / Math.abs(deltaY));// Move y2 towards y1
        }

        repaint();
    }


    @Override
    public void keyReleased(KeyEvent e) {
        // Not needed in this example
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Not needed in this example
    }

}