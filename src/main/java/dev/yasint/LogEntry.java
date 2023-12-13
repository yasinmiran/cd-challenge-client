package dev.yasint;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LogEntry {

    private String ipAddress;
    private String endpoint;
    private Date timestamp;

    public LogEntry(String ipAddress, String endpoint, Date timestamp) {
        this.ipAddress = ipAddress;
        this.endpoint = endpoint;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return ipAddress + " " + endpoint + " " + dateFormat.format(timestamp);
    }

}