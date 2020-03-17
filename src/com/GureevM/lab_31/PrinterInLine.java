package com.GureevM.lab_31;

import com.GureevM.lab_12.Transport;

import java.io.FileWriter;
import java.io.IOException;

public class PrinterInLine implements ChainOfResponsibility {

    private ChainOfResponsibility nextInChain;
    @Override
    public void printToTXTFile(Transport transport) {
        if (transport.getArrayModelLength() <= 3) {
            write(transport);
        } else {
            if(nextInChain != null) nextInChain.printToTXTFile(transport);
            else System.out.println("Отсутствует следующий в цепочке.");
        }
    }

    @Override
    public void setNextInChain(ChainOfResponsibility nextInChain) {
        this.nextInChain = nextInChain;
    }

    private void write(Transport transport) {
        try (FileWriter writer = new FileWriter("src/com/GureevM/lab_31/outputFileInLine.txt", false)) {
            String mark = transport.getMark();
            int count = transport.getArrayModelLength();
            double[] prices = transport.getArrayOfModelPrice();
            String[] models = transport.getArrayOfModelNames();
            writer.write(String.format("Mark: %s, count: %d \n", mark, count));
            for (int a = 0; a < count; a++) {
                writer.write(String.format("Model: %s, price: %d", models[a], (int) prices[a]));
                if(a!=count-1) writer.append("; ");
            }
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
