package newpackage;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class SnowMan extends AbstractShape
{
   public SnowMan(int x, int y, int w, int h )
   {
		super(x, y, w, h, Color.WHITE, 0, 0);
   }

   public void draw(Graphics window)
   {
      window.fillOval(200,300,20,20);
      window.fillOval(190,318,40,40);
      window.fillOval(180,356,60,60);         	
   }

   public void moveAndDraw(Graphics window)
   {
      draw(window);   
   }
}