<h1 align="center">Java-AST</h1>
<p align="center">Abstract Syntax Tree for Java Files in a given directory</p>

## Table Of Contents
  * [Description](#description)
  * [Scope Of Work](#scope-of-work)
  * [Getting Started](#getting-started)

## Description

This application will search a user requested directory for source-code files. This, the Java version of the application, will search for .java files. For each file, the application will generate an Abstract Syntax Tree (AST) and store it in a file with the same name as the source-code file but with the extension `.ast` (e.g., Person.java → Person.java.ast) and located in the same folder. 

## Scope Of Work

Stepping through the project, 4 fairly simple tasks are required:

- [X] Accepting User Input
- [X] Searching the given path for `.java` files
- [ ] Create output files to store AST wit the same name (trimming function)
- [ ] Write AST to output files

## Getting Started

- As usual, either copy the git and clone to you preferred directory, or download the .zip file.
- I've created bash scripts to make running this project easy. From the root directory (same level as `pom.xml`):
  
  ````
   $ cd bin
  ````
   To package the .jar file, run:
   ````
   $ bash package.sh
   ````
   To view the contents of the .jar (optional):
   ````
   $ bash view.sh
   ````
   To run the .jar file, run
   ````
   $ bash run.sh
   ````