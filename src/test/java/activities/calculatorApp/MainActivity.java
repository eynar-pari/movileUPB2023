package activities.calculatorApp;

import controls.Button;
import controls.Label;
import org.openqa.selenium.By;

public class MainActivity {
    public Button fourButton = new Button(By.id("com.android.calculator2:id/digit_4"));
    public Button threeButton = new Button(By.id("com.android.calculator2:id/digit_3"));
    public Button addButton = new Button(By.id("com.android.calculator2:id/op_add"));
    public Button equalButton = new Button(By.id("com.android.calculator2:id/eq"));
    public Label resultLabel = new Label(By.id("com.android.calculator2:id/result"));

}