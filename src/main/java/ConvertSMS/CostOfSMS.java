package ConvertSMS;

import java.util.Scanner;

public class CostOfSMS {
    public double getSMSCost() {
        return SMSCost;
    }

    private double SMSCost;
    private  int sizeSms=0;
    private double costOfOne=0;

    public CostOfSMS(String inputText, int sizeSms,double costOfOne) {
        this.sizeSms = sizeSms;
        this.costOfOne=costOfOne;
        int SMSSize = (int) Math.ceil((double) inputText.length() /sizeSms );
        this.SMSCost = costOfOne * SMSSize;
    }
}
