package Number_Guessing_Game;
import java.util.Random;
import java.util.Scanner;
public class Number_Guessing_Game {

	public static void main(String[] args) {
		Random rand = new Random();
		int RandomNumber =rand.nextInt(100)+1;
		System.out.println("Random Number is:"+RandomNumber);
		int tryCount = 0;
		
		while(true)
		{
		System.out.println("Enter your guess(1-100):");
		//break;
		Scanner sc=new Scanner(System.in);
		

		int playerGuess = sc.nextInt();
		tryCount++;
		if(playerGuess == RandomNumber)
		{
			System.out.println("Correct!You Win!");
			System.out.println("It Took you "+ tryCount+"tries");
			break;
		}
		else if(RandomNumber>playerGuess)
		{
			System.out.println("Nope! The Number is Higher, Guess Again.");
		}
		else {
			System.out.println("Nope! The Number is Lower, Guess Again.");
		}

	}

}
}
