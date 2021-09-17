import java.util.Scanner;

   public class Battleship
   {
      public static void main(String[] args)
      {
         Scanner kb = new Scanner(System.in);
                  
         int[] shipa = new int[2];
         
         int[] shipa1 = coordinates(shipa);//coordinates for computer ship
         int[] cshipa1 = coordinates(shipa);//coordinates for user ship
                 
         int[] b = hitsAndMisses(0);
         System.out.println();
         
         printArray(b);
         System.out.println();
         userBoard(b,shipa1); 
      }
//---------------------------------------------------------------------User board is printed      
      public static void userBoard(int[]allPairs,int[]coordinates)
      {
         String results = "";
         int[][] a = new int[10][10];
         
         for(int i = 0; i < coordinates.length; i++)
         {
            for(int j = 0; j < coordinates.length; j++)
            {
               if(allPairs[i] == coordinates[i])
                  results = "X";
               else
                  results = "O";   
            }
         }
         
         System.out.println();
         System.out.print("Player's Board");
         System.out.println();
         
         for(int i = 1; i <= a.length; i++)
         {
            if(i != 10)
               System.out.print(" " + i + "|");
            else if(i == 10)
               System.out.print(i + "|");   
            
            for(int j = 1; j <= a[0].length; j++)
            {
               if(i == allPairs[1] && j == allPairs[0])
                  System.out.print(" " + results + " |");
               else   
                  System.out.print(" # " + "|");
            }
            System.out.println(" ");
         }
         System.out.print("   ");
         
         for(int i = 0; i < 40; i++)
         {
            System.out.print("-" );
         }
         System.out.println(" ");
         System.out.print("    ");
         
         for(int i = 1; i <= a[0].length; i++)
         {
            if(i != 10)
               System.out.print(i + " | ");
            else if(i == 10)
               System.out.print(i);  
         }
         System.out.println();
         
         if(results == "O")
         {
            System.out.println("Miss!");                      
            computerBoard(coordinates);//goes straight to computer hit because user missed
            
         }
         else
         {
            System.out.println("Hit!");
            System.out.println("Game Over!");
         }   
      } 
//---------------------------------------------------------------------User pick hits      
      public static int[] hitsAndMisses(int a)
      {
         Scanner kb = new Scanner(System.in);
         int[] allPairs = new int[100];
         int[] array = new int[2];
         int b, c, count = 0;
         
         do
         {
            System.out.print("Enter x coordinate: ");
            b = kb.nextInt();
            System.out.print("Enter y coordinate: ");
            c = kb.nextInt();
            
            array[count] = b;
            array[count+1] = c;
            
            if(b > 10 || c > 10)
               System.out.println("Enter correct pair of coordinates!");
            
         }while(b > 10 || c > 10);
         
         for(int i = a; i < a + 2; i++)
         {
            allPairs[i] = array[count];
            count++;   
         }
         
         return array;   
      }
//---------------------------------------------------------------------Cordinates of ship      
      public static int[] coordinates(int[] shipa)
      {
         int[] array = new int[shipa.length];
         int randomShip = (int) (Math.random() * 10 + 1);
         
         for(int i = 0; i < shipa.length-1;i++)
         {
            array[i] = randomShip;
            if(randomShip <= 5)
               array[i+1] = randomShip + 1;
            else
               array[i+1] = randomShip - 1;   
         }
         return array;   
      }
//---------------------------------------------------------------------Computer Board is printed     
      public static void computerBoard(int[]coordinates)
      {
         String results = "";
         int[][] a = new int[10][10];
         int[] b = new int[2];
         
         int x = (int) (Math.random() * 10 + 1);
         
         for(int i = 0; i < b.length-1;i++)
         {
            b[i] = x;
            if(x <= 5)
               b[i+1] = x + 1;
            else
               b[i+1] = x - 1;
         }
         
         for(int i = 0; i < coordinates.length; i++)
         {
            for(int j = 0; j < coordinates.length; j++)
            {
               if(b[i] == coordinates[i])
                  results = "X";
               else
                  results = "O";   
            }
         }
         System.out.println();
         System.out.print("Computer's Board");
         System.out.println();
         
         for(int i = 1; i <= a.length; i++)
         {
            if(i != 10)
               System.out.print(" " + i + "|");
            else if(i == 10)
               System.out.print(i + "|");   
            
            for(int j = 1; j <= a[0].length; j++)
            {
               if(i == b[1] && j == b[0])
                  System.out.print(" " + results + " |");
               else   
                  System.out.print(" # " + "|");
            }
            System.out.println(" ");
         }
         System.out.print("   ");
         
         for(int i = 0; i < 40; i++)
         {
            System.out.print("-" );
         }
         System.out.println(" ");
         System.out.print("    ");
         
         for(int i = 1; i <= a[0].length; i++)
         {
            if(i != 10)
               System.out.print(i + " | ");
            else if(i == 10)
               System.out.print(i);  
         }
         System.out.println();
         
         if(results == "O")
         {
            System.out.println("Miss!");
            int[] c = hitsAndMisses(2);//goes back to user hit, since computer missed
            userBoard(c,coordinates);
         }
         else
         {
            System.out.println("Hit!");
            System.out.println("Game Over!");
         }   
      }
//---------------------------------------------------------------------Printing the set of points of hits      
      public static void printArray(int[] array)
      {
         for(int i = 0; i < array.length; i++)
         {
            System.out.print(array[i] + " ");
         }
      }
   }
