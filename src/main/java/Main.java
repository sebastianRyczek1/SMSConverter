import ConvertSMS.CostOfSMS;
import ConvertSMS.ImportText;
import ConvertSMS.SMSConvertor;
import ConvertSMS.Smaz;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        SMSConvertor smsConvertor = null;
        Smaz smaz = new Smaz();
        byte[] smasArray = null;
        String message = null;
        String choiceValue = null;
        int codedMessage = 0;
        String codedMetod = null;
        String endProgram = "N";
        System.out.println("Witaj w programie SMS Converter");
        do {
            System.out.println("Wybierz 1 jeśli chcesz wczytać plik txt");
            System.out.println("Wybierz 2 jeśli chcesz wpisać treść SMSa");
            choiceValue = sc.next();
            while (choiceValue.equals(1) ^ choiceValue.equals(2)) {
                System.out.println("Podaj poprawną wartość");
                System.out.println("1 - wczytanie textu z pliku");
                System.out.println("2 - wpisanie textu SMS");
                choiceValue = sc.next();
            }
            if (choiceValue.equals("1")) {
                ImportText importText = new ImportText("Import");
                message=importText.readText();
                System.out.println("Zaimportowano text z pliku Import.txt");
            } else {
                System.out.println("Wprowadz text SMS:");
                message = sc.next();
            }
            System.out.println("Wybierz 1 jeśli chcesz zakodować SMSa");
            System.out.println("Wybierz 2 jeśli chcesz obliczyć koszt SMSa");
            choiceValue = sc.next();

            while (choiceValue.equals(1) ^ choiceValue.equals(2)) {
                System.out.println("Podaj poprawną wartość");
                System.out.println("1 - kodowanie SMSa");
                System.out.println("2 - Obliczanie kosztu SMSa");
                choiceValue = sc.next();
            }
            if (choiceValue.equals("1")) {
                System.out.println("Wybierz 1 koduując metodą naiwną");
                System.out.println("Wybierz 2 kodując metodą SMAZ");
                choiceValue = sc.next();
                while (choiceValue.equals(1) ^ choiceValue.equals(2)) {
                    System.out.println("Podaj poprawną wartość");
                    System.out.println("1 - Metoda Naiwna");
                    System.out.println("2 - Metoda SMAZ");
                    choiceValue = sc.next();
                }
                if (choiceValue.equals("1")) {
                    codedMessage = 1;
                    System.out.println("Wybrałeś metodę naiwną");
                    smsConvertor = new SMSConvertor(message);
                    message = smsConvertor.NaiwnaCoding();
                    if (smsConvertor != null) {
                        System.out.println("Wiadomość zakodowana");
                    }
                } else {
                    codedMessage = 2;
                    smasArray = smaz.compress(message);
                    message = String.valueOf(smasArray);
                }
            } else {
                System.out.println("ILE ZNAKOW");
                System.out.println(message.length());
                CostOfSMS costOfSMS = new CostOfSMS(message, 160);
                System.out.println(costOfSMS.CalculateCostOfSMS());
            }

            // tutaj powinniśmy mieć do wyboru decodowanie i obliczanie kosztu sms lub wyjscie
            System.out.println("Wybierz 1 jeśli chcesz decodować SMSa");
            System.out.println("Wybierz 2 jeśli chcesz obliczyć koszt SMSa");
            System.out.println("Wybierz 3 jeśli chcesz wprowadzić nową wiadomośc");
            System.out.println("Wybierz 4 jeśli chcesz zakonczyć  program");
            choiceValue = sc.next();
            while (choiceValue.equals(1) ^ choiceValue.equals(2) ^ choiceValue.equals(3) ^ choiceValue.equals(4)) {
                System.out.println("Podaj poprawną wartość");
                System.out.println("1 - decodowanie smsa SMSa");
                System.out.println("2 - Obliczanie kosztu SMSa");
                System.out.println("3 - Wprowadz nową wiadomośc");
                System.out.println("4 - Zakończ program");
                choiceValue = sc.next();
            }
            switch (choiceValue) {
                case "1":
                    if (codedMessage == 1) {
                        message = smsConvertor.NaiwnaDecoding();
                    } else {
                        message = smaz.decompress(smasArray);
                    }
                    System.out.println("Zdecodowano wiadomość");
                case "2":
                    CostOfSMS costOfSMS = new CostOfSMS(message, 160);
                    System.out.println(costOfSMS.CalculateCostOfSMS());
                case "3":
                    endProgram="n";
                case "4":
                    endProgram="y";
            }
        }while (endProgram.equals("n"));
    }
}
