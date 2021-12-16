import java.awt.Graphics2D;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.File;
import java.awt.Rectangle;

import java.awt.*;

public class Platforms
{

    private static final int Y1 = 100;
    private static final int Y2 = 200;
    private static final int Y3 = 300;
    private static final int Y4 = 400;

	private static final int WIDTH = 100;
	private static final int HEIGHT = 100; //100
    
    private Game game;

    public Platforms(Game game)
    {
        this.game = game;
    }

    //cloud x-axis position
    int x6 = 500;
    int x7 = 0;
    int x8 = 30;
    int x9 = 0;


    //cloud speed
    int xf = 3;
    int xg = 3;
    int xh = 3;
    int xi = 3;


    void movePlatform1()
    {
    
        if (x6 - xf < 0)
			xf = 2;
        if (x6 + xf > game.getWidth() - 100)
            xf = -2;
		

        x6 = x6 + xf;

    }


    void movePlatform2()
    {
        if (x7 + xg < 0)
            xg = 1;
        if (x7 + xg > game.getWidth() - 100)
            xg = -1;

        x7 = x7 + xg;

    }


    void movePlatform3()
    {
        if (x8 + xh < 0)
            xh = 3;
        if (x8 + xh > game.getWidth() - 100)
            xh = -3;

        x8 = x8 + xh;
        
        

    }


    void movePlatform4()
    {
        if (x9 + xi < 0)
            xi = 4;
        if (x9 + xi > game.getWidth() - 100)
            xi = -4;

        x9 = x9 + xi;

    }

    public void paint(Graphics2D g)
    {
        try 
        {



            Image cloudImage = ImageIO.read(new File("cloudfix.png"));

            g.drawImage(cloudImage, x6, Y1, WIDTH, HEIGHT, null);
            g.drawImage(cloudImage, x7, Y2, WIDTH, HEIGHT, null);
            g.drawImage(cloudImage, x8, Y3, WIDTH, HEIGHT, null);
            g.drawImage(cloudImage, x9, Y4, WIDTH, HEIGHT, null);

        } 
        catch (IOException e) 
        {
        
            e.printStackTrace();
        }

    }

  

    



    //collision detection: indicates the position of platforms
	public Rectangle getCloudBounds1() 
    {
		return new Rectangle(x6, Y1, 40, 20); //70, 20
	}
    public Rectangle getCloudBounds2() 
    {
		return new Rectangle(x7, Y2, 40, 20);
	}
    public Rectangle getCloudBounds3() 
    {
		return new Rectangle(x8, Y3, 40, 20);
	}
    public Rectangle getCloudBounds4() 
    {
		return new Rectangle(x9, Y4, 40, 20);
	}


	public int getCloudTopY1() 
    {
		return Y1;
	}
    public int getCloudTopY2() 
    {
		return Y2;
	}
    public int getCloudTopY3() 
    {
		return Y3;
	}
    public int getCloudTopY4() 
    {
		return Y4;
	}

    
	public int getCloudTopX1() 
    {
		return x6;
	}
    public int getCloudTopX2() 
    {
		return x7;
	}
    public int getCloudTopX3() 
    {
		return x8;
	}
    public int getCloudTopX4() 
    {
		return x9;
	}



    
}
