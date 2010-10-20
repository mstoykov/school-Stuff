package Files;

import java.io.*;
import java.util.*;

public class FilesOfNumbers2 {

	public static void createFileOfRandomIntegers(String outputFileName)
			throws IOException {

		PrintStream printstream;
		printstream = new PrintStream(outputFileName);
		int numberOfIntegers = (int) (Math.random() * 100) % 10 + 1;
		printstream.println(numberOfIntegers);
		for (int i = 0; i < numberOfIntegers; i++)
			printstream.println((int) (Math.random() * 1000) % 100 + 1);
		printstream.close();
	}

	public static void createFileOfSquaresAndSqrs(String inputFileName,
			String outputFileName) throws IOException {

		FileInputStream inputStream;
		inputStream = new FileInputStream(inputFileName);

		PrintStream outputStream;
		outputStream = new PrintStream(outputFileName);

		Scanner s = new Scanner(inputStream);
		int n = s.nextInt();
		outputStream.println("The number of integers: " + n);

		for (int i = 0; i < n; i++) {
			int number = s.nextInt();
			outputStream.println("number = " + number);
			outputStream.println("sqrt(" + number + ")="
					+ Math.sqrt(number));
			outputStream.println("square(" + number + ")=" + number
					* number);
		}

		s.close();
		inputStream.close();
		outputStream.close();
	}

	public static void createFileFromTwoFiles(String inputFileName1,
			String inputFileName2, String outputFileName) throws IOException {
		/*
		 * Won't work with multithreads as there is the posibility someone will
		 * try to write to the screen or two different executions of this
		 * function.
		 */

		PrintStream oldSystemOut = System.out;
		PrintStream ps = new PrintStream(outputFileName);
		System.setOut(ps);
		copyFileToTheStandardOutput(inputFileName1);
		copyFileToTheStandardOutput(inputFileName2);
		System.setOut(oldSystemOut);
		ps.close();
	}

	public static void copyFileToTheStandardOutput(String inputFileName)
			throws IOException {
		FileInputStream fis = new FileInputStream(inputFileName);
		int c;
		while ((c = fis.read()) != -1) {
			System.out.write(c);// won't work with big files as something
			// can write on the screen in the middle of the reading
		}
		fis.close();
	}

	public static void main(String[] args) throws IOException {

		String s = File.separator;

		String usrDir = System.getProperty("user.dir");
		System.out.println("usrDir: " + usrDir);

		System.out.println("Method createFileOfRandomIntegers works!");
		createFileOfRandomIntegers(usrDir + s + "randomIntegers.txt");

		System.out.println("Method createFileOfSquaresAndSqrs works!");
		createFileOfSquaresAndSqrs(usrDir + s + "randomIntegers.txt", usrDir
				+ s + "randomDoubles.txt");

		System.out.println("Method createFileOfSquaresAndSqrs works!");
		createFileOfSquaresAndSqrs(usrDir + s + "myIntegers.txt", usrDir + s
				+ "myDoubles.txt");

		System.out.println("Method createFileFromTwoFiles works!");
		createFileFromTwoFiles(usrDir + s + "randomIntegers.txt", usrDir + s
				+ "myIntegers.txt", usrDir + s + "integers.txt");

		System.out
				.println("Method copyFileToTheStandardOutput works!");
		copyFileToTheStandardOutput(usrDir + s + "integers.txt");
	}
}
/*
 * public static void main(String[] args)throws IOException{
 * createFileOfRandomIntegers("randomIntegers.txt");
 * createFileOfSquaresAndSqrs("randomIntegers.txt","randomDoubles.txt");
 * createFileOfSquaresAndSqrs("myIntegers.txt","myDoubles.txt");
 * createFileFromTwoFiles("randomIntegers.txt","myIntegers.txt","integers.txt");
 * copyFileToTheStandardOutput("integers.txt"); }
 */