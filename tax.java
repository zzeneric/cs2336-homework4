// Raghav Pillai, 7/11/21

public class tax{
    // Tax data
    int filingStatus;
    int[][] brackets;
    double[] rates;
    double taxableIncome;

    // Classifications/enums
    static int SINGLE_FILER = 0;
    static int MARRIED_JOINTLY_OR_QUALIFYING_WIDOW= 1;
    static int MARRIED_SEPARATELY = 2;
    static int HEAD_OF_HOUSEHOLD = 3;

    // Accessors
    public int getFilingStatus(){return filingStatus;}
    public int[][] getBrackets(){return brackets;}
    public double[] getRates(){return rates;}
    public double getTaxableIncome(){return taxableIncome;}
    
    // Mutators
    public void setFilingStatus(int filingStatus){
        this.filingStatus = filingStatus;
    }
    public void setBrackets(int[][] brackets) {
        this.brackets = brackets;
    }
    public void setRates(double[] rates) {
        this.rates = rates;
    }
    public void setTaxableIncome(double taxableIncome) {
        this.taxableIncome = taxableIncome;
    }

    public double getTax(){
        if (taxableIncome <= brackets[filingStatus][0]){ // If below bottom bracket
            return Math.round(taxableIncome * rates[0]);
        }
        
        double tax = brackets[filingStatus][0] * rates[0];
        for (int i = 1; i < brackets[filingStatus].length; i++){ // Loop through brackets
            if (taxableIncome > brackets[filingStatus][i]){ // If higher than the bracket
                tax += (brackets[filingStatus][i] - brackets[filingStatus][i - 1]) * rates[i];
            }else{
                return Math.round(tax + (taxableIncome - brackets[filingStatus][i - 1]) * rates[i]);
            }
        }
        return Math.round(tax + (taxableIncome - brackets[filingStatus][4]) * rates[5]); // If highest bracket
    }

    public tax(){ // Default constructor
        this.filingStatus = 0;
        this.brackets = new int[][]{};
        this.rates = new double[]{};
        this.taxableIncome = 0;
    }

    public tax(int filingStatus, int[][] brackets, double[] rates, double taxableIncome){ // Overloaded constructor
        // Set all inputs to the values for object
        this.filingStatus = filingStatus;
        this.brackets = brackets;
        this.rates = rates;
        this.taxableIncome = taxableIncome;
    }

    public static void main(String[] args){
        // 2001 tax brackets
        int[][] brackets_2001 = {
            // Single
            {27050, 65550, 136750, 297350},
            // Married joint
            {45200, 109250, 166500, 297350},
            // Married sep
            {22600, 54625, 83250, 148675},
            // Head
            {36250, 93650, 151650, 297350}
        };

        // 2009 tax brackets
        int[][] brackets_2009 = {
            // Single
            {8350, 33950, 82250, 171550, 372950},
            // Married joint
            {16700, 67900, 137050, 208850, 372950},
            // Married sep
            {8350, 33950, 68525, 104425, 186475},
            // Head
            {11950, 45500, 117450, 190200, 372950}
        };

        // Get rates for years
        double[] rates_2001 = {0.15, 0.275, 0.305, 0.355, 0.391};
        double[] rates_2009 = {0.10, 0.15, 0.25, 0.28, 0.33, 0.35};

        System.out.println("2001"); // Year
        System.out.println("Taxable Income\t\tSingle\t\t\tMarried Joint\t\tMarried Separate\tHead of house"); // Headers

        for (int i = 50000; i <= 60000; i += 1000){ // 2001 loop through
            // Get taxes for each income
            tax single = new tax(SINGLE_FILER, brackets_2001,rates_2001, i);
            tax joint = new tax(MARRIED_JOINTLY_OR_QUALIFYING_WIDOW, brackets_2001, rates_2001, i);
            tax sep = new tax(MARRIED_SEPARATELY,brackets_2001, rates_2001, i);
            tax house = new tax(HEAD_OF_HOUSEHOLD,brackets_2001, rates_2001, i);

            System.out.println(i + "\t\t\t" + single.getTax() + "\t\t\t" + joint.getTax() + "\t\t\t" + sep.getTax() + "\t\t\t" + house.getTax());
        }

        System.out.println(""); // Blank line between sets

        System.out.println("2009"); // Year
        System.out.println("Taxable Income\t\tSingle\t\t\tMarried Joint\t\tMarried Separate\tHead of house"); // headers

        for (int i = 50000; i <= 60000; i += 1000){ // 2009 loop through
            // Get taxes for each income
            tax single = new tax(SINGLE_FILER, brackets_2009,rates_2009, i);
            tax joint = new tax(MARRIED_JOINTLY_OR_QUALIFYING_WIDOW, brackets_2009,rates_2009, i);
            tax sep = new tax(MARRIED_SEPARATELY, brackets_2009,rates_2009, i);
            tax house = new tax(HEAD_OF_HOUSEHOLD, brackets_2009,rates_2009, i);

            System.out.println(i + "\t\t\t" + single.getTax() + "\t\t\t" + joint.getTax() + "\t\t\t" + sep.getTax() + "\t\t\t" + house.getTax());
        }
    }
}
