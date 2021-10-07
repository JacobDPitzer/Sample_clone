/**
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
*/

/**
 * Extends the Stock class to include extended (of type char), 
 * price (of type double) and number (of type int) fields.  Also has get and 
 * set methods for those fields and overrides the toString method.  
 * Contains default and two parameterized constructors.
 */

/**
 * @author Peter Humphreys
 */
public class Etf extends Stock
{
   private double price;
   private int number;
   private char extended;
   
   /**
    * Default constructor, calls parent default constructor and then 
    * initializes extended to 'A', price to 2176.33 and number to 10.
    * @return none
    */
   Etf()
   {
      super();
      extended = 'A';
      price = 2176.33;
      number = 10;
   }
   
   /**
    * Parameterized constructor, calls parent default constructor and 
    * initializes extended, price and name fields to extended, price and name 
    * parameters' values.
    * @param price of type double
    * @param number of type int
    * @return none
    */
   Etf(char extended, double price, int number)
   {
      super();
      this.extended = extended;
      this.price = price;
      this.number = number;
   }
   
   /**
    * Parameterized constructor, calls parent default constructor and 
    * initializes extended, price and name fields to extended, price and name 
    * parameters' values.
    * @param name of type String
    * @param ticker of type String
    * @param price of type double,
    * number of type int
    * @return none
    */
   Etf(String name, String ticker, char extended, double price, int number)
   {
      super(name, ticker);
      this.extended = extended;
      this.price = price;
      this.number = number;
   }
   
   /**
    * Sets the object's price
    * @param price of type double.
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
    * Sets the object's extended 
    * @param extended of type char
    */
   public void setExtended(char extended)
   {
      this.extended = extended;
   }
   
   /**
    * Returns the object's extended
    * @return The value of the object's extended field, of type char
    */
   public char getExtended()
   {
      return this.extended;
   }
   
   /**
    * Calls the parent toString method and returns a String containing that 
    * information as well as the object's price and number fields.
    * @return String describing the field values of the object.
    */
   @Override
   public String toString()
   {
      return super.toString() + " " + this.extended + " " + this.price + 
              " " + this.number;
   }
   
   /**
    * Calculates the cost of the Etf by multiplying price by number
    * @return cost of the Etf
    */
   @Override
   public double cost()
   {
      return this.price * this.number;
   }
}
