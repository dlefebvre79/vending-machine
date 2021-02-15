package com.techelevator.file_io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ActivityLogger
{
    private static final String FILE_EXTENSION = ".txt";

    private String directory;

    public ActivityLogger(String directory)
    {
        this.directory = directory;
    }

    public void logMessage(String message)
    {
        String fileName = "Log";
        String logFilePath = fileName + FILE_EXTENSION;
        File logFile = new File(logFilePath);

         String currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM/DD/YYYY hh:mm:ss a"));

        // open the log file to append 
        try(FileOutputStream outputStream = new FileOutputStream(logFile, true);
            PrintWriter writer = new PrintWriter(outputStream);)
        {
            String line = String.format("%s %s", currentTime, message);
            writer.println(line);
        }
        catch(Exception ex)
        {
            
        }
        

    }
    

}
