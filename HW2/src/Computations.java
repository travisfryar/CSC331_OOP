
/**
 * Travis Fryar 
 * HW2 - CSC 331
 * 9/16/2020
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Computations {
	private String filename;
	private String[] fullLines;
	private int fileSize;
	private float mean;
	private float variance;
	private float stddv;

	public Computations(String filename) {
		this.filename = filename;
		this.fileSize = 0;
	}

	public void setFileSize() throws FileNotFoundException {
		Scanner scanFile = new Scanner(new File(filename));
		while (scanFile.hasNextLine()) {
			scanFile.nextLine();
			this.fileSize++;
		}
		scanFile.close();
	}

	private boolean initializeArray() {
		if (this.fileSize != 0) {
			this.fullLines = new String[this.fileSize];
			return true;
		}
		return false;
	}

	public void storeValues(String line, int index) {
		this.fullLines[index] = line;
	}

	public void computeMean(String line) {
		float total = 0;
		int count = 0;
		Scanner scanLine = new Scanner(line);
		scanLine.next();
		while (scanLine.hasNextInt()) {
			total += scanLine.nextInt();
			count++;
		}
		scanLine.close();
		mean = total / count;
	}

	public void computeVariance(String line) {
		float total = 0;
		int count = 0;
		int num = 0;
		Scanner scanLine = new Scanner(line);
		scanLine.next();
		while (scanLine.hasNextInt()) {
			num = scanLine.nextInt();
			total += (mean - num) * (mean - num);
			count++;
		}
		scanLine.close();
		variance = total / count;
	}

	public void computeSD() {
		stddv = (float) Math.sqrt(variance);
	}

	public void processFile() throws FileNotFoundException {
		this.setFileSize();
		boolean fileReady = this.initializeArray();
		if (fileReady) {
			Scanner scanFile = new Scanner(new File(filename));
			int index = 0;
			while (scanFile.hasNextLine()) {
				String line = scanFile.nextLine();
				this.storeValues(line, index);
				this.computeMean(line);
				this.computeVariance(line);
				this.computeSD();
				System.out.printf(line + ", Mean: %.2f" + ", Variance: %.2f" + ", SD: %.2f\n", mean, variance, stddv);
				index++;
			}
			scanFile.close();
		} else {
			System.out.println("File not found!");
		}
	}
}
