package Persistance;

import Tool.DatabaseType;


public interface IFilePath
{
    public void InitiateFilePath();
    
    public String GetPath(DatabaseType type);
    
    public Boolean CheckPaths();
}
