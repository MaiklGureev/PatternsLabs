package com.GureevM.lab_32;

import com.GureevM.lab_12.Transport;
import com.GureevM.lab_31.ChainOfResponsibility;

import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;

public class PrinterToColumn implements Command {


    @Override
    public boolean printToTXTFile(Transport transport, FileWriter writer) {
        try {
            String mark = transport.getMark();
            int count = transport.getArrayModelLength();
            double[] prices = transport.getArrayOfModelPrice();
            String[] models = transport.getArrayOfModelNames();
            writer.write(String.format("Mark: %s, count: %d \n", mark, count));
            for (int a = 0; a < count; a++) {
                writer.write(String.format("Model: %s, price: %d\n", models[a], (int) prices[a]));
            }
            writer.flush();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }
}
