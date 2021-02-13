/*
Name: Lusemar Oliveira
Class: COP2800 - Programming in Java 
Programming Assignment #4: Methods
Due date: 02/16/2021
A particular talent competition has five judges, each of whom awards a score between 0 and 10 to 
each performer. Fractional scores, such as 8.3, are allowed. A performer’s final score is determined 
by dropping the highest and the lowest score received, then averaging the three remaining scores. 
Write a program that uses these rules to calculate and display a contestant’s score.
 */
package oliveiramethods;

import java.util.Scanner; // This is a class in the Java API used to create a Scanner object.

public class oliveiraMethods {
    public static void main(String[] args) { // Here is the main method, it's where the program executes.
    // Variables declared and intialized.
        double[] scores= new double [5]; // This is array of doubles with size of 5 spaces reserved in the memory.
        int judgeNumber = 1; // Integer variable declared and incialized.
        for(int i = 0; i < 5; i++){ // This for loop that will iterate 5 times.
            scores[i] = oliveiraMethods.getJudgeData(judgeNumber); // Every time it iterates will send and receive information to the function and store into the array accordingly.
            judgeNumber++ ; // This variable will work as a counter to indicate each judge.
        }
    System.out.print("__________________________________________________\n\n"); // This is just to print a line to help to separate the content.
    System.out.printf("Contestant’s Final Average Score: %.1f\n",Math.round(oliveiraMethods.calcScore(scores)*10)/10.0); //This is a formatted output concatenated with a converted to double variable, rounding to the tenths decimal place the
    //return value from a called method and with it's following parameters. (No a specific precision to the left of the dot and one decimal digits to the right of the dot, as showing on the assignment).
    }

    public static double getJudgeData(int judgeNumber){ // This method will return the judge score after treated data, no letters, no negative numbers, no numbers greater than 10.
        // Variables declared and intialized.
        boolean correctionInput = true;
        String judjeScoreString = "";
        double judjeScore = 0;
                
        Scanner input = new Scanner(System.in); // This is the escanner function that we imported.
        while(correctionInput){ // This while will keep looping untill variable gets false.
            System.out.print("Please, Enter Judje " + judgeNumber + " Score:\n"); // This will print the message that the user will see.
            judjeScoreString = input.next(); // Storing the user input into a String variable.
                        
            if(judjeScoreString.matches("[a-zA-Z_]+.|\n")){ // This if will check if the variable matches any letter or character using Regex. 
                System.out.println("There is an Error, You Have Entered an Invalid Input! The Score must be a numeric between 0 - 10."); // This will print the message that the user will see.
                continue; // This continue statement breaks one iteration in the loop, if a specified condition occurs.
            }
            judjeScore = Double.parseDouble(judjeScoreString);// Converting the string variable to doulbe and storing into a variable.
            
            if(judjeScore > 10 || judjeScore < 0){ // This if will check if is higher than 100 or lower than zero.
                System.out.println("There is an Error, You Have Entered an Invalid Input! The Score must be between 0 - 10.");
                continue ;                
            }
        correctionInput = false; // This is where the variable gets a false value that breaking the while loop.
        }
    return judjeScore; //This is the treated data return.
    }
    public static double calcScore(double scores[]) { // This is a method that will calculate and return an average from the entered scores, removing the highest and lowest value.  
        double averageScore = 0;
        for (int i = 0; i < scores.length; i++)  // This for loop will iterate according with the array size.
            averageScore +=  scores[i]; // This will add the total score stored on at the array.
        
        return ((averageScore - oliveiraMethods.findHighest(scores)- oliveiraMethods.findLowest(scores))/3); // This will return an average from the total value minus the highest and lowest value
        // resulted from 2 other called methods.
    }
    public static double findLowest(double scores[]){ // This is a method that will calculate and return lowest value from the array.
        double lowestScore = 10;
        for (int i = 0; i < scores.length; i++) {
            if(scores[i] < lowestScore)
            lowestScore = scores[i];
        }
    return lowestScore; // This wll return lowest score from the array.
    }
    public static double findHighest(double scores[]){ // This is a method that will calculate and return the highest value from the array.
        double highestScore = 0;
        for (int i = 0; i < scores.length; i++) {
            if(scores[i] > highestScore)
            highestScore = scores[i];
        }
    return highestScore; // This wll return highest score from the array.
    }
}