import ConvertSMS.CostOfSMS;
import ConvertSMS.ImportText;
import ConvertSMS.SMSConvertor;
import ConvertSMS.Smaz;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        CostOfSMS costOfSMS= null;
        System.out.println("Wprowadz text smsa");
        String smsText=sc.nextLine();
        SMSConvertor smsConvertor= new SMSConvertor(smsText);
        System.out.println("Jaką metodą chcesz skrócić wiadomość?");
        System.out.println("Wybierz 1 jeśli chcesz Naiwną");
        System.out.println("Wybierz 2 jeśli chcesz Smaz");
        int choose=sc.nextInt();
        switch (choose){
            case 1:
                smsConvertor.Naiwna();
                break;
            case 2:
                Smaz smaz=new Smaz();
                byte[] compressed = smaz.compress(smsText);
                String uncompressedString = smaz.decompress(compressed);
                System.out.println(uncompressedString);
            case 3:
                ImportText importText = new ImportText("Import");
                String text = importText.readText();
                costOfSMS=new CostOfSMS(text);
                System.out.println(costOfSMS.CalculateCostOfSMS());
        }
    }
}
