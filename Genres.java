import ecs100.*;
import java.awt.Color;
/**
 * Has the user select the button for what genre they want
 * 
 * @author Benjamin Ameye 
 * @version 4
 */
public class Genres
{
    // The genre buttons
    //Creating the arrays I'll use
    private static final int MAXGENRES = 6;
    private GenreButtons[] GenreList = new GenreButtons[MAXGENRES];
    private String[] GenreNames = {"Action", "Horror", "Sci Fi", "Romance", "Mystery", "Other"};
    private Color[] ButtonColors = {Color.red, Color.black, Color.green, Color.pink, 
    Color.yellow, Color.blue};
    private Color[] TextColors = {Color.green, Color.red, Color.white, Color.gray, 
    Color.blue, Color.orange};
    
    //Variables to pass into Genrebuttons
    private static final double LEFT = 50;  // X axis
    private static final double TOP = 60;  // Y axis
    private static double StartX, StartY;
    private static int ChosenGenre = 0;
    private String GenreName = "";
    private String Genre = "";
    private Color ButtonColor = null;
    private Color TextColor = null;
    
    private boolean Choose = true;
    
    /**
     * Draws the genre buttons
     */
    public void DrawButtons(String Genre)
    {
       UI.println("Please select what genre you want to select");
       //Drawing all the buttons
       for (int i = 0 ; i < MAXGENRES; i++)
       
       {
           this.GenreName = GenreNames[i];
           this.ButtonColor = ButtonColors[i];
           this.TextColor = TextColors[i];
           GenreList[i] = new GenreButtons(LEFT, TOP*(i+1), ButtonColor, TextColor, GenreName); 
        }
       
       //Having the user click on a button
       while (Choose == true)
       {
           UI.setMouseListener(this::manageButtons );
       }
       
       //Calling the method that sets the genre
       AssignGenre(ChosenGenre);
       
    }
    
    /**
     * Checks what genre the user has selected
     * 
     */
    public void AssignGenre(int ChosenGenre)
    {
        // Checking what button the user has clicked on
       if (ChosenGenre == 0)
       {
           Genre = "Action";
           UI.clearGraphics();
       }
       else if (this.ChosenGenre == 1)
       {
           UI.clearGraphics();
           Genre = "Horror";
        }
       else if (this.ChosenGenre == 2)
       {
           UI.clearGraphics();
           Genre = "Sci fi";
        }
        else if (this.ChosenGenre == 3)
       {
           UI.clearGraphics();
           Genre = "Romance";
        }
       else if (this.ChosenGenre == 4)
       {
           UI.clearGraphics();
           Genre = "Mystery";
        }
        else if (this.ChosenGenre == 5)
       {
           UI.clearGraphics();
           Genre = "Other";
        } 
    }
    
    /**
     * Checks what button the user has clicked on
     * @param String action     Checks whether the user has clicked on a button
     * @param   double x    checks the X axis of where the user has clicked
     * @param   double y    checks the Y axis of where the user has clicked
     */
    public void manageButtons(String action, double x, double y)
    {
        //Checking if the user clicked on a button
        if (action.equals("clicked"))
        {
           for (int i = 0 ; i < MAXGENRES; i++)
           {
               if (this.GenreList[i].onButton(x,y) == true)
               {
                   ChosenGenre = i;
                   Choose = false;
                }
           }
        }
    }
    
    /**
     * Used to get the films genre
     * @return   director  Returns the films genre
     */
    public String getGenre()
    {
        return Genre;
    }
   
}