package ConvertSMS;

public class SMSConvertor {
    private final String InputSMS;

    public String getInputSMS() {
        return InputSMS;
    }

    public SMSConvertor(String inputSMS) {
        if (inputSMS == null || inputSMS.isEmpty()) {
            System.out.println("Ta wiadomośc nie ma tekstu");
            InputSMS="";
        } else {
            InputSMS = inputSMS;
        }
    }
    public String Naiwna(){
        String[] TableOfWords=InputSMS.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String string:TableOfWords) {
            sb.append(string.replace(string.charAt(0),string.toUpperCase().charAt(0)));
        }
        System.out.println(sb.toString());
        return sb.toString();
    }
}
