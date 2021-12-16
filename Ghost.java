import javax.swing.JPanel;
import java.awt.Graphics2D;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.File;

import java.awt.*;




public class Ghost extends JPanel
{

    private Game game;

    public Ghost(Game game)
    {
        this.game = game;
    }

    //ghost 1-5 position
    int x1 = -60;
	int y1 = 0;
    int x2 = -50;
	int y2 = 0;
    int x3 = 0;
	int y3 = 0;



    // //ghost 1-5 speed
    int xa = 3;
	int ya = 3;
    int xb = 1;
	int yb = 2;
    int xc = 3;
	int yc = 4;


    
	void moveGhost1() 
    {
		if (x1 + xa < 0)
			xa = 1;
		if (x1 + xa > game.getWidth() - 95)
			xa = -1;
		if (y1 + ya < 0)
			ya = 1;
		if (y1 + ya > game.getHeight() - 30)
			ya = -1;
		
		x1 = x1 + xa;
		y1 = y1 + ya;
	}


    void moveGhost2() 
    {
		if (x2 + xb < 0)
			xb = 1;
		if (x2 + xb > game.getWidth() - 95)
			xb = -1;
		if (y2 + yb < 0)
			yb = 1;
		if (y2 + yb > game.getHeight() - 30)
			yb = -1;
		
		x2 = x2 + xb;
		y2 = y2 + yb;
	}


    void moveGhost3() 
    {
		if (x3 + xc < 0)
			xc = 1;
		if (x3 + xa > game.getWidth() - 95)
			xc = -1;
		if (y3 + yc < 0)
			yc = 1;
		if (y3 + yc > game.getHeight() - 30)
			yc = -1;
		
		x3 = x3 + xc;
		y3 = y3 + yc;
	}


  

    public void paint(Graphics2D g)
    {
        try 
        {
            Image ghostImage = ImageIO.read(new File("ghostfix.png"));

            g.drawImage(ghostImage, x1, y1, 100, 50, null);
            g.drawImage(ghostImage, x2, y2, 100, 50, null);
            g.drawImage(ghostImage, x3, y3, 100, 50, null);
			// g.fillRect(x1, y1, 50, 50);
            // g.fillRect( x2, y2, 50, 50);
            // g.fillRect(x3, y3, 50, 50);
			
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
		
	}


	public Rectangle getGhostBounds1() 
    {
		return new Rectangle(x1, y1, 30, 30);
	}
    public Rectangle getGhostBounds2() 
    {
		return new Rectangle(x2, y2, 30, 30);
	}
    public Rectangle getGhostBounds3() 
    {
		return new Rectangle(x3, y3, 30, 30);
	}
   
    
}
