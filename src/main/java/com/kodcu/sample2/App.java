package com.kodcu.sample2;

import javax.json.*;
import javax.json.stream.JsonGenerator;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: usta
 * Date: 3/24/13
 * Time: 11:04 AM
 * To change this template use File | Settings | File Templates.
 */
public class App {
    public static void main(String[] args) throws IOException {

        // config Map is created for pretty printing.
        Map<String, Boolean> config = new HashMap<>();

        // Pretty printing feature is added.
        config.put(JsonGenerator.PRETTY_PRINTING, true);

        // A simple array
        JsonArray jsonArray = Json.createArrayBuilder()
                .add("Emin").add("Şahin").build();

        //A simple object containing Json array
        JsonObject jsonObject = Json.createObjectBuilder()
                .add("name", jsonArray)
                .add("surname", "Demir")
                .build();

        // PrintWriter and JsonWriter is being created
        // in try-with-resources
        try (PrintWriter pw = new PrintWriter("./src/main/resources/jsonObject.json")
              ;JsonWriter jsonWriter = Json.createWriterFactory(config).createWriter(pw)) {

            // Json object is being sent into file system
            jsonWriter.writeObject(jsonObject);

        }

        JsonReader reader = Json
                .createReader(new FileReader("./src/main/resources/jsonObject.json"));

        JsonObject obj = reader.readObject();

        System.out.println("Content: " + obj.toString());

        // Creating an URL object.
        URL url = new URL("http://maps.googleapis.com/maps/api/geocode/json?address=Marmara+University&sensor=false");

        // Retrieving byte stream object from URL source
        InputStream is = url.openStream();

        // Creating JSON object model from stream
        JsonObject geoObj = Json
                .createReader(is)
                .readObject();

        // PrintWriter and JsonWriter is being created
        // in try-with-resources
        try (PrintWriter pw = new PrintWriter("./src/main/resources/geoApi.json");
             JsonWriter jsonWriter = Json.createWriterFactory(config).createWriter(pw)) {

            // Json object is being sent into file system
            jsonWriter.writeObject(geoObj);
        }

    }
}
