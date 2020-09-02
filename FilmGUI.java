import ecs100.*;
import java.util.*;
import java.awt.Color;
/**
* Gets the films name
* Gets the films genre
* Gets the films director
* Gets the films score
* Sets the search score
* lets the user watch a film
* 
* @author Benjamin Ameye
* @version 4
*/
public class FilmGUI
{
    // instance variables
    private Film F = new Film();
    private double SCORE = 50;
                      
    //Declaring my array list's to store names
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
        UI.addButton("View film", this::View);
        UI.addButton("Add a film", this::name);
        UI.addButton("Search all films", this::Films);
        UI.addButton("Search films by genre", this::FilmGenres);
        UI.addButton("Search films based on director", this::FilmDirectors);
        UI.addButton("Search films by score", this::FilmScores);
        UI.addSlider("Set score to use for search", MIN, MAX, INIT, this::setScore);
        UI.setDivider(0.0);
        }
                    
    /**
    * Sets the films the user wants to search
    */
    private void setScore(double Score)
    {
        //Setting the score on the slider
        this.SCORE =  Score;
            
        double settingScore = Score;
        int currentScore = (int)settingScore;
        
        //Displaying the current search score    
        String text = "Current search score: " + currentScore + "/100";
        UI.setColor(Color.blue);
        UI.setLineWidth(35);
        UI.drawLine(150, 200, 300, 200);
        UI.setColor(Color.green);
        UI.drawString(text, 150, 200);               
    }
        
    /**
    * Has the user enter a film then view it
    * asks it they liked or disliked it.
    * 
    */
    public void View()
    {
        UI.clearPanes();
        String film = "";
        //Checks if their are any films to print
        if (!Films.isEmpty())
        {
            //Prints the names of all the films currently stored
            UI.println("These are alll the films we have");
            for (String filmName : Films)
            {
                UI.println(filmName);
            }
            boolean selectFilm = true;
                
            UI.println();
            while (selectFilm == true)
            {
                //Gets the name of the film the user wants to watch
                film = UI.askString("Please enter the film you want to view: ");
                film = film.toLowerCase();
                //Capitalises the first eltter of each word in the string
                film = CapitalizeString(film);
                
                //Checks if that film is stored and prints it if it is
                if (Films.contains(film))
                {
                    //Calling the method that shows a film
                    F.watchFilm(film);
                    selectFilm = false;
                }
                else
                {
                    UI.println(film + " is not a film we have");
                }
            }
                
            boolean rate = true;
            //Asking the user if they liked the film, or not
            while (rate == true)
            {
                UI.println();
                String thoughts = UI.askString("Did you like the film, yes ('Y') or no ('N'): ");
                thoughts = thoughts.toUpperCase();
                if (thoughts.equals("Y"))
                {
                    UI.println("That's very good to know");
                    rate = false;
                    //Calling the method that recomends a film
                    F.recomend(film);
                }
                    
                else if (thoughts.equals("N"))
                {
                    UI.println("I see....");
                    UI.sleep(1200);
                    UI.println("We are truely sorry");
                    rate = false;
                }
                else
                {
                    UI.println("thats not an option");
                }
            }
        }
            
        else if (Films.isEmpty())
        {
            UI.clearPanes();
            UI.println("No films have been added yet");
        }
    }
                    
    /**
    * Prints all the current films directors and asks the user which one they'd like to select.
    * 
    */
    public void FilmDirectors()
    {
        //Checks if there are any films/directors to print
                        
        if (!Names.isEmpty())
        {
            UI.clearPanes();
            UI.println("These are all the directors we have");
            //Prints the the directors currently stored
            for (String name : Names)
            {
                UI.println(name);
            }
                        
            boolean Select = true;
            UI.println();            
            while (Select == true)
            {
                //Asks the user for the directors name
                String Director = UI.askString("Please enter the director you'd like to view: ");
                Director = Director.toLowerCase();
                //Capitalizing first character of each word
                Director = CapitalizeString(Director);
                           
                //Checks if that director is stored
                if (Names.contains(Director))
                {
                    //calling the method that prints films based on the director
                    F.printDirectors(Director);
                    Select = false;
                }
                       
                else
                {
                    UI.println("We don't have any films by " + Director);
                }
            }
        }
        else
        {
            UI.clearPanes();
            UI.println("We don't have any films at the moment, so no directors");
        }
    }
                
    /**
    * Has the user enter the films name
    * Checks if the film has already been added
    * 
    */
    public void name()
    {
        //Asking the user for the films name
        boolean Add = true;       
        UI.clearPanes();
        while (Add == true)
        {  
            String name = UI.askString("Please enter the name of the film: ");
            name = name.toLowerCase();
            //Capitalizing first character of each word
            name = CapitalizeString(name);
                        
            //Checking is the film the user entered is already stored
            if (Films.contains(name))
            {
                UI.println(name + ", is already on this site");
                UI.sleep(2000);
                UI.clearPanes();
            }
                        
            else
            {
                Films.add(name);
                Add = false;
                //Calls the method where the user selects the score, genre and director
                newFilm(name);
            }
        }
    }
                
    /**
    * Asks the user for the films genre, score and director
    * 
    * @param FilmName The name of the film entered by the user
    */
    public void newFilm(String FilmName)
    {  
        //Asking the user for the films director
        UI.println();
        String director = UI.askString("Please enter the name of the films director: ");
        director = director.toLowerCase();
        //capitalizing the first letter of each word
        director = CapitalizeString(director);
            
        //Checking to see if the director of the new film is already stored      
        if (!Names.contains(director))
        {
            //Adding the director to the arrylist if it's not already present
            Names.add(director);
        }
        UI.println();
            
        // Asking to user to select a genre
        String Genre = "";
        Genres G = new Genres();
        G.DrawButtons(Genre);
        Genre = (G.getGenre());
                    
        //If the user selects other, it'll ask the user to enter their own genre
        if (Genre.equals("Other"))
        {
            Genre = UI.askString("Please enter the new genre of film");
            Genre = Genre.toLowerCase();
            //Capitalizing first character of each word
            Genre = CapitalizeString(Genre);   
            //Adds the new genre to the arraylist of other genre's if it's not present
            if (!OtherGenres.contains(Genre))
            {
               OtherGenres.add(Genre);
            }
        }
                    
        UI.println(Genre);
        UI.println();
        //Asking the user for the films score
        boolean enterScore = true;
        while (enterScore == true)
        {
            int score = UI.askInt("Please enter the films average score (0 to 100): ");
            UI.println();
            //Checks if score is within or out of range
            if (score >= 0 && score <= 100)
            {
                //Calling the method that adds a film
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
        //Checking if there are any films to print
        if (!Films.isEmpty())
        {
            //call the method that prints all films
            F.printFilms();
        }
                    
        else
        {
            UI.println("We don't have any films");
        }
    }
                
    /**
    * Prints films based on the grenre selected
    * 
    */
    public void FilmGenres()
    {
        UI.clearPanes();
        boolean ChooseotherGenre = false;
        boolean noGenre = true;
        // Asking to user to select a genre
        if (!Films.isEmpty())
        {
            String Genre = "";
            Genres G = new Genres();
            G.DrawButtons(Genre);
            Genre = (G.getGenre());
                
            //If the user select other, asks the user for the other genre
            //tells the user if their arn't any other genres to select
            if (Genre.equals("Other") && !OtherGenres.isEmpty())
            {
                UI.println();
                UI.println("These are the other genres we have");
                for (String Othergenre : OtherGenres)
                {
                    UI.println(Othergenre);
                    ChooseotherGenre = true;
                }
                    
                UI.println();
                while (ChooseotherGenre == true)
                {
                    Genre = UI.askString("Please enter the other genre you'd like to view: ");
                    Genre = Genre.toLowerCase();
                    //Capitalizing first character of each word
                    Genre = CapitalizeString(Genre);
                        
                    if (OtherGenres.contains(Genre))
                    {
                        //Calling the method that prints films based on the genre
                        F.printGenres(Genre);
                        ChooseotherGenre = false;
                    }
                        
                    else
                    {
                        UI.println(Genre + " is not a genre we have stored");
                    }
                }
                
            }
            //tells the user if their arn't any other genres to select    
            else if (Genre.equals("Other") && OtherGenres.isEmpty())
            { 
                UI.println("We don't have any other genres");
            }
                 
            else
            {
                //Calling the method that prints films based on the genre
                F.printGenres(Genre);
            } 
        }
        
        else if (Names.isEmpty())
        {
            UI.clearPanes();
            UI.println("No films have been added yet");
        }
    }
        
    /**
    * Prints films based on the score the user has selected
    * Asks the user how they want to print the films
    * 
    */
    public void FilmScores()
    {
        if (!Films.isEmpty())
        {
            UI.clearPanes();
            //displaying the options for how to have a film recomended based on the score
            UI.println("Would you like to print films with a score");
            UI.println("equal to or greater than the current selected score");
            UI.println();
            UI.println("Or would you like to print films with a score"); 
            UI.println("within 5 point above or below the currently selected score");
            UI.println();
            boolean ChooseScore = true;
            //asking the user how they'd like to print the films based on the score.
            while (ChooseScore == true)
            {
                String method = UI.askString("Please enter 'A' for the first option, or 'B' " + 
                    "for the second option");
                method = method.toUpperCase();
                //Checks if the user chose one of the methods
                if (method.equals("A") || method.equals("B"))
                {
                    ChooseScore = false;
                    //Calling the method that prints films based on the score
                    this.F.printScore(this.SCORE, method);
                }
                else
                {
                    UI.println("Thats not an option");
                }
            }
        }
            
        else
        {
            UI.clearPanes();
            UI.println("We don't have any films to print");
        }
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
        
        //Calling the buttons
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
                //Checking if the current character if lowercase and the first character of a word
                if (i == 0 && wordArray[i] != ' ' ||
                    wordArray[i] != ' ' && wordArray[i-1] == ' ')
                    {
                        //Checking if the current character is a number or not
                        
                        if (!Character.isDigit(wordArray[i]))
                        {
                            wordArray[i] = (char)(wordArray[i] - 'a' + 'A');
                        }
                     }
                }
           }
        
        String STR = new String(wordArray);
        //Returning the new string
        return STR;
    }
}