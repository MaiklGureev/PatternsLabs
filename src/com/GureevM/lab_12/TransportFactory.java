package com.GureevM.lab_12;

import com.GureevM.lab_12.MyExeptions.DuplicateModelNameException;

public interface TransportFactory {
    Transport createInstance(String mark, int size) throws DuplicateModelNameException;
}

