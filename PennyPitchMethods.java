package Arrays;

import java.util.Random;

public class PennyPitchMethods 
{
	public void InitialBoard(String[][] BoardArray)
	{
		for(int row=0; row<5; row++)
		{
			for(int col=0; col<5; col++)
			{
				BoardArray[row][col]="0";
			}
		}
	}
	
	public String[][] GeneratePrizes(String[][] BoardArray, int puzzleCounter, int gameCounter, int ballCounter, int posterCounter, int dollCounter)
	{
		Random generator = new Random();
		
		int r, c, spotNum=0, prizeCount=0;
		String spotLabel="";
		
		for(int i=0; i<15; i++)
		{
			// generate a random row and a random column
			r=generator.nextInt(5);
			c=generator.nextInt(5);
			
			// prevent repeats in a slot by regenerating if the slot is not empty
			if(!BoardArray[r][c].equals("0"))
			{
				while(!BoardArray[r][c].equals("0"))
				{
					r=generator.nextInt(5);
					c=generator.nextInt(5);
				}
			}
			
			// find a slot that is empty and randomly generate a prize
			if(BoardArray[r][c].equals("0"))
			{
				spotNum=generator.nextInt(5)+1;
				
				// store the number of times prize has already been used
				if(spotNum==1)
				{
					prizeCount=puzzleCounter;
				}
				else if(spotNum==2)
				{
					prizeCount=gameCounter;
				}
				else if(spotNum==3)
				{
					prizeCount=ballCounter;
				}
				else if(spotNum==4)
				{
					prizeCount=posterCounter;
				}
				else if(spotNum==5)
				{
					prizeCount=dollCounter;
				}
				
				// if the prize has already been used 3 times, generate a different prize
				if(prizeCount<=0)
				{
					while(prizeCount<=0)
					{
						spotNum=generator.nextInt(5)+1;
						
						if(spotNum==1)
						{
							prizeCount=puzzleCounter;
						}
						else if(spotNum==2)
						{
							prizeCount=gameCounter;
						}
						else if(spotNum==3)
						{
							prizeCount=ballCounter;
						}
						else if(spotNum==4)
						{
							prizeCount=posterCounter;
						}
						else if(spotNum==5)
						{
							prizeCount=dollCounter;
						}
					}
				}
				
				// after finding a prize that has not been used
					// label the spot with the prize and decrease the prize's counter
				if(spotNum==1)
				{
					spotLabel="puzzle";
					puzzleCounter--;
				}
				else if(spotNum==2)
				{
					spotLabel="game";
					gameCounter--;
				}
				else if(spotNum==3)
				{
					spotLabel="ball";
					ballCounter--;
				}
				else if(spotNum==4)
				{
					spotLabel="poster";
					posterCounter--;
				}
				else if(spotNum==5)
				{
					spotLabel="doll";
					dollCounter--;
				}
				
				BoardArray[r][c]=spotLabel;
			}
		}
		
		return BoardArray;
	}
	
	public void CreateBoard(String[][] BoardArray)
	{
		for(int row=0; row<BoardArray.length; row++)
		{
			for(int col=0; col<BoardArray[0].length; col++)
			{
				System.out.print(BoardArray[row][col]+" \t\t");
			}
			
			System.out.println();
		}
		
		System.out.println();
	}
	
	public void DetermineWin(int puzzleCounter, int gameCounter, int ballCounter, int posterCounter, int dollCounter)
	{
		if(puzzleCounter>=3)
		{
			System.out.println("You won a puzzle!");
		}
		if(gameCounter>=3)
		{
			System.out.println("You won a game!");
		}
		if(ballCounter>=3)
		{
			System.out.println("You won a ball!");
		}
		if(posterCounter>=3)
		{
			System.out.println("You won a poster!");
		}
		if(dollCounter>=3)
		{
			System.out.println("You won a doll!");
		}
		else if((puzzleCounter<3)&&(gameCounter<3)&&(ballCounter<3)&&(posterCounter<3)&&(dollCounter<3))
		{
			System.out.println("You won nothing.");
		}
	}
}