

public class PlayerTurn {
  
  public static void playTurn(InventoryManager IM){

    GameSettings.pause(1);

    System.out.println();
    System.out.println("Player: "+IM.getPlayerScore()+" points");
    System.out.println("AI: "+IM.getAIScore()+" points");

    GameSettings.pause(1);

    System.out.println();
    System.out.println("It is your turn, would you like to");

    boolean endedTurn = false;

    while(!endedTurn){
      if(IM.getPlayerSize() == 0){ //has reduced options if player has 0 characters
        playFirstTurn(IM);
        endedTurn = true;
      } else {
      System.out.println("1. Create a new Character");
      System.out.println("2. Upgrade a Character");
      System.out.println("3. Attack a Character");
      System.out.println("4. Quit the game");
      
      int playerChoice = ValidateInput.validateInput(4);

      if(playerChoice == 1){
        if(createCharacter(IM))
          endedTurn = true;
        else {
          System.out.println("You already have maximum characters");
        }
      } else if(playerChoice == 2) {
       
        if(upgradeCharacter(IM)) 
          endedTurn = true;
    
      } else if(playerChoice == 3) {
        attackTheAI(IM);
        endedTurn = true;

      } else {
        System.out.println("Thanks for Playing!");
        System.exit(0);
      }

      }
    }
  }

  public static void playFirstTurn(InventoryManager IM) {

    System.out.println("1. Create a new Character");
    System.out.println("2. Quit");

    //validates input
    int playerChoice = ValidateInput.validateInput(2);

    if(playerChoice == 1)
      createCharacter(IM);
    else {
      System.out.println("Thanks for Playing!");
      System.exit(0);
    }
  }

  public static boolean createCharacter(InventoryManager IM) {
    System.out.println("What is the name of your new Character?");
    String newCharName = ValidateInput.sc.nextLine();
    Character c = new Character(newCharName);

    if(IM.addPlayerCharacter(c)){
      System.out.println(newCharName + " was added");
      return true;
    } else return false;
  }

  public static boolean upgradeCharacter(InventoryManager IM) {

    System.out.println("Which Character would you like to upgrade? ");
    IM.printPlayerNames();

    int charLocation = ValidateInput.validateInput(IM.getPlayerSize()) - 1;
    
    System.out.println("Which Upgrade would you like to use?");
    System.out.println("1. Attack");
    System.out.println("2. Defense");
    System.out.println("3. Go Back");

    int playerChoice = ValidateInput.validateInput(3);

    if(playerChoice == 1) {
      if(IM.upgradePlayerAttack(charLocation)){
        System.out.println("Attack upgraded!");
        return true;
      } else {
        System.out.println("Attack already at max!");
        return false;
      }
       
    } else if(playerChoice == 2) {
      if(IM.upgradePlayerDefense(charLocation)){
        System.out.println("Defense upgraded!");
        return true;
      } else {
        System.out.println("Defense already at max!");
        return false;
      }
    }

    return false;

  }

  public static void attackTheAI(InventoryManager IM) {
    System.out.println("Which Character would you like to attack with? ");
    IM.printPlayerNames();

    int attackerLoc = ValidateInput.validateInput(IM.getPlayerSize()) - 1;

    System.out.println("Which Character would you like to attack? ");
    IM.printAINames();

    int defenderLoc = ValidateInput.validateInput(IM.getAISize()) - 1;

    if(IM.attackTheAI(attackerLoc, defenderLoc)){
      IM.removeAICharacter(defenderLoc);
    }
      
  }  


}