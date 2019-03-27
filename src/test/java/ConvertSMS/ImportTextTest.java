package ConvertSMS;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.*;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)

public class ImportTextTest {

    @Test
    public void inputFile(){
        String testString= "Jeśli nie ja mymi psoty, Nikt go stąd już nie wyruszy[31]. Nie ma dnia bez sprzeczki, zwady — Lecz potrzebne i układy. Pisać? — nie chcę do niecnoty. 160 Iść tam? — ślisko, mocium panie: Mógłby otruć, zabić skrycie. A mnie jeszcze miłe życie, Więc dlategom wybrał ciebie: Będziesz posłem tam w potrzebie. ";
        ImportText text = new ImportText("Import");
        assertEquals(testString,text.readText());




    }

}