import ecs100.*;
import java.awt.Color;
/**
 * Draws the buttons the user can select to choose a button
 * 
 * @author Benjamin Ameye
 * @version 3
 */
public class GenreButtons
{
    // instance variables
    private static final double SIZE = 45;
    
    //Declaring variables
    private double buttonX, buttonY;
    private Color buttonColor, textColor;
    private String GenreText;
    /**
     * Constructor for objects of class DrawGenres
     * Initialises the fields
     * 
     * @param x The value for the x axis of the buttons
     * @param y The value for the y axis of the buttons
     * @param Bcolor The Color of the buttons
     * @param Tcolor The Color of the text on the buttons
     * @param Genre The text that is printed on the buttons
     * 
     */
     public GenreButtons(double x, double y
     , Color Bcolor, Color Tcolor, String Genre)
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
        UI.drawLine(this.buttonX, this.buttonY, 
        this.buttonX + 30, this.buttonY);
        // Writing the name of the genre
        UI.setColor(this.textColor);
        UI.drawString(this.GenreText, this.buttonX, this.buttonY);
    }
    
    /**
     * Reports whether the point (x, y) s on the action genre button.
     * 
     * @param x Where the user clicked on the X axis
     * @param y Where the user clicked on the Y axis
     * 
     * @return true/false Whether the user clicked on a button
     */
    public boolean onButton(double x, double y)
    {
        
        if (x >= this.buttonX && x <= this.buttonX + (SIZE - (SIZE/3)) && 
         y >= this.buttonY - SIZE && y <= this.buttonY + SIZE*2)
            {
                return true;
            } else 
            {
                return false;
            }
    }
}
