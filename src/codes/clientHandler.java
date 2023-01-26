package codes;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class clientHandler {
    
    private Socket soc;

    public clientHandler(Socket soc) {
        this.soc = soc;
    }

    public void handle() throws IOException {

        InputStream is = soc.getInputStream();
        ObjectInputStream ois = new ObjectInputStream(is);

        OutputStream os = soc.getOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(os);

        dotProductServer test = new dotProductServer();
        test.process(ois, oos);

        ois.close();
        is.close();
        
    }


}
