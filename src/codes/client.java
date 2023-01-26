package codes;

import java.io.Console;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class client {

    public static void main(String[] args) throws UnknownHostException, IOException {

        int port=3000, row, result;
        String input, msg;

        Console cons = System.console();

        Socket soc = new Socket("localhost", port);

        OutputStream os = soc.getOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(os);

        InputStream is = soc.getInputStream();
        ObjectInputStream ois = new ObjectInputStream(is);

        input = ois.readUTF();
        msg = cons.readLine(input);

        oos.writeUTF(msg);
        oos.flush();

        String [] itemList = msg.trim().split(" ");
        row = Integer.parseInt(itemList[0]);
        // col = Integer.parseInt(itemList[1]);

        for (int i =0; i<row; i++) {
            input = ois.readUTF();
            msg = cons.readLine(input);
            oos.writeUTF(msg);
            oos.flush();
        }

        // generate multiplier
        input = ois.readUTF();
        msg = cons.readLine(input);
        oos.writeUTF(msg);
        oos.flush();

        result = ois.readInt();
        System.out.printf("The result of the calculation is: %d\n", result);

        soc.close();
    }
    
}
