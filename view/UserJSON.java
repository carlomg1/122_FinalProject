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
//	JSONObject json;
	JSONObject json = new JSONObject();  
	JSONArray jsonArray;
	JSONParser parser = new JSONParser();
	Object object;
	
	boolean  fileExists = false;
//	private static String FILE_NAME = "userFile.json";
	private static String FILE_NAME = "C:\\Users\\Carlos_PC\\eclipse-workspace\\122_LocalChanges\\src\\userFile.json";
	
	UserJSON(){}
	
	public void checkFile(String user1, String user2) {
		try {
			BufferedReader fileReader = new BufferedReader(new FileReader(FILE_NAME));     
			if (fileReader.readLine() == null) {
			    System.out.println("File empty");
//			    json = new JSONObject();  
			    loadToJSON(user1, user2);
			    writeToFile();
			}else{
				fileExists = true;
				loadToJSON(user1, user2);
				writeToFile();
//				read the json object from the file and call the load to json method.
			}
		}
		catch(Exception e){
			
		}
	}
	
	// try-with-resources statement based on post comment below :)

	public void loadToJSON(String user1, String user2) throws FileNotFoundException, IOException, ParseException {
		// check if the names are already in the JSON file, if not write to it.
		// if it already exists, do the checking. 

		if(fileExists == true) { // if an entered user exists, do not add them to the profiles
			Object object = parser.parse(new FileReader(FILE_NAME));
			json = (JSONObject) object;
			jsonArray  = (JSONArray) json.get("profiles");
			
			ArrayList<String> usersToAdd = new ArrayList<String>();
			usersToAdd.add(user1);
			usersToAdd.add(user2);
			
			int i = 0;
			for(Object user: jsonArray) {
				HashMap<String, HashMap<String, Integer>> userDict = (HashMap<String, HashMap<String, Integer>>) jsonArray.get(i);
				for(String key: userDict.keySet()) {
					if(user1.equals(key)) {
						usersToAdd.remove(user1);
//						System.out.println("yepp1");
					}else if(user2.equals(key)) {
						usersToAdd.remove(user1);
//						System.out.println("yepp2");
					}
				}
				i++;
			}
			System.out.println(usersToAdd);
			for(String user: usersToAdd) {
				HashMap<String, HashMap<String, Integer>> userDict = new HashMap<String, HashMap<String, Integer>>();
				
				HashMap<String, Integer> scoreDict = new HashMap<String, Integer>();
				scoreDict.put("checkers", 0);
				scoreDict.put("memory", 0);
				scoreDict.put("ttt", 0);
				scoreDict.put("othello", 0);
				userDict.put(user, scoreDict);
				
				jsonArray.add(userDict);
			}
		}else { // in the case that there is no Json File nor contents within it. 
			jsonArray = new JSONArray(); 
			
			// user1
			HashMap<String, HashMap<String, Integer>> userDict1 = new HashMap<String, HashMap<String, Integer>>();

			HashMap<String, Integer> scoreDict1 = new HashMap<String, Integer>();
			scoreDict1.put("checkers", 0);
			scoreDict1.put("memory", 0);
			scoreDict1.put("ttt", 0);
			scoreDict1.put("othello", 0);
			userDict1.put(user1, scoreDict1);
			
			jsonArray.add(userDict1);
			
			// user2
			HashMap<String, HashMap<String, Integer>> userDict2 = new HashMap<String, HashMap<String, Integer>>();
			
			HashMap<String, Integer> scoreDict2 = new HashMap<String, Integer>();
			scoreDict2.put("checkers", 0);
			scoreDict2.put("memory", 0);
			scoreDict2.put("ttt", 0);
			scoreDict2.put("othello", 0);
			userDict2.put(user2, scoreDict2);
			
			jsonArray.add(userDict2);
			
			json.put("profiles", jsonArray);
		}
	}
	
	public void writeToFile(){
		// check if the names are already in the JSON file, if not write to it. 
		// Make sure this does not overwrite the exisiting file & JSON
		System.out.println("IN WRITE");
		try (FileWriter file = new FileWriter(FILE_NAME)) {
			file.write(json.toJSONString());
			file.flush();
			System.out.println("Successfully Copied JSON Object to File...");
			System.out.println("\nJSON Object: " + json);
		}catch(Exception e) {
			// blah blah blah whatever
		}

	}
	
	public void incrementScore(String user) {
		System.out.println(jsonArray);
	}
	
	public ArrayList<ArrayList<String>> jsonToArray() {
		System.out.println("In JsonToArray");
		ArrayList<ArrayList<String>> profiles = new ArrayList<ArrayList<String>>();
		
		int i = 0;
		
		for(Object user: jsonArray) {
			HashMap<String, HashMap<String, Integer>> userDict = (HashMap<String, HashMap<String, Integer>>) jsonArray.get(i);
			ArrayList<String> inner = new ArrayList<String>();
			for(String key: userDict.keySet()) {
				inner.add(key);
				HashMap<String, Integer> innerDict = (HashMap<String, Integer>) userDict.get(key);
				for(String game: innerDict.keySet()) {
					inner.add(String.valueOf(innerDict.get(game)));
				}
			}
			profiles.add(inner);
			i++;
		}
		System.out.println(profiles);
		return profiles;
		// grabs the json and reformats it into a 2d array for Tim to render
	}

}
