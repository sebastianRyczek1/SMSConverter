package ConvertSMS;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.*;
import org.junit.runner.RunWith;

import java.io.FileNotFoundException;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class CostOfSMSTest {
    @Test(expected = NullPointerException.class)
    public void nullMessage() {
        String text = null;
        CostOfSMS costOfSMS = new CostOfSMS(text, 10, 1);
    }

    @Test
    public void CostOfText1() {
        String text = "Ala ma kota, Kot ma Ale";
        CostOfSMS costOfSMS = new CostOfSMS(text, 10, 1);

        assertEquals(3.0, costOfSMS.getSMSCost(), 0.009);

    }

    @Test
    public void CostOfText2() {
        String text = "Ala ma kota, Kot";
        CostOfSMS costOfSMS = new CostOfSMS(text, 10, 1.23);

        assertEquals(2.46, costOfSMS.getSMSCost(), 0.009);
    }
}