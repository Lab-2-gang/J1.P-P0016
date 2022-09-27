package Presentation.Menu;

import java.util.ArrayList;


public abstract class MenuAbstract implements IPrint
{
    protected ArrayList<String> _textList = new ArrayList<>();

    public ArrayList<String> GetTextList()
    {
        return _textList;
    }
    
    public abstract void Print();
}
