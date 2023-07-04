package Arrays;

import java.util.Random;

public class PennyPitchMain 
{

	public static void main(String[] args) 
	{
		PennyPitchMethods object = new PennyPitchMethods();
		Random generator = new Random();
		
		String[][] BoardArray = new String [5][5];
		int r, c, puzzleCounter=3, gameCounter=3, ballCounter=3, posterCounter=3, dollCounter=3;
		
		// generate 15 random squares with prizes on them
		// each prize appears 3 times: puzzle, game, ball, poster, doll
		
		// fill the board with empty spaces
		object.InitialBoard(BoardArray);
		
		// generate 15 random spaces with prizes
		BoardArray=object.GeneratePrizes(BoardArray, puzzleCounter, gameCounter, ballCounter, dollCounter, dollCounter);
		
		// print out the board
		object.CreateBoard(BoardArray);
		
		// zero out all of the counters to reuse them
		puzzleCounter=0;
		gameCounter=0;
		ballCounter=0;
		posterCounter=0;
		dollCounter=0;
		
		// generate 10 coin flips on unique spots
		// record if the coin flip landed somewhere with a prize
		for(int i=0; i<10; i++)
		{
			r=generator.nextInt(5);
			c=generator.nextInt(5);
			
			// if a coin has already landed here, pick another spot
			while((BoardArray[r][c].equals("puzzle-x"))||(BoardArray[r][c].equals("game-x"))||(BoardArray[r][c].equals("ball-x"))||(BoardArray[r][c].equals("poster-x"))||(BoardArray[r][c].equals("doll-x"))||(BoardArray[r][c].equals("0-x")))
			{
				r=generator.nextInt(5);
				c=generator.nextInt(5);
			}
			
			// change the slot to say the coin has landed here
			BoardArray[r][c]=BoardArray[r][c]+"-x";
			
			// if the coin lands somewhere with a prize, increase the prize counter
			if(BoardArray[r][c].equals("puzzle-x"))
			{
				puzzleCounter++;
			}
			else if(BoardArray[r][c].equals("game-x"))
			{
				gameCounter++;
			}
			else if(BoardArray[r][c].equals("ball-x"))
			{
				ballCounter++;
			}
			else if(BoardArray[r][c].equals("poster-x"))
			{
				posterCounter++;
			}
			else if(BoardArray[r][c].equals("doll-x"))
			{
				dollCounter++;
			}
		}
		
		// print out the board
		object.CreateBoard(BoardArray);
		
		// using the counters, if a counter is 3 or more, a prize was won, so print out a message
		object.DetermineWin(puzzleCounter, gameCounter, ballCounter, posterCounter, dollCounter);	
	}

}