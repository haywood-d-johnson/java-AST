/*
*    @author: Haywood D. Johnson
*    @groupID: com.lordorbnauticus
*    @artifactID: java-AST
*/

package com.javaAST;

import java.util.Scanner;

public class Main
{
	private static String input;

	static FileList filelist = new FileList();

	public static void main(String[] args) {

		// java.util; takes user input from command line
		Scanner scanner = new Scanner(System.in);

		do
		{
			// either ends on input or ":q!"
			System.out.print("Enter your $PATH or \":q!\" to complete: ");
			input = scanner.nextLine();

			System.out.println("You entered: " + input);
			System.out.println("-----------\n");

		} while (input == ":q!");


		if (":q!".equals(input)) {
			System.out.println("Exit!\n");
		}

		scanner.close();

		/*
		* FileList class instantiation to print found paths...
		* assigns paths to static array
		*/
		filelist.path(input);
	}
}
