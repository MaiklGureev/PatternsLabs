package com.GureevM.lab_12;

import com.GureevM.lab_12.MyExeptions.DuplicateModelNameException;
import com.GureevM.lab_12.MyExeptions.ModelPriceOutOfBoundsException;
import com.GureevM.lab_12.MyExeptions.NoSuchModelNameException;
import com.GureevM.lab_38.Visitor;

public interface Transport {
        void accept(Visitor visitor);
        String getMark();
        void setMark(String mark);
        void addNewModel(String name, double price) throws DuplicateModelNameException;
        double getPriceByModelName(String name) throws NoSuchModelNameException;
        void editPriceByModelName(String name, double newPrice) throws NoSuchModelNameException;
        String[] getArrayOfModelNames();
        double[] getArrayOfModelPrice();
        void deleteModelByNameAndPrice(String name, double price) throws NoSuchModelNameException;
        void editNameModel(String  oldName, String newName) throws NoSuchModelNameException, DuplicateModelNameException;
        int getArrayModelLength();
}
