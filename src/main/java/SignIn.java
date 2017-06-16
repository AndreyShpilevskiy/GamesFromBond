import javax.mail.MessagingException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;


public class SignIn {

    String s;
    public void logSignIn() throws IOException, MessagingException {

        FileReader fr = new FileReader("C:\\work\\log_sigIn.txt");
        BufferedReader br = new BufferedReader(fr);
        Date date = new Date();
        String str = br.readLine();
        String result = date.toString() + " Успешность запуска " + s;
        while (str != null) {
            String lineSeparator = System.getProperty("line.separator");
            result += lineSeparator + str;
            str = br.readLine();
        }
        FileWriter fw = new FileWriter("C:\\work\\log_signInt.txt");
        fw.write(result);
        fw.close();
        fr.close();
        br.close();
    }

}
