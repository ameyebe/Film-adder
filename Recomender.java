import java.util.HashMap;
import java.util.*;
import ecs100.*;
/**
 * recomends films to the user.
 * Gets the films score as a int
 * Gets the films director as a String
 * Gets the films genre as a string
 *
 * @author Benjamin Ameye
 * @version 4
 */
public class Recomender
{
    //Initialising variables to use when printing
    private String director, genre = "";
    private int score = 0;
    
    //Setting up numbers for films that can be recomended
    private int possibleS, possibleG, possibleD = 0;
    //Settting up variables to use to store info on the user's chosen film
    private String selectedD, selectedG = "";
    private int selectedS = 0;
    //Setting up arraylist to randomly select a film
    ArrayList<String> recomendations = new ArrayList<String>();
    
    /**
     * Asks the user how they want a film recomended to them
     * 
     * @param Films the hashmap thats holds the films, 
     *  their genre, score and director
     * @param selectedFilm the film the user has watched
     */
    public void chooseRecomendation(HashMap<String, Name> Films, 
        String selectedFilm)
    {
        //Clearing recomendations arraylist
        recomendations.clear();
        /*Setting variables to the genre, score and director 
         * for the film the user selected*/
        selectedG = Films.get(selectedFilm).getGenre();
        selectedD = Films.get(selectedFilm).getDirector();
        selectedS = Films.get(selectedFilm).getScore();
        //Restting possible films to be recomeneded back to 0
        possibleS = 0;
        possibleG = 0; 
        possibleD = 0;
        //Counting up how many films can be recomended
        countPossibilities(selectedFilm, Films);
        if (possibleS >= 2 || possibleG >= 2 || possibleD >= 2)
        {
            //Showing the user how they can have a film recomended to them
            UI.println("How would you like to have a film recomended: ");
            UI.println();
            //For each option it'll check if their are enough films for it
            if (possibleS >= 2)
            {
                UI.println("'A', get a recomendation with a score" + 
                    " greater than or equal to the current score");
                UI.println("Current score: " + selectedS);
                UI.println("Possible films: " + possibleS);
                UI.println();
            }
                
            if (possibleD >= 2)
            {
                UI.println("'B', get a recomendation with the director");
                UI.println("Current Director: " + selectedD);
                UI.println("Possible films: " + possibleD);
                UI.println();
            }
                
            if (possibleG >= 2)
            {
                UI.println("'C', get a recomendation with the current genre");
                UI.println("Current Genre: " + selectedG);
                UI.println("Possible films: " + possibleG);
                UI.println();
            }
            UI.println("Just press enter without typing anthing to leave this");
            
            boolean chooseRecomend = true;
            while (chooseRecomend == true)
            {
                //Asking the user how they want a film recomended
                String method = UI.askString("Please enter the letter" +  
                    " for how you'd like a recomendation: ");
                //Checking what option the user has chosen and if it's valid
                method = method.toUpperCase();
                if (method.equals("A") && possibleS >= 2)
                {
                    recomendScore(selectedFilm, Films, selectedS);
                    chooseRecomend = false;
                }
                else if (method.equals("B") && possibleD >= 2)
                {
                    recomendDirector(selectedFilm, Films, selectedD);
                    chooseRecomend = false;
                }
                
                else if (method.equals("C") && possibleG >= 2)
                {
                    recomendGenre(selectedFilm, Films, selectedG);
                    chooseRecomend = false;
                }
                
                else if (method.equals(""))
                {
                    UI.println("Then please feel free to search for a film");
                    chooseRecomend = false;
                }
                else
                {
                    UI.println("Not a method");
                }
            }
        }
        
        else
        {
            UI.println("Sorry, we can't recomend any films based on the " +
                "score, director or genre of " 
                + selectedFilm + "At the moment");
        }
    }
    
    /**
     * Counts how many of each film that can be recomended
     * 
     * @param selectedFilm The film selected by the user
     * @param Films the hashmap thats holds the films, 
     *  their genre, score and director
     */
    public void countPossibilities(String selectedFilm, 
        HashMap<String, Name> Films)
    {
        for (String names : Films.keySet())
        {
            //Setting variables to use for selecting the film
            director = Films.get(names).getDirector();
            genre = Films.get(names).getGenre();
            score = Films.get(names).getScore();
            //Counting up how many films can be recomended
            if (!names.equals(selectedFilm))
            {
                if (director.equals(selectedD))
                {
                    possibleD += 1;
                    if (!recomendations.contains(names))
                    {
                        recomendations.add(names);
                    }
                }
                
                if (genre.equals(selectedG))
                {
                    possibleG += 1;
                    if (!recomendations.contains(names))
                    {
                        recomendations.add(names);
                    }
                }
                
                if (score >= selectedS)
                {
                    possibleS += 1;
                    if (!recomendations.contains(names))
                    {
                        recomendations.add(names);
                    }
                }
            }
        }
    }
    
    /**
     * Recomends a film based on the score
     * 
     * @param selectedFilm  the film the user has watched
     * @param Films  the hashmap that contains the films
     * @param selectedScore the current score to search based of
     *  the film the user selected
     */
    public void recomendScore(String selectedFilm, HashMap<String, Name> Films, 
    int selectedScore)
    {
        Random rand = new Random();
        boolean chooseFilm = true;
        while (chooseFilm == true)
        {
            //Selecting a random film
            String recomendedFilm = recomendations.get(rand.nextInt
                (recomendations.size()));
            director = Films.get(recomendedFilm).getDirector();
            genre = Films.get(recomendedFilm).getGenre();
            score = Films.get(recomendedFilm).getScore();
            /*Checking if the randomly chosen film 
             * isn't the one the user already selected*/
            if (!recomendedFilm.equals(selectedFilm) && score >= selectedScore)
            {
                UI.println();
                UI.println("Since you liked " + selectedFilm + " We" +
                    " also recomend this film");
                UI.println();
                UI.println("Films name: " + recomendedFilm);
                UI.println("Film director: " + director);
                UI.println("Film score: " + score + "/100");
                UI.println("Film Genre " + genre);
                chooseFilm = false;
            }
        }
    }
    
    /**
     * recomends a film based on the director
     * 
     * @param selectedFilm the film the user has selected
     * @param Films the hashmap containing the films names,
     *  genres, directors, and scores
     *  @param selectedDirector the director of the film the
     *  user has selected
     */
    public void recomendDirector(String selectedFilm, 
        HashMap<String, Name> Films, String selectedDirector)
    {
        Random rand = new Random();
        boolean chooseFilm = true;
        while (chooseFilm == true)
        {
            //Selecting a random film
            String recomendedFilm = recomendations.get(rand.nextInt
                (recomendations.size()));
            director = Films.get(recomendedFilm).getDirector();
            genre = Films.get(recomendedFilm).getGenre();
            score = Films.get(recomendedFilm).getScore();
            /*Checking if the randomly chosen film 
             * isn't the one the user already selected*/
            if (!recomendedFilm.equals(selectedFilm) 
                && director.equals(selectedDirector))
            {
                UI.println();
                UI.println("Since you liked " + selectedFilm + " We" +
                    " also recomend this film");
                UI.println();
                UI.println("Films name: " + recomendedFilm);
                UI.println("Film director: " + director);
                UI.println("Film score: " + score + "/100");
                UI.println("Film Genre: " + genre);
                chooseFilm = false;
            }
        }
    }
    
    /**
     * Recomends films based on the genre
     * 
     * @param selectedFilm the film selected by the user
     * @param Films a hashmap contaning the films name, director
     *  score and genre
     *  @param selectedGenre the genre for the film selected by the user
     */
    public void recomendGenre(String selectedFilm, 
        HashMap<String, Name> Films, String selectedGenre)
    {
        Random rand = new Random();
        boolean chooseFilm = true;
        while (chooseFilm == true)
        {
            //Selecting a random film
            String recomendedFilm = recomendations.get(rand.nextInt
                (recomendations.size()));
            director = Films.get(recomendedFilm).getDirector();
            genre = Films.get(recomendedFilm).getGenre();
            score = Films.get(recomendedFilm).getScore();
            /*Checking if the randomly chosen film 
             * isn't the one the user already selected*/
            if (!recomendedFilm.equals(selectedFilm) 
                && genre.equals(selectedGenre))
            {
                UI.println();
                UI.println("Since you liked " + selectedFilm + " We" +
                    " also recomend this film");
                UI.println();
                UI.println("Films name: " + recomendedFilm);
                UI.println("Film director: " + director);
                UI.println("Film score: " + score + "/100");
                UI.println("Film Genre: " + genre);
                chooseFilm = false;
            }
        }
    }
}