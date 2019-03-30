package ConvertSMS;

import java.util.Scanner;

public class CostOfSMS {
    private double SMSCost;
    private  int sizeSms=160;

    public CostOfSMS(String inputText, int sizeSms) {
        this.sizeSms = sizeSms;
        System.out.println("Text ma: " + inputText.length() + "znaków");
        int SMSSize = (int) Math.ceil((double) inputText.length() /sizeSms );
        System.out.println(SMSSize);
        SMSCost = PriceForOneSMS() * SMSSize;
    }

    private static double PriceForOneSMS() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Podaj koszt jednego sms");
        double SMSOneCost = sc.nextDouble();
        return SMSOneCost;
    }

    public String CalculateCostOfSMS() {
        StringBuilder sb = new StringBuilder();
        sb.append("Your SMS will cost ");
        sb.append(SMSCost);
        sb.append("Zł");
        return sb.toString();

    }
}
