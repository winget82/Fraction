public class Fraction {

    //FIELDS - two private instance variables to hold the numerator and denominator as ints
    private int numerator;
    private int denominator;

    /*CONSTRUCTOR - OVERLOADING for zero parameter constructor that initializes the object to 0, meaning the numerator is 0 and the denominator is 1
    example: Fraction myFrac = new Fraction(); would create a fraction who's decimal value is 0*/
    public Fraction() {
        this.numerator = 0;
        this.denominator = 1;
    }

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
        /*thows an IllegalArgumentException if the denominator is 0
        If the user enters a negative denominator bump the negative sign to the numerator. For example, -3/-2 should be
        converted to 3/2. Likewise, 5/-3 should be converted to -5/3*/
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero.");
        } else if (denominator < 0) {
            this.denominator = -denominator;
            this.numerator = -numerator;
        } else {
            this.denominator = denominator;
        }
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
        double dbl = (double) numerator / (double) denominator;
        return dbl;
    }


    public Fraction add(Fraction other){
        //has parameters Fraction other, returns Fraction, returns a new Fraction that is the sum of other and this fraction
        //Common denominator will be multiple of greatest common divisor
        Fraction Added = null;
        int lcm = 0;
        if (this.denominator == other.denominator) {
            Added = new Fraction(this.numerator + other.numerator, this.denominator);
        } else {//get Least Common Multiple (AKA Least Common Denominator)
            lcm = lcm(this.denominator, other.denominator);
            Added = new Fraction(((lcm/this.denominator) * this.numerator) + ((lcm/other.denominator) * other.numerator), lcm);
        }

        return Added;
    }

    public Fraction subtract(Fraction other){
        //has parameters Fraction other, returns Fraction, returns a new Fractions that is the difference between
        // the other and this fraction
        Fraction Subtracted = null;
        int lcm = 0;
        if (this.denominator == other.denominator) {
            Subtracted = new Fraction(this.numerator - other.numerator, this.denominator);
        } else {//get Least Common Multiple (AKA Least Common Denominator)
            lcm = lcm(this.denominator, other.denominator);
            Subtracted = new Fraction(((lcm/this.denominator) * this.numerator) - ((lcm/other.denominator) * other.numerator), lcm);
        }

        return Subtracted;
    }

    public Fraction multiply(Fraction other) {
        //has parameters Fraction other, returns Fraction, returns a new Fraction that is the product of the other and this fraction
        //MULTIPLY NUMERATORS, THEN MULTIPLY DENOMINATORS
        this.numerator *= other.numerator;
        this.denominator *= other.denominator;
        return new Fraction(this.numerator, this.denominator);
    }

    public Fraction divide(Fraction other) {
        //has parameters Fraction other, returns Fraction, returns a new Fraction that is the division of the other and this fraction,
        //throw an IllegalArgumentException() if the user asks you to divide by 0
        //FLIP SECOND (DIVIDING) FRACTION, THEN MULTIPLY ACROSS (NUM * NUM) / (DEN * DEN)
        this.numerator *= other.denominator;
        this.denominator *= other.numerator;
        return new Fraction(this.numerator, this.denominator);
    }

    public boolean equals(Object other){
        /*has parameters Object other, returns boolean, must take in an "Object" to properly override the Object class's equals method,
        but should ultimately check if two fractions are equal
        Override the Object equals() method so that it accurately determines whether or not two fractions are equal. In order to have it override, it has to
        take an Object as a parameter. Your method should check whether or not the parameter is an instanceof Fraction, since if it is not a Fraction it
        cannot be equal. Don’t forget to cast the parameter to a Fraction after you check if it is an Object of type*/
        boolean equal = false;
        Fraction otherX = null;

        if (other instanceof Fraction) {
            otherX = (Fraction) other;
            this.toLowestTerms();
            otherX.toLowestTerms();
            if (otherX.numerator == this.numerator && otherX.denominator == this.denominator) {
                equal = true;
            }

        } else {
            equal = false;
        }

        return equal;

    }

    public void toLowestTerms(){
        //has no parameters, returns void, converts fraction to the lowest terms uses gcd() Euclidean Algorithm
        //while a and b are not zero
            //find the remainder of a divided by b
            //set a to b
            //set b to the remainder you found
        //return a
        int gcd = gcd(numerator, denominator);
        numerator = numerator/gcd;
        denominator = denominator/gcd;

    }

    public static int gcd(int num, int den){
        /*has parameters int num(erator) int den(emoninator), returns int, takes in two ints and determines the greatest common DIVISOR
        (NOT DENOMINATOR) of the two ints, should be a static method*/
        if (den == 0) {
            return num;
        } else {
            return gcd(den,num%den);//uses recursion
        }
        //same as ?: is a conditional
        //public int GCD(int a, int b) { return b==0 ? a : GCD(b, a%b);}
    }

    public int lcm(int a, int b) {
        //this method gets least common multiple / least common denominator
        int lcm = (a * b)/gcd(a,b);
        return lcm;
    }
}