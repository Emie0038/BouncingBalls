/* Filename:        BouncingBalls.java
 * Last Modified:   24 Mar 2014
 * Author:          Todd Parker
 * Email:           todd.i.parker@maine.edu
 * Course:          CIS314 - Advanced Java
 *
 * BouncingBalls.java is comprises of two classes: BouncingBalls, which hosts
 * main(), creates the GUI, creates a BallPanel object, and enters into an
 * infinite loop for repainting moving ball objects; and, BallPanel, which
 * uses a MouseEvent listener to create a ball object (method createBall()) on
 * each mouse click, store it in a Linked List, and overrides paintComponent to
 * paint the balls and a signature block. Method moveBall() is called from
 * main() for the purpose of repainting BallPanel. Each Ball object is executed
 * via ExecutorService in its own thread.
 */

package com.bouncingball;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.concurrent.*;
import java.util.Random;

public class BouncingBalls
{
    public static void main(String[] args)
    {
        BallPanel b = new BallPanel(); // Create BallPanel - JPanel Object
        JFrame f = new JFrame("Bouncing Balls Funhouse");
        f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        f.add( b );
        f.setBackground(Color.BLACK);
        f.pack();
        f.setVisible(true);
        f.setResizable(false);
        while(true)
        {
            f.repaint(); // Repaint JFrame's black background
            b.moveBall(); // Move each Ball object
            try
            {
                Thread.sleep(20);
            }
            catch(Exception event){}
        }
    } // End main

} // End BouncingBalls class

