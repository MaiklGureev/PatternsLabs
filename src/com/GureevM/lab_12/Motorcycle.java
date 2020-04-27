package com.GureevM.lab_12;

import com.GureevM.lab_12.MyExeptions.DuplicateModelNameException;
import com.GureevM.lab_12.MyExeptions.ModelPriceOutOfBoundsException;
import com.GureevM.lab_12.MyExeptions.NoSuchModelNameException;
import com.GureevM.lab_13.Prototype;
import com.GureevM.lab_38.Visitor;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class Motorcycle implements Transport, Prototype, Serializable {

    private String motorcycleMark;
    private Model head = new Model();
    private int size = 0;

    {
        head.prev = head;
        head.next = head;
    }

    public Motorcycle(String name, int size) {
        try {
            setMark(name);
            setArraySize(size, 70);
        } catch (DuplicateModelNameException e) {
            e.printStackTrace();
        }
    }


    //метод для задания длины и заполнения
    public void setArraySize(int arraySize, double mediumPrice) throws DuplicateModelNameException {
        for (int a = 0; a < arraySize; a++) {
            String name = "motorcycle_" + a;
            double price = mediumPrice + new Random().nextInt((int) mediumPrice / 2);
            addNewModel(name, price);
        }
    }

    // (паттерн визитор)
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String getMark() {
        return motorcycleMark;
    }

    public void setMark(String mark) {
        this.motorcycleMark = mark;
    }

    //метод добавления названия модели и её цены
    public void addNewModel(String name, double price) throws DuplicateModelNameException {
        if (price < 0) {
            String err = String.format("Новая цена меньше 0!", name);
            throw new ModelPriceOutOfBoundsException(err);
        }
        if (head != null) {
            String[] models = getArrayOfModelNames();
            for (int a = 0; a < models.length; a++) {
                if (name.equals(models[a])) {
                    String err = String.format("Модель %s уже существует! Добавление не выполнено!", name);
                    throw new DuplicateModelNameException(err);
                }
            }
        }

        if (head.name == null) {
            head.name = name;
            head.price = price;
        } else {
            Model temp = new Model();
            temp.next = head;
            temp.prev = head.prev;
            head.prev = temp;
            temp.name = name;
            temp.price = price;
            head = temp;
            head.prev.next = head;
        }
        size++;

    }

    //метод для получения размера массива Моделей
    public int getArrayModelLength() {
        return size;
    }

    //метод, возвращающий массив названий всех моделей
    public String[] getArrayOfModelNames() {
        Model temp = head;
        String[] models = new String[size];

        int a = 0;
        while (a != size) {
            models[a] = temp.name;
            temp = temp.next;
            a++;
        }


        return models;
    }

    //метод, возвращающий массив значений цен моделей
    public double[] getArrayOfModelPrice() {
        Model temp = head;
        double[] prices = new double[size];
        int a = 0;
        while (a != size) {
            prices[a] = temp.price;
            temp = temp.next;
            a++;
        }
        return prices;
    }

    //метод для модификации значения цены модели по её названию
    public void editPriceByModelName(String name, double newPrice) throws NoSuchModelNameException {

        if (newPrice < 0) {
            String err = String.format("Новая цена < 0!", name);
            throw new ModelPriceOutOfBoundsException(err);
        }
        Model temp = head;
        for (int a = 0; a < size; a++) {
            if (temp.name.equals(name)) {
                temp.price = newPrice;
                System.out.println(getMark() + " " + name + " цена измнена на " + newPrice);
                break;
            } else if (a == size - 1) {
                String err = String.format("Модель {0} не найдена! Изменение названия не выполнено!", name);
                throw new NoSuchModelNameException(err);
            }
            temp = temp.next;
        }
        temp = temp.next;
    }

    //метод для получения значения цены модели по её названию
    public double getPriceByModelName(String name) throws NoSuchModelNameException {
        Model temp = head;
        for (int a = 0; a < size; a++) {
            if (temp.name.equals(name)) {
                return temp.price;
            } else if (a == size - 1) {
                String err = String.format("Модель {0} не найдена!", name);
                throw new NoSuchModelNameException(err);
            }
            temp = temp.next;
        }
        return 0;
    }

    //метод удаления модели с заданным именем и её цены
    public void deleteModelByNameAndPrice(String name, double price) throws NoSuchModelNameException {
        Model temp = head;
        if (size == 0)
            System.out.println("Список пуст! Ничего не удалено!");
        for (int a = 0; a < size; a++) {
            if (temp.name.equals(name)) {
                temp.name = null;
                temp.price = Double.NaN;
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
                System.out.println(getMark() + " " + name + " " + price + " удалена!");
                temp = temp.next;
                size--;
                break;
            } else if (a == size - 1) {
                String err = String.format("Модель {0} не найдена! Удаление не выполнено!", name);
                throw new NoSuchModelNameException(err);
            }
            temp = temp.next;
        }
    }

    //метод для модификации значения названия модели
    public void editNameModel(String oldName, String newName) throws NoSuchModelNameException, DuplicateModelNameException {

        String[] models = getArrayOfModelNames();
        for (int a = 0; a < models.length; a++) {
            if (newName.equals(models[a])) {
                String err = String.format("Модель %s уже существует! Добавление не выполнено!", newName);
                throw new DuplicateModelNameException(err);
            }
        }
        Model temp = head;

        for (int a = 0; a < size; a++) {
            if (temp.name.equals(oldName)) {
                temp.name = newName;
                break;
            } else if (a == size - 1) {
                String err = String.format("Модель %s не найдена! Изменение названия не выполнено!", oldName);
                throw new NoSuchModelNameException(err);
            }
            temp = temp.next;
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {

        Motorcycle motorcycle = (Motorcycle) super.clone();
        motorcycle.head = new Model(this.head.name, this.head.price);
        motorcycle.head.prev = motorcycle.head;
        motorcycle.head.next = motorcycle.head;
        motorcycle.size = 0;
        Model h = this.head.prev;
        for (int a = 0; a < size; a++) {
            try {
                motorcycle.addNewModel(h.name, h.price);
                h = h.prev;
            } catch (DuplicateModelNameException e) {
                e.printStackTrace();
            }
        }
        //   head = head.next;
        return motorcycle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Motorcycle that = (Motorcycle) o;
        return size == that.size &&
                motorcycleMark.equals(that.motorcycleMark) &&
                head.equals(that.head);
    }

    @Override
    public int hashCode() {
        return Objects.hash(motorcycleMark, head, size);
    }

    private class Model implements Serializable{
        String name = null;
        double price = Double.NaN;
        Model prev = null;
        Model next = null;

        public Model() {
        }

        public Model(String name, double price) {
            this.name = name;
            this.price = price;
        }
    }


}
