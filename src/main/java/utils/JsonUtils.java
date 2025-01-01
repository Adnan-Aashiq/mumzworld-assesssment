package utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class JsonUtils {

	// Generic method to retrieve a value by key from the JSON file

	/*
	 * { "keyword": "Feeder", "product":
	 * "Dr. Brown's - Fresh Firsts Silicone Feeder - Grey", "quantity": 5 }
	 * 
	 * 
	 * String productName = JsonUtils.getValueFromJson("keyword"); // Retrieve
	 * product keyword
	 * 
	 */
	public static String getValueFromJson(String key) {
		JSONParser jsonParser = new JSONParser();
		String value = null;

		try (FileReader reader = new FileReader("src/test/resources/testdata.json")) {
			// Parse the JSON file
			JSONObject obj = (JSONObject) jsonParser.parse(reader);
			value = obj.get(key).toString(); // Get value for the specified key

		} catch (Exception e) {
			e.printStackTrace();
		}

		return value;
	}

	// Overloaded method for nested structures (if needed)
	/*
	 * { "productDetails": { "keyword": "Feeder", "productName":
	 * "Dr. Brown's - Fresh Firsts Silicone Feeder - Grey", "quantity": 5 },
	 * "userDetails": { "name": "Adnan Aashiq", "email": "adnan@example.com" } }
	 * 
	 * / Retrieve nested product keyword from JSON String productName =
	 * JsonUtils.getNestedValueFromJson("productDetails", "keyword");
	 *
	 *
	 */
	public static String getNestedValueFromJson(String outerKey, String innerKey) {
		JSONParser jsonParser = new JSONParser();
		String value = null;

		try (FileReader reader = new FileReader("src/test/resources/testdata.json")) {
			// Parse the JSON file
			JSONObject obj = (JSONObject) jsonParser.parse(reader);
			JSONObject nestedObj = (JSONObject) obj.get(outerKey);
			value = nestedObj.get(innerKey).toString(); // Get value for the specified inner key

		} catch (Exception e) {
			e.printStackTrace();
		}

		return value;
	}
}
