/**
 *Student Name: Mitul Mohammad Abdullah Al Mukit
 * Student ID: 1155165211
 * Date: 22/9/2022
 */




package exercise;

import javax.swing.JFrame; 
import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.TimeUnit;
/**
 * ShakeMe Game
 * Java Assignment 1
 * @author almukit
 * @since 22 September 2022
 */





public class ShakeMe extends JFrame implements ActionListener {

    /** Instance fields indicating size width x height. */
    protected int width, height; 
    /** 2D array of JButton object references. */
    protected JButton buttons[][];
    /** Number of YELLOW (turned-on) buttons. */
    protected int counter = 0;
    
    /** Default constructor. */
    public ShakeMe(){
        width = 20;
        height = 10; 
        initDisplay();
    }
    
    /** Constructor with given width and height of the ShakeMe object.
     * @param w is number of boxes left-to-right
     * @param h is number of boxed top-to-bottom
     */


    public ShakeMe (int w, int h)
    {
        width = w;
        height = h;
        initDisplay();

    }
    /** Initialize the ShakeMe window. */
    public final void initDisplay(){
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (ClassNotFoundException |
                IllegalAccessException |
                InstantiationException |
                UnsupportedLookAndFeelException exceptionobject) {

    }    
    
        setTitle("Java Shake Me");
        setLayout(new GridLayout(height, width)); 
        buttons = new JButton[height][width]; 
        for (int row = 0; row < height; row++)
            for (int col = 0; col < width; col++)
            {
                 buttons[row][col] = new JButton(row + ", " + col); 
                 buttons[row][col].setMargin(new Insets(1, 1, 1, 1)); 
                 buttons[row][col].addActionListener(this); 
                 add(buttons[row][col]);
                 if (row == height - 1)
                         buttons[row][col].setForeground(Color.RED);
            }
        setSize(width * 40, height * 40); setVisible(true); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
     /**
      * ActionPerformed on user clicking a target button, try to turn off the target.
      * On clearing all "YELLOW" targets, shake and show Done and Bye
      * @param eventObject 
      */
     @Override
       public void actionPerformed(ActionEvent eventObject) { 
           JButton target = (JButton) (eventObject.getSource());
           target.setForeground(Color.BLUE);
           if (!turnOffButton(target))
                // wrong target, shake()! 
               shake();
           else if (counter == 0) {
                shake();
                JOptionPane.showMessageDialog(null, "Done! Bye!"); 
                shake();
                System.exit(0);
           }
       }

        /** Slow down this process by sleeping this thread. */ 
        private void delay(long sleepInMS) {
            try {
                TimeUnit.MILLISECONDS.sleep(sleepInMS);
            } catch (InterruptedException exceptionobject) { 
                Thread.currentThread().interrupt();
            }
        }

        /** Shake the window. */ 
        private void shake() {
            Point windowLocation = getLocation();
            double round = 5, max_radius = 10, step = 100; 
            double limit = 2 * Math.PI * round;
            double angle_increment = limit / step; 
            double radius_increment = max_radius / step;

            for (double angle = 0,	radius = 0; 
                    angle < limit;
                    angle += angle_increment,	radius += radius_increment)
                    {
                        setLocation((int) (Math.cos(angle)*radius) + windowLocation.x,
                                    (int) (Math.sin(angle)*radius) + windowLocation.y);
                        this.delay(6);
                    }
                    this.setLocation(windowLocation);
            }
    /**
     * Turn on a button and increase the counter, taking two coordinates
     * @param h is the top-to-bottom coordinate (row index)
     * @param w is the left-to-right coordinate (column index)
     */    
    public void turnOnButton(int h, int w) {
        if (Color.YELLOW != buttons[h][w].getBackground()) {
            buttons[h][w].setBackground(Color.YELLOW);
            counter++;
        }
    }
    /** 
     * Turn off a button "object" and decrease the counter.
     * @param target is a JButton object reference
     * @return false if the target is NOT on; true after finishing the action
     */    
    public boolean turnOffButton(JButton target) {
        if (Color.YELLOW != target.getBackground())
            return false;
        target.setBackground(null);
        counter--;
        return true;
    }
    /**
     * TO DO: students should customize this method.
     * to show the last FIVE digits of your SID in YELLOW in BIG Buttons; AND
     * to show first 10-char of your SURNAME 1-by-1 RED-ON-YELLOW on the bottom
     */
    public void showMyInfo()
    {
        //Digit; 6 in YELLOW
        turnOnButton(1, 0);
        turnOnButton(1, 1);
        turnOnButton(1, 2);
        turnOnButton(1, 3);
        turnOnButton(2, 0);
        turnOnButton(3, 0);
        turnOnButton(4, 0);
        turnOnButton(5, 0);
        turnOnButton(5, 1);
        turnOnButton(5, 2);
        turnOnButton(5, 3);
        turnOnButton(4, 3);
        turnOnButton(3, 3);
        turnOnButton(3, 2);
        turnOnButton(3, 1);
        
        //Digit; 5 in YELLOW
        turnOnButton(1, 8);
        turnOnButton(1, 7);
        turnOnButton(1, 6);
        turnOnButton(1, 5);
        turnOnButton(2, 5);
        turnOnButton(3, 5);
        turnOnButton(3, 6);
        turnOnButton(3, 7);
        turnOnButton(3, 8);
        turnOnButton(4, 8);
        turnOnButton(5, 8);
        turnOnButton(5, 7);
        turnOnButton(5, 6);
        turnOnButton(5, 5);
        
        //Digit; 2  in YELLOW
        turnOnButton(1, 10);
        turnOnButton(1, 11);
        turnOnButton(1, 12);
        turnOnButton(1, 13);
        turnOnButton(2, 13);
        turnOnButton(3, 13);
        turnOnButton(3, 12);
        turnOnButton(3, 11);
        turnOnButton(4, 10);
        turnOnButton(5, 10);
        turnOnButton(5, 11);
        turnOnButton(5, 12);
        turnOnButton(5, 13);
        turnOnButton(3, 10);
        
        //Digit; 1 in YELLOW
        turnOnButton(2, 15);
        turnOnButton(1, 16);
        turnOnButton(2, 16);
        turnOnButton(3, 16);
        turnOnButton(4, 16);
        turnOnButton(5, 16);
        turnOnButton(5, 15);
        turnOnButton(5, 17);
        
        //Digit; 1 in YELLOW
        turnOnButton(2, 19);
        turnOnButton(1, 20);
        turnOnButton(2, 20);
        turnOnButton(3, 20);
        turnOnButton(4, 20);
        turnOnButton(5, 20);
        turnOnButton(5, 19);
        turnOnButton(5, 21);
        
        // surname with 5-char: M I T U L
        int c=0;
        buttons[height - 1][c].setText("M"); 
        turnOnButton(height - 1, c++); 
        buttons[height - 1][c].setText("I"); 
        turnOnButton(height - 1, c++); 
        buttons[height - 1][c].setText("T"); 
        turnOnButton(height - 1, c++); 
        buttons[height - 1][c].setText("U"); 
        turnOnButton(height - 1, c++);
        buttons[height - 1][c].setText("L"); 
        turnOnButton(height - 1, c++);
    }
    /**
     * main() method, starting point of the Java application
     * @param args are command line arguments in a String array
     */
    public static void main(String[] args) {
        ShakeMe myObj;
        // create a ShakeMe object of different size; Ex; 23 x 10
        myObj = new ShakeMe(23, 10);
        myObj.showMyInfo();
    }

}