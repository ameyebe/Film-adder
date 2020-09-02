import java.util.HashMap;
import java.util.*;
import ecs100.*;
/**
 * Holds the films
 * 
 * @author Benjamin Ameye
 * @version 4
 */
public class Film
{
    // Setting up Hashmap
    private HashMap<String, Name> filmsStored;
    
    // Declaring variables to store the films score, director and genre
    private String filmDirector = "";
    private String filmGenre = "";
    private int filmScore = 0;
    private Recomender r = new Recomender();

    /**
     * Constructor for objects of class Film
     */
    public Film()
    {
        // Creating a hashmap to store the films and their information
        filmsStored = new HashMap<String, Name>();    
    }

    /**
     * prints all the films, along with their scores, genres, and directors
     * 
     */
    public void printFilms()
    {
        //Printing all films
        UI.println("These are all the films we have");
        UI.println();
        for (String name : filmsStored.keySet())
        {
            //setting variables to use when printing
            filmScore = filmsStored.get(name).getScore();
            filmDirector = filmsStored.get(name).getDirector();
            filmGenre = filmsStored.get(name).getGenre();
            
            // Printing on multiple lines to make it easier to read.
            UI.println("Films Name: " + name);
            UI.println("Score: " + filmScore + "/100");
            UI.println("Director: " + filmDirector);
            UI.println("Genre: " + filmGenre);
            UI.println();
        }
    }
    
    
    /**
     * Prints the films based on the director the user has entered
     * 
     * @param director  The name of the films director
     */
    public void printDirectors(String director)
    {
        UI.println();
        UI.println("These are the films we have, directed by " + director);
        UI.println();
        
        for (String name : filmsStored.keySet())
        {
            //Checks if the current films directed by the director selected
            filmDirector = filmsStored.get(name).getDirector();
            if (filmDirector.equals(director))
            {
               //setting variables to use when printing
                filmScore = filmsStored.get(name).getScore();
                filmGenre = filmsStored.get(name).getGenre();
                // Printing on multiple lines to make it easier to read.
                UI.println("Films Name: " + name);
                UI.println("Score: " + filmScore + "/100");
                UI.println("Genre: " + filmGenre);
                UI.println();
            }
        }
    }
    
    /**
     * Prints the films based on what genre the user has selected
     * 
     * @param genre The genre chosen by the user
     * 
     */
    public void printGenres(String genre)
    {
        UI.println();
        UI.println("Here are all ours films under the " + genre + " genre");
        boolean noGenre = true;
        UI.println();
        
        for (String name : filmsStored.keySet())
        {
            filmGenre = filmsStored.get(name).getGenre();
            //Checking if the current films genre is the one the user wanted
            if (filmGenre.equals(genre))
            {
                //setting variables to use when printing
                filmScore = filmsStored.get(name).getScore();
                filmDirector = filmsStored.get(name).getDirector();
                // Printing on multiple lines to make it easier to read.
                UI.println("Films Name: " + name);
                UI.println("Score: " + filmScore + "/100");
                UI.println("Director: " + filmDirector);
                noGenre = false;
                UI.println();
            }
        }
        
        //Tells the user if their arn't any films to print
        if (noGenre == true)
        {
            UI.println("We have no films under the " + genre + " genre");
        }
    }
    
    /**
     * Prints the films based on the score the user has chosen
     * Checks how the user wants to print the films
     * 
     * @param score  the score chosen by the user
     * @param method  how the user wants to print the films
     */
    public void printScore(double score, String method)
    {
        //Converts current score to a int
        int scoreSet = (int)score;
        boolean noFilms = true;
        
        if (method.equals("A"))
        {
            UI.println("Here are all our films with a score" 
                + "of " + scoreSet + " or above");
        }
        else if (method.equals("B"))
        {
            UI.println("Here are all our films with a score" +
                " 5 points above or below " + scoreSet);
        }
        
        UI.println();
        for (String name : filmsStored.keySet())
        {
            filmScore = filmsStored.get(name).getScore();
            filmGenre = filmsStored.get(name).getGenre();
            filmDirector = filmsStored.get(name).getDirector();
            /*checks if the user wants to print
             * films with a score equal to the entered score of current score*/
            if (method.equals("A"))
            {
                /*Checking if the current films score 
                 * is greater than or equal to the user score*/
                if (filmScore >= scoreSet)
                {
                    // Printing on multiple lines to make it easier to read.
                    UI.println("Films Name: " + name);
                    UI.println("Score: " + filmScore);
                    UI.println("Director: " + filmDirector);
                    UI.println("Score: " + filmScore + "/100");
                    UI.println();
                    noFilms = false;
                }
            }
            
            else if (method.equals("B"))
            {
                /*Checks if the user wants to prints all films with a 
                 * score within 5 points above or below the current score*/
                if (filmScore >= scoreSet - 5 && filmScore <= scoreSet + 5)
                {
                    // Printing on multiple lines to make it easier to read
                    UI.println("Films Name: " + name);
                    UI.println("Score: " + filmScore + "/100");
                    UI.println("Director: " + filmDirector);
                    UI.println("Genre: " + filmGenre);
                    UI.println();
                    noFilms = false;
                }
            }
        } 
        
        //Tells the user if there arn't any films to print.
        if (noFilms == true && method.equals("A"))
        {
            UI.println("We dont have any films with a score of " 
                + scoreSet + ", or above");
        }
        
        else if (noFilms == true && method.equals("B"))
        {
            UI.println("We don't have any films with a score 5 points" + 
                " above or below " + scoreSet);
        }
    }
    
    /**
     * Basically has the user view the film. 
     * 
     * @param film the name of the film the user selected
     */
    public void watchFilm(String film)
    {
        //Setting variables
        filmScore = filmsStored.get(film).getScore();
        filmGenre = filmsStored.get(film).getGenre();
        filmDirector = filmsStored.get(film).getDirector();
        //Printing the films information
        UI.println("Films Name: " + film);
        UI.println("Score: " + filmScore + "/100");
        UI.println("Director: " + filmDirector);
        UI.println("Genre: " + filmGenre);
        UI.sleep(1500);
        
    }
    
    /**
     * Asks the user how and if they'd like to recommend the film
     * @param name the name of the film they've watched
     */
    public void recomend(String name)
    {
        //Checks if there are enough films to warrent recomending one
        if (filmsStored.size() >= 3)
        {
            boolean recomend = true;
            while (recomend == true)
            {
                //Asking to user if they want a film recomended to them
                String getRecomend = UI.askString("Would you like a film to" + 
                    " recomended, yes ('Y') or no ('N'): ");
                getRecomend = getRecomend.toUpperCase();
                if (getRecomend.equals("Y"))
                {
                    recomend = false;
                    //Calls the method that recomends a film
                    r.chooseRecomendation(filmsStored, name);
                }
                
                else if (getRecomend.equals("N"))
                {
                    recomend = false;
                    UI.println("Then please continue to use our site to" +
                        " search for films you like");
                }
            }
        }
        else
        {
            UI.println("Please continue to use our site to search for" +
                " Films you like");
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
        filmsStored.put(name, new Name(director, score, genre));
        
        //Telling user the film has been added
        UI.println(name + " has been added");
    }
}
