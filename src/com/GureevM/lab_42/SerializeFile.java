package com.GureevM.lab_42;

import com.GureevM.lab_12.Transport;
import java.io.*;

public class SerializeFile implements OutputFile{

    private Transport transport;

    @Override
    public void read() {
        try {
            FileInputStream fileInputStream = new FileInputStream("src/com/GureevM/lab_42/files/serFile.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            transport = (Transport) objectInputStream.readObject();
            fileInputStream.close();
            objectInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Файл прочитан!");
    }

    @Override
    public void showInfo() {
        System.out.println("Информация из файла");
        String mark = transport.getMark();
        int count = transport.getArrayModelLength();
        double[] prices = transport.getArrayOfModelPrice();
        String[] models = transport.getArrayOfModelNames();
        System.out.println("--- --- --- --- --- --- --- --- ---");
        System.out.print(String.format("Mark: %s, count: %d\n", mark, count));
        for (int a = 0; a < count; a++) {
            System.out.print(String.format("Model: %s, price: %d", models[a], (int) prices[a]));
            if (a != count - 1)  System.out.print("; \n"); else System.out.print(".");
        }
    }

    public void write(Transport transport){
        try {
            this.transport = transport;
            FileOutputStream fileOutputStream = new FileOutputStream
                    ("src/com/GureevM/lab_42/files/serFile.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(transport);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Транспорт записан в файл!");
    }
}
