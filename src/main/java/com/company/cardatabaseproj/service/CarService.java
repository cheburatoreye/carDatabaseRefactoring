package com.company.cardatabaseproj.service;
import com.company.cardatabaseproj.database.Car;
import com.company.cardatabaseproj.database.Database;
import com.company.cardatabaseproj.enums.DataTypeEnum;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

public interface CarService {
    Car create();
    Collection<Car> list();
    List<Car> read(String valuefirst, String valuesecond, boolean string, DataTypeEnum typeofdata);
    boolean delete(String valuefirst, String valuesecond, boolean string, DataTypeEnum typeofdata);
    Car update(String vin);
    void redactNumber(String vin);
    void redactMark(String vin);
    void redactModel(String vin);
    void redactMileage(String vin);
    void redactYear(String vin);
    void redactColor(String vin);
    void redactBody(String vin);
    void redactPrice(String vin);
    void databaseInit() throws IOException, ClassNotFoundException;
    void databaseSave() throws IOException;
}
