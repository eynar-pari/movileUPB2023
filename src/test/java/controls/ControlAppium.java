package controls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import session.Session;

public class ControlAppium {
    protected WebElement control;
    protected By locator;

    public ControlAppium(By locator){
        this.locator = locator;
    }

    protected void findControl(){
        this.control = Session.getSession().getDevice().findElement(this.locator);
    }

    public void click(){
        this.findControl();
        this.control.click();
    }


    public String getText(){
        this.findControl();
        return this.control.getText();
    }

    public boolean isControlDisplayed(){
        try {
            this.findControl();
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
