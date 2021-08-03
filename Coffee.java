
/**
 * Class Coffee sets up coffee options for the Coffee Machine. All my knowledge on espresso and latte macchiato
 * are based on Google searches. Different variables such as amount of coffee grounds, temperature, amount of 
 * steamed milk, foam or not and amount of water make up different coffee drinks so they are defined here.
 * 
 * 4 types of coffees are set here to match amount of tea at least partially.
 * Measures are metric.
 *
 * @author Agne Januskeviciute
 * @date 2020-03-16
 */
public class Coffee
{

    private int coffeeGrounds; //in grams
    private int temp; //temp in C
    private int amtSteamedMilk; //ml
    private boolean foam; //Yes or no
    private int totalAmount; //ml

    /**
     * Initializing instance variables.
     */
    public Coffee()
    {
        coffeeGrounds = 7;
        temp = 88;
        amtSteamedMilk = 0;
        foam = false;
        totalAmount = 25;        
    }
    //Setter methods
    /**
     * Void method for setting coffee grounds.
     * 
     * @param int grounds 
     */
    public void setCoffeeGrounds(int grounds)
    {
        this.coffeeGrounds = grounds;
    }
    
    /**
     * Void method for setting temperature.
     * 
     * @param int temp
     */
    public void setTemp(int temp)
    {
        this.temp = temp;
    }
    
    /**
     * Void method for setting milk.
     * 
     * @param int milk
     */
     public void setMilk(int milk)
    {
        this.amtSteamedMilk = milk;
    }
    
    /**
     * Void method for setting foam.
     * 
     * @param boolean foam.
     */
    public void setFoam(boolean foam)
    {
        this.foam = foam;
    }
    
    /**
     * Void method for setting water amount.
     * 
     * @param int amount
     */
    public void setTotalAmount(int amount)
    {
        this.totalAmount = amount;
    }
    //Getter methods:
    /**
     * Int method to retrieve coffee grounds.
     * 
     * @return int coffeeGrounds
     */
    public int getCoffeeGrounds()
    {
        return coffeeGrounds;
    }
    
    /**
     * Int method to retrieve temperature.
     * 
     * @return int temp
     */
    public int getTemp()
    {
        return temp;
    }
    
    /**
     * Boolean method to retrieve foam value.
     * 
     * @return foam
     */
    public boolean getFoam()
    {
        return foam;
    }
    
    /**
     * Int method to retrieve drink amount.
     * 
     * @return int totalAmount
     */
    public int getTotalAmount()
    {
        return totalAmount;
    }
    
    /**
     * Int method to return steamed milk amount.
     * 
     * @return int amtSteamedMilk
     */
    public int getMilk()
    {
        return amtSteamedMilk;
    }
    
    /**
     * Void method to set a short espresso drink. Values retrieved from Instituto Nazionale Espresso Italiano
     * http://www.espressoitaliano.org/files/File/istituzionale_inei_hq_en.pdf
     */
    public void shortEspresso()
    {
        coffeeGrounds = 7;
        temp = 88;
        totalAmount = 25;
        foam = false; 
        
        System.out.println("You chose espresso (short). Grams of coffee grounds used: " + coffeeGrounds +
        ", water temperature: " + temp + ", foam: " + foam + ", total ml of your drink: " + totalAmount);
    }
    
    /**
     * Void method to set a long espresso drink. Based on the internet, it's one shot of espresso but with double the 
     * water. Since short espresso water values are different I chose 60 for this one.
     */
    public void longEspresso()
    {
        coffeeGrounds = 7;
        temp = 88;
        totalAmount = 60;
        foam = false;
        
        System.out.println("You chose espresso (long). Grams of coffee grounds used: " + coffeeGrounds +
        ", water temperature: " + temp + ", foam: " + foam + ", total ml of your drink: " + totalAmount);
    }
    
    /**
     * Void method to set espresso macchiato. Takes one or two shots of espresso and adds milk foam.
     * If the user asks for more than 2 shots, the machine does not allow that.
     * 
     * @param int amtShots
     */
    public void espressoMacchiato(int amtShots)
    {
        if (amtShots == 1) //Single shot espresso macchiato
        {
        coffeeGrounds = 7;
        temp = 88;
        totalAmount = 30;
        foam = true;
        
        System.out.println("You chose espresso macchiato (single shot). Grams of coffee grounds used: " + coffeeGrounds +
        ", water temperature: " + temp + ", foam: " + foam + ", total ml of your drink: " + totalAmount);
      } else if (amtShots == 2) //Double shot espresso macchiato
      {
        coffeeGrounds = 14;
        temp = 88;
        totalAmount = 60;
        foam = true;
        
        System.out.println("You chose espresso macchiato (double shot). Grams of coffee grounds used: " + coffeeGrounds +
        ", water temperature: " + temp + ", foam: " + foam + ", total ml of your drink: " + totalAmount);
        
      }
      else 
      {
        System.out.println("Espresso macchiato can only be made with one or two shots.");
       }
    }
    
    /**
     * Void method to set latte macchiato. Takes one or two shots of espresso and adds milk and milk foam.
     * Recipes online vary so I chose 50ml of steamed milk.
     * If the user asks for more than 2 shots, the machine does not allow that.  
     * 
     * @param int amtShots
     */
    public void latteMacchiato(int amtShots)
    {
        if (amtShots == 1) //Single shot latte
        {
          coffeeGrounds = 7;
          temp = 95;
          amtSteamedMilk = 50;
          totalAmount = 200;
          foam = true;
          
          System.out.println("You chose latte (single shot). Grams of coffee grounds used: " + coffeeGrounds +
          ", water temperature: " + temp + ", foam: " + foam + ", total ml of your drink: " + totalAmount + amtSteamedMilk);
        }
        else if (amtShots == 2) //double shot latte
        {
          coffeeGrounds = 14;
          temp = 95;
          amtSteamedMilk = 50;
          totalAmount = 230;
          foam = true;
          
          System.out.println("You chose latte (double shot). Grams of coffee grounds used: " + coffeeGrounds +
          ", water temperature: " + temp + ", foam: " + foam + ", total ml of your drink: " + totalAmount);
        }
        else 
      {
        System.out.println("Espresso macchiato can only be made with one or two shots.");
       }
    }
}
