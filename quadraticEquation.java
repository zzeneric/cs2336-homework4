// Raghav Pillai, 7/11/21

import java.util.Scanner; // Scanner for import

public class quadraticEquation{
    private double a,b,c; // ABC double

    public quadraticEquation(double a,double b,double c){ // Constructor
        this.a = a;
        this.b = b;
        this.c = c;
    }

    // Accessors
    public double getA(){return a;}
    public double getB(){return b;}
    public double getC(){return c;}

    public double getDiscriminant(){ // Get discriminant
        return (b * b - 4.0 * a * c);
    }

    public double getRoot1(){ // Positive root
        return (-b + Math.pow(getDiscriminant(), 0.5)) / (2.0 * a);
    }

    public double getRoot2(){ // Negative root
        return (-b - Math.pow(getDiscriminant(), 0.5)) / (2.0 * a);
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in); // New scanner for input 
        double a,b,c; // Get A,B,C

        System.out.println("Enter three doubles as A, B and C: "); // Inputs
        a = scanner.nextDouble();
        b = scanner.nextDouble();
        c = scanner.nextDouble();

        scanner.close(); // Close scanner for memory leak

        quadraticEquation newObj = new quadraticEquation(a,b,c); // New obj
        double discriminant = newObj.getDiscriminant();

        if(discriminant > 0){ // If 2 roots 
            System.out.println("Roots are " + newObj.getRoot1() + " and " + newObj.getRoot2());
        }else if (discriminant == 0){ // If 1 root
            System.out.println("Root is " + newObj.getRoot1());
        }else{ // If no roots
            System.out.println("No roots");
        }
    }
}