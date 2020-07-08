import ecs100.*;
import java.awt.Color;
/**
 * Draws the buttons the user can select to choose a button
 * 
 * @author Benjamin Ameye
 * @version 1
 */
public class GenreButtons
{
    // instance variables - replace the example below with your own
    //public static final int 
    
    private static final double SIZE = 45;
    
    private double buttonX, buttonY;
    private Color buttonColor, textColor;
    private String GenreText;
    /**
     * Constructor for objects of class DrawGenres
     * Initialises the fields
     */
     public GenreButtons(double x, double y,Color Bcolor,Color Tcolor, String Genre)
    {
        // initialise instance variables
        this.buttonX = x;
        this.buttonY = y;
        this.buttonColor = Bcolor;
        this.textColor = Tcolor;
        this.GenreText = Genre;
        this.draw();
    }

    /**
     * Draws the buttons
     * Writes the name of the button
     */
     public void draw()
    {
        // Draws the button
        UI.setColor(this.buttonColor);
        UI.setLineWidth(SIZE);
        UI.drawLine(this.buttonX, this.buttonY, this.buttonX+30, this.buttonY);
        // Writing the name of the genre
        UI.setColor(this.textColor);
        UI.drawString(this.GenreText, this.buttonX, this.buttonY);
    }
    
    /**
     * Reports whether the point (x, y) s on the action genre button.
     */
    public boolean onButton(double x, double y)
    {
        if (x >= this.buttonX && x <= this.buttonX+SIZE &&
            y >= this.buttonY && y <= this.buttonY+SIZE)
            {
                return true;
            } else {
                return false;
            }
    }
}
