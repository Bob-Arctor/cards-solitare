import java.awt.*;

public class WinFormsCardView extends CardView
{
	//constructor
	public WinFormsCardView (Graphics aGraphicsObject) {
		g = aGraphicsObject;
	}
	
	public void display (Card aCard, int x, int y)
	{
		if(aCard == null) {
			g.clearRect(x, y, width, height);
			g.setColor(Color.black);
			g.fillRect(x, y, width, height);
		} else {
			paintCard (aCard, x , y);
		}
	}
		
	private void paintCard (Card aCard, int x, int y) 
	{
		String names[] = {"A", "2", "3", "4", "5", "6",
            "7", "8", "9", "10", "J", "Q", "K"};
				// clear rectangle, draw border
		g.clearRect(x, y, width, height);
		g.setColor(Color.blue);
		g.drawRect(x, y, width, height);
           // draw body of card
		g.setColor(aCard.color());
		if (aCard.faceUp()) 
		{   g.drawString(names[aCard.rank()], x+3, y+15);
			if (aCard.suit() == Card.SUIT.HEART) 
			{   g.drawLine(x+25, y+30, x+35, y+20);
				g.drawLine(x+35, y+20, x+45, y+30);
				g.drawLine(x+45, y+30, x+25, y+60);
				g.drawLine(x+25, y+60, x+5, y+30);
				g.drawLine(x+5, y+30, x+15, y+20);
				g.drawLine(x+15, y+20, x+25, y+30);
			}
			else if (aCard.suit() == Card.SUIT.SPADE) 
			{   g.drawLine(x+25, y+20, x+40, y+50);
				g.drawLine(x+40, y+50, x+10, y+50);
				g.drawLine(x+10, y+50, x+25, y+20);
				g.drawLine(x+23, y+45, x+20, y+60);
				g.drawLine(x+20, y+60, x+30, y+60);
				g.drawLine(x+30, y+60, x+27, y+45); 
			}
			else if (aCard.suit() == Card.SUIT.DIAMOND) 
			{   g.drawLine(x+25, y+20, x+40, y+40);
				g.drawLine(x+40, y+40, x+25, y+60);
				g.drawLine(x+25, y+60, x+10, y+40);
				g.drawLine(x+10, y+40, x+25, y+20);
			}
			else if (aCard.suit() == Card.SUIT.CLUB) 
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
	
	private Graphics g;
}
