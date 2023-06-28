package testMovile;


import activities.whenDoApp.MainActivity;
import activities.whenDoApp.TaskActivity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import session.Session;

public class WhenDoTest {

    MainActivity mainActivity = new MainActivity();
    TaskActivity taskActivity = new TaskActivity();
    @Test
    public void verifyAdditionTest(){
       mainActivity.addButton.click();
       taskActivity.nameTextBox.setText("UPB");
       taskActivity.saveButton.click();

       // verification


    }

    @AfterEach
    public void close(){
        Session.getSession().closeSession();
    }

}
