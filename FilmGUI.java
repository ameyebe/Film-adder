import ecs100.*;
/**
 * Gets the films name
 * Gets the films genre
 * Gets the films director
 * Gets the films score
 * 
 * @author Benjamin Ameye
 * @version 1
 */
public class FilmGUI
{
    // instance variables
    private Film F = new Film();

    /**
     * Constructor for objects of class FilmGui
     */
    public FilmGUI()
    {
        UI.initialise();
        UI.addButton("Quit", UI::quit);
        UI.addButton("Add a film", this::newFilm);
        UI.addButton("Print all films", this::Films);
    }
    
    /**
     * Adds a film
     */
    public void newFilm()
    {
        //Asking the user for the films name
        UI.clearPanes();
        String name = UI.askString("Please enter the name of the film: ");
        name = name.toLowerCase();
        
        //Asking the user for the films director
        String director = UI.askString("Please enter the name of the films director: ");
        director = director.toLowerCase();
        
        //Asking the user for the films score
        int score = UI.askInt("Please enter the films average score (0 to 100): ");
        
        // Asking to user to select a genre
        String Genre = "";
        Genres G = new Genres();
        G.DrawButtons(Genre);
        Genre = (G.getGenre());
        UI.println("I have chosen " + Genre);
        
        F.addFilm(name, director, score, Genre);
        UI.print(name + " Has been added");
    }
    
    /**
     * Prints all the films
     * 
     */
    public void Films()
    {
        F.printFilms();
    }
    
    
    /**
     * Main Routine for my function
     */
    public static void main(String [] args)
    {
        FilmGUI obj = new FilmGUI();
    }
    
}
