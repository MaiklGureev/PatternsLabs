package com.GureevM.lab_32;

import com.GureevM.lab_12.Transport;

import java.io.FileWriter;
import java.io.OutputStream;

public interface Command {
    boolean printToTXTFile(Transport transport, FileWriter writer);
}
