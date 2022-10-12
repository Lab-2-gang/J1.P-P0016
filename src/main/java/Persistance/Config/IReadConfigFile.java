package Persistance.Config;

import java.util.HashMap;
import Tool.DatabaseType;


public interface IReadConfigFile
{
    public HashMap<DatabaseType, String> Read(String filePath);
}
