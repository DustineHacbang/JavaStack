import java.util.ArrayList;
// sum from 1-10
public class CafeUtil {  

    // sum from 1-10
    public int DayStreak10(){
        int sum = 0;
        for(int days = 1;days <= 10;days++){  
            sum += days;
    }  
    return sum;
    }

    public void printPriceChart(String menuItem, double itemPrice, int quantity){
        System.out.println(menuItem);
        double total;
        for(int i = 1; i <= quantity + 1 ; i ++){
            total = i * itemPrice;
        System.out.println(i + "--" + total);
        }

        
        
        
    }



    public double getOrderTotal(double priceArray[]) {
        // return total price of the given array
        double totalPrice = 0.0;
        for (int i = 0; i < priceArray.length; i++){
            totalPrice += priceArray[i];
        }
        return totalPrice;
    }

        public void displayMenu(String nameArray[]) {
        for (int i = 0; i < nameArray.length; i++){
            System.out.println(nameArray[i]);
        }
    }

    }
