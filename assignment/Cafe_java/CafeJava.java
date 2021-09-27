public class CafeJava {
    public static void main(String[] args) {
        // APP VARIABLES
        String drink1 ="drip coffee";
        String drink2 ="latte";
        String drink3 ="cappuccino";
        // Lines of text that will appear in the app. 
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = "Your total is $";
        
        // Menu variables (add yours below)
        double drink1Price = 4.5;
        double drink2Price = 3.5;
        double drink3Price = 5.25;
    
        // Customer name variables (add yours below)
        String customer1 = "Cindhuri";
        String customer2 = "Sam";
        String customer3 = "Jimmy";
        String customer4 = "Noah";
    
        // Order completions (add yours below)
        boolean isReadyOrder1 = false;
        boolean isReadyOrder2 = true;

        // APP INTERACTION SIMULATION (Add your code for the challenges below)

        System.out.println(generalGreeting + customer1 + drink1 + isReadyOrder1); 
        System.out.println(generalGreeting + customer4 + drink1 + isReadyOrder2); 
        System.out.println(generalGreeting + customer2 + drink1 + isReadyOrder1); 

        // Example:
        System.out.println(generalGreeting + customer1); // Displays "Welcome to Cafe Java, Cindhuri"
    	// ** Your customer interaction print statements will go here ** //
    }
}
