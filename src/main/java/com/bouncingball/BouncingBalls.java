
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
                Thread.sleep(5);
            }
            catch(Exception event){}
        }
    } // End main

} // End BouncingBalls class

