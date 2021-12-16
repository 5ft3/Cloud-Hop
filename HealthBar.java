import java.awt.Graphics2D;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.File;

import java.awt.*;

public class HealthBar 
{
    int health = 3;
    public void paint(Graphics2D g)
    {
    
        try 
        {
            Image fullHealth = ImageIO.read(new File("fullhealth.png"));
            Image emptyHealth = ImageIO.read(new File("emptyhealth.png"));

            if(health == 3)
            {
                g.drawImage(fullHealth, 0, 530, 30, 30, null);
                g.drawImage(fullHealth, 30, 530, 30, 30, null);
                g.drawImage(fullHealth, 60, 530, 30, 30, null);
                
            }

            else if(health == 2)
            {
                g.drawImage(emptyHealth, 0, 530, 30, 30, null);
                g.drawImage(fullHealth, 30, 530, 30, 30, null);
                g.drawImage(fullHealth, 60, 530, 30, 30, null);
                
            }

            else if(health == 1)
            {
                g.drawImage(emptyHealth, 0, 530, 30, 30, null);
                g.drawImage(emptyHealth, 30, 530, 30, 30, null);
                g.drawImage(fullHealth, 60, 530, 30, 30, null);
                 
            }

           else if(health == 0)
            {
                g.drawImage(emptyHealth, 0, 530, 30, 30, null);
                g.drawImage(emptyHealth, 30, 530, 30, 30, null);
                g.drawImage(emptyHealth, 60, 530, 30, 30, null);
               
            }

         
        } 
        catch (IOException e) 
        {
        
            e.printStackTrace();
        }
        
    }
}
