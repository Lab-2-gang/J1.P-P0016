package Presentation.Menu;


public class WelcomeText extends MenuAbstract
{
    public WelcomeText()
    {
        _textList.add("Welcome");
    }

    @Override
    public void Print()
    {
        for (String text : _textList)
        {
            System.out.println(text);
        }
    }
}
