
public interface Inventory {

  public boolean addCharacter(Character c);
  public boolean removeCharacter(int charLocation);
  public boolean upgradeAttack(int charLocation);
  public boolean upgradeDefense(int charLocation);
  public boolean attack(Inventory inv, int attackerLoc, int defenderLoc);

  public Character getCharacter(int charLocation);

  public int getLargestCharacter();
  public int getCharacterSize();
  public int getScore();

  public void printNames();

}