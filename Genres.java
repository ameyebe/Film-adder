import ecs100.*;
import java.awt.Color;
/**
 * Has the user select the button for what genre they want
 * 
 * @author Benjamin Ameye 
 * @version 2
 */
public class Genres
{
    // The genre buttons
    //Creating a array of genres
    private static final int MAXGENRES = 6;
    private GenreButtons[] GenreList = new GenreButtons[MAXGENRES];
    private String[] GenreNames = {"Action", "Horror", "Sci Fi", "Romance", "Mystery", "Other"};
    private Color[] ButtonColors = {Color.red, Color.black, Color.green, Color.pink, 
    Color.yellow, Color.blue};
    private Color[] TextColors = {Color.green, Color.red, Color.white, Color.gray, 
    Color.blue, Color.black};
    
    //Variables to pass into Genrebuttons
    private static final double LEFT = 50;
    private static final double TOP = 60;
    private static int ChosenGenre = 0;
    private String GenreName = "";
    private String Genre = "";
    private Color ButtonColor = null;
    private Color TextColor = null;
    
    private boolean Choose = true;

    
    /**
     * Constructor for objects of class Genres
     * @param   director    The name of the films director
     */
    /*public Genres(String Genre)
    {
        this.GenreType = Genre;
    }*/
    
    /**
     * Draws the genre buttons
     */
    public void DrawButtons(String Genre)
    {
        UI.println("Please select what genre you want to select");
       for (int i = 0 ; i < MAXGENRES; i++)
       
       {
           this.GenreName = GenreNames[i];
           this.ButtonColor = ButtonColors[i];
           this.TextColor = TextColors[i];
           GenreList[i] = new GenreButtons(LEFT, TOP*(i+1), ButtonColor, TextColor, GenreName); 
        }
       
        
       while (Choose == true)
       {
           UI.setMouseListener(this::manageButtons );
       }
       
       AssignGenre(ChosenGenre);
       
    }
    
    public void AssignGenre(int number)
    {
        // Checking what button the user has clicked on
       if (this.ChosenGenre == 0)
       {
           UI.clearPanes();
           Genre = "Action";
       }
       else if (this.ChosenGenre == 1)
       {
           UI.clearPanes();
           Genre = "horror";
        }
       else if (this.ChosenGenre == 2)
       {
           UI.clearPanes();
           Genre = "Sci fi";
        }
        else if (this.ChosenGenre == 3)
       {
           UI.clearPanes();
           Genre = "Romance";
        }
       else if (this.ChosenGenre == 4)
       {
           UI.clearPanes();
           Genre = "Mystery";
        }
        else if (this.ChosenGenre == 5)
       {
           UI.clearPanes();
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
        else
        {
            UI.println("Please click on one of the buttons");
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