package ConvertSMS;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.*;
import org.junit.runner.RunWith;

import java.io.FileNotFoundException;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)

public class ImportTextTest {

    @Test
    public void inputFile(){
        String testString= "TO jest Test 1 ";
        ImportText text = new ImportText("nazwa");
        assertEquals(testString,text.readText());
    }

    @Test(expected = NullPointerException.class)
    public void inputFileNullPointer(){
        ImportText text = new ImportText("nazwwa");
    }
}