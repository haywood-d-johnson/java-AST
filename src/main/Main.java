package com.javaAST;

public class Main {

	private static String input;

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		while (true) {

			System.out.print("Enter your $PATH: ");
			input = scanner.nextLine();

			if (":q!".equals(input)) {
				System.out.println("Exit!");
				break;
			}

			System.out.println("You entered: " + input);
			System.out.println("-----------\n");
		}

		scanner.close();

	}

}