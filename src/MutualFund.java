/**
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
*/

/**
 * Extends the Stock class to include price (of type double), number (of type 
 * int) and yieldPercentage (of type double) fields.  Also has get and set 
 * methods for those fields and overrides the toString method.  Contains 
 * default and two parameterized constructors.
 */

/**
 * @author Peter Humphreys
 */
public class MutualFund extends Stock
{
   final static int DECIMAL_CONVERSION = 100;
   private double price;
   private int number;
   private double yieldPercentage;
   
   /**
    * Default constructor, initializes price to 2176.33, number to 10 and
    * yieldPercentage to 10.0.
    * @return none
    */
   MutualFund()
   {
      super();
      this.price = 2176.33;
      this.number = 10;
      this.yieldPercentage = 10.0;
   }
   
   /**
    * Parameterized constructor, calls parent default constructor and 
    * initializes price, name and yieldPercentage fields to price, name and 
    * yieldPercentage parameters' values.
    * @param price of type double
    * @param number of type int
    * @param yieldPercentage of type double
    * @return none
    */
   MutualFund(double price, int number, double yieldPercentage)
   {
      super();
      this.price = price;
      this.number = number;
      this.yieldPercentage = yieldPercentage;
   }
   
   /**
    * Parameterized constructor, calls parent parameterized constructor and 
    * initializes price, name and yieldPercentage fields to price, name and 
    * yieldPercentage parameters' values.
    * @param name of type String
    * @param ticker of type String
    * @param price of type double
    * @param number of type int
    * @return none
    */
   MutualFund(String name, String ticker, double price, int number, 
           double yieldPercentage)
   {
      super(name, ticker);
      this.price = price;
      this.number = number;
      this.yieldPercentage = yieldPercentage;
   }
   
   /**
    * Sets the object's price
    * @param price of type double
    * @return none
    */
   public void setPrice(double price)
   {
      this.price = price;
   }
   
   /**
    * Returns the object's price
    * @return The value of the object's price field, of type double.
    */
   public double getPrice()
   {
      return this.price;
   }
   
   /**
    * Sets the object's number
    * @param number of type int
    * @return none
    */
   public void setNumber(int number)
   {
      this.number = number;
   }
   
   /**
    * Returns the object's number
    * @return The value of the object's number field, of type int.
    */
   public int getNumber()
   {
      return this.number;  
   }
   
   /**
    * Sets the object's yieldPercentage
    * @param yieldPercentage of type double
    * @return none
    */
   public void setYieldPercentage(double yieldPercentage)
   {
      this.yieldPercentage = yieldPercentage;
   }
   
   /**
    * Returns the object's yieldPercentage
    * @return Value of the object's yieldPercentage field, of type double.
    */
   public double getYieldPercentage()
   {
      return this.yieldPercentage;
   }
   
   /**
    * 
    * Calls the parent toString method and returns a String containing that 
    * information as well as the object's price, number and yieldPercentage
    * fields.
    * @return String describing the field values of the object.
    */
   @Override
   public String toString()
   {
      return super.toString() + " " + this.price + " " + this.number + " " + 
              this.yieldPercentage;
   }
   
   /**
    * Calculates the cost of the MutualFund by dividing yieldPercentage by 
    * 100 and then multiplying that value by price times number
    * @return cost of the MutualFund
    */
   @Override
   public double cost()
   {
      return (this.yieldPercentage / DECIMAL_CONVERSION) * 
              (this.price * this.number);
   }
}
