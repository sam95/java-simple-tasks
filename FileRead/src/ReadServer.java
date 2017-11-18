import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by sameerasy on 18/11/17.
 */
public class ReadServer {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ServerSocket ss = new ServerSocket(1234);
        Socket s = ss.accept();
        ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
        String message = (String) ois.readObject();
        System.out.println("Message Received: " + message);
        ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
        oos.writeObject(countZero(message)+" "+countOne(message));
        ois.close();
        oos.close();
        s.close();

    }

    private static int countZero(String s) {
        return s.length()-s.replaceAll("0","").length();
    }

    private static int countOne(String s) {
        return s.length()-s.replaceAll("1","").length();
    }
}
