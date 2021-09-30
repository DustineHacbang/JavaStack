import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class CafeUtilTest {
	    // TO-DO:
	    // Create an instance of the CafeUtil class        
	    // in order to use the CafeUtil class' methods.
    
	    // Hint: it will need to correspond with the variable name
	    // used in your test code.
    
	    // Given Test Cases Here
    

    public static void main(String[] args) {  
    //Code of Java for loop
    CafeUtil newCafe = new CafeUtil();
    System.out.println(newCafe.DayStreak10());

    String[] menu1 = {
            "drip coffee -- $1.50",
            "cappucino -- $3.50",
            "latte -- $4.50",
            "mocha -- $3.50"
        };

    double[] menu1prices = {
            3.5,
            3.5,
            4.0,
            4.5
        };

        System.out.printf(
            "Order total: %s \n", newCafe.getOrderTotal(menu1prices)
            );

        System.out.println("----- Price Chart Test-----");
    newCafe.printPriceChart("Chai Latte Mix", 4.5, 3);
    newCafe.printPriceChart("Specialty Coaster", 2.0, 5);
    
}  
}
