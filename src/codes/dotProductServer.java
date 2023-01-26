package codes;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class dotProductServer{

    String input;
    String[] inputItems = null;

    public void process(ObjectInputStream ois, ObjectOutputStream oos) throws IOException {
        
        int row, col;
        String msg;
    
        // Getting input for number of row and col.
        oos.writeUTF("Please key in number of rows and cols for the dot product. Separate each value by space.\n");
        oos.flush();
        input = ois.readUTF();
        String [] itemList = input.trim().split(" ");
    
        row = Integer.parseInt(itemList[0]);
        col = Integer.parseInt(itemList[1]);

        int result=0, interim;

        Integer[][] array1 = new Integer[row][col];
        Integer[] multiplier = new Integer[col];

        // Generate 1st matrix
        for (int i =0; i<row; i++) {
            msg = "Please key " + String.valueOf(col) +" values for row#" + String.valueOf(i+1) 
                   + ", separate each value by space:\n";
            oos.writeUTF(msg);
            oos.flush();
            input = ois.readUTF();
            inputItems = input.trim().split(" ");
            for (int j =0; j<inputItems.length; j++){
                array1[i][j]= Integer.parseInt(inputItems[j]);
            }
        }

        // generate multiplier
        msg = "Please key " + String.valueOf(col) +" values for multiplier, separate each value by space:\n";
        oos.writeUTF(msg);
        oos.flush();
        
        input = ois.readUTF();
        inputItems = input.trim().split(" ");
        for (int j =0; j<inputItems.length; j++){
            multiplier[j]= Integer.parseInt(inputItems[j]);
        }

        // getting dotproduct
        for (int i=0; i< row; i++) {
            interim =0;

            for (int j=0; j< col; j++){
                interim += array1[i][j]*multiplier[j];
            }
            result += interim;
        }

        oos.writeInt(result);
        oos.flush();
    }





}