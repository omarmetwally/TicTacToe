/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screens.Record;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Omar
 */

public class Record {
    private String recordFileName;
    private boolean isRecording;

    public Record() {
        isRecording = false;
    }

    public boolean isIsRecording() {
        return isRecording;
    }

    public void setIsRecording(boolean isRecording) {
        this.isRecording = isRecording;
    }

    public void startRecording(String player1, String player2) {
        if (!isRecording) {
            String directory =System.getProperty("user.dir")+ "/src/screens/Record/";
            recordFileName = directory+player1 + "&" + player2 + ".txt";
            isRecording = true;
            clearRecordFile();
        }
    }

    private void clearRecordFile() {
        try (PrintWriter out = new PrintWriter(recordFileName)) {
            // Clearing the content of the file
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void recordMove(String mark, int row, int col) {
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(recordFileName, true)))) {
            out.println(mark + " - Row: " + row + ", Col: " + col);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isRecording() {
        return isRecording;
    }

    public void stopRecording() {
        isRecording = false;
    }
}