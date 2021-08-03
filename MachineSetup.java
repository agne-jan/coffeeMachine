import java.io.*;
import java.util.*;

/**
 * Class MachineSetup allows the user to set up coffee shop info, tea and coffee.
 *
 * @author Agne Januskeviciute
 * @date 2020-03-16
 */
public class MachineSetup
{
    //Scanner and printwriter variables:
    Scanner keyboard = new Scanner (System.in);
    Scanner file = null;
    PrintWriter output = null;
    
    //Tea, coffee and order objects to allow to retrieve data from there:
    Order order = new Order();
    Tea regularTea = new Tea();
    Coffee regularCoffee = new Coffee ();
    
    //Tea variables
    String [] teas = new String [5];
    int[] temp = regularTea.getTemp();
    int n = 0;
    int cream = 0;
    int temperature = 90;
    int sugar = 0;
    String lemon = "no";
    String teaLeaf = "Black";

    //Coffee variables
    int grounds;
    int tempCoffee;
    int total;
    int milk;

    /**
     * Void method that allows the user to set up the parameters for the Coffee Machine.
     * Returns back to the main menu after choices are recorded.
     */
    public void setEverything()
    {
        System.out.println("Set up your favorite: " + "\n" +"1: Coffee shop " + "\n" +"2: Morning coffee "
        + "\n" +"3: Morning tea");
        
        int choice = keyboard.nextInt();
        
          switch (choice)//Menu options
          {
            
                
               case 1: //Sets the coffee
                    System.out.println("You chose 1 - to set up your coffee shop.");
                    System.out.println("Set up your favorite coffee shop. Type in phone number and address " +
                    "separated by space and in one line:");
                    order.setShop();
                    System.out.println("Coffee shop for takeout has been memorized. Going back to main menu:");
                    break; //Breaks this loop
               
               case 2: //Sets up coffee
                    System.out.println("You chose 2 - to set up your morning coffee.");
                    System.out.println("Set up your coffee:");
                    setCoffee();
                    System.out.println("Morning coffee has been memorized. Going back to main menu:");
                    break;//Breaks this loop
                   
               case 3: //Sets up tea
                    System.out.println("You chose 3 - to set up your morning tea.");
                    System.out.println("Set up your tea:");
                    fillTea();
                    viewTea(teas);
                    setTea();
                    System.out.println("Morning tea has been memorized. Going back to main menu:");
                    break;//Breaks this loop
               
          }
           
    }

    /**
     * Void method to set up the shop. Uses the file writing information in Order class.
     */
    public void setShops()
    {
        System.out.println("Set up information for your favorite coffee shop:");
        
        order.setShop();
    }
    
    /**
     * Array method to retrieve the tea list from the file.
     * 
     * @return String[] teas
     */
    public String[] fillTea()
    {
     
     try 
     {    
       Scanner file = new Scanner(new File ("Teas.txt"));
       //Fills in the new tea list from the file
         for (int i = 0; i < teas.length+1; i++) 
         {
           teas[i] = file.nextLine();
         }
     } 
     catch (Exception e) 
     {
       System.out.println("");
     }
      return teas;        
    }
    
    /**
     * Void method that prints out the tea list.
     */
    public void viewTea(String[] tea)
    {
        //Prints every option. i+1 so it does not look awkward to the user
        for (int i = 0; i<tea.length; i++)
        {
            System.out.println((i+1)+ ": " + tea[i] + "\n"); 
        }
    }
    
   /**
    * Void method to set the morning tea. Reads the file, asks user which tea, sugar, cream they want,
    * whether or not they want lemon. Temperature is set accordingly.
    */
    public void setTea()
    {
        try 
        {            
           output = new PrintWriter(new FileOutputStream("MorningTea.txt"));
           
           //Prints to file the tea of choice
           System.out.println("Choose your morning tea: "); 
           Scanner keyboard = new Scanner (System.in);
           this.n = keyboard.nextInt();
           this.teaLeaf = teas[n-1]; //n-1 to counteract the menu choice
           System.out.println("You chose " + teas[n-1]);
           output.println(teas[n-1]);
           
           //Prints to file lemon choice - not a yes or no, but the boolean value
           System.out.println("Would you like lemon? Type in yes or no: ");
           lemon = keyboard.nextLine();
           lemon = keyboard.nextLine();
           regularTea.setLemon(lemon);
           System.out.println("You chose " + regularTea.getLemon());
           output.println(regularTea.getLemon());
           
           //Prints to file amount of sugar
           System.out.println("How much sugar? Type in teaspoons: ");
           this.sugar = keyboard.nextInt();
           regularTea.setSugar(sugar);
           System.out.println("You chose " + sugar);
           output.println(sugar);
           
           //Prints to file amount of cream
           System.out.println("How much half and half? Type in ml: ");
           this.cream =  keyboard.nextInt();
           regularTea.setCream(cream);
           System.out.println("You chose " + cream);
           output.println(cream);
           
           //Prints to file the temperature
           this.temperature = temp[n-1];
           System.out.println("Temperature will be set accordingly: " + temperature);
           output.println(temperature);
        } 
        catch (IOException e) 
        {
           System.out.println("File not found.");
        } 
        output.close();
    }
    
  /**
    * Void method to retrieve morning tea from file that is saved in setTea method.
    */
  public void getMorningTea()
  {
        try 
     {
       file = new Scanner(new FileInputStream ("MorningTea.txt"));
       
       //Reads tea
       String teaLeaf = file.nextLine();
       
       //Reads lemon choice
       String lemon = file.nextLine();
       
       //Reads sugar value
       int sugar = file.nextInt();
       
       //Reads empty line 
       String empty = file.nextLine();
       
       //Reads cream value
       int cream = file.nextInt();
       
       //Reads empty line 
       String empty1 = file.nextLine();
       
       //Reads temperature value
       int temperature = file.nextInt();
       
       //Returns the morning tea for brewing
       System.out.println("Your morning tea is " + teaLeaf + ",  lemon: " + lemon + ", sugar: " + sugar + 
       ", cream: " + cream + " at " + temperature + "`C");
    }

    catch (IOException e) 
    {
       System.out.println("File Not Found");
    }
    file.close();

  }
   
  /**
   * Void method to set cofee choices that are then written to morning coffee file.
   */
  public void setCoffee()
  {
    try 
    {            
           output = new PrintWriter(new FileOutputStream("MorningCoffee.txt"));
           
           //Prints amount of coffee:
           System.out.println("How much coffee grounds would you like (in grams)?:");
           this.grounds = keyboard.nextInt();
           regularCoffee.setCoffeeGrounds(grounds);
           System.out.println("You chose " + grounds);
           output.println(grounds);
           
           //Prints wanted temperature:
           System.out.println("What temperature would you like your coffee to be? Type in value in Celsius: ");
           this.tempCoffee = keyboard.nextInt();
           regularCoffee.setTemp(tempCoffee);
           System.out.println("You chose " + tempCoffee);
           output.println(tempCoffee);
           
           //Prints amount of water:
           System.out.println("How much water would you like? Type in value in ml:");
           this.total = keyboard.nextInt();
           regularCoffee.setTotalAmount(total);
           System.out.println("You chose " + total);
           output.println(total);
           
           //Prints amount of steamed milk:
           System.out.println("How much steamed milk would you like? Type in value in ml:");
           this.milk = keyboard.nextInt();
           regularCoffee.setMilk(milk);
           System.out.println("You chose " + milk);
           output.println(milk);
    } 
    catch (IOException e) 
    {
           System.out.println("File not found.");
    } 
    output.close();
  }
  
  /**
   * Void method to retrieve morning coffee from file that is updated above.
   */
  public void getMorningCoffee()
  {
    try 
    {  
       file = new Scanner(new FileInputStream ("MorningCoffee.txt"));
       
       //Reads amount of coffee grounds
       int grounds = file.nextInt();
       
       //Reads temperature
       int temperature = file.nextInt();
       
       //Reads amount of water
       int water = file.nextInt();
       
       //Reads empty string
       String empty = file.nextLine();
       
       //Reads amount of milk
       int milk = file.nextInt();
       
       String empty1 = file.nextLine();
       
       //Returns morning coffee for brewing:
       System.out.println("Your morning tea is " + grounds + "g of coffee grounds at " + temperature + "`C, with " + water + 
       "ml of water and  " + milk + "ml of steamed milk. ");
    }

    catch (IOException e) 
    {
       System.out.println("File Not Found");
    }
    file.close();
    }

}
