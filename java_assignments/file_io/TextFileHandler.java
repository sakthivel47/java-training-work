package problemtwoandthree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TextFileHandler {
	
	// main function
	public static void main(String[] args) {

		System.out.println("Reading countries and capitals from file");
		// static method calling
		readFromFile();

		System.out.println("Writing coutries and capitals that matches the given conditions");

		char startsWith = 0;
		
		// handling the exception
		try {
			// taking the arguments given as input to startWith variable
			startsWith = args[0].charAt(0);
		} catch(ArrayIndexOutOfBoundsException e) {  // handling exception if argument not given
			System.err.println("No arguments given as input\nArgument usage: <character>");
		}

		// storing the filename with extension that is to be created
		String newFileName = "countries_" + Character.toString(startsWith) + ".csv";

		// static method call with arguments as newFileName and startsWith variables
		writeToFile(newFileName, startsWith);

	}

	/*
	 * Function - readFromFile()
	 * Description - From the given csv file reading the countries and capitals
	 * and storing it in a map as key and values
	 * Output - Printing the countries and capitals from the map
	 */
	public static void readFromFile() {

		// creating a map object to store countries and capitals
		Map<String, String> countryMap = new HashMap<String, String>();		

		// handling exceptions
		try {
			// creating File obj and storing the filepath
			File file = new File("D:\\OutputFiles\\countries_and_capitals.csv");
			
			// creating FileReader obj 
			FileReader fr = new FileReader(file);

			// creating BufferedReader obj 
			BufferedReader br = new BufferedReader(fr);
			String line = "";

			// running loop till there is contents in it 
			while((line = br.readLine()) != null) {
				// splitting the line with delimiter (,) and storing it
				String[] country_capital = line.split(",");
				
				// storing the read content to map 
				countryMap.put(country_capital[0], country_capital[1]);
			}
			// closing the reader objects
			br.close();
			fr.close();

			System.out.println("Countries and Capitals");
			// iterating through map and printing the key and values
			for(Map.Entry<String, String> entry : countryMap.entrySet()) {
				System.out.println(entry.getKey() + " - " + entry.getValue()) ;
			}
			System.out.println("****************************************");
		} catch(FileNotFoundException e) { 
			System.out.println("File doesn't exists");
		}
		catch(IOException e) {
			System.out.println("IOException while reading the content");
		}

	}
	
	/*
	 * Function - writeToFile(String newFileName, char countryNameBeginingWith)
	 * Description - taking the countries that starts with given letter as input
	 * and writing it to a separate csv file
	 */
	public static void writeToFile(String newFileName, char countryNameBeginingWith) {
		FileWriter fw;
		// handling exceptions
		try {

			// storing filepath in string
			String filePath = "D:\\OutputFiles\\" + newFileName;
			
			// creating File obj
			File file = new File(filePath);

			// creating fileWriter obj by passing file obj and true (boolean append) 
			fw = new FileWriter(file, true);

			// creating bufferedWriter obj and with fileWriter obj
			BufferedWriter bw = new BufferedWriter(fw);

			// creating string array which contains countries and capitals as an example to work
			// considering that, this is read from a csv file
			String[] countries_capitals = {"Australia,Canberra","Brazil,Brasillia", "Canada,Ottawa","Serbia,Belgrade", "India,NewDelhi", "Sweden,Stockholm", "SaudiArabia,Riyadh"};

			boolean check = false;

			// iterating through all the String in the array
			for(String all : countries_capitals) {

				// splitting the array element with ',' as a delimiter
				String[] content = all.split(",");
				
				// checking whether country name starts with given letter
				if(content[0].charAt(0) == countryNameBeginingWith) {
					check = true;
					// writing the countries and capitals that matches given condition to csv file
					bw.append(content[0] + "," + content[1] + "\n");
				}
			}
			bw.close();

			// if no countries matched with given letter
			if(!check) {
				System.out.println("No contents to write");
			} 
			else {
				System.out.println("Contents written successfully");
			}
		} catch (FileNotFoundException e) {
			System.out.println("File doesn't exists");
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
