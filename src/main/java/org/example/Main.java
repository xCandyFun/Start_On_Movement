package org.example;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main extends JPanel implements KeyListener {

    private int x = 100; // Initial x position of the object
    private int y = 100; // Initial y position of the object
    private final int objectWidth = 50;
    private final int objectHeight = 50;
    private final int moveStep = 10;

    public Main() {
        // Set the size of the JPanel
        this.setPreferredSize(new Dimension(400, 400));
        // Add the KeyListener to the JPanel
        this.setFocusable(true);
        this.addKeyListener(this);
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
    }

    // Implement the KeyListener methods
    @Override
    public void keyPressed(KeyEvent e) {

        int panelWidth = this.getWidth();
        int panelHeight = this.getHeight();

        if (e.getKeyCode() == KeyEvent.VK_W){
            if (y - moveStep >= 0){
                y -= moveStep;
            }
        } else if (e.getKeyCode() == KeyEvent.VK_A){
            if (x - moveStep >= 0){
                x -= moveStep;
            }
        }else if (e.getKeyCode() == KeyEvent.VK_S){
            if (y + moveStep + objectHeight <= panelHeight){
                y += moveStep;
            }
        }else if (e.getKeyCode() == KeyEvent.VK_D) {
            if (x + moveStep + objectWidth <= panelWidth){
                x += moveStep;
            }
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