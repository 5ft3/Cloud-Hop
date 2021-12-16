import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;


import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;


@SuppressWarnings("serial")

class Game extends JPanel 
{
    Ghost ghost = new Ghost(this);
    Platforms cloud = new Platforms(this);
    Bunny bunny = new Bunny(this);
    Coin coin = new Coin(this);
    BackgroundImage background = new BackgroundImage();
    Cat cat = new Cat();
    HealthBar health = new HealthBar();
    
   



    public Game() 
    {
		addKeyListener(new KeyListener() 
        {
			@Override
			public void keyTyped(KeyEvent e) 
            {
			}

			@Override
			public void keyReleased(KeyEvent e) 
            {
				bunny.keyReleased(e);
			}

			@Override
			public void keyPressed(KeyEvent e) 
            {
				bunny.keyPressed(e);
			}
		});
		setFocusable(true);
	}



    private void move()
    {
        ghost.moveGhost1();
        ghost.moveGhost2();
        ghost.moveGhost3();
        cloud.movePlatform1();
        cloud.movePlatform2();
        cloud.movePlatform3();
        cloud.movePlatform4();
        bunny.move();
        coin.moveCoin1();
        coin.moveCoin2();
        coin.moveCoin3();
        coin.moveCoin4();
        
    }

  
    @Override
    public void paint(Graphics g) 
    {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        background.paint(g2d);
        bunny.paint(g2d);
        cloud.paint(g2d);
        ghost.paint(g2d);
        coin.paint(g);
        cat.paint(g2d);
        health.paint(g2d);
      
        
 
    }


    public void gameOver() {
		JOptionPane.showMessageDialog(this, "Game Over :(", "Game Over :(", JOptionPane.YES_NO_OPTION);
		System.exit(ABORT);
	}


    void playMusic()
    {
        try
        {
            File musicPath = new File("dreamy-music2.wav");

            if(musicPath.exists())
            {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();

            }
            else{
                System.out.println("Can't find file");
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
       
        
    public static void main(String args[]) throws InterruptedException, UnsupportedAudioFileException, IOException, LineUnavailableException
    {

        JFrame frame = new JFrame("Cloud Hop");
    
        Game game = new Game();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(495,601);
        frame.add(game);
        
	
        frame.setVisible(true);
       
        game.playMusic();
        
       
        while (true) 
        {
			game.move();
			game.repaint();
        
            
			Thread.sleep(10);
		}
    
    }

   
    
}


