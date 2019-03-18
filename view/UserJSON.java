package view;

import java.util.*;

import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.sun.javafx.scene.paint.GradientUtils.Parser;

public class UserJSON {
	JSONObject json;
	JSONParser parser = new JSONParser();
	boolean  fileExists = false;
	private static String FILE_NAME = "C:\\Users\\Carlos_PC\\eclipse-workspace\\122_LocalChanges\\src\\userFile.txt";
	
	UserJSON(){}
	
	public void checkFile(String user1, String user2) {
		try {
			BufferedReader fileReader = new BufferedReader(new FileReader(FILE_NAME));     
			if (fileReader.readLine() == null) {
			    System.out.println("File empty");
			    json = new JSONObject();  
			    loadToJSON(user1, user2);
			    writeToFile();
			}else{
				fileExists = true;
				Object object = parser.parse(new FileReader(FILE_NAME));
				json = (JSONObject) object;
//				Iterator<String> iter = json.keySet();
				System.out.println(json);
//				read the json object from the file and call the load to json method.
			}
		}
		catch(Exception e){
			
		}
	}
	
	// try-with-resources statement based on post comment below :)

	public void loadToJSON(String user1, String user2) {
		// check if the names are already in the JSON file, if not write to it.
		// if it already exists, do the checking. 
		System.out.println("IN LOAD");
		json.put(user1, new HashMap<String,Integer>());
		json.put(user2, new HashMap<String,Integer>());
		
		System.out.println("LOAD END");
	}
	
	public void writeToFile(){
		// check if the names are already in the JSON file, if not write to it. 
		// Make sure this does not overwrite the exisiting file & JSON
		System.out.println("IN WRITE");
		try (FileWriter file = new FileWriter(FILE_NAME)) {
			file.write(json.toJSONString());
			System.out.println("Successfully Copied JSON Object to File...");
			System.out.println("\nJSON Object: " + json);
		}catch(Exception e) {
			// blah blah blah whatever
		}

	}

}
