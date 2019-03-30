package ConvertSMS;

public class Naiwna implements Compressor {
    private String SMSTextMessage;

    public String getSMSTextMessage() {
        return SMSTextMessage;
    }

    public Naiwna(String textMessage) {
        if (textMessage == null || textMessage.isEmpty()) {
            System.out.println("Ta wiadomośc nie ma tekstu");
            SMSTextMessage ="";
        } else {
            SMSTextMessage = textMessage;
        }
    }
    @Override
    public String compress(){
        String[] TableOfWords= SMSTextMessage.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String string:TableOfWords) {
            sb.append(string.replace(string.charAt(0),string.toUpperCase().charAt(0)));
        }
        System.out.println(sb.toString());
        SMSTextMessage =sb.toString();
        return SMSTextMessage ;
    }

    @Override
    public  String decompress(){
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
