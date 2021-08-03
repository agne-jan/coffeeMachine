import java.io.*;
import java.util.*;

/**
 * Class Tea sets up tea options for the Coffee Machine. It uses a "teas" file with a list of teas and calculates 
 * temperatures accordingly (as different teas need different temperatures). Since part of the specification was
 * black or green tea with lemon, sugar or cream, I added those 3 options for black or green tea. Others do not have 
 * them as they are normally enjoyed without lemon, sugar or cream.
 *
 * @author Agne Januskeviciute
 * @date 2020-03-16
 */
public class Tea
{
    //Instance variables - tea type, temperature, lemon, sugar and cream
    private String []type;
    private int[] temp; //temp in C because I do not know Farenheit well enough
    private boolean lemon;
    private int sugar;
    private int cream;

    /**
     * Constructor for objects of class Coffee. Initialized the variables.
     */
    public Tea()
    {
        type = new String[6] ;
        temp = new int [5] ;
        lemon = false;
        sugar = 0;
        cream = 0;   
    }
    //Setter methods:
    /**
     * Array method to fill in tea list from the file "teas". 
     * 
     * @return String[] type
     */
    public String[] setTea()
    {
     this.type = type; //Setting the instance variable to this method
     
     try 
     {    
       Scanner file = new Scanner(new File ("Teas.txt"));
       //Tea type array is filled with each line from the text
         for (int i = 0; i < type.length; i++) 
         {
           type [i] = file.nextLine();
         }
     } 
     catch (Exception e) 
     {
      System.out.println("");
     }
      return type; 
    }
    
    /**
     * Array method to fill in temperatures for the tea. I sorted teas such that
     * in the file they each match every 5`C increase in recommended water temperature.
     * 
     * @return int[] temp
     */
    public int [] setTemp ()
    {
      int celsius = 75; //lowest temperature for teas is 75`C (matches "White" in the file)
      //Temperature array filled with temperature values (5`C increase with each tea)
      for (int i = 0; i<temp.length; i++)
      {
        temp [i] = celsius + (i*5);  
      }
      
      return temp;
    }
    
    /**
     * Void method to set lemon values (yes or no).
     * 
     * @param String choice
     */
     public void setLemon(String choice)
    {
        if (choice.equalsIgnoreCase("yes")) //Ignores capital letters 
        {
            lemon = true;
        }
        else if (choice.equalsIgnoreCase("no"))
        {
            lemon = false;
        }
    }
    
    /**
     * Void method to set sugar (in teaspoons).
     * 
     * @param int sugar
     */
         public void setSugar(int sugar)
    {
        this.sugar = sugar; 
    }
    
    /**
     * Void method to set cream (in ml).
     * 
     * @param int cream
     */
    public void setCream(int cream)
    {
        this.cream = cream;
    }
    //Getter methods  
    /**
     * Array method to retrieve updated tea.
     * 
     * @return String[] type
     */
    public String[] getTea()
    {
        this.type = type;
        return type;
    }
    
    /**
     * Boolean method to retrieve lemon option.
     * 
     * @return boolean lemon;
     */
    public boolean getLemon()
    {
        return lemon;
    }
    
    /**
     * Int method to retrieve cream amount.
     * 
     * @return int cream;
     */
    public int getCream()
    {
        return cream;
    }
    
    /**
     * Int method to retrieve sugar amount.
     * 
     * @return int sugar
     */
    public int getSugar()
    {
        return sugar;
    }
    
    /**
     * Array method to retrieve temperatures array.
     * 
     * @return int[] temp
     */
    public int[] getTemp()
    {
     temp = setTemp(); //Assigns temperatures to the new array.
     return temp;
    }
    
    /**
     * Void method that takes in user decisions for black tea. Temperature is adjusted
     * accordingly. I don't think lemon and cream should go together but people should
     * have a choice.
     * 
     * @param String type[]
     * @param boolean lemon
     * @param int cream
     * @param int sugar
     */
    public void blackTea(String type[], boolean lemon, int cream, int sugar)
    {
        String teaLeaf = type[3];
        getTemp(); //Retrieves the temperature array
        int temperature = temp [3]; //Temperature matching 4th tea on file
        
        System.out.println("Your choice of tea is: " + teaLeaf + ", brewing temperature: " + temperature + ", lemon: " +
        lemon + ", cream: " + cream + ", sugar: " + sugar);
    }
    
    /**
     * Void method that takes in user decisions for green tea. Temperature is adjusted
     * accordingly. 
     * 
     * @param String type[]
     * @param boolean lemon
     * @param int cream
     * @param int sugar
     */
    public void greenTea(String type[],  boolean lemon, int cream, int sugar)
    {
       String teaLeaf = type [2];
       getTemp(); //Retrieves the temperature array
       int temperature = temp [2]; //Temperature matching 2nd tea on file
       
       System.out.println("Your choice of tea is: " + teaLeaf + ", brewing temperature: " + temperature + ", lemon: " +
        lemon + ", cream: " + cream + ", sugar: " + sugar);
    }
}
