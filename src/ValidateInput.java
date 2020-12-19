import java.util.Scanner;
import java.util.Random;

public class ValidateInput {

  public static Scanner sc = new Scanner(System.in);
  public static Random rand = new Random();

  //validates an input for only acceptable formats
  public static int validateInput(int numChoices){
    int playerChoice;
      do {
        System.out.println("Please enter a number between 1 and "+ numChoices + ".");
        while (!sc.hasNextInt()) {
            System.out.println("That's not an acceptable input");
            sc.nextLine();
        }
        playerChoice = sc.nextInt();

      } while(playerChoice < 1 || playerChoice > numChoices);
    
    sc.nextLine();

    return playerChoice;
  }

  // returns a validated input from the user (used for changing settings)
  public static int getValidatedInput(){
    int playerChoice;
      do {
        while (!sc.hasNextInt()) {
            System.out.println("That's not an acceptable input");
            sc.nextLine();
        }
        playerChoice = sc.nextInt();

      } while(playerChoice <= 0);

    return playerChoice;
  }

}