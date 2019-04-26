/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

/**
 *
 * @author Kelly
 */
public class StormySnowFlake extends AbstractShape
{

   public StormySnowFlake(int x, int y, int w, int h )
   {
    super(x, y, w, h, Color.WHITE, 0, 3);
   }

   public void draw(Graphics window)
   {
      window.setColor(getColor());
      window.fillRect(getXPos(), getYPos() , getWidth(), getHeight());	
   }

   public void moveAndDraw(Graphics window)
   {

        setXPos(getXPos() + 20);
        setYPos(getYPos() + 20);
        draw(window);   
   }

 
}
