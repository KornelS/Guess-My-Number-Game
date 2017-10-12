/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guess.my.number;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Saleron
 */
public class GuessMyNumber {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int limit, numberOfTry, guess, randomNumber, i=0;
        
        Scanner input = new Scanner (System.in);
        Random random = new Random();
        
        System.out.println("Please type in the highest number.");
         while (!input.hasNextInt())
        {
            System.out.println("This is not a number!");
            input.next();
        }
         limit = input.nextInt();
        
         System.out.println("Please type in how many times do you want to try.");
         while (!input.hasNextInt())
        {
            System.out.println("This is not a number!");
            input.next();
        }
         numberOfTry = input.nextInt();
         
        randomNumber = random.nextInt(limit) + 1;
        System.out.println(randomNumber);
        
        System.out.println("Please type in your guess.");
         while (!input.hasNextInt())
        {
            System.out.println("This is not a number!");
            input.next();
        }
         guess = input.nextInt();
         
        while (i != numberOfTry)
        {
            if (i == numberOfTry)
                //Because we already asked for a guess before the loop we will end up with "numberOfTry" + 1 guess prompt if we don't 
                //guess the right answer before the given guess limit.
                //When the loop ends and the answer is correct the program won't print out the line for the correct guess, 
                //even though it does for the wrong answer. I don't know why.
                //So to go around this i kept the "numberOfTry" + 1 and simply broke the program on the last loop.
                //This way it will always check for every scenario.
                //Not exactly elegant but it works.
                {
                    System.out.println("Game Over!");
                    break;
                }
            if (guess == randomNumber)
                {
                    System.out.println("Correct! The answer is: " + randomNumber);
                    break;
                }
            if (guess != randomNumber)
                {
                    System.out.println("Wrong, try again!");
                    i++;
                    while (!input.hasNextInt())
                        {
                            System.out.println("This is not a number!");
                            input.next();
                        }
                    guess = input.nextInt();
                }
            if (guess != randomNumber && i == numberOfTry-1)
                {
                    System.out.println("Game Over! You didn't guess the number!");
                    break;
                }
            
        }
        
        }
    }
