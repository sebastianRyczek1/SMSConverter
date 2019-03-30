package ConvertSMS;

import junitparams.JUnitParamsRunner;

import org.junit.*;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class NaiwnaTest {
    @Test
    public void  creatingSMSConvertorNull(){
        Naiwna smsConvertor= new Naiwna(null);
        assertEquals("",smsConvertor.getSMSTextMessage());
    }

    @Test
    public void  creatingSMSConvertorblanc(){
        Naiwna smsConvertor= new Naiwna("");
        assertEquals("",smsConvertor.getSMSTextMessage());
    }

    @Test
    public void NaiwnaMetod() {
        Naiwna smsConvertor = new Naiwna("Ala ma kota, a kot ma ale");
        assertEquals("AlaMaKota,AKotMaAle",smsConvertor.compress());
    }


    @Test
    public  void NaiwnaDecompresing(){
        Naiwna smsConvertor = new Naiwna("AlaMaKota,AKotMaAle");
        assertEquals("Ala ma kota, a kot ma ale",smsConvertor.decompress());
    }
}
