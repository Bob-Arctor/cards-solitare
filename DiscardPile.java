import java.util.Random;

class DiscardPile extends CardPile 
{   
  // constructors
	
	public DiscardPile (int x, int y, int suitP, int tableauP)
	{
		super(x, y);
		suitPiles = suitP;
		tableauPiles = tableauP;
	}
	public DiscardPile(int x, int y) 
    { 
		this(x, y, 4, 7); 
	}

  // mutators
    public void addCard (Card aCard) 
    {   if (! aCard.faceUp())
            aCard.flip();
        super.addCard(aCard);
    }

    public void select (int tx, int ty) 
    {   if (isEmpty())
            return;
        Card topCard = pop();
        for (int i = 0; i < suitPiles; i++)
            if (Game.suitPile(i).canTake(topCard)) 
            {   Game.suitPile(i).addCard(topCard);
                return;
            }
        for (int i = 0; i < tableauPiles; i++)
            if (Game.tableau(i).canTake(topCard)) 
            {   Game.tableau(i).addCard(topCard);
                return;
            }
        // nobody can use it, put it back on our list
        addCard(topCard);
    }
    
    //internal params
	private int suitPiles;
	private int tableauPiles;
}
