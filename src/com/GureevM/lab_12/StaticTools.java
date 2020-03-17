package com.GureevM.lab_12;

import com.GureevM.lab_12.MyExeptions.DuplicateModelNameException;
import com.GureevM.lab_22.TransportDecorator;

public class StaticTools {

    //private static Transport transport;
    private static TransportFactory transportFactory = new AutoFactory();


    public static TransportFactory getTransportFactory() {
        return transportFactory;
    }

    public static Transport createInstnce(String  name, int size) throws DuplicateModelNameException {
       return  transportFactory.createInstance(name,size);
    }

    public static double getAveragePrice(Transport transport) {
        double[] prices = transport.getArrayOfModelPrice();
        double average = 0;
        if (prices.length != 0) {
            for (int a = 0; a < prices.length; a++) {
                average += prices[a];
            }
            average /= prices.length;
        } else {
            return -1;
        }
        return average;
    }

    public static  void printModelsAndPrices(Transport transport){
        double[] prices = transport.getArrayOfModelPrice();
        String[] names = transport.getArrayOfModelNames();
        int size = transport.getArrayModelLength();
        System.out.println("Марка: "+transport.getMark());
        System.out.println("Количество моделей: "+size);
        for (int a = 0; a < size; a++) {
            String n = names[a];
            double p = prices [a];
            System.out.println(String.format((a+1)+" Модель: %s, стоймость: %s",n,p));
        }
    }

//    public static void setTransportFactory(String type, String name, int size) throws DuplicateModelNameException {
//        transport = (type == "car") ? new Car(name, size) : new Motorcycle(name, size);
//    }
//
    public static void setTransportFactory(TransportFactory factory) throws DuplicateModelNameException {
        transportFactory = factory;
    }

    public Transport synchronizedTransport (Transport t){
        return new TransportDecorator(t);
    }

}
