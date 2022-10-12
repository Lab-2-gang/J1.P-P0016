package Persistance.Tool;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;


public class ReadFile implements IReadFile
{
    @Override
    public ArrayList<String> Read(String filePath)
    {
        try
        {
            File file = new File(filePath);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
        
            String line = bufferedReader.readLine();
            
            if (line == null || line.isBlank())
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
