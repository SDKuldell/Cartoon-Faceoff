public class GameSettings{

  private static int maxTurns;
  private static int maxCharacters;
  private InventoryManager IM;

  public GameSettings(){
    maxTurns = 15;
    maxCharacters = 8;
    IM = new InventoryManager();
  }

  public GameSettings(int turns, int characters){
    maxTurns = turns;
    maxCharacters = characters;
    IM = new InventoryManager(); 
  }

  public static void printSettings(){
    System.out.println("Max Turns: "+maxTurns);
    System.out.println("Max Characters: "+maxCharacters);
  }

  public static void setTurns(int newTurns){
    maxTurns = newTurns;
  }

  public static void setCharacters(int newCharacters){
    maxCharacters = newCharacters;
  }

  public static int getTurns(){
    return maxTurns;
  }

  public static int getCharacters(){
    return maxCharacters;
  }

  public InventoryManager getInvManager(){
    return IM;
  }

  public static void pause(int numSeconds){
    for(int i = 0; i < numSeconds; i++){
      try {
        Thread.sleep(1000);
      } catch(InterruptedException ex) {
        Thread.currentThread().interrupt();
      }
    }
  }
}