//serves as a facade to manage Inventories in one location.

public class InventoryManager {

  private Inventory PlayerInv;
  private Inventory AIInv;

  public InventoryManager() {
    PlayerInv = PlayerInventory.createPlayerInventory();
    AIInv = AIInventory.createAIInventory();
  }

  //AI facade methods
  public boolean addAICharacter(Character c){
    return AIInv.addCharacter(c);
  }

  public boolean removeAICharacter(int charLocation){
    return AIInv.removeCharacter(charLocation);
  }

  public boolean upgradeAIAttack(int charLocation) {
    return AIInv.upgradeAttack(charLocation);
  }

  public boolean upgradeAIDefense(int charLocation) {
    return AIInv.upgradeDefense(charLocation);
  }

  public boolean attackThePlayer(int attackerLocation, int defenderLocation){
    return AIInv.attack(PlayerInv, attackerLocation, defenderLocation);
  }

  public Character getAICharacter(int charLocation) {
    return AIInv.getCharacter(charLocation);
  }

  public int getLargestAICharacter() {
    return AIInv.getLargestCharacter();
  }

  public int getAISize() {
    return AIInv.getCharacterSize();
  }

  public int getAIScore() {
    return AIInv.getScore();
  }

  public void printAINames(){
    AIInv.printNames();
  }

  //player facade methods
  public boolean addPlayerCharacter(Character c) {
    return PlayerInv.addCharacter(c);
  }

  public boolean removePlayerCharacter(int charLocation) {
    return PlayerInv.removeCharacter(charLocation);
  }

  public boolean upgradePlayerAttack(int charLocation) {
    return PlayerInv.upgradeAttack(charLocation);
  }

  public boolean upgradePlayerDefense(int charLocation) {
    return PlayerInv.upgradeDefense(charLocation);
  }

  public boolean attackTheAI(int attackerLocation, int defenderLocation){
    return PlayerInv.attack(AIInv, attackerLocation, defenderLocation);
  }

  public Character getPlayerCharacter(int charLocation) {
    return PlayerInv.getCharacter(charLocation);
  }

  public int getLargestPlayerCharacter() {
    return PlayerInv.getLargestCharacter();
  }

  public int getPlayerSize() {
    return PlayerInv.getCharacterSize();
  }

  public int getPlayerScore() {
    return PlayerInv.getScore();
  }
  
  public void printPlayerNames() {
    PlayerInv.printNames();
  }
}