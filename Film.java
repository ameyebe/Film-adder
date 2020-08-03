import java.util.HashMap;
import java.util.*;
import ecs100.*;
/**
 * Holds the films
 * 
 * @author Benjamin Ameye
 * @version 3
 */
public class Film
{
    // Setting up Hashmap
    private HashMap<String, Name> FilmsStored;
    
    // Declaring variables to store the films score, director and genre
    private String FilmDirector = "";
    private String FilmGenre = "";
    private int FilmScore = 0;
    

    /**
     * Constructor for objects of class Film
     */
    public Film()
    {
        // Creating a hashmap to store the films and their information
        FilmsStored = new HashMap<String, Name>();
        
    }

    /**
     * prints all the films, along with their scores, genres, and directors
     * 
     */
    public void printFilms()
    {
        //Printing all films
        UI.println("These are all the films we have");
        for (String name : FilmsStored.keySet())
        {
            FilmScore = FilmsStored.get(name).getScore();
            FilmDirector = FilmsStored.get(name).getDirector();
            FilmGenre = FilmsStored.get(name).getGenre();
            
            // Printing on multiple lines to make it easier to read.
            UI.println("Films Name: " + name);
            UI.println("Score: " + FilmScore);
            UI.println("Director: " + FilmDirector);
            UI.println("Genre: " + FilmGenre);
            UI.println();
        }
    }
    
    
    /**
     * Prints the films based on the director the user has entered
     * 
     * @param Director  The name of the films director
     */
    public void printDirectors(String Director)
    {
        UI.println("These are the films we have, directed by " + Director);
        UI.println();
        
        for (String name : FilmsStored.keySet())
        {
           //Checks if the current films directed by the director selected
           FilmDirector = FilmsStored.get(name).getDirector();
           if (FilmDirector.equals(Director))
            {
            FilmScore = FilmsStored.get(name).getScore();
            FilmGenre = FilmsStored.get(name).getGenre();
            // Printing on multiple lines to make it easier to read.
            UI.println("Films Name: " + name);
            UI.println("Score: " + FilmScore);
            UI.println("Genre: " + FilmGenre);
            UI.println();
           }
        }
    }
    
    /**
     * Prints the films based on what genre the user has selected
     * 
     * @param Genre The genre chosen by the user
     * 
     */
    public void printGenres(String Genre)
    {
        UI.println();
        UI.println("Here are all ours films under the " + Genre + " Genre");
        UI.println();
        
        for (String name : FilmsStored.keySet())
            {
            FilmGenre = FilmsStored.get(name).getGenre();
            //Checking if the current films genre is the one the user wanted
            if (FilmGenre.equals(Genre))
            {
                FilmScore = FilmsStored.get(name).getScore();
                FilmDirector = FilmsStored.get(name).getDirector();
                // Printing on multiple lines to make it easier to read.
                UI.println("Films Name: " + name);
                UI.println("Score: " + FilmScore);
                UI.println("Director: " + FilmDirector);
                UI.println();
            }
            
        }
        
    }
    
    /**
     * Prints the films based on the score the user has chosen
     * 
     * @param Score  the score chosen by the user
     */
    public void printScore(double Score)
    {
        int SCORE = (int)Score;
        
        UI.println("Here are all ours films with a score" 
         + "of " + SCORE + " or above");
        for (String name : FilmsStored.keySet())
        {
            FilmScore = FilmsStored.get(name).getScore();
            //Checking if the current films score is greater than or equal to the user score
            if (FilmScore >= SCORE)
            {
                FilmGenre = FilmsStored.get(name).getGenre();
                FilmDirector = FilmsStored.get(name).getDirector();
                // Printing on multiple lines to make it easier to read.
                UI.println("Films Name: " + name);
                UI.println("Score: " + FilmScore);
                UI.println("Director: " + FilmDirector);
                UI.println("Genre: " + FilmGenre);
                UI.println();
            }
        } 
    }
    
    /**
     * Adds a film to the hashmap 
     * Will also add a director to a array containing the directors
     * 
     * @param name     The name of the film
     * @param director The films director
     * @param score  The average score of the film (0 to 100)
     * @param genre  The films genre
     */
    public void addFilm(String name, String director, int score, String genre)
    {
        UI.clearPanes();
        //Adding a film to the Hash map
        FilmsStored.put(name, new Name(director, score, genre));
        
        UI.println(name + " has been added");
    }
}
