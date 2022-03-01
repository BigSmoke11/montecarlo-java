import java.util.*;
import java.lang.Math;

public class Pie
{
	//Checking if point is inside the circle
	public static boolean isInside(double xPoint, double yPoint)
	{
		double r = Math.sqrt(xPoint * xPoint + yPoint * yPoint);

		return(r < 1.0);
	}

	public static double calculatePIE(int iterations)
	{

		Random rando = new Random();
		int insides = 0;
		double PIE = 0;

		for(int i = 0; i < iterations ; i++)
		{
			double x = rando.nextDouble();
			double y = rando.nextDouble();
			//Set of Points inside the circle of unit radius
			if(isInside(x,y))
			{
				insides++;
			}
			
		}
		//This helps with calculating precise difference between estimation and actual value of PI
		
		double darts = iterations;
		
		//Actual Monte Carlo Formula
		
		PIE = (4.0 *(insides/darts));
		return PIE; 
	}
	
	public static void main(String []main)
	{
		int empty = 0;
		int[] trials = new int[10];	
		Scanner scan = new Scanner(System.in);
		System.out.println("This is the Monte Carlo Method for Finding PI");
		//Ask user to try with different amount of darts in iterations, maximum 10, do not go over 200000 because processing gets slow
		
		System.out.println("Please enter amount of trials (max 10)");
		int times = scan.nextInt();
		if(times>10)
		System.out.println("Invalid amount, Please try again");
		else
		{
			for(int i = 0; i < times; i++)
			{	
				System.out.println("Please enter Trial " +(i+1));
				trials[i] = scan.nextInt();
			}
			//Printing The Results
			for(int j:trials)
			{
				if(j != 0)
				{
					double P = calculatePIE(j);
					double Difference = P - Math.PI;
					System.out.println("Estimation of PI is = " + P + ", Amount of DARTS : " + j + " Difference is: " +Difference);
					
				}
			}
		} 		
		
		
	}
}