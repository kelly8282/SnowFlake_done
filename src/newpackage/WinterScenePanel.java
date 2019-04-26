package newpackage;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;
import java.lang.Math; 
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;


public class WinterScenePanel extends JPanel implements Runnable, KeyListener 
{
	private List<AbstractShape> shapes;
	private AbstractShape sMan;
        private SnowMan dog;
        private List<AbstractShape> rawr;
        private boolean keys;
           

	public WinterScenePanel()
	{
                setFocusable(true);
		setVisible(true);                
                
                keys = false;
		//refer shapes to a new ArrayList of AbstractShape
                SimpleSnowFlake snow;
                FancySnowFlake fancy;
		//populate the list with 50 unique snowflakes
                
                shapes = new ArrayList<AbstractShape>();
                for( int i = 0; i < 50; i ++)
                {
                     int x = (int) (Math.random() * 1000 % 750);
                     int y = (int) (Math.random() * 1000 % 550);
                    snow = new SimpleSnowFlake(x,y,20,20);
                    shapes.add(snow);
                }
                rawr = new ArrayList<AbstractShape>();
                for( int i = 0; i < 50; i ++)
                {
                     int x = (int) (Math.random() * 1000 % 750);
                     int y = (int) (Math.random() * 1000 % 550);
                    fancy = new FancySnowFlake(x,y,20,20);
                    rawr.add(fancy);
                }
		//instantiate a snowman
                dog = new SnowMan(100,100,20,20);
		new Thread(this).start();
	}

	public void update(Graphics window)
	{
		paint(window);
	}

	public void paint(Graphics window)
	{
		window.setColor(Color.BLUE);
		window.fillRect(0,0,getWidth(), getHeight());
		window.setColor(Color.WHITE);
		window.drawRect(20,20,getWidth()-40,getHeight()-40);
		window.setFont(new Font("TAHOMA",Font.BOLD,18));
		window.drawString("MAKE A BIG WINTER SCENE!",40,40);

		//make the snowman appear
                dog.draw(window);
		//make the snowflakes appear and move down the screen\
                
                for( int i = 0; i < shapes.size(); i ++)
                {
                    AbstractShape blank = shapes.get(i);
                    blank.moveAndDraw(window);
                }
                for( int i = 0; i < rawr.size(); i ++)
                {
                    AbstractShape blank = rawr.get(i);
                    blank.moveAndDraw(window);
                }
                
		//check to see if any of the snowflakes need to be reset to the top of the screen
                for( int i = 0; i < shapes.size(); i ++)
                {
                    AbstractShape blank = shapes.get(i);
                    if ( blank.getYPos() >= 600 || blank.getXPos() >= 800)
                    {
                        int x = (int) (Math.random() * 1000 % 750);
                        int y = (int) (Math.random() * 1000 % 550);
                        blank.setYPos(y);
                        blank.setXPos(x);
                    }
                }
                for( int i = 0; i < rawr.size(); i ++)
                {
                    AbstractShape blank = rawr.get(i);
                    if ( blank.getYPos() >= 600 || blank.getXPos() >= 800 )
                    {
                        int x = (int) (Math.random() * 1000 % 750);
                        int y = (int) (Math.random() * 1000 % 550);
                        blank.setYPos(y);
                        blank.setXPos(x);
                    }
                }
                
	}
  public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_W)
		{
                    StormySnowFlake stormy;
                    
                    for( int i = 0; i < rawr.size(); i ++)
                    {
                        AbstractShape blank = rawr.get(i);
                        stormy = new StormySnowFlake(blank.getXPos(),blank.getYPos(),20,20);
                        rawr.set(i, stormy);
                        
                    }
                    for( int i = 0; i < shapes.size(); i ++)
                    {
                        AbstractShape blank = shapes.get(i);
                        stormy = new StormySnowFlake(blank.getXPos(),blank.getYPos(),20,20);
                        shapes.set(i, stormy);
                    }
		}
		//repaint();
	}
 public void keyReleased(KeyEvent e)
	{
		//if (e.getKeyCode() == KeyEvent.VK_W)
		//{
		//	keys = false;
		//}
		//repaint();
	}
 public void keyTyped(KeyEvent e)
	{
      //no code needed here
	}

   public void run()
   {
   	try
   	{
   		while(true)
   		{
                     this.addKeyListener(this);
   		   Thread.currentThread().sleep(35);
            repaint();
         }
      }catch(Exception e)
      {
      }
  	}
}