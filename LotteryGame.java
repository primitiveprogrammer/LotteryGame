/**
 * 
 */
package edu.gsu.csc1301.lotterygame;
import java.util.Scanner;
import java.util.Arrays;
/**
 * This program determines a lottery winner by matching five 
 * user inputs against five randomly generated numbers. 
 * 
 * @author Patrick Copeland
 * @version 04/212/2020
 */
public class LotteryGame 
{
    static final int NUM_DIGITS = 5;

	public static void main(String[] args) 
	{
		greetUser();
		int[] lotteryNumbers = getLotteryNumbers();
		int[] userPicks = getUserPicks();
		int matches = findMatches(lotteryNumbers, userPicks);
		//List lotteyr numbers
		System.out.print("\nLottery Numbers: ");
		for (int element : lotteryNumbers) 
		{
			System.out.print(element + " ");
		}
		//Display the number of matching digits
		System.out.println("\nNumber of matching digits: " + matches);
		if (matches == NUM_DIGITS)
		{
			System.out.println("GRAND PRIZE WINNER!");
		}
		else
		{
			System.out.println("Sorry, you didn't win");
		}	
	}
		
	/**
	 * This method displays a greeting to the user
	 * @param 
	 * @return 
	 */
	public static void greetUser()
	{
		System.out.println("       Welcome to the Lottery Game");
		System.out.println("You will pick 5 numbers (0 - 9) and we will");
		System.out.println("see if you are the Grand Prize Winner!\n"); 
	}
	
	/**
	 * This method prompts the user to enter values within a set range and stores the chosen values
	 * @param 
	 * @return the users chosen values
	 */
	public static int[] getUserPicks()
	{
		Scanner in = new Scanner(System.in);
		int[] userPicks = new int[NUM_DIGITS];
		//Gather user input and store
		for (int i = 0; i < NUM_DIGITS; i++)
		{
			int n = 1;
			System.out.print("Enter pick " + (n + i) + " (0 - 9): ");
			userPicks[i] = in.nextInt();
			//Display an error message for in improper inputs
			while (userPicks[i] < 0 || userPicks[i] > 9)
			{
				System.out.print("ERROR. Please enter a number (0 - 9): ");
				userPicks[i] = in.nextInt();
			}
			
			in.close();
		}
		//Sort and return data
		Arrays.sort(userPicks);
		return userPicks;
	}
	
	/**
	 * This method generates and returns a series of "lottery" numbers
	 * @param
	 * @return five randomly generated numbers
	 */
	public static int[] getLotteryNumbers()
	{
		//Scanner in = new Scanner(System.in);
		int[] randomNumbers = new int[NUM_DIGITS];
		for (int i = 0; i < NUM_DIGITS; i++)
	    {  
			randomNumbers[i] = (int) (Math.random() * 10);
	    }
		Arrays.sort(randomNumbers);
		return randomNumbers;
	}

	/**
	 * This method checks for matches between the users choices and 
	 * the random numbers and returns the number of matches found
	 * @param lotteryNumbers the set of randomly generated lottery numbers
	 * @param userPicks the numbers chosen by the user
	 * @return five randomly generated numbers
	 */
	public static int findMatches(int[] lotteryNumbers, int[] userPicks)
	{
		int count = 0;
		for (int i = 0; i < NUM_DIGITS; i++)
		{
			for (int j = 0; j < NUM_DIGITS; j++)
			{
				if (lotteryNumbers[i] == userPicks[j])
				{
					count++;
				}
			}
		}
		return count;
	}
}
