public class Fraction {

    //FIELDS - two private instance variables to hold the numerator and denominator as ints
    private int numerator;
    private int denominator;

    /*CONSTRUCTOR - OVERLOADING for zero parameter constructor that initializes the object to 0, meaning the numerator is 0 and the denominator is 1
    example: Fraction myFrac = new Fraction(); would create a fraction who's decimal value is 0*/



    /*CONSTRUCTOR - OVERLOADING for single digits to convert to have denominator of 1
    one parameter constructor that initializes the object equal in value to the integer parameter.
    example: Fraction myFrac = new Fraction(3) would create a Fraction with numerator equal to 3 and denominator equal to 1.*/
    public Fraction(int numerator) {
        this.numerator = numerator;
        this.denominator = 1;
    }
    /*CONSTRUCTOR - a two parameter constructor that initializes the numerator and denominator as ints
    example: Fraction myFrac = new Fraction(4,5); creates a fraction who's numerator is 4 and denominator is 5*/
    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        //thows an IllegalArgumentException if the denominator is 0
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero.");
        } else {
            this.denominator = denominator;
        }



        /*If the user enters a negative denominator bump the negative sign to the numerator. For example, -3/-2 should be
        converted to 3/2. Likewise, 5/-3 should be converted to -5/3 HOW DO YOU GET A NEGATIVE AT THIS POINT IF IT IS AN INVALID FRACTION???  THE OBJECT NEVER GETS MADE*/


        //You should eliminate as much redundancy as possible by letting your constructors rely on one another using the "this" keyword.
    }

    //BEHAVIORS
    public int getNumerator() {
        //exposes the value of the numerator field to the user
        return numerator;
    }

    public int getDenominator() {
        //exposes the value of the denominator field to the user
        return denominator;
    }

    public String toString() {
        //no parameters, returns a String, "numerator/denominator", a String representation of the Fraction
        return numerator + "/" + denominator;
    }

    public double toDouble() {
        //no parameters, returns a double, the result of numerator/denominator
        double dbl = numerator / denominator;
        return dbl;
    }
}
/*
    public Fraction add(Fraction other){
        //has parameters Fraction other, returns Fraction, returns a new Fraction that is the sum of other and this fraction

    }

    public Fraction subtract(Fraction other){
        //has parameters Fraction other, returns Fraction, returns a new Fractions that is the difference between the other and this fraction

    }

    public Fraction multiply(Fraction other){
        //has parameters Fraction other, returns Fraction, returns a new Fraction that is the product of the other and this fraction

    }

    public Fraction divide(Fraction other){
        //has parameters Fraction other, returns Fraction, returns a new Fraction that is the division of the other and this fraction,
        //throw an IllegalArgumentException() if the user asks you to divide by 0

    }

    public boolean equals(Object other){
        //has parameters Object other, returns boolean, must take in an "Object" to properly override the Object class's equals method,
        //but should ultimately check if two fractions are equal

    }

    public void toLowestTerms(){
        //has no parameters, returns void, converts fraction to the lowest terms
        //while a and b are not zero
            //find the remainder of a divided by b
            //set a to b
            //set b to the remainder you found
        //return a

    }

    public int gcd(int num, int den){
        //has parameters int num int den, returns int, takes in two ints and determines the greatest common divisor of
        //the two ints, should be a static method

    }

}
*/