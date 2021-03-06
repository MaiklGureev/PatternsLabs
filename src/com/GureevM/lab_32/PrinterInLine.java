package com.GureevM.lab_32;

import com.GureevM.lab_12.Transport;
import com.GureevM.lab_31.ChainOfResponsibility;

import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;

public class PrinterInLine implements Command, Serializable {


    @Override
    public boolean printToTXTFile(Transport transport, FileWriter writer) {
        try {
            String mark = transport.getMark();
            int count = transport.getArrayModelLength();
            double[] prices = transport.getArrayOfModelPrice();
            String[] models = transport.getArrayOfModelNames();
            writer.write(String.format("Mark: %s, count: %d \n", mark, count));
            for (int a = 0; a < count; a++) {
                writer.write(String.format("Model: %s, price: %d", models[a], (int) prices[a]));
                if (a != count - 1) writer.append("; ");
            }
            writer.flush();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return  false;
        }

    }
}
