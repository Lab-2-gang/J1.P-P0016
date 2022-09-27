package Presentation.Menu;


public class MainMenu extends MenuAbstract
{
    public MainMenu()
    {
        _textList.add("1. ");
        _textList.add("2. ");
        _textList.add("3. ");
        _textList.add("4. ");
        _textList.add("5. ");
        _textList.add("6. ");
        _textList.add("7. ");
        _textList.add("8. ");
        _textList.add("9. ");
        _textList.add("10. ");
    }

    @Override
    public void Print()
    {
        String lastText = _textList.get(_textList.size() - 1);
        
        for (String text : _textList)
        {
            if (text.equals(lastText))
            {
                System.out.print(text);
                return;
            }
            
            System.out.println(text);
        }
    }
}
