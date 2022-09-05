public class fraction
{
  private int numerator;
  private int denominator;
  private static int numFractions;

  // Default constructor: creates fraction 1/1
  public fraction(){
    numerator = 1;
    denominator = 1;
    numFractions++;
  }

  /* This constructor initially calls the default constructor to give the
   * fraction 1/1. Then this calls the mutator methods to set numerator and
   * denominator if the parameters are positive.
   */
  public fraction(int n, int d){
    this();
    setNumerator(n);
    setDenominator(d);
  }

  // Accessor methods for the class variables
  public int getNumerator(){
    return numerator;
  }

  public int getDenominator(){
    return denominator;
  }

  public static int getNumFractions(){
    return numFractions;
  }

  // Return the fraction as a String e.g. "2/3"
  public String toString(){
    return numerator + "/" + denominator;
  }

  // Return the fraction as a mixed number String
  public String mixedNumber(){
    // If fraction is proper return fraction using toString method
    if(numerator < denominator){
      return toString();
    }

    // If numerator is a multiple of denominator return just integer part
    if (numerator % denominator == 0){
      return "" + numerator/denominator;
    }

    /* Runs only if neither conditional section ran (both have return statements).
     * Calculates the integer part using numerator/denominator, and numerator of
     * the fraction part by finding the remainder using numerator%denominator.
     */
    return numerator/denominator + " " + numerator%denominator + "/" + denominator;
  }

  /* Mutator methods for the member variables change the values only if the parameters
   * are greater than 0.
   */
  public void setNumerator(int n){
    if(n > 0){
      numerator = n;
    }
  }

  public void setDenominator(int d){
    if(d > 0){
      denominator = d;
    }
  }

  // Adds the fraction n/d to this fraction if n and d are both greater than 0
  public void add(int n, int d){
    if(n > 0 && d > 0){
      numerator = numerator * d + n * denominator;
      denominator *= d;
    }
  }

  // Adds the fraction other to this fraction by calling the overloaded method
  public void add(fraction other){
    add(other.getNumerator(), other.getDenominator());
  }

  // Multiplies this fraction by the fraction n/d if n and d are both greater than 0
  public void multiply(int n, int d){
    if(n>0 && d>0){
      numerator *= n;
      denominator *= d;
    }
  }

  // Multiplies this fraction by the fraction other
  public void multiply(fraction other){
    multiply(other.getNumerator(), other.getDenominator());
  }

  //Extension - squares the fraction
  public void square(){
    multiply(this);
  }
}