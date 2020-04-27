package com.GureevM.lab_42;

public class TxtTypeDAOFactory implements DAOFactory{
    @Override
    public OutputFile createFile() {
        System.out.printf("Выбрано чтение в текстовом виде.");
        return new TxtFile();
    }
}
