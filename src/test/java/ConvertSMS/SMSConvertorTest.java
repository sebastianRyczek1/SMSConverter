package ConvertSMS;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.*;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class SMSConvertorTest {
    @Test
    public void  creatingSMSConvertorNull(){
        SMSConvertor smsConvertor= new SMSConvertor(null);
        assertEquals("",smsConvertor.getInputSMS());
    }

    @Test
    public void  creatingSMSConvertorblanc(){
        SMSConvertor smsConvertor= new SMSConvertor("");
        assertEquals("",smsConvertor.getInputSMS());
    }

    @Test
    public void NaiwnaMetod() {
        SMSConvertor smsConvertor = new SMSConvertor("ala ma kota, a kot ma ale");
        assertEquals("AlAMaKota,AKotMaAle",smsConvertor.Naiwna());
    }
}
