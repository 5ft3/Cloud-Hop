import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.File;
import java.awt.*;

public class Coin 
{
   
    private Game game;

    public Coin(Game game)
    {
        this.game = game;
    }

    int coinsCollected = 0;

    //coin x-axis position
    int x6 = 500;
    int x7 = 0;
    int x8 = 30;
    int x9 = 0;


    //coin speed
    int xf = 3;
    int xg = 3;
    int xh = 3;
    int xi = 3;


    void moveCoin1()
    {
    
        if (x6 - xf < 0)
			xf = 2;
        if (x6 + xf > game.getWidth() - 100)
            xf = -2;
		

        x6 = x6 + xf;

    }


    void moveCoin2()
    {
        if (x7 + xg < 0)
            xg = 1;
        if (x7 + xg > game.getWidth() - 100)
            xg = -1;

        x7 = x7 + xg;

    }


    void moveCoin3()
    {
        if (x8 + xh < 0)
            xh = 3;
        if (x8 + xh > game.getWidth() - 100)
            xh = -3;

        x8 = x8 + xh;
        
        

    }


    void moveCoin4()
    {
        if (x9 + xi < 0)
            xi = 4;
        if (x9 + xi > game.getWidth() - 100)
            xi = -4;

        x9 = x9 + xi;

    }


    public void paint(Graphics g) 
    {
        try 
        {

            Image coin = ImageIO.read(new File("coin.png"));
    
            g.drawImage(coin, x6+30, 100, 30, 30, null);
            g.drawImage(coin, x7+30, 200, 30, 30, null);
            g.drawImage(coin, x8+30, 300, 30, 30, null);
            g.drawImage(coin, x9+30, 400, 30, 30, null);

        } 
        catch (IOException e) 
        {
        
            e.printStackTrace();
        }

    }

    //collision detection: indicates the hitbox of coins
	public Rectangle getCoinBounds1() 
    {
		return new Rectangle(x6, 110, 10, 10);
	}
    public Rectangle getCoinBounds2() 
    {
		return new Rectangle(x7, 210, 10, 10);
	}
    public Rectangle getCoinBounds3() 
    {
		return new Rectangle(x8, 310, 10, 10);
	}
    public Rectangle getCoinBounds4() 
    {
		return new Rectangle(x9, 310, 10, 10);
	}
    
}
