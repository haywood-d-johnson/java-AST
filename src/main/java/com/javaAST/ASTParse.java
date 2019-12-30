package com.javaAST;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FilenameUtils;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;

public class ASTParse
{
	public static FileList fileList = new FileList();
	public static ASTParser parser = ASTParser.newParser(AST.JLS13);

	public static void parse(List<String> results) throws IOException
	{
		for (String result : results)
		{
			//Create output file
			String addExtension = result + ".ast";
			System.out.println("Creating File: " + addExtension);
			File output = new File(addExtension);
			output.createNewFile();
			FileWriter fw = new FileWriter(output);

			//Begin ASTParser
			parser.setSource(result.toCharArray());
			parser.setKind(ASTParser.K_COMPILATION_UNIT);

			final CompilationUnit cu = (CompilationUnit) parser.createAST(null);

			cu.accept(new ASTVisitor() {

				Set<String> names = new HashSet<>();

				public boolean visit(VariableDeclarationFragment node) {
					SimpleName name = node.getName();
					this.names.add(name.getIdentifier());
					try
					{
						fw.write("Declaration of '" + name + "' at line" + cu.getLineNumber(name.getStartPosition()) + "\n");
					} catch (IOException e)
					{
						e.printStackTrace();
					}
					return false; // do not continue to avoid usage info
				}

				public boolean visit(SimpleName node) {
					if (this.names.contains(node.getIdentifier())) {
						try
						{
							fw.write("Usage of '" + node + "' at line " + cu.getLineNumber(node.getStartPosition()) + "\n");
						} catch (IOException e)
						{
							e.printStackTrace();
						}
					}
					return true;
				}
			});
		}
	}
}
