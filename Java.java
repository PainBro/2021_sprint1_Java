import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        // Welcome stuff
        System.out.println("Welcome to an MTG basic Card storage!");

        // Set up user input
        Scanner input = new Scanner(System.in);
        System.out.println("How many cards would you like to input?: ");

        // Creating a user input
        int numOfCards = input.nextInt();
        System.out.println("You will input for " + numOfCards + " cards.");

        // Declaring an array 
        ArrayList<Card> arr = new ArrayList<Card>(); 

        // Allocating memory for objects 
        //arr = new Card[numOfCards]; 
        
        // Creating card objects in array
        for (int i = 0; i < numOfCards; i++){
            arr.add(new Card());
            // System.out.println("Card " + i);
        }
        
        // Explaining program limits to user
        System.out.println("This program only accepts old card types (Land, Creature, Instant, Sorcery)");

        Scanner nameIn = new Scanner(System.in);
        Scanner typeIn = new Scanner(System.in);
        Scanner manaIn = new Scanner(System.in);
        Scanner subTypeIn = new Scanner(System.in);
        Scanner effectIn = new Scanner(System.in);
        Scanner powerIn = new Scanner(System.in);
        Scanner toughnessIn = new Scanner(System.in);
        // Setting variables
        for (int i = 0; i < numOfCards; i++){
            // Get the card's name from the user
            System.out.println("What is the name of card " + (i + 1) + "?: ");
            String name = nameIn.nextLine();
            

            // Find type of card from user
            System.out.println("What type of card is " + name + "?: ");
            String typ = typeIn.next();
            //System.out.println(typ);
            
            
            // Setting up other variables
            String mana = "";
            String subType = "";
            String effect = "";
            String power = "";
            String toughness = "";
            Card item = arr.get(i);

            // Help create card
            if (typ.equals("Land")){
                System.out.println("What are the subtypes of " + name + "?: ");
                subType = subTypeIn.nextLine();
                System.out.println("What are the effects/abilities of " + name + "?: ");
                effect = effectIn.nextLine();
                item.makeCard(name, mana, typ, subType, effect, power, toughness);

            } else if (typ.equals("Creature")){
                System.out.println("What is the mana cost of " + name + "?: ");
                mana = manaIn.nextLine();
                System.out.println("What are the subtypes of " + name + "?: ");
                subType = subTypeIn.nextLine();
                System.out.println("What are the effects/abilities of " + name + "?: ");
                effect = effectIn.nextLine();
                System.out.println("What is the power of " + name + "?: ");
                power = powerIn.nextLine();
                System.out.println("What is the toughness of " + name + "?: ");
                toughness = toughnessIn.nextLine();
                arr.get(i).makeCard(name, mana, typ, subType, effect, power, toughness);

            } else if (typ.equals("Instant") | typ.equals("Sorcery")){
                System.out.println("What is the mana cost of " + name + "?: ");
                mana = manaIn.nextLine();
                System.out.println("What are the subtypes of " + name + "?: ");
                subType = subTypeIn.nextLine();
                System.out.println("What are the effects/abilities of " + name + "?: ");
                effect = effectIn.nextLine();
                arr.get(i).makeCard(name, mana, typ, subType, effect, power, toughness);

            } else {
                System.out.println("This program only accepts old card types(Land, Creature, Instant, Sorcery)");
                i--;
            }
        }

        boolean checkCards = true;
        while(checkCards){
            int cardChecker = 0;
            while(checkCards){
                System.out.println("Which card would you like to see?(1-"+ numOfCards +"): ");
                cardChecker = input.nextInt();
                if(cardChecker >= 1 & cardChecker <= (numOfCards + 1)){
                    break;
                }
                System.out.println("Please enter a number between 1 and " + numOfCards + ".");
            }
            Card crd = arr.get(cardChecker - 1);
            String typ = crd.getType();




            if (typ.equals("Land")){
                System.out.println(crd.getName());
                System.out.println("Is a " + typ + "-" + crd.getSubType() + " card.");
                System.out.println("It's effects/abilities are " + crd.getEffect() + ".");

            } else if (typ.equals("Creature")){
                System.out.println(crd.getName());
                System.out.println("Is a " + typ + "-" + crd.getSubType() + " card.");
                System.out.println("It costs " + crd.getMana()+ " mama.");
                System.out.println("It's effects/abilities are " + crd.getEffect() + ".");
                System.out.println("It had a power and toughness of [" + crd.getPower() + "/" + crd.getToughness() + "].");

            } else if (typ.equals("Instant") | typ.equals("Sorcery")){
                System.out.println(crd.getName());
                System.out.println("Is a " + typ + "-" + crd.getSubType() + " card.");
                System.out.println("It costs " + crd.getMana()+ " mama.");
                System.out.println("It's effects/abilities are " + crd.getEffect() + ".");

            }

            while(checkCards){
                System.out.println("Would you like to see another card?(Yes/No): ");
                String another = input.next();
                if(another.equals("No")){
                    checkCards = false;
                    break;
                }else if(another.equals("Yes")){
                    break;
                }
                System.out.println("Please input either Yes or No.");
            }
        }

        nameIn.close();
        typeIn.close();
        manaIn.close();
        subTypeIn.close();
        effectIn.close();
        powerIn.close();
        toughnessIn.close();
        
        //Scanner file = new Scanner(System.in);
        String fileName = "Card";
        
        //System.out.println("Please input the filename.");
        //fileName = file.next();

        //file.close();
        input.close();

        try {  
            File myObj = new File(fileName + ".txt");  
            if (myObj.createNewFile()) {  
              System.out.println("File created: " + myObj.getName());  
            } else {  
              System.out.println("File already exists.");  
            }  
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();  
        }     
        try {
            FileWriter myWriter = new FileWriter("filename.txt");
            for (int i = 0; i < numOfCards; i++){
            myWriter.write("Card " + i + ": " 
            + arr.get(i).getName() + ", "
            + arr.get(i).getMana() + ", "
            + arr.get(i).getType() + ", "
            + arr.get(i).getSubType() + ", "
            + arr.get(i).getEffect() + ", "
            + arr.get(i).getPower() + ", "
            + arr.get(i).getToughness());
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            }
        }
   
    }
// Making new class Card
class Card {
    // Creating variables for the card
    private String _name = "";
    private String _mana = "";
    private String _type = "";
    private String _subType = "";
    private String _effect = "";
    private String _power = "";
    private String _toughness = "";

    // Making function to allow for card data input
    public void makeCard(String name, String mana, String typ, String subType, String effect, String power, String toughness){
        // Setting class variables
        _name = name;
        _mana = mana;
        _type = typ;
        _subType = subType;
        _effect = effect;
        _power = power;
        _toughness = toughness;
    }

    public String getName(){
        return(_name);
    }
    public String getMana(){
        return(_mana);
    }
    public String getType(){
        return(_type);
    }
    public String getSubType(){
        return(_subType);
    }
    public String getEffect(){
        return(_effect);
    }
    public String getPower(){
        return(_power);
    }
    public String getToughness(){
        return(_toughness);
    }
}

