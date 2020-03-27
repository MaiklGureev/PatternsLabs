package com.GureevM.lab_12;

import com.GureevM.lab_12.MyExeptions.DuplicateModelNameException;
import com.GureevM.lab_12.MyExeptions.ModelPriceOutOfBoundsException;
import com.GureevM.lab_12.MyExeptions.NoSuchModelNameException;
import com.GureevM.lab_13.Prototype;
import com.GureevM.lab_32.Command;
import com.GureevM.lab_32.PrinterToColumn;
import com.GureevM.lab_33.Memento;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
import java.util.Iterator;

public class Car implements Transport, Prototype, Serializable {

    private String carMark;
    private Model[] models;
    private Command command;
    private AutoIterator autoIterator;
    private Memento memento;

    public Car(String markName, int arraySize) {
        try {
            autoIterator = new AutoIterator();
            command = new PrinterToColumn();
            memento =  new Memento();
            setMark(markName);
            setArraySize(arraySize, 50);

        } catch (DuplicateModelNameException e) {
            e.printStackTrace();
        }
    }

    // установка текущей команды (паттерн команд)
    public void setPrintCommand(Command command) {
        this.command = command;
    }

    //метод для печати (паттерн команд)
    public void print(FileWriter writer) {
        if (command.printToTXTFile(this, writer)) {
            System.out.println("Печать в файл выполнена!");
        } else {
            System.out.println("Печать в файл не выполнена!");
        }
    }

    //метод возврашающий экземпляр автоитератора (паттерн итератор)
    public AutoIterator iterator() {
        return new AutoIterator();
    }

    //метод делающий снимок текущей машины (паттерн мементо)
    public void createMemento(Car car){
            memento.setAuto(car);
    }

    //метод возврашающий экземпляр машины из снимка (паттерн мементо)
    public Car getMemento(){
        return memento.getCar();
    }

    //метод для задания длины и заполнения
    public void setArraySize(int arraySize, double mediumPrice) throws DuplicateModelNameException {
        models = new Model[0];
        for (int a = 0; a < arraySize; a++) {
            String name = "car_" + a;
            double price = mediumPrice + new Random().nextInt((int) mediumPrice / 2);
            addNewModel(name, price);
        }
    }

    //метод для получения марки автомобиля
    public String getMark() {
        return carMark;
    }

    //метод для модификации марки автомобиля
    public void setMark(String mark) {
        this.carMark = mark;
    }

    //метод для получения значения цены модели по её названию
    public double getPriceByModelName(String name) throws NoSuchModelNameException {
        for (int a = 0; a < models.length; a++) {
            if (models[a].name.equals(name)) {
                return models[a].price;
            }
        }
        String err = String.format("Модель {0} не найдена!", name);
        throw new NoSuchModelNameException(err);
    }

    //метод для модификации значения цены модели по её названию
    public void editPriceByModelName(String name, double newPrice) throws NoSuchModelNameException {
        for (int a = 0; a < models.length; a++) {

            if (newPrice < 0) {
                String err = String.format("Новая цена меньше 0!", name);
                throw new ModelPriceOutOfBoundsException(err);
            }

            if (models[a].name.equals(name)) {
                models[a].price = newPrice;
                System.out.println(getMark() + " " + name + " цена измнена на " + newPrice);
                break;
            } else if (models.length - 1 == a) {
                String err = String.format("Модель {0} не найдена! Изменение названия не выполнено!", name);
                throw new NoSuchModelNameException(err);
            }
        }

    }

    //метод, возвращающий массив названий всех моделей
    public String[] getArrayOfModelNames() {
        String[] arrayOfModelNames = new String[models.length];
        for (int a = 0; a < arrayOfModelNames.length; a++) {
            if (models[a] != null) {
                arrayOfModelNames[a] = models[a].name;
            }
        }
        return arrayOfModelNames;
    }

    //метод, возвращающий массив значений цен моделей
    public double[] getArrayOfModelPrice() {
        double[] arrayOfModelPrice = new double[models.length];
        for (int a = 0; a < arrayOfModelPrice.length; a++) {
            if (models[a] != null) {
                arrayOfModelPrice[a] = models[a].price;
            }
        }
        return arrayOfModelPrice;
    }

    //метод добавления названия модели и её цены (путем создания
    //нового массива Моделей), использовать метод Arrays.copyOf(),
    public void addNewModel(String name, double price)  {
        // Model[] copyModels = new Model[models.length + 1];

        for (int a = 0; a < models.length; a++) {
            if (models[a] != null && models[a].name.equals(name)) {
                String err = String.format("Модель {0} уже есть! Добавление не выполнено!", name);
                try {
                    throw new DuplicateModelNameException(err);
                } catch (DuplicateModelNameException e) {
                    e.printStackTrace();
                }
            }
        }

        if (price < 0) {
            String err = String.format("Новая цена меньше 0!", name);
            throw new ModelPriceOutOfBoundsException(err);
        }

        models = Arrays.copyOf(models, models.length + 1);
        models[models.length - 1] = new Model(name, price);

        System.out.println(getMark() + " " + name + " " + price + " добавлена!");

    }

    //метод для модификации значения названия модели
    public void editNameModel(String oldName, String newName) throws NoSuchModelNameException, DuplicateModelNameException {
        for (int a = 0; a < models.length; a++) {
            if (models[a] != null && models[a].name.equals(newName)) {
                String err = String.format("Модель {0} уже есть! Добавление не выполнено!", newName);
                throw new DuplicateModelNameException(err);
            }
        }
        for (int a = 0; a < models.length; a++) {
            if (models[a].name.equals(oldName)) {
                models[a].name = newName;
                System.out.println(getMark() + " " + oldName + " измнена на " + newName);
                break;
            } else if (models.length - 1 == a) {
                String err = String.format("Модель {0} не найдена! Изменение названия не выполнено!", oldName);
                throw new NoSuchModelNameException(err);
            }
        }

    }

    //метод удаления модели с заданным именем и её цены, использовать методы System.arraycopy, Arrays.copyOf(),
    public void deleteModelByNameAndPrice(String name, double price) throws NoSuchModelNameException {
        Model[] newModels;
        for (int a = 0; a < models.length; a++) {
            if (models[a].name.equals(name) && models[a].price == price) {
                if (models.length > 0) {
                    System.out.println(getMark() + " " + name + " " + price + " удалена!");
                    newModels = Arrays.copyOf(models, models.length - 1);
                    System.arraycopy(models, a + 1, newModels, a, newModels.length - a);
                    //System.arraycopy(models,2,newModels,1,3);
                    models = newModels;
                    break;
                }
            } else if (models.length - 1 == a) {
                String err = String.format("Модель {0} не найдена! Удаление не выполнено!", name);
                throw new NoSuchModelNameException(err);
            }
        }

    }

    //метод для получения размера массива Моделей
    public int getArrayModelLength() {
        return models.length;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Car result = (Car) super.clone();
        result.models = models.clone();
        for (int a = 0; a < models.length; a++) {
            result.models[a] = new Model(models[a].name, models[a].price);
        }
//            result.models[a].name = models[a].name;
//            result.models[a].price = models[a].price;
//        }
//        Car result = null;
//        try {
//            ByteArrayOutputStream writeBuffer = new ByteArrayOutputStream();
//            ObjectOutputStream outputStream  = new ObjectOutputStream(writeBuffer);
//            outputStream.writeObject(super.clone());
//            outputStream.close();
//            byte[] buffer = writeBuffer.toByteArray();
//            ByteArrayInputStream readBuffer = new ByteArrayInputStream(buffer);
//            ObjectInputStream inputStream = new ObjectInputStream(readBuffer);
//            result = (Car)inputStream.readObject();
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }


        return result;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return carMark.equals(car.carMark) &&
                Arrays.equals(models, car.models);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(carMark);
        result = 31 * result + Arrays.hashCode(models);
        return result;
    }

    static class Model implements Serializable {

        String name;
        double price;

        public Model(String name, double price) {
            this.name = name;
            this.price = price;
        }

        // метод печати в строку (паттерн итератор)
        @Override
        public String toString() {
            return "Model " + "name = " + name + ", price = " + price;
        }

    }

    public class AutoIterator implements Iterator, Serializable {

        int index = 0;

        @Override
        public boolean hasNext() {
            if (getArrayModelLength() > index)
                return true;
            else
                return false;
        }

        @Override
        public Object next() {
            if (hasNext()) {
                return models[index++];
            }
            else {
                index = 0;
            }
            return null;
        }

    }


}
