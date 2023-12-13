package dev.yasint;

import java.util.Date;
import java.util.Random;

public class LogGenerator implements Runnable {

    private LogWriter logWriter;
    private int numberOfEntries;

    public LogGenerator(LogWriter logWriter, int numberOfEntries) {
        this.logWriter = logWriter;
        this.numberOfEntries = numberOfEntries;
    }

    @Override
    public void run() {
        Random random = new Random();
        String[] endpoints = {"/home", "/login", "/register", "/about", "/contact"};

        for (int i = 0; i < numberOfEntries; i++) {
            String ipAddress = "192.168.1." + random.nextInt(255);
            String endpoint = endpoints[random.nextInt(endpoints.length)];
            Date timestamp = new Date();

            LogEntry entry = new LogEntry(ipAddress, endpoint, timestamp);
            logWriter.writeLog(entry);
        }
    }

}