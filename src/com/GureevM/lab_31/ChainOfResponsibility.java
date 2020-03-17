package com.GureevM.lab_31;

import com.GureevM.lab_12.Transport;

public interface ChainOfResponsibility {
    void printToTXTFile(Transport transport);
    void setNextInChain(ChainOfResponsibility nextInChain);

}
