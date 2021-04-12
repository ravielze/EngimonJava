package com.engimon.common;

import java.io.IOException;
import java.util.List;

import com.opencsv.CSVReader;

public class DataReader {

    private CSVReader csv;
    private List<String[]> result;

    public DataReader(ResourceReader rr) {
        this.csv = new CSVReader(rr.getStreamReader());
        try {
            this.result = csv.readAll();
        } catch (IOException ex) {
            System.out.println("Unknown error when " + rr.getFilename() + " is loaded into data reader.");
        }
    }

    public final List<String[]> getResult() {
        return this.result;
    }

}
