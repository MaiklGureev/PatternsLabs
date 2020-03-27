package com.GureevM;

import com.GureevM.lab_11.Singleton;
import com.GureevM.lab_12.*;
import com.GureevM.lab_12.MyExeptions.DuplicateModelNameException;
import com.GureevM.lab_12.MyExeptions.NoSuchModelNameException;
import com.GureevM.lab_13.Prototype;
import com.GureevM.lab_21.Adapter;
import com.GureevM.lab_21.AdapterRelease;
import com.GureevM.lab_22.TransportDecorator;
import com.GureevM.lab_31.ChainOfResponsibility;
import com.GureevM.lab_32.Command;
import com.GureevM.lab_32.PrinterInLine;
import com.GureevM.lab_32.PrinterToColumn;

import java.io.*;
import java.util.Arrays;
import java.util.Properties;

public class Main {

    public static void main(String[] args)  {
        //Разработка приложения с использованием паттерна Chain of Responsibility
//        Transport transport = new Motorcycle("DefMark",10);
//        ChainOfResponsibility chainOfResponsibility =  new PrinterInLine();
//        chainOfResponsibility.setNextInChain(new PrinterToColumn());
//        chainOfResponsibility.printToTXTFile(transport);

        //Разработка приложения с использованием паттерна Command
//        Car transport = new Car("DefMark",10);
//        //Command command = new PrinterInLine();
//        Command command = new PrinterToColumn();
//        transport.setPrintCommand(command);
//        try {
//            FileWriter writer = new FileWriter("src/com/GureevM/lab_32/out.txt");
//            transport.print(writer);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


    }


}
