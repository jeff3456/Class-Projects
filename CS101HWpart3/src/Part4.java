import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import processing.core.PApplet;

/*Author: Jefferson Lee
 * Date: 5/3/2013
 * Section: CS101, section 03, Spring 2014
 */

public class Part4 extends PApplet
{
	public void setup()
	{
		// variables for max and min of longitude and latitude;
		float maxLong = -89, minLong = -87, maxLat = 35, minLat = 36;
		
		// Shape object ArrayList that will contain all the states
		ArrayList<Shape> states = new ArrayList<Shape>();
		
		//size of canvas
		size(640, 480);
		
		// open up data file 
		File mapPoints = new File("data/USA.csv");
		
		// find max and min points in csv file
		try
		{
			Scanner input = new Scanner (mapPoints);
			
			// loop over data until there is no line left to read
			while(input.hasNextLine())
			{
				String line = input.nextLine();
				
				// Split the incoming line on the character ","
				String[] splitLine = line.split(",");
				
				// parse the values into floats and create point
				float tempLong = Float.parseFloat(splitLine[1]);
				float tempLat = Float.parseFloat(splitLine[2]);
								
				
				
				//find the max values by comparing the long/lat of the points in the data
				if(tempLong > maxLong)
				{
					maxLong = tempLong;
				}
				else if(tempLong < minLong)
				{
					minLong = tempLong;
				}
				if(tempLat > maxLat)
				{
					maxLat = tempLat;
				}
				else if(tempLat < minLat)
				{
					minLat = tempLat;
				}
			}
			input.close();
		}
		catch (Exception e)
		{
			
		}
		
		// make shapes of all the states and draw them
		// convert points using built in map method
		// float newValue = map(oldValue, minValue, maxValue, newMinValue, newMaxValue);
		File newMapPoints = new File("data/USA.csv");
		try
		{
			Scanner newInput = new Scanner(newMapPoints);
			while(newInput.hasNextLine())
			{
				String line = newInput.nextLine();
				
				// Split the incoming line on the character ","
				String[] splitLine = line.split(",");
				
				float tempLong = Float.parseFloat(splitLine[1]);
				float tempLat = Float.parseFloat(splitLine[2]);
				
				//convert tempLong and tempLat
				float newLong =  (tempLong-minLong)/(maxLong-minLong)*640;
				float newLat =  (tempLat-minLat)/(maxLat-minLat)*-480 + 480;
								
				//add point p with converted values
				Point p = new Point(newLong,newLat);

				//boolean to see if new state needs to be created
				boolean newState = true;
				
				// See if the first two letters of string are already contained in ArrayList states
				for(int k = 0; k < states.size(); k++)
				{
					// see if shape names are equals to each other
					if(splitLine[0].equals(states.get(k).name))
					{
						states.get(k).addPoint(p);
						newState = false;
						break;
					}
					else
					{
						newState = true;
					}
				}
				
				// if new state need to be included then add new Shape to ArrayList
				if(newState)
				{
					Shape a = new Shape(splitLine[0]);
					a.addPoint(p);
					states.add(a);
				}
			}
			newInput.close();
		}
		catch (Exception e)
		{

		}
		
		// set colors of states by iterating through the states ArrayList and then going through the data
		//of the election
		File president2012 = new File("data/USA2012.csv");
		try
		{
			Scanner input = new Scanner(president2012);
			
			// first line isn't part of the data so must be omitted
			String line = input.nextLine();
			
			while(input.hasNextLine())
			{				
				line = input.nextLine();
				
				String[] splitLine = line.split(",");
				
				double romney = Integer.parseInt(splitLine[1]), obama = Integer.parseInt(splitLine[2]);
				
				// the ratio of blue and red is dependent on the percentage of obama vs romney
				// color to blue
				
				for(int i = 0; i < states.size(); i++)
				{
					if((splitLine[0].charAt(0) == states.get(i).name.charAt(0)) && (splitLine[0].charAt(1) == states.get(i).name.charAt(1)))
					{
						states.get(i).red = (float) (255 * (romney/ (romney + obama)));
						states.get(i).blue = (float) (255 * (obama / (romney+ obama)));
					}
				}
				
			}
			input.close();
		}
		catch(Exception e)
		{
			println(e);
		}
		
		//draw states
		for(int i = 0; i< states.size(); i++)
		{			
			states.get(i).setColor(states.get(i).red, 0, states.get(i).blue);
			states.get(i).draw(this);
		}
	}
	
	// draw method is left empty because all the drawing is done in setup
	public void draw()
	{
		
	}

}
