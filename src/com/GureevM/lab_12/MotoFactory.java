package com.GureevM.lab_12;

import com.GureevM.lab_12.MyExeptions.DuplicateModelNameException;

public class MotoFactory implements TransportFactory {
    @Override
    public Transport createInstance(String mark, int size) throws DuplicateModelNameException {
        return new Motorcycle(mark,size);
    }
}
