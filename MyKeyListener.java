import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MyKeyListener extends KeyAdapter 
{
	CreateMap map = new CreateMap();
	public void keyPressed(KeyEvent evt)
	{
		if (evt.getKeyChar() == 'a')
		{
			System.out.println("Check for key characters: " + evt.getKeyChar());
		}
		if (evt.getKeyCode() == KeyEvent.VK_DOWN)
		{
			String event = "DOWN";
			map.movePlayer(event);
		}
		
		else if (evt.getKeyCode() == KeyEvent.VK_UP)
		{
			String event = "UP";
			map.movePlayer(event);
		}
		
		else if (evt.getKeyCode() == KeyEvent.VK_LEFT)
		{
			String event = "LEFT";
			map.movePlayer(event);
		}
		
		else if (evt.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			String event = "RIGHT";
			map.movePlayer(event);
		}
	}
}