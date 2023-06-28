package activities.whenDoApp;

import controls.Button;
import controls.TextBox;
import org.openqa.selenium.By;


public class TaskActivity {

    public TextBox nameTextBox = new TextBox(By.xpath("//android.widget.EditText[contains(@resource-id,'Title')]"));
    public Button saveButton = new Button(By.xpath("//android.widget.TextView[@content-desc=\"Save\"]"));

}
