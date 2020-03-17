package com.GureevM.lab_21;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

public interface Adapter {
    OutputStream writeArrayToOutputStream(String[] array);
}
