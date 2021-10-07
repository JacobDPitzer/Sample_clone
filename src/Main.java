/**
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
*/

/**
 * Creates an array of Stock objects of fixed size MAX_STOCKS and performs 
 * operations on it.  Takes command inputs to add new objects to the array, 
 * remove objects, update the price of an object, test for equality of cost 
 * and print Strings containing all pertinent information of all objects in 
 * the array.  Loops until user specifies to stop.
 */

/**
 * @author Peter Humphreys
 * Note - I completed all of the discarded items except the test case.
 */
import java.io.File;
import java.util.Scanner;
public class Main
{
   final static int MAX_STOCKS = 6;
   final static int NUM_INDEXES = 2;
   static Scanner input = new Scanner(System.in);
   static int numStocks = 0;
   
   /**
    * Creates an array of type Stock and performs selected operations on the 
    * array depending on the command.
    * @param args of type String
    * @return none
    */
   public static void main(String [] args)
   {
      try
      {
         input = new Scanner(new File(args[0]));
      }
      catch(Exception ex)
      {
         input = new Scanner(System.in);
      }
      Stock [] stockList = new Stock [MAX_STOCKS];
      System.out.println("Let's start trading!\nPick an option:\tA-Add"
              + "\tR-Remove\tP-Print\tC-Change Price\tQ-Quit\tY-Equality");
      char command = 'Z';
      command = input.next().charAt(0);      
      int index = -1;
      int indexes [] = {-1, -1};
      while (command == 'A' || command == 'a' || command == 'R' || 
              command == 'r' || command == 'C' || command == 'c' || 
              command == 'P' || command == 'p' || command == 'Y' || 
              command == 'y')
      {
         if ((command == 'R' || command == 'r' || command == 'P' || 
                 command == 'p' || command == 'C' || command == 'c' || 
                 command == 'Y' || command == 'y') && numStocks == 0)
            System.out.println("Manager is empty");
         else if ((command == 'A'  || command == 'a') && 
                 numStocks == MAX_STOCKS)
            System.out.println("Manager is full");
         else
            processCommand(stockList, command, index, indexes);
         System.out.println("Pick an option:\tA-Add\tR-Remove\tP-Print"
                 + "\tC-Change Price\tQ-Quit\tY-Equality");
         command = input.next().charAt(0);
      }
      System.out.println("Done trading");
   }
   
   /**
    * Switches flow of control to given method, depending on the command 
    * passed from the main method.
    * @param stockList of type Stock
    * @param command of type char
    * @param index of type int
    * @param indexes of type int
    * @return none
    */
   public static void processCommand(Stock [] stockList, char command,
           int index, int [] indexes)
   {
      if (command == 'A' || command == 'a')
      {
         command = input.next().charAt(0);
         if (command == 'M' || command == 'm')
            add(stockList, input.next(), input.next(), input.nextDouble(), 
                    input.nextInt(), input.nextDouble());
         else if (command == 'E' || command == 'e')
            add(stockList, input.next(), input.next(), input.next().charAt(0),
                    input.nextDouble(), input.nextInt());
      }
      else if (command == 'R' || command == 'r')
         remove(stockList, index);
      else if (command == 'P' || command == 'p')
         print(stockList);
      else if (command == 'C' || command == 'c')
         changePrice(stockList, index);
      else if (command == 'Y' || command == 'y')
         System.out.println(equality(stockList, command, indexes));
   }
   
   /**
    * Checks if ticker already exists and if not, adds a new MutualFund Stock 
    * to the array and increments the number of Stocks in array
    * @param stockList of type Stock
    * @param name of type String
    * @param ticker of type String
    * @param price of type double
    * @param number of type int
    * @param yieldPercentage of type double
    */
   public static void add(Stock [] stockList, String name, String ticker, 
           double price, int number, double yieldPercentage)
   {
      if (search(stockList, ticker) < 0)
      {      
         price = (absoluteValue(price));
         stockList [numStocks] = new MutualFund(name, ticker, price, number, 
                 yieldPercentage);
         numStocks ++;
      }
   }
   
   /**
    * Checks if combination of ticker and extended already exists and if not,
    * adds a new Etf Stock to the array and increments the number of Stocks 
    * in array
    * @param stockList of type Stock
    * @param name of type String
    * @param ticker of type String
    * @param extended of type char
    * @param price of type double
    * @param number of type int
    * @return none
    */
   public static void add(Stock [] stockList, String name, String ticker,
           char extended, double price, int number)
   {
      if (search(stockList, ticker, extended) < 0)
      {
         price = (absoluteValue(price));
         stockList [numStocks] = new Etf(name, ticker, extended, price, 
                 number);
         numStocks ++; 
      }
   }
   
   /**
    * Calls search to find index of specified ticker (Does not consider if 
    * stock is Etf or MutualFund) - if index is found, removes a Stock from 
    * the array and decrements the number of Stocks in the array, otherwise 
    * prints "Not found".
    * @param stockList of type Stock []
    * @param indexToDelete of type int
    * @return none
    */
   public static void remove(Stock [] stockList, int indexToDelete)
   {
      indexToDelete = search(stockList, input.next());
      //If index is found, copy every object at indexes above it to
      //one index lower, delete last object and decrement numStocks
      if (indexToDelete >= 0)
      {
         for (int i = indexToDelete; i < numStocks - 1; i ++)
            stockList [i] = stockList [i + 1];
         stockList [numStocks - 1] = null;
         numStocks --;
      }
      else 
         System.out.println("Not found");
   }
   
   /**
    * Calls search to find index of specified ticker (Does not consider if 
    * stock is Etf or MutualFund) - if index is found, casts the Stock object 
    * at the specified index to the proper subclass and updates the price- 
    * otherwise prints "Not found".
    * @param stockList of type Stock
    * @param indexToChange of type int
    * @return none
    */
   public static void changePrice(Stock [] stockList, int indexToChange)
   {
      indexToChange = search(stockList, input.next());
      if (indexToChange >= 0)
      {
         if (stockList [indexToChange] instanceof Etf)
            ((Etf)stockList [indexToChange]).setPrice
               (absoluteValue(input.nextDouble()));
         else if (stockList [indexToChange] instanceof MutualFund)
            ((MutualFund) stockList [indexToChange]).setPrice
               (absoluteValue(input.nextDouble()));
      }
      else 
         System.out.println("Not found");
   }
   
  /**
   * If price is negative, multiplies price by -1 to produce absolute value 
   * of price, otherwise returns price as passed.
   * @param price of type double
   * @return absolute value of price
   */
   public static double absoluteValue(double price)
   {
      if (price < 0)
         return price * -1;
      return price;
   }
   
   /**
    * Prints a String description of the Stock's fields and field values.
    * @param stockList of type Stock
    * @return none
    */
   public static void print(Stock [] stockList)
   {
      for (int i = 0; i < numStocks; i ++)
         System.out.println(stockList [i].toString());
   }
   
   /**
    * Searches the array for the specified ticker value and returns index if
    * it is found and -1 if it is not.
    * @param stockList of type Stock 
    * @param ticker of type String
    * @return index of ticker, if found.  Else, -1.
    */
   public static int search(Stock [] stockList, String ticker)
   {
      for (int i = 0; i < numStocks; i ++)
      {
         if (stockList [i] instanceof MutualFund)
         {
            if (((MutualFund)stockList [i]).getTicker().equals(ticker))
               return i;
         }
         else if (stockList [i] instanceof Etf)
         {
            if (((Etf)stockList [i]).getTicker().equals(ticker))
               return i;
         }
      }
      return -1;
   }
   
   /**
    * Searches the array for the specified combination of ticker and extended
    * values and returns index if it is found and -1 if it is not.
    * @param stockList
    * @param ticker of type String
    * @param extended of type char
    * @return index of ticker/extended combination, if found.  Else, -1.
    */
   public static int search(Stock [] stockList, String ticker, char extended)
   {
      for (int i = 0; i < numStocks; i ++)
      {
         if (stockList [i] instanceof Etf)
         {
            if (((Etf)stockList [i]).getTicker().equals(ticker) && 
                    ((Etf)stockList [i]).getExtended() == extended)
               return i;
         }
      }
      return -1;
   }
   
   /**
    * Depending on command, calls appropriate search method to check if 
    * 2 specified Stocks are in the array, if so, calls appropriate cost 
    * methods of those Stocks and returns a String describing whether they 
    * are equal or not - otherwise returns "Not found".
    * @param stockList of type Stock
    * @param command of type char
    * @param indexes of type int
    * @return String describing "Equal", "Not Equal" or "Not Found".
    */
   public static String equality(Stock [] stockList, char command,
           int [] indexes)
   {
      for (int i = 0; i <= 1; i ++)
      {
         command = input.next().charAt(0);
         if (command == 'E' || command == 'e')
            indexes [i] = search(stockList, input.next(), 
                    input.next().charAt(0));
         else if (command == 'M' || command == 'm')
            indexes [i] = search(stockList, input.next());
      }
      if (indexes [0] < 0 || indexes [1] < 0)
         return "Not found";
      else if (stockList [indexes [0]].cost() == 
              stockList [indexes [1]].cost())
            return "Equal";
      return "Not equal";
   }
}
