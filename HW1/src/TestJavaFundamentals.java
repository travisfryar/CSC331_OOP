/**
 * Travis Fryar
 * CSC 331 - HW1 
 * 8/21/2020
 */
import java.util.Scanner;
public class TestJavaFundamentals {
	public static void main(String[] args) {
		int num1=0, num2=0, option;

		JavaFundamentals obj1;
		obj1 = new JavaFundamentals();
		
		do {
			Scanner keyboard;
			keyboard = new Scanner(System.in);
			System.out.println("What would you like to see?");
			System.out.println("[1] Assignment operators");
			System.out.println("[2] Increment/decrement operators");
			System.out.println("[3] Logical operators");
			System.out.println("[4] While loop sum of first 100 integers");
			System.out.println("[5] Do While loop sum of first 100 integers");
			System.out.println("[6] For loop sum of first 100 integers");
			System.out.println("[7] Exit");
			option = keyboard.nextInt();

			
			if (option == 1) {
				System.out.println("Enter a number: ");
				num1 = keyboard.nextInt();
				System.out.println("Enter another number: ");
				num2 = keyboard.nextInt();
			}
	
			switch (option) {
			case 1 : 
				obj1.assignOperators(num1, num2);
				System.out.printf("-----------%n");
				break;
			case 2: 
				obj1.incdecOperators(num1);
				System.out.printf("-----------%n");
				break;
			case 3: 
				obj1.logicalOperators();
				System.out.printf("-----------%n");
				break;
			case 4: 	
				obj1.whilesumIntegers();
				System.out.printf("-----------%n");
				break;
			case 5: 	
				obj1.dowhilesumIntegers();
				System.out.printf("-----------%n");
				break;
			case 6: 	
				obj1.forsumIntegers();
				System.out.printf("-----------%n");
				break;
			case 7:
				keyboard.close();
				System.exit(0);
			}

		} while (option != 7);
					
		}
	}


