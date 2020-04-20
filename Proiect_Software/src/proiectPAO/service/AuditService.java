package proiectPAO.service;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

public class AuditService {

    private static AuditService instance = new AuditService();
    BufferedWriter output;
    private AuditService() {
        try  {
            Path path = Paths.get("audit.csv");
            output = Files.newBufferedWriter(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static AuditService getInstance() {
        return instance;
    }

    public void writeData(String functionName){


        try  {
            output.write(functionName);
            output.write(",");
            Date date= new Date();
            long time = date.getTime();
            output.write(Long.toString(time));
            output.newLine();
            output.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
