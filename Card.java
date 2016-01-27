import java.awt.*;

public class Card 
{ 
  // internal data fields
    private boolean faceup;  // card face exposed?
    private int r;           // card rank
    private SUIT s;           // card suit
  
  // public constants for card dimensions
    public final static int width = 50;
    public final static int height = 70;

  // ENUM class for card suits
	public enum SUIT {
		HEART, SPADE, DIAMOND, CLUB
	}

  // constructors
    public Card (SUIT sv, int rv) 
    { s = sv; r = rv; faceup = false; }

  // mutators 
    public final void flip() { faceup = ! faceup; }

  // accessors
    public final int rank () { return r; }

    public final SUIT suit() { return s; }

    public final boolean faceUp() { return faceup; }

    public final Color color() 
    {   if (faceUp())
            if (suit() == SUIT.HEART || suit() == SUIT.DIAMOND)
                return Color.red;
            else
                return Color.black;
        return Color.yellow;
    }

    public void draw (Graphics g, int x, int y) 
    {   String names[] = {"A", "2", "3", "4", "5", "6",
            "7", "8", "9", "10", "J", "Q", "K"};
            // clear rectangle, draw border
        g.clearRect(x, y, width, height);
        g.setColor(Color.blue);
        g.drawRect(x, y, width, height);
            // draw body of card
        g.setColor(color());
        if (faceUp()) 
        {   g.drawString(names[rank()], x+3, y+15);
            if (suit() == SUIT.HEART) 
            {   g.drawLine(x+25, y+30, x+35, y+20);
                g.drawLine(x+35, y+20, x+45, y+30);
                g.drawLine(x+45, y+30, x+25, y+60);
                g.drawLine(x+25, y+60, x+5, y+30);
                g.drawLine(x+5, y+30, x+15, y+20);
                g.drawLine(x+15, y+20, x+25, y+30);
            }
            else if (suit() == SUIT.SPADE) 
            {   g.drawLine(x+25, y+20, x+40, y+50);
                g.drawLine(x+40, y+50, x+10, y+50);
                g.drawLine(x+10, y+50, x+25, y+20);
                g.drawLine(x+23, y+45, x+20, y+60);
                g.drawLine(x+20, y+60, x+30, y+60);
                g.drawLine(x+30, y+60, x+27, y+45); 
            }
            else if (suit() == SUIT.DIAMOND) 
            {   g.drawLine(x+25, y+20, x+40, y+40);
                g.drawLine(x+40, y+40, x+25, y+60);
                g.drawLine(x+25, y+60, x+10, y+40);
                g.drawLine(x+10, y+40, x+25, y+20);
            }
            else if (suit() == SUIT.CLUB) 
            {   g.drawOval(x+20, y+25, 10, 10);
                g.drawOval(x+25, y+35, 10, 10);
                g.drawOval(x+15, y+35, 10, 10);
                g.drawLine(x+23, y+45, x+20, y+55);
                g.drawLine(x+20, y+55, x+30, y+55);
                g.drawLine(x+30, y+55, x+27, y+45); 
            }
        }
        else 
        {       // face down
            g.drawLine(x+15, y+5, x+15, y+65);
            g.drawLine(x+35, y+5, x+35, y+65);
            g.drawLine(x+5, y+20, x+45, y+20);
            g.drawLine(x+5, y+35, x+45, y+35);
            g.drawLine(x+5, y+50, x+45, y+50);
        }
    }

  
}
