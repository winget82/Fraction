import java.util.Scanner;

public class Main {

    public static void main(String args[]) {
        //Putting it all together:
        //1. Write a short introduction method that describes the calculator program and welcomes your user
        intro();
        //2. Ask the user to enter in an operation
        getOperation();
        //3. As long as the user enters something that’s not "q" or "Q" when asked for an operation you should run the calculator

        //4. Get two fractions from the user and then perform whichever operation they ask for

        //5. Print the result of the operation

    }

    public static void intro() {
        System.out.println("This is a fraction calculator program.");
        System.out.println("It will do various tasks, until you type Q to quit.");
        System.out.println("It will add, subtract, multiply, and divide fractions.");
        System.out.println("Please enter your fractions in the form a/b, where a and b are integers.");
    }

    public static String getOperation() {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter an operation (+, -, /, *, =, or Q to quit): ");
        String operation = input.nextLine();

        while (!operation.equals("+") && !operation.equals("-") && !operation.equals("/") && !operation.equals("*") &&
                !operation.equals("=") && !operation.equals("q") && !operation.equals("Q")) {
            System.out.print("Invalid input (+, -, /, *, =, or Q to quit): ");
            operation = input.next();
        }
        System.out.println(operation);
        return operation;
    }
}
/*
    public boolean validFraction(String input){
        //has parameter String input, returns boolean, returns true if the parameter is in the form "a/b" where a is
        //any int and b is any positive int
        //Some things to be mindful of when implementing the validFraction() method:
        //The first character may or may not be a "-" character. If a negative shows up anywhere else, then it is not a
        //valid fraction. It may be helpful to
        //remove the "-" character if there is one. COULD USE INDEX[0] TO HANDLE THIS
        //If there is no "/" character, then every character in the string must be a number (if you removed the "-" sign). COULD USE A FOR LOOP ITERATING OVER EACH CHARACTER TO HANDLE THIS
        //If there is a "/" character, then it may be helpful to create substrings for the numerator and denominator.
        //Both substrings must be non-empty.
        //Both must be entirely made of numbers.
        //The denominator cannot be "0".
        //Hint 1: It may be useful to create a helper method isNumber() that takes a String as input and returns true
        //if every character in the String is a
        //number 0-9 and false otherwise. This method can also check for

    }

    public Fraction getFraction(Scanner input){
        //has parameter Scanner input, returns Fraction, It prompts the user for a String that is a validFraction.
        //If they enter any thing that is not a valid Fraction, it should re-prompt them until it is valid

    }
}
*/
