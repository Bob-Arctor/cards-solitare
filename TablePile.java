import java.util.Enumeration ;

class TablePile extends CardPile
{ // constructors
    public TablePile (int x, int y, int c, int suitP, int tableauP) 
    {       // initialize the parent class
        super(x, y);
            // then initialize our pile of cards
        for (int i = 0; i < c; i++) 
        {   addCard(Game.deckPile().pop()); }
            // flip topmost card face up
        top().flip();
        
        suitPiles = suitP;
        tableauPiles = tableauP;
    }
    public TablePile (int x, int y, int c) {this(x,y,c,4,7);}

  // mutators
    public void select (int tx, int ty) 
    {   if (isEmpty())
            return;

            // if face down, then flip
        Card topCard = top();
        if (! topCard.faceUp()) 
        {   topCard.flip();
            return;
        }

            // else see if any suit pile can take card
        topCard = pop();
        for (int i = 0; i < 4; i++)
            if (Game.suitPile(i).canTake(topCard)) 
            {   Game.suitPile(i).addCard(topCard);
                return;
            }

            // else see if any other table pile can take card
        for (int i = 0; i < 7; i++)
            if (Game.tableau(i).canTake(topCard)) 
            {   Game.tableau(i).addCard(topCard);
                return;
            }

            // else put it back on our pile
        addCard(topCard);
    }

  // accessors
    public boolean canTake (Card aCard) 
    {   if (isEmpty())
            return aCard.rank() == 12;
        Card topCard = top();
        return (aCard.color() != topCard.color()) &&
               (aCard.rank() == topCard.rank() - 1);
    }

    public boolean includes (int tx, int ty) 
    {       // don't test bottom of card
        return x <= tx && tx <= x + CardView.width && y <= ty; 
    }

    public void display (CardView cv) 
    {   int localy = y;
		int hs = CardView.height / 2; //half size
        for (Enumeration e = thePile.elements(); e.hasMoreElements();) 
        {   Card aCard = (Card) e.nextElement();
            cv.display (aCard, x, localy);
            localy += hs;
        }
    }
    
    //private params - number of suit piles and tableau piles
	private int suitPiles;
	private int tableauPiles;
}
