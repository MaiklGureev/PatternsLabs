package com.GureevM.lab_42;

public class SerializeTypeDAOFactory implements DAOFactory{
    @Override
    public OutputFile createFile() {
        System.out.printf("Выбрано чтение из сериализованного файла.");
        return new SerializeFile();
    }
}
