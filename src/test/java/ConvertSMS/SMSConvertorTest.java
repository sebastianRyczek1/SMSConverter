package ConvertSMS;

import junitparams.JUnitParamsRunner;

import org.junit.*;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class SMSConvertorTest {
    @Test
    public void  creatingSMSConvertorNull(){
        SMSConvertor smsConvertor= new SMSConvertor(null);
        assertEquals("",smsConvertor.getSMSTextMessage());
    }

    @Test
    public void  creatingSMSConvertorblanc(){
        SMSConvertor smsConvertor= new SMSConvertor("");
        assertEquals("",smsConvertor.getSMSTextMessage());
    }

    @Test
    public void NaiwnaMetod() {
        SMSConvertor smsConvertor = new SMSConvertor("Ala ma kota, a kot ma ale");
        assertEquals("AlaMaKota,AKotMaAle",smsConvertor.NaiwnaCoding());
    }


    @Test
    public  void NaiwnaDecompresing(){
        SMSConvertor smsConvertor = new SMSConvertor("AlaMaKota,AKotMaAle");
        assertEquals("Ala ma kota, a kot ma ale",smsConvertor.NaiwnaDecoding());
    }
}
