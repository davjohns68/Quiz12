/*
 * Write a public static method toBinaryString that accepts an integer parameter n 
 * and returns a String representation of a single integer argument as an unsigned integer in base 2. 
 * Your solution must be recursive, and do not use Integer Class anyplace in your code 
 * (because you could just return Integer.toBinaryString(n) which Oracle already wrote).  
 * Assume a value of n between 0 to MAX_INT.
 * Created by David Johnson, October 18, 2017
 * for CS211 course, Bellevue College
 */
package quiz12;

public class Quiz12 {

    public static void main(String[] args) {
        System.out.println(Quiz12.toBinaryString(43));  // "101011"
        System.out.println(Quiz12.toBinaryString(8));  // "1000"
        System.out.println(Quiz12.toBinaryString(0));  // "0"
        System.out.println(toBinaryString(32767));


    }
    
    // The public method that returns what we want
    public static String toBinaryString(int n) {
        // Using a StringBuilder for ease of reversal (String gets built backwards)
        StringBuilder binary = new StringBuilder();
        String toReturn = toBinaryString(n, binary).reverse().toString();
        
        // Pull off the leading 0 if there is one
        if(toReturn.charAt(0) == '0' && toReturn.length() > 1) {
            toReturn = toReturn.substring(1);
        }
        return toReturn;
    }
    
    // The recursive helper method
    private static StringBuilder toBinaryString(int n, StringBuilder binary) {
        // Base case
        if(n == 0) {
            return binary.append(0);
        // Recursive case
        } else {
            // n mod 2 will be either 0 or 1
            binary.append(n % 2);
            // Recurse with n bit-shifted one place (divided by 2)
            return toBinaryString(n >> 1, binary);
        }
    }
    
}
