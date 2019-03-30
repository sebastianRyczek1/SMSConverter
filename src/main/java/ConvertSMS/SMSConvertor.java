package ConvertSMS;

public class SMSConvertor {
    private String SMSTextMessage;

    public String getSMSTextMessage() {
        return SMSTextMessage;
    }

    public SMSConvertor(String inputSMS) {
        if (inputSMS == null || inputSMS.isEmpty()) {
            System.out.println("Ta wiadomośc nie ma tekstu");
            SMSTextMessage ="";
        } else {
            SMSTextMessage = inputSMS;
        }
    }
    public String NaiwnaCoding(){
        String[] TableOfWords= SMSTextMessage.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String string:TableOfWords) {
            sb.append(string.replace(string.charAt(0),string.toUpperCase().charAt(0)));
        }
        System.out.println(sb.toString());
        SMSTextMessage =sb.toString();
        return SMSTextMessage ;
    }
    public  String NaiwnaDecoding(){
        char[] TableOfChars= SMSTextMessage.toCharArray();
        StringBuilder SMSText=new StringBuilder();
        SMSText.append(TableOfChars[0]);
        for (int i =1;i<TableOfChars.length;i++){
            if (TableOfChars[i]>='A' && TableOfChars[i]<='Z'){
                SMSText.append(" ");
                TableOfChars[i]= (char) (TableOfChars[i]+32);
            }
            SMSText.append(TableOfChars[i]);
        }
        SMSTextMessage =SMSText.toString();
        return  SMSTextMessage;
    }
}
