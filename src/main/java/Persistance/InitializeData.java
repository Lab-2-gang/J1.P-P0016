package Persistance;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import Presentation.Tool.Color;
import Presentation.Tool.Message;
import Tool.DatabaseType;


public class InitializeData
{
    // initialize data
    public static void Initiate()
    {
        // check whether the Data folder exists
        File destinationDirectory = new File("Data");

        if (destinationDirectory.exists() == true)
        {
            // Data folder already exist
            return;
        }


        // if Data folder not exist, copy Data folder from resources
        destinationDirectory.mkdir();
        
        IFilePath filePath = new FilePath();
        filePath.InitiateFilePath();

        CopyFile(filePath.GetPath(DatabaseType.Accounts));
        CopyFile(filePath.GetPath(DatabaseType.Dealers));
    }

    private static void CopyFile(String filePath)
    {
        try
        {
            // load source file in jar
            ClassLoader classLoader = InitializeData.class.getClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream(filePath);


            // create file outside jar
            File destinationFile = new File(filePath);
            destinationFile.createNewFile();
            FileOutputStream outputStream = new FileOutputStream(destinationFile);


            // copy file
            byte[] buffer = new byte[1024];
            int bufferLength = inputStream.read(buffer);

            while (bufferLength >= 0)
            {
                outputStream.write(buffer, 0, bufferLength);
                bufferLength = inputStream.read(buffer);
            }

            outputStream.close();
        }
        catch (Exception e)
        {
            // error copying file
            Message.showMessage("Error initiating data!\n", Color.RED);
            System.exit(1);
        }
    }
}