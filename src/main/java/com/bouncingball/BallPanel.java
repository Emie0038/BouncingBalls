package com.bouncingball;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class BallPanel extends JPanel {
    private ArrayList<Ball> balls;
    private final Random colorGenerator = new Random();
    private ExecutorService threadExecutor;
    private Color ballColor;
    private Student_Sig_Block sig;
    private Integer numBalls = 0;

    // constructor
    public BallPanel() {
        sig = new Student_Sig_Block(52);
        balls = new ArrayList();
        threadExecutor = Executors.newCachedThreadPool();
        addMouseListener(
                new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        createBall(e.getX(), e.getY());
                        numBalls = balls.size();
                    } // end mouseClicked
                } // end MouseAdapter()
        ); // End anonymous inner class
    } // End BouncingBalls constructor

    // Creates a BouncingBall, and executes it in a thread, for each mouse click
    public void createBall(double x, double y) {
        // Randomly generate a ball color
        ballColor = new Color(colorGenerator.nextInt(255), colorGenerator.nextInt(255), colorGenerator.nextInt(255));
        // Add new ball object to a LinkedList
        balls.add(new Ball(ballColor, x, y));
        // Executes new thread of created ball object
        threadExecutor.execute(balls.get(balls.size() - 1));
    } // end createBall() method

    // Called from loop in main() to continuously repaint BallPanel()
    public void moveBall() {
        repaint();
    } // end moveBall() method

    // Sets the default JPanel size when pack() is called
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(640, 480);
    } // End Overloaded JPanel Dimension

    // Overridden paintComponent() method to display balls and signature block
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        Graphics2D g2d = (Graphics2D) g;
        for (Ball ball : balls) {
            g2d.setPaint(ball.getBallColor());
            g2d.fillOval((int) ball.getBallCoords().getX(), (int) ball.getBallCoords().getY(), (int) ball.getBallDimension().getWidth(), (int) ball.getBallDimension().getHeight());
        }

        // Display signature block information
        g.setColor(Color.WHITE);
        g.fillRect(65, 20, 345, 80);

        g.setColor(Color.BLACK);
        g.setFont(new Font("Courier New", Font.PLAIN, 12));
        g.drawString(sig.getBorder(), 50, 30);
        g.drawString(sig.getName(), 65, 50);
        g.drawString("Balls created:  " + numBalls.toString(), 275, 50);
        g.drawString("Active Threads: " + Thread.activeCount(), 275, 65);
        g.drawString(sig.getCourse(), 65, 70);
        g.drawString(sig.getEmail(), 65, 65);
        g.drawString(sig.getBorder(), 50, 100);

    } // End Overloaded paintCompenent()
} // end MyPanel class
