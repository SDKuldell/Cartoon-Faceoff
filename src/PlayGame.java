public class PlayGame {

  public static void playGame(GameSettings settings) { //loops


    for(int turnNum = 0; turnNum < GameSettings.getTurns(); turnNum++){

      GameSettings.pause(1);

      if(turnNum+1 == GameSettings.getTurns()){
        System.out.println("This is the last turn!");
      } else 

      System.out.println("Turn: "+(turnNum+1)+" of "+GameSettings.getTurns());

      // GameSettings.pause(1);

      PlayerTurn.playTurn(settings.getInvManager());

      GameSettings.pause(1);

      AITurn.playTurn(settings.getInvManager());

    }
    System.out.println("With a score of " + settings.getInvManager().getPlayerScore() + " to " + settings.getInvManager().getAIScore());
    if(settings.getInvManager().getPlayerScore() > settings.getInvManager().getAIScore()) {
      System.out.println("You Win!");
    } else if(settings.getInvManager().getPlayerScore() < settings.getInvManager().getAIScore()) {
      System.out.println("You Lose, better luck next time");
    } else System.out.println("It is a tie!");

    System.out.println("Game Over, Thanks for playing!");

  }

}