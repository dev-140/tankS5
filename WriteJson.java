package main;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.*;

public class WriteJson {
	@SuppressWarnings("unchecked")
	public static void setData(String name, String order, String desc, String img) {
		// Set the path to the JSON file
        String filePath = "filepath";

        // Read the existing JSON data from the file
        JSONArray finalData = readJsonData(filePath);

        // Add a new object to the JSON array
        JSONObject newData = new JSONObject();
        newData.put("Room name", name);
        newData.put("Room price", order);
        newData.put("Room description", desc);
        newData.put("Room img", img);
        finalData.add(newData);

        // Write the updated JSON data back to the file
        writeJsonData(filePath, finalData);
    }

    private static JSONArray readJsonData(String filePath) {
        JSONParser parser = new JSONParser();
        JSONArray data = new JSONArray();

        try {
            FileReader fileReader = new FileReader(filePath);
            data = (JSONArray) parser.parse(fileReader);
            fileReader.close();
        } catch (IOException | ParseException e) {
            // File does not exist or cannot be parsed
        }

        return data;
    }

    private static void writeJsonData(String filePath, JSONArray data) {
        try {
            FileWriter fileWriter = new FileWriter(filePath);
            fileWriter.write(data.toJSONString());
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            // File cannot be written to
        }
	}
}