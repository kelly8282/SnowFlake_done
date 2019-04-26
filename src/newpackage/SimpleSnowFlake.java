/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

/**
 *
 * @author liuk6719
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

//extend the AbstractShape class to make a FancySnowFlake class

public class SimpleSnowFlake extends AbstractShape
{
   public SimpleSnowFlake(int x, int y, int w, int h )
   {
    super(x, y, w, h, Color.WHITE, 0, 3);
   }

   public void draw(Graphics window)
   {
      window.setColor(getColor());
      window.drawLine(getXPos(),getYPos(),getXPos()+ getWidth(), getYPos()+ getHeight());
      window.drawLine(getXPos()+ getWidth(), getYPos(), getXPos(), getYPos()+ getHeight());
   } 

   public void moveAndDraw(Graphics window)
   {
       int offset = (int) (Math.random() * 4);
        int rnd = (int) (Math.random() * 2);
        if (rnd == 1) {
            offset = offset * -1;
        }
        setXPos(getXPos() + offset);
        setYPos(getYPos() + getYSpeed());
        draw(window);
      
   }
}
