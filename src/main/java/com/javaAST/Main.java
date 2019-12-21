package com.javaAST;

import java.util.Scanner;

public class Main
{
	private static String input;

	static FileList filelist = new FileList();

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		do
		{
			System.out.print("Enter your $PATH or \":q!\" to complete: ");
			input = scanner.nextLine();

			System.out.println("You entered: " + input);
			System.out.println("-----------\n");

		} while (input == ":q!");


		if (":q!".equals(input)) {
			System.out.println("Exit!\n");
		}

		scanner.close();

		filelist.path(input);
	}
}
