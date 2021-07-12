// Raghav Pillai, 7/11/21

class MyDate{ // Date class
    int year, month, day; // Specific data
    
    public MyDate(int month, int day, int year){ // Set date to values
        this.month = month;
        this.day = day;
        this.year = year;
    }
}

class staff extends employee{ // staff -> employee -> person
    String title; // Specific data

    staff(String name){ // First constructor
        this(name, "none");
    }

    staff(String name, String title){ // Detailed constructor
        super(name);
        this.title = title;
    }
    
    public String toString() { // Overload function
        return "Class: " + this.getClass().getName() + ", Name: " + name;
    }
}

class faculty extends employee{ // faculty -> employee -> person
    String officeHours, rank;// Specific data

    faculty(String name){ // First constructor
        this(name, "2-3", "Employee");
    }

    faculty(String name, String officeHours, String rank){ // Detailed constructor
        super(name);
        this.officeHours = officeHours;
        this.rank = rank;
    }

    public String toString(){ // Overload function
        return "Class: " + this.getClass().getName() + ", Name: " + name;
    }
}

class employee extends person{ // employee -> person
    // Specific data
    double salary;
    String office;
    MyDate dateHired;

    employee(String name){ // First constructor
        this(name, 0, "none", new MyDate(4,10,2001));
    }

    employee(String name, double salary, String office, MyDate dateHired){ // Detailed constructor
        super(name);
        this.salary = salary;
        this.office = office;
        this.dateHired = dateHired;
    }

    public String toString(){ // Overload function
        return "Class: " + this.getClass().getName() + ", Name: " + name;
    }
}

class student extends person{ // student -> person
    String status; // Specific data

    student(String name){ // First constructor
        super(name);
    }

    student(String name, String status){ // Detailed constructor
        super(name);
        this.status = status;
    }

    public String toString(){ // Overload function
        return "Class: " + this.getClass().getName() + ", Name: " + name;
    }
}

public class person{
    String name, address, phoneNumber, email; // Specific data

    public person(String name){ // First constructor
        this.name = name;
    }

    public String toString(){ // Overload function
        return "Class: " + this.getClass().getName() + ", Name: " + name;
    }

    public static void main(String[] args){ // Main test
        staff testObj = new staff("Test");
        System.out.println(testObj.toString());
    }
}