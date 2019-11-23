package com.company.cardatabaseproj.facade;
import com.company.cardatabaseproj.database.Car;
import com.company.cardatabaseproj.enums.DataTypeEnum;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

public interface UserFacade {
    List<Car> save();
    Collection<Car> getAll();
    List<Car> read(String valuefirst, String valuesecond, boolean string, DataTypeEnum typeofdata);
    void DatabaseInit() throws IOException, ClassNotFoundException;
    void databaseSave() throws IOException, ClassNotFoundException;
    void redactCar(String correct,String vin) throws IOException, ClassNotFoundException;
    List<Car> searchByYear();
    List<Car> searchByMileage();
    List<Car> searchByPrice();
    List<Car> searchByMarkModel();
    List<Car> searchByMark();
    boolean deleteByValue(String value) throws IOException;


}
