import ecs100.*;
import java.util.*;
/**
 * Gets the films name
 * Gets the films genre
 * Gets the films director
 * Gets the films score
 * 
 * @author Benjamin Ameye
 * @version 3
 */
public class FilmGUI
{
    // instance variables
    private Film F = new Film();
    private double SCORE = 50;
    
    
    //Declaring my array list's
    ArrayList<String> Names = new ArrayList<String>();
    ArrayList<String> OtherGenres = new ArrayList<String>();
    ArrayList<String> Films = new ArrayList<String>();
    
    /**
     * Constructor for objects of class FilmGui
     */
    public FilmGUI(double MIN, double MAX, double INIT)
    {
        //Initialising the buttons
        UI.initialise();
        UI.addButton("Quit", UI::quit);
        UI.addButton("Add a film", this::name);
        UI.addButton("Print all films", this::Films);
        UI.addButton("Print films by genre", this::FilmGenres);
        UI.addButton("Print films based on director", this::FilmDirectors);
        UI.addButton("Print films by score", this::FilmScores);
        UI.addSlider("Set minimum score to search", MIN, MAX, INIT, this::setScore);
        UI.setDivider(0.0);
    }
    
    /**
     * Sets the films the user wants to search
     */
    private void setScore(double Score)
    {
        //Setting the score on the slider
        UI.clearPanes();
        this.SCORE = Score;
        UI.println("Current minimum search score: " + SCORE);
        
    }
    
    /**
     * Prints all the current films directors and asks the user which one they'd like to select.
     * 
     */
    public void FilmDirectors()
    {
        
        UI.clearPanes();
        for (String name : Names)
        {
            UI.println(name);
        }
        
        boolean Select = true;
        
        while (Select == true)
        {
           String Director = UI.askString("Please enter the directort you'd like to view: ");
           Director = Director.toLowerCase();
           Director = CapitalizeString(Director);
           boolean Check = Names.contains(Director);
           
           if (Check)
            {
               F.printDirectors(Director);
               Select = false;
           }
           
           else
           {
               UI.println("We don't have any films by " + Director);
            }
        }

    }
    
    /**
     * Has the user enter the films name
     * Checks if the film has already been added
     * 
     */
    public void name()
    {
        boolean Add = true;
        
        //Asking the user for the films name
        UI.clearPanes();
        while (Add == true)
        {  
            String name = UI.askString("Please enter the name of the film: ");
            name = name.toLowerCase();
            name = CapitalizeString(name);
            //Checking is we already have the film the user entered stored
            boolean Checkfilm = Films.contains(name);
            
            if (Checkfilm)
            {
                UI.println(name + ", is already on this site");
            }
            
            else
            {
                Films.add(name);
                Add = false;
                newFilm(name);
            }
        }
        
    }
    
    /**
     * Adds a film
     * 
     * @param FilmName The name of the film entered by the user
     */
    public void newFilm(String FilmName)
    {  
        //Asking the user for the films director
        
        UI.println();
        String director = UI.askString("Please enter the name of the films director: ");
        director = director.toLowerCase();
        director = CapitalizeString(director);

        //Checking to see if the director of the new film is already stored
        boolean AddDirector = Names.contains(director);
        
        if (AddDirector)
        {
            UI.println();
        }
        else
        {
            //Adding the director to the arrylist if it's not already present
            Names.add(director);
            UI.println();
        }
        
        // Asking to user to select a genre
        String Genre = "";
        Genres G = new Genres();
        G.DrawButtons(Genre);
        Genre = (G.getGenre());
        
        //If the user select other, asks the user for the other genre
        if (Genre.equals("Other"))
        {
            Genre = UI.askString("Please enter the new genre of film");
            Genre = Genre.toLowerCase();
            Genre = CapitalizeString(Genre);
            boolean AddGenre = OtherGenres.contains(Genre);
            
            if (AddGenre)
            {
                UI.println();
            }
            
            else
            {
               OtherGenres.add(Genre);
               UI.println();
            }
        }
        
        else
        {
            UI.println();
        }
        
        UI.println(Genre);
        //Asking the user for the films score
        boolean enterScore = true;
        while (enterScore == true)
        {
            int score = UI.askInt("Please enter the films average score (0 to 100): ");
            UI.println();
            
            if (score >= 0 && score <= 100)
            {
                F.addFilm(FilmName, director, score, Genre);
                enterScore = false;
            }
            else if (score < 0 || score > 100)
            {
                UI.println(score + " is out of range");
            }
        }
        
    }
    
    /**
     * Prints all the films
     * 
     */
    public void Films()
    {
        UI.clearPanes();
        F.printFilms();
    }
    
    /**
     * Prints films based on the grenre selected
     * 
     */
    public void FilmGenres()
    {
        UI.clearPanes();
        // Asking to user to select a genre
        String Genre = "";
        Genres G = new Genres();
        G.DrawButtons(Genre);
        Genre = (G.getGenre());
        
        //If the user select other, asks the user for the other genre
        if (Genre.equals("Other"))
        {
            for (String Othergenre : OtherGenres)
            {
                UI.println(Othergenre);
            }
            boolean ChooseotherGenre = true;
            
            while (ChooseotherGenre == true)
            {
                Genre = UI.askString("Please enter the other genre you'd like to view: ");
                Genre = Genre.toLowerCase();
                Genre = CapitalizeString(Genre);
                boolean ChooseGenre = OtherGenres.contains(Genre);
                
                if (ChooseGenre)
                {
                    ChooseotherGenre = false;
                }
                
                else
                {
                    UI.println(Genre + " is not a genre we have stored");
                }
            }
        }
        
        F.printGenres(Genre);
    }
    
    /**
     * Prints films based on the score the user has selected
     * 
     */
    public void FilmScores()
    {
        UI.clearPanes();
        this.F.printScore(this.SCORE);
    }
    
    
    /**
     * Main Routine for my function
     */
    public static void main(String [] args)
    {  
        // min, max and initial score of the films
        final double SCOREMIN = 0;
        final double SCOREMAX = 100;
        final double SCOREINIT = 50;
        
        FilmGUI obj = new FilmGUI(SCOREMIN, SCOREMAX, SCOREINIT);
    }
    
    /**
     * Makes it so the first letter of each word in a string is capital
     * 
     * @param str the string entered by the user
     */
    static String CapitalizeString(String str)
    {
        // Creating a char array
        char wordArray[] = str.toCharArray();
        for (int i = 0; i < str.length(); i++)
        {
            {
                if (i == 0 && wordArray[i] != ' ' ||
                    wordArray[i] != ' ' && wordArray[i-1] == ' ')
                    {
                        //Checking if the current character is a number or not
                        boolean checkChar = Character.isDigit(wordArray[i]);
                        
                        if (!checkChar)
                        {
                            wordArray[i] = (char)(wordArray[i] - 'a' + 'A');
                        }
                     }
                }
           }
        
        String STR = new String(wordArray);
        return STR;
    }
    
}
