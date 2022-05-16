/* Filename:        Ball.java
 * Last Modified:   19 Mar 2014
 * Author:          Todd Parker
 * Email:           todd.i.parker@maine.edu
 * Course:          CIS314 - Advanced Java
 *
 * Ball.java implements Runnable so that each ball can possess its own thread.
 * Each Ball maintains is attributes such as size, coordinates, color, velocity,
 * and boundary limits.  Accesssor and Mutator methods are available for each
 * respective attribute to allow BallPanel to maintain a Ball's creation and
 * positioning.
 */

package com.bouncingball;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.util.Random;

public class Ball implements Runnable
{
    private Ellipse2D.Double ball; // Ball objects shape attributes
    private Dimension ballDimension; // Store size of a Ball
    private Point2D.Double ballCoords; // Store location coords of a Ball
    private Point2D.Double ballVelocity; // Store x and y velocity of Ball
    private final Color colorOfBall; // Store randomized color of ball
    private static final Point2D.Double xBoundaries = new Point2D.Double(0, 600); // Horizontal boundaries of a ball
    private static final Point2D.Double yBoundaries = new Point2D.Double(0, 440); // Vertical boundaries of a ball
    private final Random initialDirection = new Random();  // Randomize ball's initial left|right direction

    // Constructor
    public Ball(Color ballColor, double xPos, double yPos)
    {
        ballCoords = new Point2D.Double(xPos, yPos);
        ballDimension = new Dimension(50, 50);
        if( (initialDirection.nextInt(2) % 2 == 0) )
            ballVelocity = new Point2D.Double( 3, 10);
        else
            ballVelocity = new Point2D.Double(3,10);
        colorOfBall = ballColor; //
        setBallObject( ballCoords, ballDimension);
    } // End Ball constructor

    // Update ball position
    @Override
    public void run()
    {
        while(true)
        {
            updateBallPosition();

            try
            {
                Thread.sleep(20);
            }
            catch(Exception e){}
        }
    } // End run() method

    // Detect x|y boundary collisons and update Ball velocity
    public void updateBallPosition()
    {
        // if ball hasn't reached window max width, add 1 to x-coord
        if( ballVelocity.getX() > 0 )
        {
            if( (ballCoords.getX() + 1) < xBoundaries.getY() )
                ballCoords.setLocation( ballCoords.getX() + ballVelocity.getX() , ballCoords.getY());
                // else ball's x-coord has reached max, reverse direction
            else
            {
                ballVelocity.setLocation( -1, ballVelocity.getY());
                ballCoords.setLocation( ballCoords.getX() + ballVelocity.getX() , ballCoords.getY());
            }
        }
        // if ball hasn't reached window min width, minus 1 from x-coord
        else if( ballVelocity.getX() < 0 )
        {
            if( (ballCoords.getX() - 1) > xBoundaries.getX() )
                ballCoords.setLocation( ballCoords.getX() + ballVelocity.getX() , ballCoords.getY());
                // else ball's x-coord has reached min, reverse direction
            else
            {
                ballVelocity.setLocation( 1, ballVelocity.getY());
                ballCoords.setLocation( ballCoords.getX() + ballVelocity.getX() , ballCoords.getY());
            }
        }

        // if ball hasn't reached window max height, add 1 to y-coord
        if( ballVelocity.getY() > 0 )
        {
            if( (ballCoords.getY() + 1) < yBoundaries.getY() )
                ballCoords.setLocation( ballCoords.getX(), ballCoords.getY() + ballVelocity.getY());
                // else ball's y-coord has reached max, reverse direction
            else
            {
                ballVelocity.setLocation( ballVelocity.getX(), -1);
                //                ballCoords.setLocation( ballCoords.getX(), ballCoords.getY() + ballVelocity.getY());
            }
        }
        // if ball hasn't reached window min height, minus 1 from y-coord
        else if( ballVelocity.getY() < 0 )
        {
            if( (ballCoords.getY() - 1) > yBoundaries.getX() )
                ballCoords.setLocation( ballCoords.getX(), ballCoords.getY() + ballVelocity.getY());
                // else ball's y-coord has reached min, reverse direction
            else
            {
                ballVelocity.setLocation( ballVelocity.getX(), 1);
                ballCoords.setLocation( ballCoords.getX(), ballCoords.getY() + ballVelocity.getY());
            }
        }
        // Set new coordinates of ball
        setBallObject(ballCoords);

    } // End updateBallPosition() method

    // private method to set initial ball object
    private void setBallObject(Point2D loc, Dimension size)
    {
        ball = new Ellipse2D.Double( loc.getX(), loc.getY(), size.getWidth(), size.getHeight());
    } // End setBallObject() mutator

    // private overloaded method to set new ball values
    private void setBallObject(Point2D loc)
    {
        ball.setFrame(loc, ballDimension);
    } // End overloaded setBallObject() mutator

    // public method to return ball object
    public Ellipse2D.Double getBallObject()
    {
        return ball;
    } // End getballObject() accessor

    // public method to return velocity of ball object
    public Point2D getBallVelocity()
    {

        return ballVelocity;
    } // End getBallVelocity() accessor

    // public method to return coordinates of ball object
    public Point2D getBallCoords()
    {
        return ballCoords;
    } // End getBallCoords() accessor

    // public method to return color of ball object
    public Color getBallColor()
    {
        return colorOfBall;
    } // End getBallColor() accessor

    // public method to return dimensions of ball
    public Dimension getBallDimension()
    {
        return ballDimension;
    } // End getBallDimension() accessor

} // end BouncingBallsContainer class