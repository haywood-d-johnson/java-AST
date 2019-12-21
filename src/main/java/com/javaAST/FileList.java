package com.javaAST;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.nio.file.Files.walk;

public class FileList
{
	public static List<String> results = new ArrayList<String>();

	public static void path(String input)
	{
		try (Stream<Path> walk = walk(Paths.get(input))) {

			results = walk.map(x -> x.toString())
					.filter(f -> f.endsWith(".java")).collect(Collectors.toList());

			System.out.println("Here are the .java files in the directory:");
			System.out.println("-----------\n");
			results.forEach(System.out::println);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
