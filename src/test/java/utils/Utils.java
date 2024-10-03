package utils;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Utils {
    public static void setEvnVar(String key,String value) throws ConfigurationException {
        //to store config file
        PropertiesConfiguration config=new PropertiesConfiguration("./src/test/resources/config.properties");
        config.setProperty(key,value);
        config.save();

    }

    public static int generateRandomId(int min,int max){
        double random=  Math.random()*(max-min)+min;
        int randId=(int)random;
        return randId;
    }


    //for customer 1
    public static void addJsonList(String createdUserName, String createdUserPassword, String createdUserPhone, String createdUserEmail, String createdUserNid, String createdUserRole) throws IOException, ParseException {

        String fileName = "./src/test/resources/info.json";
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader(fileName));
        JSONArray jsonArray = (JSONArray) obj;
        JSONObject userInfo = new JSONObject();

        userInfo.put("createdUserName", createdUserName);
        userInfo.put("createdUserPassword", createdUserPassword);
        userInfo.put("createdUserPhone", createdUserPhone);
        userInfo.put("createdUserEmail", createdUserEmail);
        userInfo.put("createdUserNid", createdUserNid);
        userInfo.put("createdUserRole", createdUserRole);

        jsonArray.add(userInfo);

        FileWriter file = new FileWriter(fileName);
        file.write(jsonArray.toJSONString());
        file.flush();
        file.close();
    }

    //for customer 2
    public static void addJsonList2(String createdUser2Name, String createdUser2Password, String createdUser2Phone, String createdUser2Email, String createdUser2Nid, String createdUser2Role) throws IOException, ParseException {

        String fileName = "./src/test/resources/info.json";
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader(fileName));
        JSONArray jsonArray = (JSONArray) obj;
        JSONObject userInfo = new JSONObject();

        userInfo.put("createdUser2Name", createdUser2Name);
        userInfo.put("createdUser2Password", createdUser2Password);
        userInfo.put("createdUser2Phone", createdUser2Phone);
        userInfo.put("createdUser2Email", createdUser2Email);
        userInfo.put("createdUser2Nid", createdUser2Nid);
        userInfo.put("createdUser2Role", createdUser2Role);

        jsonArray.add(userInfo);

        FileWriter file = new FileWriter(fileName);
        file.write(jsonArray.toJSONString());
        file.flush();
        file.close();
    }

    //for agent
    public static void addAgent(String createdAgentName, String createdAgentPassword, String createdAgentPhone, String createdUAgentEmail, String createdAgentNid, String createdAgentRole) throws IOException, ParseException {

        String fileName = "./src/test/resources/info.json";
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader(fileName));
        JSONArray jsonArray = (JSONArray) obj;
        JSONObject userInfo = new JSONObject();

        userInfo.put("createdAgentName", createdAgentName);
        userInfo.put("createdAgentPassword", createdAgentPassword);
        userInfo.put("createdAgentPhone", createdAgentPhone);
        userInfo.put("createdAgentEmail", createdUAgentEmail);
        userInfo.put("createdAgentNid", createdAgentNid);
        userInfo.put("createdAgentRole", createdAgentRole);

        jsonArray.add(userInfo);

        FileWriter file = new FileWriter(fileName);
        file.write(jsonArray.toJSONString());
        file.flush();
        file.close();
    }

    //read json file
    public static JSONObject readJSONFile(String filename, int index) throws IOException, ParseException {

        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader(filename));
        JSONArray jsonArray = (JSONArray) obj;
        int arraySize = jsonArray.size();
        int arrayIn = arraySize - index;

        JSONObject arrayObject = (JSONObject) jsonArray.get(arrayIn);

        return arrayObject;
    }
}

