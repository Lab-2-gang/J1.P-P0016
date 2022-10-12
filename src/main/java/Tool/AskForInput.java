package Tool;

import Presentation.Tool.Color;
import Presentation.Tool.Message;

public class AskForInput
{
    public static String Ask(String message)
    {
        if (message == null || message.isBlank() == true)
        {
            Message.showMessage("No message was found to ask!", Color.RED);
            return null;
        }

        System.out.print(message);
        return ReadInput.Read();
    }
}
