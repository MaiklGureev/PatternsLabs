package com.GureevM;

import com.GureevM.lab_11.Singleton;
import com.GureevM.lab_12.*;
import com.GureevM.lab_12.MyExeptions.DuplicateModelNameException;
import com.GureevM.lab_12.MyExeptions.NoSuchModelNameException;
import com.GureevM.lab_13.Prototype;
import com.GureevM.lab_21.Adapter;
import com.GureevM.lab_21.AdapterRelease;
import com.GureevM.lab_22.TransportDecorator;

import java.io.OutputStream;
import java.util.Arrays;
import java.util.Properties;

public class Main {

    public static void main(String[] args) throws NoSuchModelNameException, DuplicateModelNameException, CloneNotSupportedException {

        //Разработка приложения с использованием паттерна Singleton
//        Singleton singleton = Singleton.getInstance();
//        Properties properties = singleton.getProperties();
//        String n = properties.getProperty("name");
//        String ln = properties.getProperty("last_name");
//        System.out.println(n + " " + ln);

        //Разработка приложения с использованием паттерна Factory Method
        //Transport car = new Car("Lada",10);
//        Transport car = new Motorcycle("Moto",10);
//        System.out.println(car.getMark());
//
//        car.addNewModel("калина",15);
//        car.addNewModel("приора",20);
//        car.addNewModel("веста",35);
//        car.addNewModel("иксРей",50);
//        car.addNewModel("гранта",30);
//
//        car.editNameModel("гранта","rfkbyf");
//        car.editPriceByModelName("иксРей",120);
//        System.out.println(car.getPriceByModelName("веста"));
//        System.out.println(Arrays.toString(car.getArrayOfModelNames()));
//        System.out.println(Arrays.toString(car.getArrayOfModelPrice()));
//        car.deleteModelByNameAndPrice("приора",20);
//        car.deleteModelByNameAndPrice("калина",15);
//        System.out.println("Добавляем машину!");
//        car.addNewModel("kalinaSport",70);
//        System.out.println("Удаляем машину!");
//        car.deleteModelByNameAndPrice("веста",35);
//        System.out.println(Arrays.toString(car.getArrayOfModelNames()));
//        System.out.println(Arrays.toString(car.getArrayOfModelPrice()));
//        System.out.println("Количество моделей " + car.getArrayModelLength());

//        Motorcycle motorcycle = new Motorcycle("YAMAXA",10);
//        System.out.println(motorcycle.getMark());
//        motorcycle.setMark("YAMAXA_2000");
//        motorcycle.deleteModelByNameAndPrice("das",423);
//        motorcycle.addNewModel("A21",100);
//        motorcycle.addNewModel("N43",50);
//        motorcycle.addNewModel("B2",40);
//        motorcycle.addNewModel("LC32",60);
//        motorcycle.addNewModel("MM43",80);
//        System.out.println("Количество моделей " + motorcycle.getArrayModelLength());
//        System.out.println(Arrays.toString(motorcycle.getArrayOfModelNames()));
//        System.out.println(Arrays.toString(motorcycle.getArrayOfModelPrice()));
//        motorcycle.editPriceByModelName("A21",99);
//        System.out.println(Arrays.toString(motorcycle.getArrayOfModelNames()));
//        System.out.println(Arrays.toString(motorcycle.getArrayOfModelPrice()));
//        System.out.println(motorcycle.getMark()+ " B2 цена = "+motorcycle.getPriceByModelName("B2"));
//        motorcycle.deleteModelByNameAndPrice("B2",40);
//        System.out.println(Arrays.toString(motorcycle.getArrayOfModelNames()));
//        System.out.println(Arrays.toString(motorcycle.getArrayOfModelPrice()));
//        transport.addNewModel("G23",200);
//        transport.addNewModel("H65",300);
//        transport.addNewModel("D77",250);
//        transport.addNewModel("J45",110);
//        transport.addNewModel("L11",220);
//        StaticTools.setTransportFactory("car","VETEROK",10);
//        setTransportFactory("moto");
//        transport.editPriceByModelName("G23",99);
//        transport.editPriceByModelName("G2300",99);
//        transport.deleteModelByNameAndPrice("H65",300);
//        transport.deleteModelByNameAndPrice("H6500",300);
//        transport.getPriceByModelName("D77");

//        Transport tr = StaticTools.createInstnce("hgjhghgj",2);
//        System.out.println(tr.getClass());
//        StaticTools.setTransportFactory(new MotoFactory());
//        Transport tr2 = StaticTools.createInstnce("4334343",2);
//        System.out.println(tr2.getClass());
        // StaticTools.printModelsAndPrices();
//        StaticTools.setTransportFactory("moto");
//        StaticTools.printModelsAndPrices();
//        System.out.println("Средняя цена: "+StaticTools.getAveragePrice());

//        Car car =  new Car("DefaultCar",10);
//        Car cloneCar = (Car) car.clone();
//        cloneCar.editNameModel("car_0","changedCar");
//
//
//        if(car.equals(cloneCar)){
//            System.out.println(true);
//        }
//        else {
//            System.out.println(false);
//        }
//
//        System.out.println(car.hashCode());
//        System.out.println(Arrays.toString(car.getArrayOfModelNames()));
//        System.out.println(Arrays.toString(car.getArrayOfModelPrice()));
//
//        System.out.println(cloneCar.hashCode());
//        System.out.println(Arrays.toString(cloneCar.getArrayOfModelNames()));
//        System.out.println(Arrays.toString(cloneCar.getArrayOfModelPrice()));
//
//
//        Motorcycle moto = new Motorcycle("DefaultMoto", 5);
//
//        Motorcycle cloneMoto = (Motorcycle) moto.clone();
//        cloneMoto.editNameModel("motorcycle_0", "changedMoto");
//        cloneMoto.editPriceByModelName("changedMoto", 1000);
//        System.out.println("changedMoto " + cloneMoto.getPriceByModelName("changedMoto"));
//        cloneMoto.deleteModelByNameAndPrice("changedMoto",1000);
//        //  cloneMoto.addNewModel("ghgj", 9);
//
//        System.out.println("Сравним объекты...");
//
//        if (moto.equals(cloneMoto)) {
//            System.out.println(true);
//        } else {
//            System.out.println(false);
//        }
//
//        System.out.println(moto.hashCode());
//        System.out.println(Arrays.toString(moto.getArrayOfModelNames()));
//        System.out.println(Arrays.toString(moto.getArrayOfModelPrice()));
//
//        System.out.println(cloneMoto.hashCode());
//        System.out.println(Arrays.toString(cloneMoto.getArrayOfModelNames()));
//        System.out.println(Arrays.toString(cloneMoto.getArrayOfModelPrice()));

//        //2.1	Разработка приложения с использованием паттерна Adapter
//        Car car = new Car("DefaultMark",10);
//        Adapter adapter = new AdapterRelease();
//        OutputStream temp = adapter.writeArrayToOutputStream(car.getArrayOfModelNames());
//        System.out.println(temp.toString());

        //2.2 Разработка приложения с использованием паттерна Decorator

    }


}
