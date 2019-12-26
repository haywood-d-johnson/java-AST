/*
*    @author: Haywood D. Johnson
*    @groupID: com.lordorbnauticus
*    @artifactID: java-AST
*/

package com.javaAST;

import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {

		String input;

		// java.util; takes user input from command line
		Scanner scanner = new Scanner(System.in);

		do
		{
			// either ends on input or ":q!"
			System.out.print("Enter your $PATH or \"q\" to complete: ");

			input = scanner.nextLine();

			if ("q".equals(input)) {
				System.out.println("Exit!\n");
				break;
			}

			System.out.println("You entered: " + input);
			System.out.println("-----------\n");

			/*
			 * FileList class instantiation to print found paths...
			 * assigns paths to static array
			 */
			if (!"q".equals(input)) {
				FileList.path(input.trim());
				System.out.println(" ");
				System.out.println("Creating and overwriting AST files...");
				break;
			}

		} while (!input.equals("q"));

		scanner.close();

	}
}
