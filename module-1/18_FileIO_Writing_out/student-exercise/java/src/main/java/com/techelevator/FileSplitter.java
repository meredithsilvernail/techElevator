package com.techelevator;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileSplitter {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.print("Where is the input file (please include the path to the file: [path-to-file]/input.txt)? ");
		String fileName = input.nextLine();

		System.out.print("How many lines of text (max) should there be in the split files?: ");
		int maxLines = Integer.parseInt(input.nextLine());

		List<String> linesList = new ArrayList<>();

		try(Scanner scanner = new Scanner(new File(fileName))){

			while(scanner.hasNext()){
				String line = scanner.nextLine();
				linesList.add(line);
			}

		} catch(IOException ex){
			System.out.println("Error: " + ex.getMessage());
		}

		System.out.println("The input file has " + linesList.size() + " lines of text.\n");
		System.out.println("Each file that is created should have a sequential number assigned to it. \n"
		);

		int totalFiles = (int) Math.ceil(linesList.size() / (double)maxLines);

		System.out.println("For a 50 line input file \"input.txt\", this produces " + totalFiles + " output files.\n");
		System.out.println("**GENERATING OUTPUT**\n");

		for(int currentFile = 1; currentFile <= totalFiles; currentFile++){
			String currentName = "input" + "-" + currentFile + ".txt";
			System.out.println(currentName);

			try(PrintWriter pw = new PrintWriter(new FileWriter(currentName))){
				for(int currentLine = 0; currentLine < maxLines; currentLine++){
					pw.println(linesList.get(currentLine));
				}

			}catch(IOException ex){
				System.out.println("Error: " + ex.getMessage());
			}
		}
	}
}
