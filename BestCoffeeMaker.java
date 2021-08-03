import java.io.*;
import java.util.*;
/**
 * Class BestCoffeeMaker connects Tea, Coffee, MachineSetup and Order classes into a coffee machine.
 * The coffee machine prints the menu for user to choose and user can choose from a variety of beverages
 * (even order for takeout!). 
 * 
 * Disclaimer: I do not own a coffee machine so menu options are imaginary.
 *
 * @author Agne Januskeviciute
 * @version 1.0
 * @date 2020-03-16
 * 
 * @version 1.1
 * @date 2020-03-18
 */
public class BestCoffeeMaker
{
  public static void main (String[] args) throws IOException
  {
    Scanner keyboard = new Scanner (System.in);
        
    //Class variables:
    Order order = new Order();
    Coffee cup = new  Coffee();
    Tea cupses = new Tea ();
    MachineSetup setStuff = new MachineSetup();
        
    //Temperature array:
    int[] temp = cupses.getTemp();
        
    //Tea array:
    cupses.setTea();
    String [] tea  = cupses.getTea();
       
    //Drinks array for printing full drink menu:
    String drinks[][] = beverages();

    //User instructions
    System.out.println("Hello! If it is your first time using the machine,"+ 
          "please set up your favorite shop, coffee and tea." ); 
    System.out.println("Here's the menu. Press q or quit to exit:" ); 
        
    //Prints main menu
    printMainMenu();
        
    boolean keepMenu = true;
    int choice = 0;
    String button = " ";
        
    while(keepMenu)
    {
      //Try-catch block  for the main menu. 
      try //This try-catch is built just for the main menu as I could not get it work within other loops with this
      //still  being active
      {
        //For the first entry, the program reads any button:  
        button = keyboard.next();
        
        //If the entry is q or quit, program exits
        if(button.equals("q") || button.equals(("quit")))
        {
          keepMenu = false;//At the next iteration the keep running flag is false and the program will stop.
          continue;//Continue statement forces the program to go to the next iteration of the loop.
        }
        
        //If the button is not numeric prints an error message:
        if(!isNumeric(button))
        {
          throw new Exception("Please type a number between 1 and 5");
        }

        choice = Integer.parseInt(button);
        switch (choice) //Enters the menu
        {
          case 1: //Sets everything up
             System.out.println("You chose 1 - to set up your machine.");
             setStuff.setEverything(); 
             break;
                    
          case 2: //Calls for takeout beverage
             System.out.println("You chose 2 - to order your beverage for takeout.");
             System.out.println("Ordering your beverage from cafe on file");
             order.callToOrder();
             System.out.println("Enjoy your beverage! It will be ready soon.");
             System.exit(0);         
            
          case 3: //Prints the beverage menu
             System.out.println("You chose 3 - to print drinks menu.");
             beverageMenu(drinks);
                    
          case 4: //Tea or coffee menu
             System.out.println("You chose 4 - to brew tea or coffee.");
             System.out.println("Choose tea or coffee (type in lower case tea or coffee):");
             //Reads the empty line before recognizing tea or coffee
             String empty = keyboard.nextLine();
             String choice2 = keyboard.nextLine();             
                switch(choice2)
                {
                  case "tea": //If chosen tea, prints tea menu
                     System.out.println("You chose tea - the machine will show tea options");
                     printTea(drinks);
                     int choice3 = keyboard.nextInt();
                      switch (choice3)
                      {
                        case 1: //Prepares white tea with proper temperature
                           System.out.println("You chose 1 - white tea");
                           System.out.println("Preparing " + tea[0]+ " at " + temp[0] + "` C");
                           System.out.println("Your beverage is ready. Enjoy!");
                           System.exit(0);
                            
                        case 2: //Prepares Oolong tea with proper temperature
                           System.out.println("You chose 2 - oolong tea");
                           System.out.println("Preparing " + tea[1]+ " at " + temp[1] + "` C");
                           System.out.println("Your beverage is ready. Enjoy!");
                           System.exit(0);
                                
                        case 3: //Prepares Green tea with proper temperature
                           System.out.println("You chose 3 - green tea");
                           System.out.println("Preparing " + tea[2]+ " at " + temp[2] + "` C");
                                
                           //Asks for user to choose lemon:
                           System.out.println("Would you like lemon? Yes or no:");
                           String doIWantLemon = keyboard.next();
                           System.out.println("You chose " + doIWantLemon);
                           cupses.setLemon(doIWantLemon);
                           boolean lemon = cupses.getLemon();
                                
                           //Asks for user to choose cream:
                           System.out.println("Would you like half and half? Enter amount in ml:");
                           int cream = keyboard.nextInt();
                           System.out.println("You chose " + cream + " ml of cream");
                                
                           //Asks for user to choose sugar:
                           System.out.println("Would you like sugar? Enter amount in teaspoons:");
                           int sugar = keyboard.nextInt();
                           System.out.println("You chose " + sugar + " teaspoons of sugar");  
                           
                            //Prints green tea:
                            cupses.greenTea(tea, lemon, cream, sugar);
                            System.out.println("Your beverage is ready. Enjoy!");
                            System.exit(0);
                                
                        case 4: //Prepares Black tea with proper temperature
                            System.out.println("You chose 4 - black tea");
                            System.out.println("Preparing " + tea[3]+ " at " + temp[3] + "` C");
                                
                            //Asks for user to choose lemon:
                            System.out.println("Would you like lemon? Yes or no:");
                            String doIWantLemon1 = keyboard.next();
                            System.out.println("You chose " + doIWantLemon1);
                            cupses.setLemon(doIWantLemon1);
                            boolean lemon1 = cupses.getLemon();
                                
                            //Asks for user to choose cream:
                            System.out.println("Would you like half and half? Enter amount in ml:");
                            int cream1 = keyboard.nextInt();
                            System.out.println("You chose " + cream1 + " ml of cream");
                                
                            //Asks for user to choose sugar:
                            System.out.println("Would you like sugar? Enter amount in teaspoons:");
                            int sugar1 = keyboard.nextInt();
                            System.out.println("You chose " + sugar1 + " teaspoons of sugar");
                                
                            //Prints Black tea:
                            cupses.blackTea(tea, lemon1, cream1, sugar1);
                            System.out.println("Your beverage is ready. Enjoy!");
                            System.exit(0);
                                
                        case 5: //Prepares Rooibos tea with proper temperature 
                            System.out.println("You chose 5 - rooibos tea");
                            System.out.println("Preparing " + tea[4]+ " at " + temp[4] + "` C");
                            System.out.println("Your beverage is ready. Enjoy!");
                            System.exit(0);
                                
                        case 6: //Prepares pre-set morning tea
                            System.out.println("You chose 6 - morning tea");
                            setStuff.getMorningTea();
                            System.out.println("Preparing your morning tea.");
                            System.out.println("Your beverage is ready. Enjoy!");
                            System.exit(0);
                                
                        default://Default statement to show that the choice is not valid
                            System.out.println("Invalid choice. Please try turning on the machine again.");
                            System.exit(0); //System exit because I could not get it work with
                            //this submenu without it continuing to the coffee menu
                      }
                        
                    case "coffee":
                       System.out.println("You chose coffee - the machine will show coffee options");
                       printCoffee(drinks); //Prints coffee options
                       int choice4 = keyboard.nextInt();
                        switch (choice4)
                        {
                            case 1: //Prepares short espresso
                                System.out.println("You chose 1 - Short Espresso.");
                                cup.shortEspresso();
                                System.out.println("Your beverage is ready. Enjoy!");
                                System.exit(0);
                                
                            case 2: //Prepares long espresso
                                System.out.println("You chose 2 - Long Espresso.");
                                cup.longEspresso();
                                System.out.println("Your beverage is ready. Enjoy!");
                                System.exit(0);
                                
                            case 3:  //Prepares espresso macchiato
                                System.out.println("You chose 3 - Late Macchiato.");
                                System.out.println("Please enter the amount of espresso shots you'd like:");
                                int espressoShots = keyboard.nextInt(); 
                                while (espressoShots > 2)
                                //loops until it gets a proper amount of shots and then makes the drink
                                {
                                    System.out.println("Latte can only be made with one or two shots." );
                                    espressoShots = keyboard.nextInt();
                                }
                                System.out.println("You chose " + espressoShots + " shots of espresso.");
                                cup.latteMacchiato(espressoShots);
                                System.out.println("Your beverage is ready. Enjoy!");
                                System.exit(0);
                                
                            case 4: //Prepares espresso macchiato
                                System.out.println("You chose 4 - Espresso Macchiato.");
                                System.out.println("Please enter the amount of espresso shots you'd like:");
                                int espressoShots1 = keyboard.nextInt(); 
                                while (espressoShots1 > 2)
                                //loops until it gets a proper amount of shots and then makes the drink
                                {
                                    System.out.println("Espresso Macchiato can only be made with one or two shots." );
                                    espressoShots1 = keyboard.nextInt();
                                }
                                System.out.println("You chose " + espressoShots1 + " shots of espresso.");
                                cup.espressoMacchiato(espressoShots1);
                                System.out.println("Your beverage is ready. Enjoy!");
                                System.exit(0);
                            
                            case 5: //prepares morning coffee
                                System.out.println("You chose 5 - Morning Coffee");
                                setStuff.getMorningCoffee();
                                System.out.println("Preparing your morning coffee.");
                                System.out.println("Your beverage is ready. Enjoy!");
                                System.exit(0);
                                
                            case 6: //Prepares hot water
                                System.out.println("You chose 6 - Hot Water");
                                System.out.println("Here's a cup of hot water!");
                                System.exit(0);
                                
                            default: //Default statement to show that the choice is not valid
                                System.out.println("Invalid choice. Returning to main menu");
                                break;

                        }
                }             
          }
        //If the choice is not valid, prints this error message:  
        if(choice < 1 || choice > 4)
        {
          throw new Exception("Please type a number between 1 and 5");
        }
        //If try-catch catches an error, it returns the error message:    
        }
        catch (Exception  e)
        {
           System.out.println(e.getMessage());
        }
     }                 
   }
    
   /**
    * Void method to print the main menu.
    */
    public static void printMainMenu()
    {
        System.out.println("Machine's menu:");
        System.out.println("1: Set up your favourite takeout, coffee and tea parameters");
        System.out.println("2: Order takeout");
        System.out.println("3: View teas and coffees menu");
        System.out.println("4: Brew coffee/tea");
    }
    
    /**
     * Void method to print tea menu from a 2D array.
     * 
     * @param String [][] beverages
     */
    public static void printTea(String beverages[][])
    {
        System.out.println("Tea menu:");
        int i = 0;        
        for (int j = 0; j<beverages[i].length; j++)
        {
            //Prints each number (+1 so it doesn't look weird) and retrieves the string.
            //Since I designed the menu, I know the row that tea is in.
            System.out.println((j+1) + ": " + beverages[0][j]); 
        }               
    }
    
    /**
     * Void method to print coffee menu from a 2D array.
     * 
     * @param String [][] beverages
     */
    public static void printCoffee(String beverages[][])
    {
        System.out.println("Coffee menu:");
        
        for(int i = 0; i<beverages[1].length; i++)
        {
            //Prints each number (+1 so it doesn't look weird) and retrieves the string.
            //Since I designed the menu, I know the row that coffee is in.
            System.out.println((i+1) + ": " + beverages[1][i]);
        }
    }
    
    /**
     * Void method to print the whole menu. To make it simpler, I used a 2D array.
     * 
     * @param String [][] beverages
     */
    public static void beverageMenu(String beverages[][])
    {
        for (int i = 0; i<beverages.length; i++)
        {
          if (i<1)
          //First row, first element is the title
          {
            System.out.println("Tea options: "); 
          }
          else if (i>0&&i<2)
          //First row, second element is the title
          {
          System.out.println("Coffee options: "); 
         }
         
          //Actual menu:
          for (int j = 0; j<beverages[i].length; j++)
          {
           System.out.print(beverages[i][j] + " | "); 
          }
          //Some empty lines for display:
          System.out.println();
          
        }
        System.out.println();
          
    }

    /**
     * 2D String array method to create beverages array for printing the menus.
     * 
     * @return String[][] beverages
     */
    public static String[][] beverages()
    {
        //New objects from other classes
        Tea cupses = new Tea ();
        MachineSetup setStuff = new MachineSetup();
        cupses.setTea(); //Sets the tea array
        
        String[] tea  = cupses.getTea(); //Retrieves the teas from file
        String[] coffeeOptions = new String[] //New coffee array
        {"Short Espresso", "Long Espresso", "Latte Macchiato", "Espresso Macchiato", "Morning Coffee", "Hot Water"};
        
        //2D array
        String[][] beverages = new String[2][tea.length];

        int i;
        
        //Fills in the first row with teas. Leaving one empty element for morning tea
        for(i = 0; i < tea.length-1; i++)
        {
            beverages[0][i] = tea[i];
        }
        beverages[0][i] = "Morning tea"; //Last element is not in file so I declare it separately
        
        //Filling in the second row with coffee array
        for (int j = 0; j < coffeeOptions.length; j++)
        {
            beverages[1][j] = coffeeOptions[j];
        }
        return beverages;
    }
    
    /**
     * Private boolean method just for this class. If the String is not a numeric value, program catches it
     * as an error and returns "false" to break the loop.
     * 
     * @param String button
     * @return boolean true/false
     */
    private static boolean isNumeric(String button)
    {
        try
        //Returns false if it catches an error of entry not being an integer
        {
            int i = Integer.parseInt(button);
        }
        catch(Exception ex)
        {
            return false;
        }

        return true; //Returns true if the entry is an int
    }
}
