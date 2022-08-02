/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import org.junit.Test;


/**
 *
 * @author Reuben Corriea
 * @modifier : Arif Faysal
 * @date : 18/04/2022
 *
 */
public class MainTest
{

   public MainTest ()
   {
   }



   /**
    * Test of isUniqueUsername method, of class Main.
    * 
    */
   @Test
   public void testIsUniqueUsernameGood ()      // different length & added charachters name
   {
      System.out.println("isUniqueUsernameGood");
      ArrayList<Player> warPlayerList = new ArrayList<>();
      WarPlayer w1 = new WarPlayer("reuben1");
      warPlayerList.add((Player) w1);

      String name = "reuben1122";
      boolean expResult = true;
      boolean result = Main.isUniqueUsername(warPlayerList, name);
      assertEquals(expResult, result);

   }

   /**
    * Test of isUniqueUsername method, of class Main.
    * 
    */
   @Test
   public void testIsUniqueUsernameBad ()       // same length & upper/lower cased charachters name
   {
      System.out.println("isUniqueUsernameBad");
      ArrayList<Player> warPlayerList = new ArrayList<>();
      WarPlayer w1 = new WarPlayer("REUBEN");
      warPlayerList.add((Player) w1);

      String name = "reuben";
      boolean expResult = false;
      boolean result = Main.isUniqueUsername(warPlayerList, name);
      assertEquals(expResult, result);

   }

   /**
    * Test of isUniqueUsername method, of class Main.
    * 
    */
   @Test
   public void testIsUniqueUsernameBoundary ()
   {
      System.out.println("isUniqueUsernameBoundary");
      ArrayList<Player> warPlayerList = new ArrayList<>();
      String name = "Reuben";
      boolean expResult = true;
      boolean result = Main.isUniqueUsername(warPlayerList, name);
      assertEquals(expResult, result);

   }

}
