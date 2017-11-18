import java.io.*;
import java.net.Socket;

/**
 * Created by sameerasy on 18/11/17.
 */
public class ReaderClient {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        FileInputStream fstream = new FileInputStream("/Users/sameerasy/IdeaProjects/FileRead/src/data.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(fstream));
        String line;
        Socket s = new Socket("127.0.0.1", 1234);
        ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
        while ((line = reader.readLine()) != null) {
            oos.writeObject(line);
            ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
            String message = (String) ois.readObject();
            System.out.println("Count of 0's : " + message.split(" ")[0]);
            System.out.println("Count of 1's : " + message.split(" ")[1]);
            ois.close();
        }
        reader.close();
    }
}
