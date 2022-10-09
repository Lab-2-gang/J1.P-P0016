package Tool;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class ReadFile
{
    public ArrayList<String> Read(String filePath)
    {
        try
        {
            ClassLoader classLoader = getClass().getClassLoader();
            InputStream streamReader = classLoader.getResourceAsStream(filePath);

            InputStreamReader inputReader = new InputStreamReader(streamReader);
            BufferedReader fileReader = new BufferedReader(inputReader);

            String line = fileReader.readLine();

            if (line == null || line.isBlank())
            {
                // error file is empty
                return null;
            }

            ArrayList<String> fileContent = new ArrayList<>();

            while (line != null)
            {
                fileContent.add(line);
                line = fileReader.readLine();
            }

            return fileContent;
        }
        catch (Exception e)
        {
            // error reading file
            return null;
        }
    }
}
