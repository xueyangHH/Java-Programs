/***************************************************

  Program name:        RockPaperScissors

  Class: CS101 sec. 005
  Name:  Xueyang Huang
  Date:  10/11
 
****************************************************/

import java.util.Scanner;

public class RockPaperScissors {
	public static void main(String[] args) {
		System.out.println("=========================================");
		System.out.println("Welcome to the Rock-Paper-Scissors game!");
		System.out.println("=========================================\n");
		System.out.println("Select your element:");
		System.out.println("	 R/r - Rock");
		System.out.println("	 P/p - paper");
		System.out.println("	 S/s - scissors");
		String user_input;
		while (true) {
			Scanner input = new Scanner(System.in);
			System.out.print("> ");
			user_input = input.nextLine();
			if ((user_input.equals("R")) || (user_input.equals("r")) || (user_input.equals("P")) || (user_input.equals("p")) || (user_input.equals("S")) || (user_input.equals("s"))) {
				break;
			}
		}
		int player_choice = 0;
		if ((user_input.equals("R")) || (user_input.equals("r"))) {
			player_choice = 1;
		}
		else if ((user_input.equals("P")) || (user_input.equals("p"))) {
			player_choice = 2;
		}
		else if ((user_input.equals("S")) || (user_input.equals("s"))) {
			player_choice = 3;
		}
		System.out.println("");
		ptgame(player_choice);
		System.out.println("Player\n");

		int comp_choice = (int) (1 + (Math.random() * 3));
		ptgame(comp_choice);
		System.out.println("Computer\n");

		if ((player_choice == 1) && (comp_choice == 1)){
			System.out.println("Tie! (both get rock)");
		}
		else if ((player_choice == 1) && (comp_choice == 2)) {
			System.out.println("Computer wins! (paper beats rock)");
		}
		else if ((player_choice == 1) && (comp_choice == 3)) {
			System.out.println("Player wins! (rock beats scissors)");
		}
		else if ((player_choice == 2) && (comp_choice == 1)) {
			System.out.println("Player wins! (paper beats rock)");
		}
		else if ((player_choice == 2) && (comp_choice == 2)) {
			System.out.println("Tie! (both get paper)");
		}
		else if ((player_choice == 2) && (comp_choice == 3)) {
			System.out.println("Computer wins! (scissors beats paper)");
		}
		else if ((player_choice == 3) && (comp_choice == 1)) {
			System.out.println("Computer wins! (rock beats scissors)");
		}
		else if ((player_choice == 3) && (comp_choice == 2)) {
			System.out.println("Player wins! (scissors beats paper)");
		}
		else {
			System.out.println("Tie! (both get scissors)");
		}
	}
	public static void ptgame(int n) {
		if (n == 1) {
			System.out.println(" __.--.--._");
			System.out.println("/  | _|  | `|");
			System.out.println("|  |` |  |  |");
			System.out.println("| /’--:--:__/");
			System.out.println("|/  /      |");
			System.out.println("(  ’ \\     |");
			System.out.println(" \\    `.  /");
			System.out.println("  |      |");
			System.out.println("  |      |");
		}
		else if (n == 2) {
			System.out.println("    --.--.");
			System.out.println("   |  |  |");
			System.out.println(".\"\"|  |  |_");
			System.out.println("|  |  |  | `|");
			System.out.println("|  | _|  |  |");
			System.out.println("|  |` )  |  |");
			System.out.println("| /’  /     /");
			System.out.println("|/   /      |");
			System.out.println("(   ’ \\     |");
			System.out.println("\\      `.  /");
			System.out.println(" |        |");
			System.out.println(" |        |");
		}
		else {
			System.out.println(".\"\".   .\"\",");
			System.out.println("|  |  /  /");
			System.out.println("|  | /  /");
			System.out.println("|  |/ .--._");
			System.out.println("|    _|  | `|");
			System.out.println("|  /` )  |  |");
			System.out.println("| /  /’--:__/");
			System.out.println("|/  /      |");
			System.out.println("(  ’ \\     |");
			System.out.println(" \\    `.  /");
			System.out.println("  |      |");
			System.out.println("  |      |");
		}
	}
}



