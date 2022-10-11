package Persistance.SaveFile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import Persistance.Database;
import Persistance.Entity.Dealer.Dealer;
import Presentation.Tools.Color;
import Presentation.Tools.Message;

public class SaveDealerFile
{
    public void Save(String filePath)
    {
        try
        {
            File file = new File(filePath);
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (Dealer dealer : Database.GetDatabase().GetDealerDatabase())
            {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(dealer.getDealerID());
                stringBuilder.append(";");
                stringBuilder.append(dealer.getDealerName());
                stringBuilder.append(";");
                stringBuilder.append(dealer.getDealerHouseNumber());
                stringBuilder.append(";");
                stringBuilder.append(dealer.getDealerStreetName());
                stringBuilder.append(";");
                stringBuilder.append(dealer.getDealerNumber());
                stringBuilder.append(";");
                stringBuilder.append(dealer.getIsContinuing());
                stringBuilder.append("\n");

                bufferedWriter.write(stringBuilder.toString());
            }

            Message.showMessage("Save completed!\n", Color.GREEN);
            bufferedWriter.close();
        }
        catch (Exception e)
        {
            // cannot save to file
            Message.showMessage("Cannot save\n", Color.GREEN);
        }
    }
}
