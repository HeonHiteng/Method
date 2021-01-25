import java.util.*;
import javax.swing.JOptionPane;

public class method {

	//Method get Shipping price
	
	public static double getShippingPrice (double normalShipping , double discount) {
		return normalShipping * (1-discount);
	}
	
	//Display Shipping fees
	 
	public static void displayShipping(double actualShipping, double normalShipping) { 
		System.out.printf("Your final shipping fee is RM%.2f. %n(Normal shipping fee is RM%.2f).%n%n", actualShipping, normalShipping);   
	}
	
	//Method display total price message
	
	public static void displayMessage() {
		System.out.println("Thanks for your oder. Total price including shipping:");
	}
	
	//Method display enterOrder
	
	public static void enterOrder() {
		System.out.println("============= ENTER ORDER =============");
	}
	
	
	//Method read quantity of shirt
	
	public static int readQuantity1() {
		Scanner scan = new Scanner(System.in);
		System.out.println ("Number of t-shirts to purchase? You can only buy up to 4 t-shirts: ");
		int numOfShirts = scan.nextInt();
		return numOfShirts;
	   }
	
	//Method read quantity of trousure
	
	public static int readQuantity2() {
		Scanner scan = new Scanner(System.in);
		System.out.println ("Number of trousers to purchase? Again, max. 4 items: ");
		int numOfTrousers = scan.nextInt();
		return numOfTrousers;
	   }
	
	//Display quantity
	
	public static void printOutput(int numOfShirts, int numOfTrousers) {
		System.out.println ("You have ordered " + numOfShirts + " t-shirts and " + numOfTrousers + " trousers.");
		}
	
	
	//Calculated price of Tshirt
	
	public static double calcPrice(double numOfShirts) {
		double priceShirt =  10.00 * numOfShirts;
		return priceShirt;
	   }

	//Calculated price of Trouser
	
	public static double calcPrice2(double numOfTrousers) {
		double priceTrouser =  20.00 * numOfTrousers;
		return priceTrouser;
	   }
	
	//Display total price
	 
	public static void displayTotal(double priceShirt, double priceTrouser, double actualShipping) {
	    double priceTotal = priceShirt + priceTrouser + actualShipping ;
	    System.out.printf("RM%.2f. Please come again!!!", (priceTotal));
	   
	}
	
	public static void main(String[] args) {
		
		String pc = JOptionPane.showInputDialog(null, "Please enter your postcode to check whether \nyour suburb qualifies for super shipping discount:)", "DELIVERY CHARGE", JOptionPane.QUESTION_MESSAGE);
				
				int numOfShirts = 0;
				int numOfTrousers = 0;
				int postcode = Integer.parseInt(pc);
				double discount = 0.05;
				double normalShipping = 19.55;
				double actualShipping;
				
				String msg;
				String repeatingMsg = "Congratulations!\nYou qualify for the super special shipping fee discount of ";
				switch (postcode) {
				
				case 43650:
				   msg = "You are from Bangi! " + repeatingMsg;
				   actualShipping = getShippingPrice(10.00,0.7500);
				   break;
				case 43000:
				   msg = "You are from Kajang! " + repeatingMsg;
				   actualShipping = getShippingPrice(15.00,0.8500);
				   break;
				case 43400:
				   msg = "You are from Serdang! " + repeatingMsg;
				   actualShipping = getShippingPrice(25.00,1.00);
				   break;
				default:
				   msg = "Your suburb does not qualify for any shipping fee discount.\nWe however still offer a shipping discount of";
				   actualShipping = normalShipping*(1-discount);
				   break;
				}
				
				System.out.printf("%s %.2f%%.%n", msg, discount*100);
				displayShipping(actualShipping, normalShipping);
				enterOrder();
				int done = 0;
				while (done==0) {
					 numOfShirts =  readQuantity1();
				     numOfTrousers = readQuantity2();
				   if ((numOfShirts <= 4) && (numOfShirts >= 0) && (numOfTrousers <= 4) && (numOfTrousers >= 0)) {
				      done = 1;
				      printOutput(numOfShirts, numOfTrousers);
				      displayMessage();
				      double priceShirt = calcPrice(numOfShirts);
				      double priceTrouser = calcPrice2(numOfTrousers);
				      displayTotal(priceShirt,  priceTrouser, actualShipping);
				}
				   else
				      System.out.println("At most 4... and of course, plz enter a positive number...");
				}
	}
}
				
				
			

	   

           
