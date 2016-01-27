import java.awt.*;

public class Card 
{ 
  // internal data fields
    private boolean faceup;  // card face exposed?
    private int r;           // card rank
    private SUIT s;           // card suit

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
  
}
