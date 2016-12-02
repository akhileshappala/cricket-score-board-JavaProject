public class Team
{
   // String[] players = new String[11];
    public Player[] players = new Player[11];
    /**Name of team */
    public String name;
    /**Whether team is batting or bowling */
    public int turn;
    /**Score of team */
    public int sc;
    /**Wickets fallen */
    public int wk;
    /**No of Overs  */
    public float ov;
    /**Player 1 */
    public int p1;
    /**Player 2 */
    public int p2;
    Team()
    {
    turn = 0;
    sc = 0;
    wk = 0;
    ov = 0.0f;
    p1 = 0;
    p2 = 1;
    }
}