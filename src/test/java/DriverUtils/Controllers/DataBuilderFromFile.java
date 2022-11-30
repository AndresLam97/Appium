package DriverUtils.Controllers;

import com.google.gson.Gson;
import java.io.FileNotFoundException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DataBuilderFromFile {

    public static <T> T listDataFromJsonFile(String filePath, Class<T> className)
    {
        Gson gson = new Gson();
        String fileLocation = System.getProperty("user.dir").concat(filePath);
        T data = null;
        try (Reader fileReader = Files.newBufferedReader(Paths.get(fileLocation)))
        {
            data = gson.fromJson(fileReader,className);
        }catch(FileNotFoundException fileNotFoundException)
        {
            System.out.println(fileNotFoundException.toString());
        }
        catch(Exception ex)
        {
            System.out.println(ex.toString());
        }
        if(data == null)
        {
            throw new RuntimeException("[ERROR] The data file is not exist!!!");
        }
        return data;
    }
}
