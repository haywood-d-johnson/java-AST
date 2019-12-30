/*
*    @author: Haywood D. Johnson
*    @groupID: com.lordorbnauticus
*    @artifactID: java-AST
*/

package com.javaAST;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main
{
	public static void main(String[] args) throws IOException
	{

		String input;

		// java.util; takes user input from command line
		Scanner scanner = new Scanner(System.in);
		FileList fileList = new FileList();
		ASTParse ast = new ASTParse();

		do
		{
			// either ends on input or "q"
			System.out.print("Enter your $PATH or \"q\" to complete: ");

			input = scanner.nextLine();
			/*TODO: Error Handling for input*/
			if ("q".equals(input)) {
				System.out.println("Exit!\n");
				break;
			}

			System.out.println("You entered: " + input);

			/*
			 * FileList class instantiation to print found paths...
			 * assigns paths to static array
			 */
			if (!"q".equals(input)) {
				FileList.path(input.trim());
				break;
			}

		} while (!input.equals("q"));

		scanner.close();

		List<String> res = fileList.getResults();

		ASTParse.parse(res);
	}
}
