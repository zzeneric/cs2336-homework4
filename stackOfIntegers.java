// Raghav Pillai, 7/11/21

import java.util.ArrayList;

public class stackOfIntegers{
    ArrayList<Integer> numbers = new ArrayList<Integer>(); // Arraylist to append integers to

    public static Boolean isPrime(int num){ // Returns true if prime, input of integer to test
        for(int i = 2; i <= num/2; i++){
		    if(num % i == 0){
                return false;
            }     
		}
		return true;
    }

    public stackOfIntegers(){ // Constructor
        for(int i = 1; i < 120; i++){ // Get every number to 120
            if (isPrime(i)){
                numbers.add(i); // If it's prime, then add to arraylist
            }
        }
    }

    public Integer[] getNumbers(){ // Returns a table of the prime numbers
        Integer arr[] = new Integer[numbers.size()]; // Construct new int array
        arr = numbers.toArray(arr); // Convert array list to array
        return arr;
    }

    public static void main(String[] args){
        stackOfIntegers newObj = new stackOfIntegers(); // Construct new object
        Integer[] numbers = newObj.getNumbers(); // Get all numbers, put into an int array

        for(int i = 0; i < numbers.length; i++){ // Loop through all numbers in array
            System.out.println(numbers[i]); // Output numbers
        }

    }
}