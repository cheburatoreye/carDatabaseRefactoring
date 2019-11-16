package com.company.cardatabaseproj.facade;
import com.company.cardatabaseproj.database.Car;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

public interface UserFacade {
    List save();
    Collection<Car> getAll();
    List select(String valuefirst, String valuesecond, boolean string, String typeofdata);
    void DatabaseInit() throws IOException, ClassNotFoundException;
    void databaseSave() throws IOException, ClassNotFoundException;
    void redactCar(String correct,String vin) throws IOException, ClassNotFoundException;
    List searchByYear();
    List searchByMileage();
    List searchByPrice();
    List searchByMarkModel();
    List searchByMark();
    boolean deleteByValue(String value) throws IOException;


}
