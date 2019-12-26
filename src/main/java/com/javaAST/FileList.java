package com.javaAST;

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
	//static array to hold paths
	public static List<String> results = new ArrayList<String>();

	public static void path(String input)
	{
		try (Stream<Path> walk = walk(Paths.get(input))) {
			// maps to array if file is .java

			results = walk.map(i -> i.toString())
					.filter(i -> i.endsWith(".java")).collect(Collectors.toList());

			results.replaceAll(filename -> FilenameUtils.getBaseName(filename)+ "." + FilenameUtils.getExtension(filename));

			System.out.println("Here are the .java files in the directory/subdirectory(s):");
			System.out.println("-----------\n");
			results.forEach(System.out::println);

		// throws error if input is unmatched/no file
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
