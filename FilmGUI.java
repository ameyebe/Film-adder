import ecs100.*;
import java.util.*;
/**
 * Gets the films name
 * Gets the films genre
 * Gets the films director
 * Gets the films score
 * 
 * @author Benjamin Ameye
 * @version 2
 */
public class FilmGUI
{
    // instance variables
    private Film F = new Film();
    private double SCORE = 50;
    
    //Declaring a array list
    ArrayList<String> Names = new ArrayList<String>();
    
    /**
     * Constructor for objects of class FilmGui
     */
    public FilmGUI(double MIN, double MAX, double INIT)
    {
        
        UI.initialise();
        UI.addButton("Quit", UI::quit);
        UI.addButton("Add a film", this::newFilm);
        UI.addButton("Print all films", this::Films);
        UI.addButton("Print films by genre", this::FilmGenres);
        UI.addButton("Print films based on director", this::FilmDirectors);
        UI.addButton("Print films by score", this::FilmScores);
        UI.addSlider("Score the search", MIN, MAX, INIT, this::setScore);
        UI.setDivider(0.0);
    }
    
    /**
     * Sets the films the user wants to search
     */
    private void setScore(double Score)
    {
        this.SCORE = Score;
        UI.println(SCORE);
        UI.sleep(2000);
        UI.clearPanes();
        
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
     * Adds a film
     */
    public void newFilm()
    {
        boolean Add = true;
        
        //Asking the user for the films name
        UI.clearPanes();
        String name = UI.askString("Please enter the name of the film: ");
        name = name.toLowerCase();
        UI.println();
        
        //Asking the user for the films director
        String director = UI.askString("Please enter the name of the films director: ");
        director = director.toLowerCase();     
        
        //Checking to see if the director of the new film is already stored
        boolean AddDirector = Names.contains(director);
        
        if (AddDirector)
        {
            UI.println();
        }
        else
        {
            Names.add(director);
            UI.println();
        }
        //Asking the user for the films score
        int score = UI.askInt("Please enter the films average score (0 to 100): ");
        UI.println();
        
        // Asking to user to select a genre
        String Genre = "";
        Genres G = new Genres();
        G.DrawButtons(Genre);
        Genre = (G.getGenre());
        
        F.addFilm(name, director, score, Genre);
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
    
}
