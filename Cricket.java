import java.awt.Font;
import javax.swing.*;
public class Cricket  
{
   /**Team 1 */
   public Team t1 = new Team();
   /**Team 2 */
   public Team t2 = new Team();
  Cricket()
   {
       t1.name = "INDIA";
       t1.players[0] = new Player("Sehwag");
       t1.players[1] = new Player("Ganbir");
       t1.players[2] = new Player("kohli");
       t1.players[3] = new Player("raina");
       t1.players[4] = new Player("dhoni");
       t1.players[5] = new Player("rahane");
       t1.players[6] = new Player("aswin");
       t1.players[7] = new Player("jadeja");
       t1.players[8] = new Player("shami");
       t1.players[9] = new Player("jayant yadav");
       t1.players[10] = new Player("umesh yadav");
       
       t2.name = "ENGLAND";
       t2.players[0] = new Player("cook");
       t2.players[1] = new Player("root");
       t2.players[2] = new Player("molin ali");
       t2.players[3] = new Player("baristo");
       t2.players[4] = new Player("strokes");
       t2.players[5] = new Player("buttler");
       t2.players[6] = new Player("batty");
       t2.players[7] = new Player("rashid");
       t2.players[8] = new Player("anderson");
       t2.players[9] = new Player("hammed");
       t2.players[10] = new Player("woaks");
      
     
       
   }
   /**Each ball that is bowled */
   
public boolean bowl(Team t, JTable team, int pos, JLabel runs, JLabel overs, JLabel wickets, JLabel score, JLabel bat, JLabel bowler, JLabel status, JLabel sco)
   {
       int p1, p2, p, s =0;
       p1 = t.p1;
       p2 = t.p2;
       int b = 0;
       boolean flag = false;
       
            if((int)t.ov % 2 == 0)//if even p1 will play
            { 
                while(p1 < 10 && t.players[p1].out == 1){
                 p1++;
                 if(t.players[p1].play == 1 && p1 < 11){
                     p1++;
                     if(p1 == p2 && p1<11)
                         p1++;
                 }
                }
                p = p1;
                t.p1 = p1;
            }
            else
            {
                while(p2 < 10 && t.players[p2].out == 1){
                 p2++;
                 if( t.players[p2].play == 1 && p1 < 11){
                     p2++;
                     if(p2 == p1 && p1 < 11)
                         p2++;
                 }
             }
                p = p2;
                t.p2 = p2;
            }
        if(t.wk == 10)
        {
            flag = true;
            t.turn = 0;
        }
        else
        {
            flag = false;
            t.turn = 1;
            t.players[p].play = 0;
            bat.setText(t.players[p].name);
        }
             s =(int)(Math.random()*8);
             if((Math.floor((t.ov %1)*10)/10) != 0.6)
                t.ov += 0.1;     
             if(flag==false){
            switch(s)
            {
                case 7: t.wk++;
                        t.players[p].out = 1;
                        status.setText("OUT!");
                        t.players[p].play = 1;
                        team.setValueAt(t.players[p].name+"  (Out)",p,pos);
                        sco.setText(""+t.players[p].score);
                        break;
                default: t.sc += s;
                        if((Math.floor((t.ov %1)*10)/10) != 0.6)
                            t.players[p].score += s;
                         runs.setText(""+s);
                         status.setText(" ");
                         team.setValueAt(t.players[p].name+" (Batting)",p,pos);
                         sco.setText(""+t.players[p].score);

            }
           
            if((Math.floor((t.ov %1)*10)/10) == 0.6)
            {
                t.ov += 0.4;
                status.setText("New Over");
                t.players[p].play = 1;
                b = (int)(Math.random()*11);
                if(t.name.equals(t1.name))
                    bowler.setText(""+t2.players[b].name);
                else if(t.name.equals(t2.name))
                    bowler.setText(""+t1.players[b].name);
               team.setValueAt(t.players[p].name,p,pos);
               
                if(t.players[p].out == 1)
                    team.setValueAt(t.players[p].name+"  (Out)",p,pos);
                sco.setText(""+t.players[p].score);
                overs.setText(""+Math.floor(t.ov*10)/10);
            }
            else if((Math.floor((t.ov %1)*10)/10) < 0.6)
            {   
                if(t.players[p].out != 1){
                    t.players[p].play = 0;
                    status.setText(" ");                
                }
                else
                    status.setText("OUT!");
                score.setText(""+t.sc);
                wickets.setText(""+t.wk);
                status.setText("");
                overs.setText(""+Math.floor(t.ov*10)/10);
            }
            if(t.ov <= 0.5f){
                if(t.name.equals(t1.name))
                    bowler.setText(""+t2.players[b].name);
                else if(t.name.equals(t2.name))
                    bowler.setText(""+t1.players[b].name);
            }
             }
            return flag;
   }
    
}
