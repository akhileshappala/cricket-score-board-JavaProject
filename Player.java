public class Player
{
    /**Name of the player */
    public String name;
    /**Whether the player has been out */
    public int out = 0;
    /**Whether the player has played the last ball of the over */
    public int play = 0;
    /**Score of each player */
    public int score = 0;
    Player()
    {
    }
    Player(String name)
    {
        this.name = name;
    }
}