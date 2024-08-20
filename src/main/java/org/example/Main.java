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
    private final int moveStep = 10;

    private int x2 = 300; // Initial x position of the object
    private int y2 = 100; // Initial y position of the object
    private final int objectWidth2 = 50;
    private final int objectHeight2 = 50;
    private final int moveStep2 = 8;
    private Timer timer;

    public Main() {
        // Set the size of the JPanel
        this.setPreferredSize(new Dimension(400, 400));
        // Add the KeyListener to the JPanel
        this.setFocusable(true);
        this.addKeyListener(this);

        // Set up a timer to move the second object automatically
        timer = new Timer(100, this); // Timer will trigger every 100 milliseconds
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

        int panelWidth = this.getWidth();
        int panelHeight = this.getHeight();

        // Movement logic for object 2 (Blue, Computer-controlled)
        // Example: Move right until hitting the boundary, then move down
        if (x2 + moveStep2 + objectWidth <= panelWidth) {
            x2 += moveStep2;
        } else {
            x2 = 0; // Reset to the left side after reaching the right edge
            y2 += objectHeight; // Move down one step
            if (y2 + objectHeight > panelHeight) {
                y2 = 0; // Reset to the top after reaching the bottom
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