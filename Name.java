
/**
 * Has the films score as a int
 * Has the films director as a String
 * Has the films genre as a string
 * 
 * @author Benjamin Ameye
 * @version 1
 */
public class Name
{
    private String director;
    private int score;
    private String genre;

    /**
     * Constructor for objects of class Name
     * @param   director    The name of the films director
     */
    public Name(String filmDirector, int filmScore, String filmGenre)
    {
        this.director = filmDirector;
        this.score = filmScore;
        this.genre = filmGenre;
    }

    /**
     * Used to get the films director
     * @return   director     Returns the name of the director
     */
    public String getDirector()
    {
        return this.director;
    }
    
    /**
     * Used to get the films score
     * @return   score    Returns the fims score (0 to 100)
     */
    public int getScore()
    {
        return this.score;
    }
    
    /**
     * Used to get the films genre
     * @return   director  Returns the films genre
     */
    public String getGenre()
    {
        return this.genre;
    }
}
