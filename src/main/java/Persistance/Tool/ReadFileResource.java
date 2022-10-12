package Persistance.Tool;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import Tool.CheckNullOrBlank;


public class ReadFileResource implements IReadFile
{
    // read files from resources folder in jar
    @Override
    public ArrayList<String> Read(String filePath)
    {
        try
        {
            ClassLoader classLoader = getClass().getClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream(filePath);

            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        
            String line = bufferedReader.readLine();
            
            if (CheckNullOrBlank.Check(line) == true)
            {
                bufferedReader.close();
                return null;
            }
            
            ArrayList<String> fileContent = new ArrayList<>();
            
            while (line != null)
            {
                fileContent.add(line.trim());
                line = bufferedReader.readLine();
            }
            
            bufferedReader.close();
            return fileContent;
        }
        catch (Exception e)
        {
            return null;
        }
    }
}
