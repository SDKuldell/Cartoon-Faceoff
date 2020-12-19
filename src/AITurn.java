

public class AITurn {

  public static void playTurn(InventoryManager IM){


    if(IM.getAISize() == 0){
      createCharacter(IM);
      return;
    }

    if(IM.getAICharacter(IM.getLargestAICharacter()).checkMaxUpgrades() || ValidateInput.rand.nextInt(5) == 5) { //if there is a fully upgraded character or a 1 in 5 chance
      attackThePlayer(IM); //attack with that character against a random player character
      return;
    }

    //decision can be either create a new character or upgrade

   
    float decisionWeight = ((float) IM.getAISize() / (float)GameSettings.getCharacters()) * 100 + 30; //weight = current characters / total characters allowed + 50 for balancing
    int randomRoll = ValidateInput.rand.nextInt(100)+1;

    if(randomRoll < decisionWeight) { //if its under, then upgrade a random character;
      upgradeCharacter(IM);
    } else {
      if(!createCharacter(IM)) //otherwise create a character if possible otherwise upgrade one
        upgradeCharacter(IM);
    }

    /*basic overview of AI: 
      if there are 0 characters, create one
      if there is a fully upgraded character or a 1 in 5 chance, attack the player

      otherwise either create a new character or upgrade one
      the probability changes based on the amount of current characters

    */

    

  }

  public static void attackThePlayer(InventoryManager IM){

    int defenderLocation = ValidateInput.rand.nextInt(IM.getPlayerSize());

    if(IM.attackThePlayer(IM.getLargestAICharacter(), defenderLocation)){
      IM.removePlayerCharacter(defenderLocation);
    }
  }

  public static boolean createCharacter(InventoryManager IM){
    Character c = new Character(getRandomName());

    if(IM.addAICharacter(c)){
      System.out.println("The AI created a new Character named "+c.getName());
      return true;
    } else return false;
  }

  //upgrades a random Character
  public static boolean upgradeCharacter(InventoryManager IM){
    //possible to give higher priority to characters 
    if(IM.getAISize() == GameSettings.getCharacters())
      return false;
    int chosenCharacter = ValidateInput.rand.nextInt(IM.getAISize());

    if(ValidateInput.rand.nextBoolean()){

      if(!IM.upgradeAIAttack(chosenCharacter))
        IM.upgradeAIDefense(chosenCharacter);

    } else {
      if(!IM.upgradeAIDefense(chosenCharacter))
        IM.upgradeAIAttack(chosenCharacter);
    }
    return true;
  }

  public static String getRandomName(){
    String randomName = "";
    
    String[] firstNames = 
    {"Ashy", 
    "Black", 
    "Blue", 
    "Gray", 
    "Green", 
    "Icy", 
    "Lemon", 
    "Mango", 
    "Orange", 
    "Purple", 
    "Red", 
    "Salmon", 
    "White", 
    "Yellow",
    "Alive",
    "Better",
    "Careful",
    "Clever",
    "Dead",
    "Easy",
    "Famous",
    "Gifted",
    "Hallowed",
    "Helpful",
    "Important",
    "Inexpensive",
    "Mealy",
    "Mushy",
    "Odd",
    "Poor",
    "Powerful",
    "Rich",
    "Shy",
    "Tender",
    "Unimportant",
    "Uninterested",
    "Vast",
    "Wrong",
    "Aggressive",
    "Agreeable",
    "Ambitious",
    "Brave",
    "Calm",
    "Delightful",
    "Eager",
    "Faithful",
    "Gentle",
    "Happy",
    "Jolly",
    "Kind",
    "Lively",
    "Nice",
    "Obedient",
    "Polite",
    "Proud",
    "Silly",
    "Thankful",
    "Victorious",
    "Witty",
    "Wonderful",
    "Zealous"};

    String[] lastNames = 
    {
    "Actor",
    "Gold",
    "Painting",		
    "Parrot",
    "Afternoon",
    "Pencil",
    "Airport",	
    "Guitar",	
    "Piano",
    "Ambulance",	
    "Hair",	
    "Pillow",
    "Animal",	
    "Hamburger",	
    "Pizza",
    "Answer",	
    "Helicopter",	
    "Planet",
    "Apple",	
    "Helmet",	
    "Plastic",
    "Army",	
    "Holiday",	
    "Honey",	
    "Potato",
    "Balloon",	
    "Horse",	
    "Queen",
    "Banana",	
    "Hospital",	
    "Quill",
    "Battery",	
    "House",	
    "Rain",
    "Beach",	
    "Hydrogen",
    "Rainbow",
    "Beard",	
    "Ice",	
    "Raincoat",
    "Bed",	
    "Insect",	
    "Refrigerator",
    "Belgium",	
    "Insurance",	
    "Restaurant",
    "Boy",	
    "Iron",	
    "River",
    "Branch",	
    "Island",	
    "Rocket",
    "Lighter",	
    "Telephone",
    "Diamond",	
    "Lion",	
    "Television",
    "Dinner",
    "Lizard",	
    "Tent",
    "Disease",	
    "Lock",	
    "Thailand",
    "Doctor",	
    "London",	
    "Tomato",
    "Dog",
    "Lunch",	
    "Toothbrush",
    "Dream",	
    "Machine",	
    "Traffic",
    "Dress",
    "Magazine",	
    "Train",
    "Easter",	
    "Magician",	
    "Truck",
    "Egg",	
    "Manchester",
    "Eggplant",
    "Market",	
    "Umbrella",	
    "Match",	
    "Van",
    "Elephant",	
    "Microphone",
    "Vase",
    "Energy",	
    "Monkey",	
    "Vegetable",
    "Engine",	
    "Morning",	
    "Vulture",
    "England",	
    "Motorcycle",	
    "Wall",
    "Evening",	
    "Nail",	
    "Whale",
    "Eye",	
    "Napkin",	
    "Window",
    "Family",	
    "Needle",	
    "Wire",	
    "Nest",	
    "Xylophone",
    "Fish",	
    "Yacht",
    "Flag",	
    "Night",	
    "Yak",
    "Flower",	
    "Notebook",	
    "Zebra",
    "Football",	
    "Ocean",	
    "Zoo",
    "Forest",	
    "Oil",	
    "Garden",
    "Fountain",	
    "Orange",	
    "Gas",	
    "Oxygen",	
    "Girl",
    "Furniture",	
    "Oyster",	
    "Glass",
    "Garage",	
    "Ghost",
    };

    int r = ValidateInput.rand.nextInt(firstNames.length);
    randomName += firstNames[r]+ " ";

    r = ValidateInput.rand.nextInt(lastNames.length);
    randomName += lastNames[r];

    return randomName;
  }


}