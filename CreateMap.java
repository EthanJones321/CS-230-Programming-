import java.util.*;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;

public class CreateMap {
	private static char[][] map;
	
	public CreateMap()
	{
		map = this.generateMap(map);
	}
	
	
	public char[][] generateMap(char[][] map)
	{
		try {
			File file = new File ("P:\\eclipse-workspace\\MapGeneration\\MapTest.txt");
			Scanner s = new Scanner(new FileReader(file));
			int rows = s.nextInt();
			int columns = s.nextInt();
			String newLine = s.nextLine();
			char[][] newMap = new char[rows][columns];
			for(int i = 0; i < columns; i++)
			{
				String line = s.nextLine();
				for(int j = 0; j < rows; j++)
				{
					if (line.charAt(j) == ' ')
					{
						newMap[j][i] = ' ';
					}
					else
					{
						newMap[j][i] = line.charAt(j);
					}
				}
			}
			return newMap;
		} catch (IOException i)
		{
			System.out.println("Big Oopsie..");
			return map;
		}
	}
	
	public char[][] getMap ()
	{
		return this.map;
	}
	
	public String getPlayerPosition(char[][] map)
	{
		String position = "";
		for (int i = 0; i < map[0].length; i++) 
		{
			for (int j = 0; j< map.length; j++)
			{
				if (map[j][i] == 'P')
				{
					position = j + " " + i;
				}
			}
		}
		return position;
	}
	
	public char[][] movePlayer (String event)
	{
		String position = getPlayerPosition(map);
		String[] positions = position.split(" ");
		int xcoord = Integer.parseInt(positions[0]);
		int ycoord = Integer.parseInt(positions[1]);
		System.out.println("The player is at " + xcoord + ", " + ycoord);
		if (event == "DOWN")
		{
			map[xcoord][ycoord] = ' ';
			map[xcoord][ycoord + 1] = 'P';
			printMap(map);
			ycoord += 1;
			return map;
		}
		
		else if (event == "UP")
		{
			map[xcoord][ycoord] = ' ';
			map[xcoord][ycoord - 1] = 'P';
			printMap(map);
			ycoord -= 1;
			return map;
		}
		
		else if (event == "LEFT")
		{
			map[xcoord][ycoord] = ' ';
			map[xcoord - 1][ycoord] = 'P';
			printMap(map);
			xcoord -= 1;
			return map;
		}
		
		else if (event == "RIGHT")
		{
			map[xcoord][ycoord] = ' ';
			map[xcoord + 1][ycoord] = 'P';
			printMap(map);
			xcoord += 1;
			return map;
		}
		return map;
	}
	
	
	public void printMap(char[][] map)
	{
		for (int i = 0; i < map[0].length; i++) 
		{
			for (int j = 0; j< map.length; j++)
			{
				System.out.print(map[j][i]);
			}
			System.out.println("");
		}
	}
}
