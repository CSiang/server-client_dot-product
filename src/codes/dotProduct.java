package codes;

import java.io.Console;


// This is the dotProduct program for local console, for dotProduct to be used for server-client
// refer to dotProductServer.java

public class dotProduct{

    Console cons = System.console();

    String input;
    String[] inputItems = null;

    public int process() {
        
        int row, col;
    
        // Getting input for number of row and col.
        input = cons.readLine("Please key in number of rows and cols for the dot product. Separate each value by space.\n");
        String [] itemList = input.trim().split(" ");
    
        row = Integer.parseInt(itemList[0]);
        col = Integer.parseInt(itemList[1]);

        int result=0, interim;

        Integer[][] array1 = new Integer[row][col];
        Integer[] multiplier = new Integer[col];

        // Generate 1st matrix
        for (int i =0; i<row; i++) {
            input = cons.readLine("Please key %d values for row#%d, separate each value by space:\n", col, i+1);
            inputItems = input.trim().split(" ");
            for (int j =0; j<inputItems.length; j++){
                array1[i][j]= Integer.parseInt(inputItems[j]);
            }
        }

        // generate multiplier
        input = cons.readLine("Please key %d values for multiplier, separate each value by space:\n", col);
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

        return result;
    }





}