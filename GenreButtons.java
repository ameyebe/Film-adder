import ecs100.*;
import java.awt.Color;
/**
 * Draws the buttons the user can select to choose a button
 * 
 * @author Benjamin Ameye
 * @version 4
 */
public class GenreButtons
{
    // instance variables
    private static final double SIZE = 45;
    
    //Declaring variables
    private double buttonX, buttonY;
    private Color buttonColor, textColor;
    private String genreText;
    /**
     * Constructor for objects of class DrawGenres
     * Initialises the fields
     * 
     * @param x The value for the x axis of the buttons
     * @param y The value for the y axis of the buttons
     * @param bColor The Color of the buttons
     * @param tColor The Color of the text on the buttons
     * @param genre The text that is printed on the buttons
     * 
     */
    public GenreButtons(double x, double y,
        Color bColor, Color tColor, String genre)
    {
        // initialise instance variables
        this.buttonX = x;
        this.buttonY = y;
        this.buttonColor = bColor;
        this.textColor = tColor;
        this.genreText = genre;
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
            this.buttonX + 35, this.buttonY);
        // Writing the name of the genre
        UI.setColor(this.textColor);
        UI.drawString(this.genreText, this.buttonX, this.buttonY);
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
        //Checks if the user clicked on one of the buttons
        if (x >= this.buttonX - (SIZE / 2)  && x <= this.buttonX + 
            (SIZE * 2 - 32.5) && y >= this.buttonY - (SIZE / 2) && 
            y <= this.buttonY + (SIZE / 2))  
        {
            return true;
        }
        
        return false;   
    }
}
