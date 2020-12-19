

public class Character {

  private String Name;
  private int Attack;
  private int Defense;
  private boolean maxUpgrades;

  public Character(String Name){
    this.Name = Name;
    Attack = 0;
    Defense = 0;
    maxUpgrades = false;
  }

  //getter and setter for name
  public String getName(){
    return this.Name;
  }

  public void setName(String newName){
    this.Name = newName;
  }

  //getter and setter for attack
  public int getAttack(){
    return this.Attack;
  }

  public void setAttack(int newAttack){
    this.Attack = newAttack;
  }

  //getter and setter for defense
  public int getDefense(){
    return this.Defense;
  }

  public void setDefense(int newDefense){
    this.Defense = newDefense;
  }

  //adds one to attack, returns false if tries to improve attack over 2, if successful, return true
  public boolean incrementAttack(){
    if(this.Attack == 2)
      return false;
    else {
      this.Attack++;
      if(this.Attack == 2 && this.Defense == 2)
        this.maxUpgrades = true;
      return true;
    }
  }

  //adds one to defense, returns false if tries to improve defense over 2, if successful, return true
  public boolean incrementDefense(){
    if(this.Defense == 2)
      return false;
    else {
      this.Defense++;
      if(this.Attack == 2 && this.Defense == 2)
        this.maxUpgrades = true;
      return true;
    }
  }

  public boolean checkMaxUpgrades(){
    return maxUpgrades;
  }

  //gets score for specific character (+1 for each upgrade, +1 for existence)
  public int getScore(){
    return getAttack() + getDefense() + 1;
  }

  //checks if 2 characters are equal
  public boolean equals(Character c){
    if(Name.equals(c.getName()) && getAttack() == c.getAttack() && getDefense() == c.getDefense())
      return true;
    return false;

  }

  public int compareTo(Character c){

    if(getScore() > c.getScore())
      return 1;
    else if (getScore() == c.getScore())
      return 0;
    else return -1;

  }

}