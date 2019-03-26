import ConvertSMS.SMSConvertor;
import ConvertSMS.Smaz;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
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
        }
    }
}
