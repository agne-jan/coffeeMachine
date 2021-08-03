import java.io.*;
import java.util.*;
/**
 * Class Order sets data for ordering for takeout.
 *
 * @author Agne Januskeviciute
 * @date 2020-03-16
 */

public class Order
{
   //Text writing variables
   Scanner file = null;
   PrintWriter output = null;
   
   /**
    * Void method to set shop for takeout. Saves into a file.
    */
   public void setShop()
   {
        try 
        {            
           output = new PrintWriter(new FileOutputStream("FavoriteShop.txt"));
           
           Scanner keyboard = new Scanner (System.in);
           
           //Allows user to add in phone number and address:
           long number = keyboard.nextLong();
           String address = keyboard.nextLine();
           
           System.out.println("You entered " + number + " as a phone number and " + address + " as an address");
           output.println(number + "\n" + address);
           
        } 
        catch (IOException e) 
        {
           System.out.println("File not found.");
        } 
        output.close();
   }
    
    /**
     * Void method to retrieve shop's data that was typed in earlier.
     */
   public void callToOrder()
    {
    try 
     {
       
       file = new Scanner(new FileInputStream ("FavoriteShop.txt"));
       
       //Assigns long number to phone number
       long phoneNum = file.nextLong();
       //Skips the empty space
       String empty = file.nextLine();
       //Assigns the next line to address
       String address = file.nextLine();
       
       System.out.println("Phone number is: " + phoneNum + ", address: " + address);
    }
    catch (IOException e) 
    {
       System.out.println("File Not Found");
    }
    file.close();
    }
}
