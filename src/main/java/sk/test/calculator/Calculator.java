package sk.test.calculator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Calculator {
	private List<String> input = new ArrayList<>();
	double result;
	BufferedReader reader;

	public int readInput(String file) {
		try {
			String currentLine;
			reader = new BufferedReader(new FileReader(file));

			while ((currentLine = reader.readLine()) != null) {
				input.add(currentLine);
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
			return 0;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					System.out.println(e);
				}
			}
		}

		return this.countResult();
	}

	public int countResult() {
		result = Integer.parseInt(input.get(input.size() - 1).substring(6));
		String currentLine;

		for (int i = 0; i < input.size() - 1; i++) {
			currentLine = input.get(i);
			if (currentLine.contains("add")) {
				result += Double.parseDouble(currentLine.substring(4));
			} else if (currentLine.contains("multiply")) {
				result *= Double.parseDouble(currentLine.substring(9));
			} else if (currentLine.contains("divide")) {
				result /= Double.parseDouble(currentLine.substring(7));
			} else if (currentLine.contains("subtract")) {
				result -= Double.parseDouble(currentLine.substring(9));
			}
		}

		if (result == (int)result) {
			System.out.println((int)result);
		} else {
			System.out.println(result);
		}

		return (int)result;
	}

	public static void main(String[] args) throws Exception {
		if (args.length == 0) {
			System.out.println("You must specify the input file.");
		} else {
			Calculator calc = new Calculator();
			calc.readInput(args[0]);
		}
	}
}
