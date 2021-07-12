// Raghav Pillai, 7/10/21

public class rectangle{
    double width, height; // Construct width and height

    public rectangle(){ // Default constructor
        width = 1;
        height = 1;
    }

    public rectangle(double newWidth, double newHeight){ // Modified constructor, input width and height
        width = newWidth;
        height = newHeight;
    }

    public double getArea(){ // Return area
        return width * height;
    }

    public double getPerimeter(){ // Return perimeter
        return ((width*2) + (height*2));
    }

    public static void main(String[] args){ // Testing the class
        rectangle newObj = new rectangle(4,40); // First rectangle
        rectangle newObj2 = new rectangle(3.5, 35.9); // Second rectangle
        System.out.println("Rectangle 1 (Width: " + newObj.width + ", Height: " + newObj.height + ")");
        System.out.println("Area: " + newObj.getArea());
        System.out.println("Perimeter: " + newObj.getPerimeter());

        System.out.println(""); // New line

        System.out.println("Rectangle 2 (Width: " + newObj2.width + ", Height: " + newObj2.height + ")");
        System.out.println("Area: " + newObj2.getArea());
        System.out.println("Perimeter: " + newObj2.getPerimeter());
    }
}