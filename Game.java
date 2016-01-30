import java.awt.*;
import java.awt.event.*;

public class Game 
{ 
  // constructors
    public Game (int suitPiles, int tableauPiles) 
    {
		// first allocate the arrays
        allPiles = new CardPile[13];
            // then fill them in
        allPiles[0] = new DeckPile(335, 30);
        allPiles[1] = new DiscardPile(268, 30, suitPiles, tableauPiles);
        for (int i = 0; i < suitPiles; i++)
            allPiles[2+i] =
                new SuitPile(15 + (CardView.width+10) * i, 30);
        for (int i = 0; i < tableauPiles; i++)
            allPiles[6+i] =
                new TablePile(15 + (CardView.width+5) * i, 
									CardView.height + 35, i+1, 
									suitPiles, 
									tableauPiles); 
    }
    public Game ()
    {	this(4, 7); }
    
    public static void paint (CardView cv) {
		for (int i = 0; i < 13; i++) {
			allPiles[i].display(cv);
		}
	} 
	
	public static void mouseDown (int x, int y) {
		System.out.println(x + " " + y);
		for (int i=0; i < 13; i++) {
			if( allPiles[i].includes(x, y)) {
				allPiles[i].select(x,y);
				System.out.println("boo");
			}
		}
	}
	
	public static CardPile deckPile () 
	{	return allPiles[0]; }
	
	public static CardPile discardPile ()
	{	return allPiles[1]; }
	
	public static CardPile tableau (int index)
	{	return allPiles[6+index]; }
	
	public static CardPile suitPile (int index)
	{	return allPiles[2+index]; }
	
	// single array to alias all above piles -- to aid polymorphism
    static private CardPile allPiles [ ];
}
