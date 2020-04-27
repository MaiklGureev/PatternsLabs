package com.GureevM.lab_42;

import com.GureevM.lab_12.Transport;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TxtFile implements OutputFile{

    String mark;
    int count ;
    double[] prices ;
    String[] models ;

    @Override
    public void write(Transport transport) {
        try {
            FileWriter writer = new FileWriter("src/com/GureevM/lab_42/files/txtFile.txt");
            mark = transport.getMark();
            count = transport.getArrayModelLength();
            prices = transport.getArrayOfModelPrice();
            models = transport.getArrayOfModelNames();
            writer.write(String.format("%s\n", mark));
            writer.write(String.format("%d\n", count));
            for (int a = 0; a < count; a++) {
                writer.write(String.format("%s\n", models[a] ));
                writer.write(String.format("%d\n", (int) prices[a]));
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Транспорт записан в файл!");
    }

    @Override
    public void read() {
        try{
        FileReader fileReader = new FileReader("src/com/GureevM/lab_42/files/txtFile.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        mark = bufferedReader.readLine();
        count = Integer.valueOf(bufferedReader.readLine());
        models = new String[count];
        prices = new double[count];
        for(int a= 0;a<count;a++){
            models[a] = bufferedReader.readLine();
            prices[a] = Double.valueOf(bufferedReader.readLine());
        }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Файл прочитан!");
    }

    @Override
    public void showInfo() {
        System.out.println("Информация из файла");
        System.out.println("--- --- --- --- --- --- --- --- ---");
        System.out.print(String.format("Mark: %s, count: %d\n", mark, count));
        for (int a = 0; a < count; a++) {
            System.out.print(String.format("Model: %s, price: %d", models[a], (int) prices[a]));
            if (a != count - 1)  System.out.print("; \n"); else System.out.print(".");
        }
    }
}
