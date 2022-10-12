package Persistance;

import Tool.DatabaseType;


public interface IFilePath
{
    public String GetPath(DatabaseType type);
    public void InitiateFilePath();
}
