// Raghav Pillai, 7/10/21

public class stock{
    String symbol, name; // Symbol and name string
    double previousClosingPrice, currentPrice; // Previous closing price and current price
    
    public stock(String newSymbol, String newName){ // Default constructor 
        symbol = newSymbol;
        name = newName;
    }

    public double getChangePercent(){ // Get change in price percentage from previous and current (returns double)
        return ((currentPrice - previousClosingPrice) / previousClosingPrice);
    }

    public static void main(String[] args){ // Test
        stock testObj = new stock("ORCL", "Oracle Corporation");
        testObj.previousClosingPrice = 34.5;
        testObj.currentPrice = 34.35;

        System.out.println("Changed Percent: " + (testObj.getChangePercent() * 100) + "%");
    }
}