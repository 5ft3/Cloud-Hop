import java.awt.event.KeyEvent;
import java.awt.Graphics2D;

import java.io.IOException;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


import java.io.File;


import java.awt.*;
public class Bunny 
{
	private static final int WIDTH = 100;
	private static  int HEIGHT = 100;

	//Bunny starting position
	int x = 400;
	int y = 460;
 
	int xa = 0;
	int ya = 0;

    private Game game;

	public Bunny(Game game) 
    {
		this.game= game;
	}

    public void move() 
    {
		
		if (x + xa > 0 && x + xa < game.getWidth()-30)
			x = x + xa;

		if (y + ya > 0 && y + ya < game.getHeight()-100)
	
			y = y + ya;	
	
		if (collisionCloud1())
		{
			x -= (xa-3);
			y -=   ya;
			
		}
		if (collisionCloud2())
		{
			x -= (xa-3);
			y -=  ya;
		}
		if (collisionCloud3())
		{
			x -= (xa - 3);
			y -=  ya;
		}
		if (collisionCloud4())
		{		
			//if player falls off cloud, player will move on the y axis 6 pixel aka "fall"
			x -= (xa - 3);
			y -=  ya;
		}


		if(game.health.health == 3 && collisionGhost1()||collisionGhost2()||collisionGhost3())
		{
			game.health.health = 2;
			
			x -= (xa - 10);
			y -=  (ya*2);
		

			try
			{
          
				File musicPath = new File("sparkleSound.wav");
				
				if(musicPath.exists())
				{
					AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
					Clip clip = AudioSystem.getClip();
					clip.open(audioInput);
					clip.start();

				}
				else
				{
					System.out.println("Can't find file");
				}
        	}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}

		
		if(game.health.health == 2 && collisionGhost1()||collisionGhost2()||collisionGhost3())
		{
			game.health.health = 1;
	
			x -= (xa - 10);
			y -=  (ya*2);
			
			try
			{
          
				File musicPath = new File("sparkleSound.wav");
				
				if(musicPath.exists())
				{
					AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
					Clip clip = AudioSystem.getClip();
					clip.open(audioInput);
					clip.start();

				}
				else
				{
					System.out.println("Can't find file");
				}
        	}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}


		if(game.health.health == 1 && collisionGhost1()||collisionGhost2()||collisionGhost3())
		{
			game.health.health = 0;
		
			x -= (xa - 10);
			y -=  (ya *2) ;

			try
			{
          
				File musicPath = new File("sparkleSound.wav");
				
				if(musicPath.exists())
				{
					AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
					Clip clip = AudioSystem.getClip();
					clip.open(audioInput);
					clip.start();

				}
				else
				{
					System.out.println("Can't find file");
				}
        	}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			
		}

	}

	public void paint(Graphics2D g) 
    {
	
		try
		{	
			
			Image mainCharacterLeft = ImageIO.read(new File("bunnyleft.png"));
			g.drawImage(mainCharacterLeft, x, y, WIDTH, HEIGHT, null);
	
		}
		catch (IOException e) 
        {
        
            e.printStackTrace();
        }
	
	}

	public void keyReleased(KeyEvent e) 
    {
		xa = 0;

		//adding jumping mechanic
		ya = 6;
	
	}
	
	public void keyPressed(KeyEvent e) 
    {
	
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			xa = -3;
				
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			xa = 3;
		
		if (e.getKeyCode() == KeyEvent.VK_SPACE)

			ya = -10;
	
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
			ya = 3;	
					
	}


	//collision detection: indicates the position of bunny
	public Rectangle getBounds() 
    {
		return new Rectangle(x, y, 50, 50);
	}

	public int getTopY() 
    {
		return y;
	}

    
	public int getTopX() 
    {
		return x;
	}

	
	
	private boolean collisionCloud1() {
		
		return game.cloud.getCloudBounds1().intersects(getBounds());
	}
	private boolean collisionCloud2() {
		
		return game.cloud.getCloudBounds2().intersects(getBounds());
	}
	private boolean collisionCloud3() {
		
		return game.cloud.getCloudBounds3().intersects(getBounds());
	}
	private boolean collisionCloud4() {
	
		return game.cloud.getCloudBounds4().intersects(getBounds());
	}


	private boolean collisionGhost1() {

		return game.ghost.getGhostBounds1().intersects(getBounds());
	}
	private boolean collisionGhost2() {
	
		return game.ghost.getGhostBounds2().intersects(getBounds());
	}
	private boolean collisionGhost3() {
	
		return game.ghost.getGhostBounds3().intersects(getBounds());
	}


	private boolean collisionCoin1() {
	
		return game.coin.getCoinBounds1().intersects(getBounds());
	}
	private boolean collisionCoin2() {
	
		return game.coin.getCoinBounds2().intersects(getBounds());
	}
	private boolean collisionCoin3() {
	
		return game.coin.getCoinBounds3().intersects(getBounds());
	}
	private boolean collisionCoin4() {
	
		return game.coin.getCoinBounds4().intersects(getBounds());
	}





    
}
