import java.awt.Graphics2D;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.File;

import java.awt.*;

public class BackgroundImage
{
    public void paint(Graphics2D g)
    {
        try 
        {
            Image backgroundImage = ImageIO.read(new File("forest1.jpg"));
            g.drawImage(backgroundImage, 0, 0, null);    
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }

        try 
        {
            Image backgroundBottom = ImageIO.read(new File("lrgplatform.png"));
            g.drawImage(backgroundBottom, -60, 530, 650, 50, null);            
        } 
        catch (IOException e) 
        {
        
            e.printStackTrace();
        }

    }
  
}
