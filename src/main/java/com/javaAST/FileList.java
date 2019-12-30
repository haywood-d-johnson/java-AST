package com.javaAST;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.commons.io.FilenameUtils;

import static java.nio.file.Files.walk;

public class FileList
{
	public static ASTParse parser = new ASTParse();
	//static array to hold paths
	public static List<String> results = new ArrayList<String>();

	public static List<String> path(String input)
	{
		try (Stream<Path> walk = walk(Paths.get(input))) {
			// maps to array if file is .java
			results = walk.map(Path::toString)
					.filter(i -> i.endsWith(".java")).collect(Collectors.toList());

			List<String> printResults = new ArrayList<String>(results);

			printResults.replaceAll(filename -> FilenameUtils.getBaseName(filename)+ "." + FilenameUtils.getExtension(filename));

			System.out.println("\n");
			System.out.println("Here are the .java files in the directory/subdirectory(s):");
			System.out.println("-----------");
			printResults.forEach(System.out::println);
			System.out.println("\n");
			System.out.println("Creating and overwriting AST files...");
			System.out.println("-----------");

			return results;

			// throws error if input is unmatched/no file
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static List<String> getResults()
	{
		return results;
	}
}
