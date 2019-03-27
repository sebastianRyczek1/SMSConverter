package ConvertSMS;

import java.util.Scanner;

public class CostOfSMS {
    private double SMSCost;

    public CostOfSMS(String inputText) {
        System.out.println("Text ma: " + inputText.length() + "znaków");
        int SMSSize = (int) Math.ceil((double) inputText.length() / 160);
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
        int number=(int)Math.floor(SMSCost);

        sb.append("Your SMS will cost ");
        sb.append(number);
        sb.append('.');
        sb.append(((int)Math.floor(SMSCost - Math.floor(SMSCost)) * 100));
        sb.append("Zł");
        return sb.toString();

    }
}
