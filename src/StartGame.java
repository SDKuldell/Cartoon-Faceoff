public class StartGame extends ValidateInput {

  public static GameSettings settings;

  	public static void main(String[] args) {
    
    int playerChoice = -1;
    settings = new GameSettings();

    while(playerChoice != 1){
      printMainMenu();

      playerChoice = validateInput(4);
      if(playerChoice == 1){
        PlayGame.playGame(settings);
      } else if(playerChoice == 2){

        printHowToPlay();

      } else if(playerChoice == 3){

        modifySettings();

      } else {

        System.out.println("Thanks for playing!");
        System.exit(0);

      }
    }

    //start Game
    
  }

  private static void printMainMenu(){
    System.out.println("Welcome to Cartoon Faceoff!");
    System.out.println("Enter the number that corresponds to your choice:");
    System.out.println("1. Start");
    System.out.println("2. How to Play");
    System.out.println("3. Modify Game Settings");
    System.out.println("4. Quit");
  }

  private static void printHowToPlay(){
    System.out.println("Cartoon Faceoff is a Text Game Where Each Turn You can Either:");
    System.out.println("Create a new Character,");
    System.out.println("Attack a separate Character,");
    System.out.println("or Upgrade one of your current characters.");
    System.out.println("To attack a character, roll a 6 sided die.");
    System.out.println("If it is a 4, 5, or 6, the attack succeeds and the defending character is destroyed. Otherwise, the defender survives.");
    System.out.println("Attack Upgrades increase the odds of a successful attack, and Defense upgrades decrease the odds.");
    System.out.println("You have a point for owning a character and for each upgrade they have, and if you destroy an opponents character, then you get 3 points!");
    System.out.println("However, if someone runs out of characters, they lose 10 points!");
    System.out.println("The player with the highest score at the end of the game wins!");
    System.out.println();
  }

  private static void modifySettings(){

      GameSettings.printSettings();

      System.out.println("Which setting would you like to modify?");
      System.out.println("1. Maximum Turns");
      System.out.println("2. Maximum Characters per player");

      int playerChoice = validateInput(2);

      if(playerChoice == 1) {
        System.out.println("What is the new Value?");
        int newValue = getValidatedInput();
        GameSettings.setTurns(newValue);
      } else {
        System.out.println("What is the new Value?");
        int newValue = getValidatedInput();
        GameSettings.setCharacters(newValue);
      }
  }

}