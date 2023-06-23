package testMovile;

import activities.calculatorApp.MainActivity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import session.Session;

public class CalculatorTest {

    MainActivity mainActivity = new MainActivity();

    @Test
    public void verifyAdditionTest(){
        mainActivity.fourButton.click();
        mainActivity.addButton.click();
        mainActivity.threeButton.click();
        mainActivity.equalButton.click();
        Assertions.assertEquals("7",mainActivity.resultLabel.getText(),
                "ERROR! La suma es incorrecta");

    }

    @AfterEach
    public void close(){
        Session.getSession().closeSession();
    }


}
