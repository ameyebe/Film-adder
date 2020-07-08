import java.util.HashMap;
import java.util.Arrays;
/**
 * Holds the films
 * 
 * @author Benjamin Ameye
 * @version 1
 */
public class Film
{
    // Setting up Hashmap
    private HashMap<String, Name> FilmsStored;
    
    //Declaring arrays
    private String[] Names;

    /**
     * Constructor for objects of class Film
     */
    public Film()
    {
        // Creating a hashmap to store the films and their data
        FilmsStored = new HashMap<String, Name>();
        
    }

    /**
     * prints all the films, along with their scores, genres, and directors
     * 
     */
    public void printFilms()
    {
        //Printing all films
        for (String name : FilmsStored.keySet())
        {
            System.out.println("Name: " + name + " Score: " + FilmsStored.get(name).getScore() + " Director: " + FilmsStored.get(name).getDirector() + " Genre: " + FilmsStored.get(name).getGenre());
        }
    }
    
    /**
     * Adds a film to the hashmap
     * @param   String name     The name of the film
     * @param   String Director The films director
     * @param   int score     The average score of the film (0 to 100)
     * @param   String genre     The films genre
     */
    public void addFilm(String name, String director, int score, String genre)
    {
        //Adding a film to the Hash map
        FilmsStored.put(name, new Name(director, score, genre));
    }
}
