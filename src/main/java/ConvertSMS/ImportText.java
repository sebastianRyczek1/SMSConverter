package ConvertSMS;

import java.io.*;

public class ImportText {
    private String message;
    public ImportText(String file) {
        BufferedReader br = null;
        StringBuilder stringBuilder = new StringBuilder();
        String lineOfText = null;
        try {
            br = new BufferedReader(new FileReader(file));
            lineOfText = br.readLine();
            do {
                System.out.println(lineOfText);
                stringBuilder.append(lineOfText);
                stringBuilder.append(" ");
                lineOfText = br.readLine();
            } while (lineOfText != null);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String outputMessage = stringBuilder.toString();
        message= outputMessage;
    }

    public String readText(){
        return message;
    }
}
