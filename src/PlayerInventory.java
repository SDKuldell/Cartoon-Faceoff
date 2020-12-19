public class PlayerInventory implements Inventory {

  private Character[] PlayerCharacters;
  private int kills;

  private static PlayerInventory inventory;

  private PlayerInventory(){
    PlayerCharacters = new Character[0];
    kills = 0;
  }

  public static Inventory createPlayerInventory(){
    if(inventory == null) {
      inventory = new PlayerInventory();
    } else System.out.println("Error, Inventory already exists");
    return inventory;
  }

  public static void removePlayerInventory(){
    inventory = null;
  }

  //adds a given character to the Player Character Array. Returns true if successful, false if unsuccessful
  public boolean addCharacter(Character c){
    if(PlayerCharacters.length < GameSettings.getCharacters()){ 
      Character[] newArr = new Character[PlayerCharacters.length + 1];

      for(int i = 0; i < PlayerCharacters.length; i++){
        newArr[i] = PlayerCharacters[i];
      }

      newArr[newArr.length-1] = c;

      PlayerCharacters = newArr;
      return true;
    }
    return false;
  }
  
  //removes a given Character from the Player Character Array. Returns true if sucessful, false if unsuccessful
  public boolean removeCharacter(int index){
    System.out.println("Got to remove");
    if(PlayerCharacters.length > 0){

      Character[] copyArray = new Character[PlayerCharacters.length - 1];

      System.arraycopy(PlayerCharacters, 0, copyArray, 0, index);
      System.arraycopy(PlayerCharacters, index + 1, copyArray, index, PlayerCharacters.length - index - 1);
      PlayerCharacters = copyArray;

      if(PlayerCharacters.length == 0){ //check if ran out of characters
        System.out.println("You ran out of Characters!");
        kills -= 10;
      }
      return true;
    }
    return false;
  }

  public boolean upgradeAttack(int charLocation) {
    return PlayerCharacters[charLocation].incrementAttack();
  }

  public boolean upgradeDefense(int charLocation) {
    return PlayerCharacters[charLocation].incrementDefense();
  }

  public boolean attack(Inventory defenderInv, int attackerLoc, int defenderLoc){
    System.out.println(PlayerCharacters[attackerLoc].getName()+" is attacking "+defenderInv.getCharacter(defenderLoc).getName());
    System.out.printf("Rolling ");

    for(int i = 0; i < 3; i++){
        try {
        Thread.sleep(1000);
      } catch(InterruptedException ex) {
        Thread.currentThread().interrupt();
      }
      System.out.printf(". ");
    }

    try {
        Thread.sleep(1000);
      } catch(InterruptedException ex) {
        Thread.currentThread().interrupt();
      }

    int roll = ValidateInput.rand.nextInt(5)+1;//1-6 inclusive
    System.out.println();
    System.out.println("The roll was a "+roll+"!");

    try {
        Thread.sleep(1000);
      } catch(InterruptedException ex) {
        Thread.currentThread().interrupt();
      }

    int tippingPoint = 3 - PlayerCharacters[attackerLoc].getAttack() - defenderInv.getCharacter(defenderLoc).getDefense();

    if(roll > tippingPoint){
      //successful attack
      System.out.println(defenderInv.getCharacter(defenderLoc).getName() + " was destroyed!");
      kills++;
      return true;
    } else {
    //unsuccessful attack
    System.out.println(PlayerCharacters[attackerLoc].getName() + "'s attack failed!");
    return false;
    }
  }

  public Character getCharacter(int charLocation){
    return PlayerCharacters[charLocation];
  }

  public int getLargestCharacter(){

    int index = 0;
    Character returnCharacter = PlayerCharacters[0];

    for(int i = 0; i < PlayerCharacters.length; i++){
      if(PlayerCharacters[i].compareTo(returnCharacter) > 0){
        returnCharacter = PlayerCharacters[i];
        index = i;
      }
    }

    return index;
  }

  public int getCharacterSize(){
    return PlayerCharacters.length;
  }

  //gets the score from each character, and adds kills (+3)
  public int getScore(){

    int returnScore = 0;
    for(Character c : PlayerCharacters){
      returnScore += c.getScore();
    }
    returnScore += (kills * 3);
    return returnScore;

  }

  public void printNames(){
    String names = "";
    for(int i = 0; i < PlayerCharacters.length; i++)
      names = names + (i+1)+". "+PlayerCharacters[i].getName()+": ("+ PlayerCharacters[i].getAttack()+"-"+PlayerCharacters[i].getDefense()+")    ";
    
    System.out.println(names);
  }
  
}
