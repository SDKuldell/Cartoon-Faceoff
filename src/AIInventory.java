public class AIInventory implements Inventory {

  private Character[] AICharacters;
  private int kills;

  private static AIInventory inventory;

  private AIInventory(){
    AICharacters = new Character[0];
    kills = 0;
  }

  public static Inventory createAIInventory(){
    if(inventory == null) {
      inventory = new AIInventory();
    } else System.out.println("Error, Inventory already exists");
    return inventory;
  }

  public static void removeAIInventory(){
    inventory = null;
  }

  //adds a given character to the AI Character Array. Returns true if successful, false if unsuccessful
  public boolean addCharacter(Character c){
    if(AICharacters.length < GameSettings.getCharacters()){ 
      Character[] newArr = new Character[AICharacters.length + 1];
      for(int i = 0; i < AICharacters.length; i++)
        newArr[i] = AICharacters[i];
      newArr[newArr.length-1] = c;

      AICharacters = newArr;
      return true;
    }
    return false;
  }
  
  //removes a given Character from the AI Character Array. Returns true if sucessful, false if unsuccessful
  public boolean removeCharacter(int index){
    if(AICharacters.length > 0){

      Character[] copyArray = new Character[AICharacters.length - 1];

      System.arraycopy(AICharacters, 0, copyArray, 0, index);
      System.arraycopy(AICharacters, index + 1, copyArray, index, AICharacters.length - index - 1);
      AICharacters = copyArray;

      if(AICharacters.length == 0){ //check if ran out of characters
        System.out.println("The AI ran out of Characters!");
        kills -= 10;
      }

      return true;
    }
    return false;
  }

  public boolean attack(Inventory defenderInv, int attackerLoc, int defenderLoc){
    System.out.println(AICharacters[attackerLoc].getName()+" is attacking "+defenderInv.getCharacter(defenderLoc).getName());
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

    int tippingPoint = 3 - AICharacters[attackerLoc].getAttack() - defenderInv.getCharacter(defenderLoc).getDefense();

    if(roll > tippingPoint){
      //successful attack
      System.out.println(defenderInv.getCharacter(defenderLoc).getName() + " was destroyed!");
      kills++;
      return true;
    }
    //unsuccessful attack
    System.out.println(AICharacters[attackerLoc].getName() + "'s attack failed!");
    return false;
    }

  public boolean upgradeAttack(int charLocation) {
    if(AICharacters[charLocation].incrementAttack()){
      System.out.println("The AI Upgraded "+AICharacters[charLocation].getName()+"'s Attack!");
      return true;
    } else return false;
  }

  public boolean upgradeDefense(int charLocation) {
    if(AICharacters[charLocation].incrementDefense()){
      System.out.println("The AI Upgraded "+AICharacters[charLocation].getName()+"'s Defense!");
      return true;
    } else return false;
  }

  public Character getCharacter(int charLocation){
    return AICharacters[charLocation];
  }

  public int getLargestCharacter(){

    int index = 0;
    Character returnCharacter = AICharacters[0];

    for(int i = 0; i < AICharacters.length; i++){
      if(AICharacters[i].compareTo(returnCharacter) > 0){
        returnCharacter = AICharacters[i];
        index = i;
      }
    }

    return index;
  }

  public int getCharacterSize(){
    return AICharacters.length;
  }

  public int getScore(){

    int returnScore = 0;
    for(Character c : AICharacters){
      returnScore += c.getScore();
    }
    returnScore += (kills * 3);
    return returnScore;

  }

  public void printNames(){
    String names = "";
    for(int i = 0; i < AICharacters.length; i++)
      names = names + (i+1)+". "+AICharacters[i].getName()+": ("+ AICharacters[i].getAttack()+"-"+AICharacters[i].getDefense()+")    ";
    
    System.out.println(names);
  }
}
  

  

