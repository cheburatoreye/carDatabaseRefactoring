package com.company.cardatabaseproj.crud;


import com.company.cardatabaseproj.database.Car;
import com.company.cardatabaseproj.enums.DataTypeEnum;

import java.io.IOException;
import java.util.Collection;
import java.util.List;


public interface CrudDatabase {

    Car create(Car car) ;
    List<Car> read(String valuefirst, String valuesecond, boolean string, DataTypeEnum typeofdata);
    Collection<Car> list();
    boolean delete(String valuefirst, String valuesecond, boolean string, DataTypeEnum typeofdata);
    Car update(Car car);
    void databaseInit() throws IOException, ClassNotFoundException;
    void databaseSave() throws IOException;
}
