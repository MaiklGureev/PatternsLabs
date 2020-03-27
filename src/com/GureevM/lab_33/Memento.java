package com.GureevM.lab_33;

import com.GureevM.lab_12.Car;

import java.io.*;

public class Memento implements  Serializable{

    Car car;
    public void setAuto(Car car){
        try {
            ByteArrayOutputStream writeBuffer = new ByteArrayOutputStream();
            ObjectOutputStream outputStream  = new ObjectOutputStream(writeBuffer);
            outputStream.writeObject(car);
            outputStream.close();
            byte[] buffer = writeBuffer.toByteArray();
            ByteArrayInputStream readBuffer = new ByteArrayInputStream(buffer);
            ObjectInputStream inputStream = new ObjectInputStream(readBuffer);
            this.car = (Car)inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Car getCar() {
        return car;
    }
}
