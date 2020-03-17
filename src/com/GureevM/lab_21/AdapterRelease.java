package com.GureevM.lab_21;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class AdapterRelease implements Adapter {
    @Override
    public OutputStream writeArrayToOutputStream(String[] array) {
        OutputStream outputStream = new ByteArrayOutputStream();
        try {
            for (int a = 0; a < array.length; a++) {
                byte[] buffer = array[a].getBytes();
                outputStream.write(buffer, 0, buffer.length);
            }
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return outputStream;
    }
}
