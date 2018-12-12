import java.util.Scanner;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String args[]) {
        //Putting it all together:
        //1. Write a short introduction method that describes the calculator program and welcomes your user
        intro();

        //2. Ask the user to enter in an operation
        //3. As long as the user enters something that’s not "q" or "Q" when asked for an operation you should run the calculator
        String operation = new Main().getOperation();

        //4. Get two fractions from the user and then perform whichever operation they ask for
        Fraction fraction1 = new Main().getFraction();//have to make a new instance of the class to call a non-static
        Fraction fraction2 = new Main().getFraction();//method from a static method
/*
        if (operation.equals("+")) {
            Fraction result = new Fraction.add(fraction1, fraction2);
        } else if (operation.equals("-")) {
            Fraction result = new Fraction.subtract(fraction1, fraction2);
        } else if (operation.equals("*")) {
            Fraction result = new Fraction.multiply(fraction1, fraction2);
        } else if (operation.equals("/")) {
            Fraction result = new Fraction.divide(fraction1, fraction2);
        } else if (operation.equals("=")) {
            boolean result = new Fraction.equals(fraction1, fraction2);
        } else {
            System.exit(0);
        }
*/
        System.out.println("Print results of " + fraction1.toString() + " " + operation + " " + fraction2.toString());
        //System.out.println("Result = " + result);
        //5. Print the result of the operation
    }

    public static void intro() {
        System.out.println("This is a fraction calculator program.");
        System.out.println("It will do various tasks, until you type Q to quit.");
        System.out.println("It will add, subtract, multiply, and divide fractions.");
        System.out.println("Please enter your fractions in the form a/b, where a and b are integers.");
    }

    public String getOperation() {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter an operation (+, -, /, *, =, or Q to quit): ");
        String operation = input.nextLine();

        while (!operation.equals("+") && !operation.equals("-") && !operation.equals("/") && !operation.equals("*") &&
                !operation.equals("=") && !operation.equals("q") && !operation.equals("Q")) {
            System.out.print("Invalid input (+, -, /, *, =, or Q to quit): ");
            operation = input.next();
        }
        System.out.println(operation);

        if (operation == "q" || operation == "Q") {
            System.exit(0);
        }

        return operation;
    }

    public boolean isNumber(String string) {
        /*loop through characters of string to see if it is a number 0-9, returns false if not
        Hint 1: It may be useful to create a helper method isNumber() that takes a String as input and returns true
        if every character in the String is a
        number 0-9 and false otherwise. This method can also check forempty strings. Hint 2: Once you determine whether or not the Strings are
        numbers, you may find the Integer.parseInt() method helpful.*/
        boolean nvalue = true;
        for (int i = 1; i < string.length() + 1; i++) {
            String string2 = string.substring(i-1,i);
            if (string2.matches("[0-9]+")) {
                System.out.println(string2);
            } else {
                nvalue = false;
            }
        }

        return nvalue;
    }

    public boolean validFraction(String frac){
        /*has parameter String input, returns boolean, returns true if the parameter is in the form "a/b" where a is
        any int and b is any positive int

        Some things to be mindful of when implementing the validFraction() method:

        The first character may or may not be a "-" character. If a negative shows up anywhere else, then it is not a
        valid fraction. It may be helpful to remove the "-" character if there is one.*/
        boolean bvalue = false;

        String positiveFrac = "";

        if (frac.startsWith("-")) {
            positiveFrac = frac.substring(1, frac.length());
        } else if (!frac.startsWith("-") && frac.contains("-")) {
            bvalue = false;
        } else {
            positiveFrac = frac;
        }

        /*If there is no "/" character, then every character in the string must be a number (if you removed the "-" sign).
        If there is a "/" character, then it may be helpful to create substrings for the numerator and denominator.
        Both substrings must be non-empty.
        Both must be entirely made of numbers.
        The denominator cannot be "0".*/
        if (!positiveFrac.contains("/")) {
            if (isNumber(positiveFrac)){
                bvalue = true;
            } else if (!isNumber(positiveFrac)){
                bvalue = false;
            }
        } else if (positiveFrac.contains("/")){
            String[] numden = {};
            numden = positiveFrac.split("/");
            String numer = numden[0];
            String denom = numden[1];

            if (isNumber(numer) && isNumber(denom) && !denom.equals("0")){
                bvalue = true;
            } else {
                bvalue = false;
            }
        } else bvalue = false;

        return bvalue;
        /*Hint 1: It may be useful to create a helper method isNumber() that takes a String as input and returns true
        if every character in the String is a
        number 0-9 and false otherwise. This method can also check forempty strings. Hint 2: Once you determine whether or not the Strings are
        numbers, you may find the Integer.parseInt() method helpful.*/
    }

    public Fraction getFraction(){
        //has parameter Scanner input, returns Fraction, It prompts the user for a String that is a validFraction.
        //If they enter any thing that is not a valid Fraction, it should re-prompt them until it is valid
        Scanner input2 = new Scanner(System.in);
        int a = 0;//had to assign these before the IF statement and give a default value for it to work
        int b = 0;
        boolean single = false;
        boolean zero = false;
        boolean loop = false;
        while (!loop) {
            System.out.print("Please enter a fraction (a/b) or integer (a): ");
            String frac = input2.nextLine();
            System.out.println(frac);

            if (validFraction(frac)) {
                //break down frac into variables a & b
                String[] fracsplit = frac.split("/");//split on the /
                List<String> fraclist = Arrays.asList(fracsplit);//make array list from split

                a = Integer.parseInt(fraclist.get(0));//cast string at index 0 to integer

                try {
                    b = Integer.parseInt(fraclist.get(1));//cast string at index 1 to integer
                } catch (java.lang.ArrayIndexOutOfBoundsException e) {//if nothing at index 1 (single digit)
                    //b = 1; NEEDS TO BE HANDLED IN THE OBJECT CONSTRUCTOR PER PROJECT INSTRUCTIONS
                    if (a != 0) {
                        single = true;
                    } else {
                        zero = true;
                    }
                    System.out.println("Denominator of 1");
                }

                loop = true;

            } else if (!validFraction(frac)) {
                loop = false;
            }
        }
        if (single) {
            return new Fraction(a);
        } else if (zero) {
            return new Fraction();
        } else {
            return new Fraction(a, b);
        }
    }
}

