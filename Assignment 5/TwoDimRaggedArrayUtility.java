package assignment5;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class TwoDimRaggedArrayUtility {

	// Returns the average of the elements in the two dimensional array
	public static double getAverage(double[][] data) {
		double sum = 0.0;
		int count = 0;

		for(int row = 0; row < data.length; row++) {
			for(int col = 0; col < data[row].length; col++) {
				sum += data[row][col];
				count++;
			}
		}
		return sum / count;
	}

	// Returns the total of the selected column in the two dimensional array
	public static double getColumnTotal(double[][] data, int col) {
		double total = 0.0;

		for(int row = 0; row < data.length; row++) {
			if(col < data[row].length) {
				total += data[row][col];
			}
		}
		return total;
	}

	// Returns the largest element in the two dimensional array
	public static double getHighestInArray(double[][] data) {
		double max = data[0][0];
		for(int row = 0; row < data.length; row++) {
			for(int col = 0; col < data[row].length; col++) {
				if(data[row][col] > max) {
					max = data[row][col];
				}
			}
		}
		return max;
	}

	// Returns the largest element of the selected column
	public static double getHighestInColumn(double[][] data, int col) {
		double max = Double.NEGATIVE_INFINITY;

		for(int row = 0; row < data.length; row++) {
			if(col < data[row].length) {
				if(data[row][col] > max) {
					max = data[row][col];
				}
			}
		}
		return max;
	}

	// Returns index of the largest element of the selected column
	public static int getHighestInColumnIndex(double[][] data, int col) {
		double max = Double.NEGATIVE_INFINITY;
		int highestRow = -1;

		for(int row = 0; row < data.length; row++) {
			if(col < data[row].length) {
				if(data[row][col] > max) {
					max = data[row][col];
					highestRow = row;
				}
			}
		}
		return highestRow;
	}

	// Returns the largest element of the selected row
	public static double getHighestInRow(double[][] data, int row) {
		double max = data[row][0];

		for(int col = 0; col < data[row].length; col++) {
			if(data[row][col] > max) {
				max = data[row][col];
			}
		}
		return max;
	}

	// Returns index of the largest element of the selected row
	public static int getHighestInRowIndex(double[][] data, int row) {
		double max = data[row][0];
		int highestCol = 0;

		for(int col = 0; col < data[row].length; col++) {
			if(data[row][col] > max) {
				max = data[row][col];
				highestCol = col;
			}
		}
		return highestCol;
	}

	// Returns the smallest element in the two dimensional array
	public static double getLowestInArray(double[][] data) {
		double min = data[0][0];

		for(int row = 0; row < data.length; row++) {
			for(int col = 0; col < data[row].length; col++) {
				if(data[row][col] < min) {
					min = data[row][col];
				}
			}
		}
		return min;
	}

	// Returns the smallest element of the selected column
	public static double getLowestInColumn(double[][] data, int col) {
		double min = Double.POSITIVE_INFINITY;

		for(int row = 0; row < data.length; row++) {
			if(col < data[row].length) {
				if(data[row][col] < min) {
					min = data[row][col];
				}
			}
		}
		return min;
	}

	// Returns index of smallest element of the selected column
	public static int getLowestInColumnIndex(double[][] data, int col) {
		double min = Double.POSITIVE_INFINITY;
		int lowestRow = -1;

		for(int row = 0; row < data.length; row++) {
			if(col < data[row].length) {
				if(data[row][col] < min) {
					min = data[row][col];
					lowestRow = row;
				}
			}
		}
		return lowestRow;
	}

	// Returns the smallest element of the selected row
	public static double getLowestInRow(double[][] data, int row) {
		double min = data[row][0];

		for(int col = 0; col < data[row].length; col++) {
			if(data[row][col] < min) {
				min = data[row][col];
			}
		}
		return min;
	}

	// Returns index of smallest element of the selected row
	public static int getLowestInRowIndex(double[][] data, int row) {
		double min = data[row][0];
		int lowestCol = 0;

		for(int col = 0; col < data[row].length; col++) {
			if(data[row][col] < min) {
				min = data[row][col];
				lowestCol = col;
			}
		}
		return lowestCol;
	}

	// Returns the total of the selected row
	public static double getRowTotal(double[][] data, int row) {
		double total = 0.0;

		for(int col = 0; col < data[row].length; col++) {
			total += data[row][col];
		}
		return total;
	}

	// Returns the total of all elements
	public static double getTotal(double[][] data) {
		double total = 0.0;

		for(int row = 0; row < data.length; row++) {
			for(int col = 0; col < data[row].length; col++) {
				total += data[row][col];
			}
		}
		return total;
	}

	// Reads file into 2D ragged array of doubles
	public static double[][] readFile(File file) throws FileNotFoundException {
		Scanner input = new Scanner(file);
		ArrayList<double[]> rows = new ArrayList<double[]>();

		while(input.hasNextLine()) {
			String line = input.nextLine().trim();

			if(line.length() != 0) {
				String[] parts = line.split(" ");
				double[] row = new double[parts.length];

				for(int i = 0; i < parts.length; i++) {
					row[i] = Double.parseDouble(parts[i]);
				}
				rows.add(row);
			}
		}
		input.close();

		double[][] data = new double[rows.size()][];
		for(int i = 0; i < rows.size(); i++) {
			data[i] = rows.get(i);
		}

		return data;
	}

	// Writes ragged array to file
	public static void writeToFile(double[][] data, File file) throws FileNotFoundException {
		PrintWriter out = new PrintWriter(file);

		for(int row = 0; row < data.length; row++) {
			for(int col = 0; col < data[row].length; col++) {
				out.print(data[row][col]);
				if(col < data[row].length - 1) {
					out.print(" ");
				}
			}
			out.println();
		}

		out.close();
	}
}
