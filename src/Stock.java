/**
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
*/

/**
 * Contains fields name, of type String, ticker, of type String.  Also has
 * get and set methods for those fields, a toString method and an abstract
 * cost method.  Contains default and parameterized constructors.
 */

/**
 * @author Peter Humphreys
 */
public abstract class Stock 
{
   private String name;
   private String ticker;
   
   /**
    * Default constructor, initializes name to "Amazon" and ticker to "AMZN"
    * @param none
    * @return none
    */
   protected Stock()
   {
      name = "Amazon";
      ticker = "AMZN";
   }
   
   /**
    * Parameterized constructor, sets name and ticker fields to name and 
    * ticker parameter values.
    * @param name of type String
    * @param ticker of type String
    * @return none
    */
   protected Stock(String name, String ticker)
   { 
      this.name = name;
      this.ticker = ticker;
   }
   
   /**
    * Sets the object's name
    * @param name of type String
    * @return none
    */
   public void setName(String name)
   {
      this.name = name;
   }
   
   /**
    * Returns the object's name
    * @param none
    * @return String describing the field values of the object.
    */
   public String getName()
   {
      return this.name;
   }
   
   /**
    * Sets the object's ticker.
    * @param ticker of type String
    * @return none
    */
   public void setTicker(String ticker)
   {
      this.ticker = ticker;
   }
   
   /**
    * Returns the object's ticker.
    * @param none
    * @return Value of the object's ticker field, of type String
    */
   public String getTicker()
   {
      return this.ticker;
   }
   
   /**
    * Returns a string containing the values of the object's fields.
    * @param none
    * @return String describing the field values of the object.
    */
   @Override
   public String toString()
   {
      return this.name + " " + this.ticker;
   }
   
   /**
    * Calculates cost of Stock, implementation specified in subclasses.
    * @param none
    * @return cost of Stock
    */
   public abstract double cost();
}
