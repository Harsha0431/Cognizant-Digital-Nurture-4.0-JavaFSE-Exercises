package algorithms.exercise7;

public class FinancialForecast {

    public static double futureValue(double presentValue, double rate, int years) {
        if (years == 0) {  // Base case: no growth after 0 years
            return presentValue;
        }

        return (1 + rate) * futureValue(presentValue, rate, years - 1);
    }

    public static void main(String[] args) {
        double presentValue = 10000;
        double rate = 0.05;
        int years = 5;

        System.out.println("Present value: " + presentValue + "\nRate of growth annually: " + rate*100 + "%" + "\nYears: " + years);

        double futureVal = futureValue(presentValue, rate, years);
        System.out.printf("\nFuture Value after %d years: $%.2f\n", years, futureVal);
    }
}

