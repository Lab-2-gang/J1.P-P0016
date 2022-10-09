package Database.Tool;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;


public class ReadFile implements IReadFile
{
    @Override
    public ArrayList<String> Read(String filePath)
    {
        try
        {
            ClassLoader classLoader = getClass().getClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream(filePath);

            InputStreamReader inputReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            BufferedReader fileReader = new BufferedReader(inputReader);
        
            String line = fileReader.readLine();
            
            if (line == null || line.isBlank())
            {
                return null;
            }
            
            ArrayList<String> fileContent = new ArrayList<>();
            
            while (line != null)
            {
                fileContent.add(line.trim());
                line = fileReader.readLine();
            }
            
            return fileContent;
        }
        catch (Exception e)
        {
            return null;
        }
    }
}
