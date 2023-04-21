package main;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadJson {
//	global vars
	static String roomFName, roomSPrice, roomIconImg, roomDesc, roomHeroIcon, roomOtherImageInfo, dummyheroIcon;
	static long roomPrice;
	
    public static void fetchData(String roomData) {
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("filepath")) {
            Object obj = jsonParser.parse(reader);
            JSONArray roomList = (JSONArray) obj;

            for (int i = 0; i < roomList.size(); i++) {
                JSONObject room = (JSONObject) roomList.get(i);
                String roomName = (String) room.get("room");
                
                if (roomName.equals(roomData)) {
                    JSONArray features = (JSONArray) room.get("feature");
                    JSONObject images = (JSONObject) room.get("images");
                    
                    roomFName = (String) room.get("roomName");
                    roomPrice = (long) room.get("price");
                    roomSPrice = (String) room.get("priceS");
                    roomIconImg = (String) images.get("smallImageIcon");
                    roomHeroIcon = (String) images.get("heroIcon");
                    roomOtherImageInfo = (String) images.get("otherImageInfo");
                    dummyheroIcon = (String) images.get("dummyheroIcon");
                    roomDesc = (String) room.get("desc");
                    
//                  loop for features
                    for (int j = 0; j < features.size(); j++) {
                        String feature = (String) features.get(j);
                    }
                }
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}

