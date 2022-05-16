/* Filename:        Student_Sig_Block.java
 * Last Modified:   28 Jan 2014
 * Author:          Todd Parker
 * Email:           todd.i.parker@maine.edu
 * Course:          CIS314 - Advanced Java
 *
 */
package com.bouncingball;

public class Student_Sig_Block
{
    // Declare variables to create ascii border for signature block
    String border = "";
    int border_Characters;
    // Declare and initialize variables to hold student/course information
    String name;
    String course_Info;
    String email;
    // Constructor initializes the number of asterisks in signature border and
    // initializes signature with default information
    public Student_Sig_Block(int borderChars)
    {
        name = "Emie Abalora";
        course_Info = "Computer Science";
        email = "";
        // Use a for loop structure to populate the border variable with an
        // 80 character line of *'s. Loop utilizes string concatenation.
        for (int i = 0; i < borderChars; ++i)
        {
            border += "*";
        }
    } // end Student_Sig_Block() constructor

    // Accessor to return border
    public String getBorder()
    {
        return border;
    } // end getBorder() method

    // Accessor to return sig name
    public String getName()
    {
        return name;
    } // end getName() method

    // Mutator to set sig name
    public void setName(String nameIn)
    {
        name = nameIn;
    } // end setName() method

    // Accessor to return sig email
    public String getEmail()
    {
        return email;
    } // end getEmail() method

    // Mutator to set sig email
    public void setEmail(String emailIn)
    {
        name = emailIn;
    } // end setEmail() method

    // Accessor to return sig course info
    public String getCourse()
    {
        return course_Info;
    } // end getCourse() method

    // Mutator to set sig course name
    public void setCourse(String courseIn)
    {
        name = courseIn;
    } // end setCourse() method
} // end class Student_Sig_Block