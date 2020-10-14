/**
 * Travis Fryar
 * CSC 331 - HW1 
 * 8/21/2020
 */

public class JavaFundamentals {

	public JavaFundamentals()
	{}

	public void assignOperators (int num1, int num2) {
		System.out.printf("Demonstrating '+='%n");//Addition
		System.out.printf("num1 = " + num1 + "%n");
		System.out.printf("num2 = " + num2 + "%n");
		System.out.printf("num1 += num2" + "%n");
		num1 += num2;
		System.out.printf("new num1 value = " + num1 + "%n");
		System.out.printf("-----------%n");
		System.out.printf("Demonstrating '-='%n");//Subtraction
		System.out.printf("num1 = " + num1 + "%n");
		System.out.printf("num2 = " + num2 + "%n");
		System.out.printf("num1 -= num2" + "%n");
		num1 -= num2;
		System.out.printf("new num1 value = " + num1 + "%n");
		System.out.printf("-----------%n");
		System.out.printf("Demonstrating '*='%n");//Multiplication
		System.out.printf("num1 = " + num1 + "%n");
		System.out.printf("num2 = " + num2 + "%n");
		System.out.printf("num1 *= num2" + "%n");
		num1 *= num2;
		System.out.printf("new num1 value = " + num1 + "%n");
		System.out.printf("-----------%n");
		System.out.printf("Demonstrating '/='%n");//Division
		System.out.printf("num1 = " + num1 + "%n");
		System.out.printf("num2 = " + num2 + "%n");
		System.out.printf("num1 /= num2" + "%n");
		num1 /= num2;
		System.out.printf("new num1 value = " + num1 + "%n");
		System.out.printf("-----------%n");
		System.out.printf("Demonstrating modulus%n");//Mod
		System.out.printf("num1 = " + num1 + "%n");
		System.out.printf("num2 = " + num2 + "%n");
		System.out.printf("num1 mod num2" + "%n");
		num1 %= num2;
		System.out.printf("new num1 value = " + num1 + "%n");
		}

	public void incdecOperators (int num1) {
		System.out.printf("Demonstrating ++, --%n");
		System.out.printf("num1 = " + num1 + "%n");
		System.out.printf("num1++, num1 is incremented after print, num1: " + num1++ +"%n");
		System.out.printf("num1 = " + num1 + "%n");
		System.out.printf("++num1, num1 is incremented before print, num1: " + ++num1 +"%n");
		System.out.printf("num1 = " + num1 + "%n");
		System.out.printf("-----------%n");
		System.out.printf("num1 = " + num1 + "%n");
		System.out.printf("num1--, num1 is decremented after print, num1: " + num1-- +"%n");
		System.out.printf("num1 = " + num1 + "%n");
		System.out.printf("++num1, num1 is decremented before print, num1: " + --num1 +"%n");
		System.out.printf("num1 = " + num1 + "%n");
	}
	
	public void logicalOperators () {
		int x;
		System.out.printf("Demonstrating logical operators%n");
		x=10;
		System.out.printf("x=10%n");
		System.out.printf("(AND) if x is greater than 15 AND less than 100, print true else false%n");
		System.out.println(x > 15 && x < 100);
		System.out.printf("(OR) if x is greater than 15 OR less than 100, print true else false%n");
		System.out.println(x > 15 || x < 100);
		System.out.printf("(NOT AND) if x is greater than 15 AND less than 100, print true else false%n");
		System.out.println(!(x > 15 && x < 100));

	}
	
	public void whilesumIntegers () {
		int sum=1, curr=1;
		while (curr < 101) {
			System.out.println("Current integer: " + curr + ", Current sum: " + sum);
			curr++;
			sum = sum + curr;
		}
	}
	
	public void dowhilesumIntegers () {
		int sum=1, curr=1;
		do {
			System.out.println("Current integer: " + curr + ", Current sum: " + sum);
			curr++;
			sum = sum + curr;
		} while (curr < 101);
	}
	
	public void forsumIntegers () {
		int sum = 0;
		for (int curr = 1; curr < 101; curr++) {
			sum = sum + curr;
			System.out.println("Current integer: " + curr + ", Current sum: " + sum);
		}
		
	}
	
	
	
	
	
	
	
	
	
	}


