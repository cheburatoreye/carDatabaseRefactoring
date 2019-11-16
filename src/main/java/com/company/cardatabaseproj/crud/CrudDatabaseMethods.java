package com.company.cardatabaseproj.crud;
import com.company.cardatabaseproj.database.Car;
import com.company.cardatabaseproj.database.Database;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

public class CrudDatabaseMethods implements CrudDatabase {

    private  static  CrudDatabase db=new CrudDatabaseMethods();
    private CrudDatabaseMethods(){}
    public  static final CrudDatabase getInstance(){
        return db;
    }

    private Database database=Database.getInstance();

    @Override
    public Car create(Car car) {
        database.insert(car);
        return car;
    }

    @Override
    public List read(String valuefirst, String valuesecond,boolean string, String typeofdata) {
        return database.read( valuefirst,  valuesecond, string,typeofdata);
    }

    @Override
    public Collection<Car> list() {
        return database.getAll();
    }

    @Override
    public boolean delete(String valuefirst,String valuesecond,boolean string, String typeofdata) {
       return database.delete(valuefirst,valuesecond,string,typeofdata);
    }

    @Override
    public Car update(Car car) {
       return database.update(car);
    }

    @Override
    public void databaseInit() throws IOException, ClassNotFoundException {
        database.databaseInit();
    }

    @Override
    public void databaseSave() throws IOException {
       database.databaseSave();
    }
}
