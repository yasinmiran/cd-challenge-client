package dev.yasint;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class LogWriter {

    private String endpointUrl;

    public LogWriter(String endpointUrl) {
        this.endpointUrl = endpointUrl;
    }

    public void writeLog(LogEntry entry) {
        System.out.println(entry.toString());
//        try {
//            URL url = new URL(endpointUrl);
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            conn.setRequestMethod("POST");
//            conn.setRequestProperty("Content-Type", "application/json");
//            conn.setDoOutput(true);
//
//            String jsonInputString = "{\"log\": \"" + entry.toString() + "\"}";
//
//            try (OutputStream os = conn.getOutputStream()) {
//                byte[] input = jsonInputString.getBytes("utf-8");
//                os.write(input, 0, input.length);
//            }
//
//            int responseCode = conn.getResponseCode();
//            System.out.println("POST Response Code :: " + responseCode);
//
//            conn.disconnect();
//        } catch (Exception e) {
//            System.err.println("Error in HTTP POST: " + e.getMessage());
//        }
    }

}