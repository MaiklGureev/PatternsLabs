package com.GureevM.lab_38;

import com.GureevM.lab_12.Car;
import com.GureevM.lab_12.Motorcycle;
import com.GureevM.lab_12.Transport;

public interface Visitor {
        void visit(Car car);
        void visit(Motorcycle car);
}
