package TicTacToe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class tictactoe {
	static ArrayList<Integer>playerposition=new ArrayList<Integer>();
	static ArrayList<Integer>cpuposition=new ArrayList<Integer>();

	public static void main(String[] args) {
		char[][]gameboard= {{' ','|',' ','|',' '},
		{'-','+','-','+','-'},
		{' ','|',' ','|',' '},
		{'-','+','-','+','-'},
		{' ','|',' ','|',' '}};
		Scanner scan=new Scanner(System.in);
		
		while(true) {
		System.out.print("Enter your placement(1-9):");
		int playerpos=scan.nextInt();
		
		while(playerposition.contains(playerpos)||cpuposition.contains(playerpos)) {
			System.out.println("position is occupied.enter another position:");
			playerpos=scan.nextInt();
		}
		
		placepiece(gameboard,playerpos,"player");
		printgameboard(gameboard);
		
		String result=checkwinner();
	    if(result.length()>0) {
			System.out.print(result);
			break;
			}
	    
		Random rand=new Random();
		int cpupos=rand.nextInt(9) + 1;
		while(playerposition.contains(cpupos)||cpuposition.contains(cpupos)) {
			 cpupos=rand.nextInt(9) + 1;
		}
		
		placepiece(gameboard,cpupos,"cpu");
		printgameboard(gameboard);
		
	    result=checkwinner();
	    if(result.length()>0) {
	    	System.out.print(result);
	    	break;
		}
	    }
		scan.close();
	}
	public static void printgameboard(char[][]gameboard) {
		for(char[] row:gameboard) {
			for(char c: row) {
				System.out.print(c);
			}
			System.out.println();
		}
	}
	public static void placepiece(char[][]gameboard,int pos,String user) {
		char symbol = (user.equals("player")) ? 'X' : 'O';
		
        if (user.equals("player")) {
            playerposition.add(pos);
        } else {
            cpuposition.add(pos);
        }

		switch(pos) {
		case 1:
			gameboard[0][0]=symbol;
			break;
		case 2:
			gameboard[0][2]=symbol;
			break;
		case 3:
			gameboard[0][4]=symbol;
			break;
		case 4:
			gameboard[2][0]=symbol;
			break;
		case 5:
			gameboard[2][2]=symbol;
			break;
		case 6:
			gameboard[2][4]=symbol;
			break;
		case 7:
			gameboard[4][0]=symbol;
			break;
		case 8:
			gameboard[4][2]=symbol;
			break;
		case 9:
			gameboard[4][4]=symbol;
			break;
		default:
			break;
		}
	}
	public static String checkwinner(){
		List toprow=Arrays.asList(1,2,3);
		List midrow=Arrays.asList(4,5,6);
		List botrow=Arrays.asList(7,8,9);
		List leftcol=Arrays.asList(1,4,7);
		List midcol=Arrays.asList(2,5,8);
		List rightcol=Arrays.asList(3,6,9);
		List cross1=Arrays.asList(1,5,9);
		List cross2=Arrays.asList(7,5,3);
		
		List<List>winning=new ArrayList<List>();
		winning.add(toprow);
		winning.add(midrow);
		winning.add(botrow);
		winning.add(leftcol);
		winning.add(midcol);
		winning.add(rightcol);
		winning.add(cross1);
		winning.add(cross2);
		
		for(List l:winning) {
			if(playerposition.containsAll(l)) {
				System.out.println( "congratulation you win");
			}
			else if(cpuposition.containsAll(l)) {
				System.out.println( "computer wins :");
			}
			}
		if(playerposition.size()+cpuposition.size()==9) {
			System.out.println( "tie");
		}
		return "";
	}
}
