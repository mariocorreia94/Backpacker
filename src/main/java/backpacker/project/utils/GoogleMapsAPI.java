package backpacker.project.utils;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GoogleMapsAPI {

    private String inputOrigin;
    private String inputDestiny;

    public GoogleMapsAPI(String inputOrigin, String inputDestiny) {
        this.inputOrigin = inputOrigin;
        this.inputDestiny = inputDestiny;
    }

    public int calculateDistance() {

        JSONObject jsonObject = null;
        String line;
        String outputString = "";

        try {
            URL url = new URL("https://maps.googleapis.com/maps/api/distancematrix/json?origins=" +
                    concatPlaceName(inputOrigin) + "&destinations=" + concatPlaceName(inputDestiny) + "&mode=walking");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            while ((line = reader.readLine()) != null) {
                outputString += line;
            }

            jsonObject = new JSONObject(outputString);

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Para mais tarde poder dar indicação se foi origem ou destino que falharam google maps
        if ((jsonObject.getJSONArray("origin_addresses")).toString().equals("[\"\"]")) {
            return -1;
        } else if ((jsonObject.getJSONArray("destination_addresses")).toString().equals("[\"\"]")) {
            return -2;
        }

        String km = jsonObject.getJSONArray("rows").getJSONObject(0).getJSONArray("elements").
                getJSONObject(0).getJSONObject("distance").getString("text").split(" ")[0];

        return Integer.parseInt(km);
    }

    private String concatPlaceName(String place) {
        return place.replace(" ", "");

    }

}
