
/**
 * Travis Fryar 
 * HW2 - CSC 331
 * 9/16/2020
 */

import java.io.FileNotFoundException;

public class TestComputations {
	public static void main(String[] args) {
		String filename = "CoursesData.txt";
		Computations program = new Computations(filename);
		try {
			program.processFile();

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		}
	}// *End of main
}// *End of class
