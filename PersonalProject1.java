import java.util.Scanner;
import java.util.Random;
public class PersonalProject1{
    public static void main(String[] arrrgs){
        Scanner scnr = new Scanner(System.in);
        Random rand = new Random();
        int pointUser =0;
        int pointComputer =0;
        int count =0;
        
        System.out.println("dice game");
        System.out.println("Rules: In a dice turn, if your point is higher than computer's point, all points from computer and dice point move to you.");
        System.out.println("If your point is lower than computer's point, all points from you and dice point move to computer.");
        System.out.println("The game ends when one player has 100 point first.");
        System.out.println("If the point is 0, you just can have the point from dice.");
        System.out.println("Do you want to start the game? (y/n)");
        String start = scnr.next();
        if(start.equals("y"))
        {
            //game start
            while(pointUser < 100 && pointComputer < 100){
                count ++;
                System.out.print("\nType roll to roll the dice: ");
                String roll = scnr.next();

                if(roll.equalsIgnoreCase("roll"))
                {
                    int diceUser = rand.nextInt(1,7);
                    int diceComputer = rand.nextInt(1,7);
                    System.out.println("\nYour dice point: " + diceUser);
                    System.out.println("Computer's dice point: " + diceComputer);

                    if( diceUser > diceComputer)
                    {
                        pointUser = pointUser + pointComputer + diceUser + diceComputer;
                        pointComputer = 0;

                        if (pointUser >= 100)
                        {
                            System.out.printf("\nYou win! with %d turns", count);
                            break;
                        }

                        else{
                        System.out.println("\n=>Your point: " + pointUser);
                        System.out.println("Computer's point: " + pointComputer);
                        }
                    }

                    else if(diceUser < diceComputer)
                    {
                        pointComputer = pointComputer + pointUser + diceComputer+diceUser;
                        pointUser = 0;

                        if (pointComputer >= 100)
                        {
                            System.out.println("\nComputer win! with " + count + " turns");
                            break;
                        }

                        else
                        {
                        System.out.println("\nYour point: " + pointUser);
                        System.out.println("=>Computer's point: " + pointComputer);
                        }
                    }

                    else if(diceUser == diceComputer)
                    {
                        pointUser = pointUser + diceUser;
                        pointComputer = pointComputer + diceComputer;
                        System.out.println("\nYour point: " + pointUser);
                        System.out.println("Computer's point: " + pointComputer);
                    }
                }
                
                else {
                    System.out.println("\nYou broke the game");
                    break;
                }
            }
        }

        else if(start.equals("n"))
        {
            System.out.println("bye");
        }

        else
        {
            System.out.println("Invalid input");
        }
        scnr.close();
    }
}