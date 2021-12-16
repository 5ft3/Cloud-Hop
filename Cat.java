import java.awt.Graphics2D;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.File;

import java.awt.*;
public class Cat 
{
    public void paint(Graphics2D g)
    {
    
        try 
        {
            Image cat = ImageIO.read(new File("cat2.png"));
            g.drawImage(cat, 300, 500, 50, 50, null);
        } 
        catch (IOException e) 
        {
        
            e.printStackTrace();
        }
        
    }
}
