package com.GureevM.lab_12;

import com.GureevM.lab_12.MyExeptions.DuplicateModelNameException;

public class AutoFactory implements TransportFactory {
    @Override
    public Transport createInstance(String mark, int size) throws DuplicateModelNameException {
        return  new Car(mark,size);
    }
}
