package com.company.cardatabaseproj.service;
import com.company.cardatabaseproj.builder.CarConstructor;
import com.company.cardatabaseproj.crud.CrudDatabase;
import com.company.cardatabaseproj.crud.CrudDatabaseMethods;
import com.company.cardatabaseproj.database.Car;


import java.io.IOException;
import java.util.*;

public class CarServiceMethods implements CarService {
   private Scanner sc=new Scanner(System.in);

    private static  final CarService service =new CarServiceMethods();
    private CarServiceMethods(){}
    public static final CarService getInstance(){
        return service;
    }

    private CrudDatabase crudDatabase= CrudDatabaseMethods.getInstance();

    @Override
    public Car create() {
        CarConstructor carConstructor=CarConstructor.getInstance();
        Car car=carConstructor.buildCar();
        crudDatabase.create(car);
        return car;
    }

    @Override
    public Collection<Car> list() {
        return crudDatabase.list();
    }

    @Override
    public List read(String valuefirst, String valuesecond,boolean string,String typeofdata) {
        return crudDatabase.read(valuefirst,valuesecond,string,typeofdata);
    }

    @Override
    public boolean delete(String valuefirst, String valuesecond,boolean string, String typeofdata) {
        crudDatabase.delete(valuefirst,valuesecond,string,typeofdata);
        return true;
    }

    @Override
    public Car update(String vin) {
        CarConstructor carConstructor=CarConstructor.getInstance();
       return crudDatabase.update(carConstructor.buildCar());
    }

    @Override
    public void databaseInit() throws IOException, ClassNotFoundException {
    crudDatabase.databaseInit();
    }

    @Override
    public void databaseSave() throws IOException {
        crudDatabase.databaseSave();
    }

    @Override
    public void redactNumber(String vin) {
        String number;
        List list =crudDatabase.read(vin,"empty",true,"any");
        ListIterator listIter = list.listIterator();

        while(listIter.hasNext()){
            Car car=(Car)listIter.next();
            if (car.getVin().equals(vin)) {
                System.out.println("current number " + car.getNumber());
                System.out.println("Enter new number");
                car.setNumber(number = sc.next());
                System.out.println("Entered new number " + number);
                crudDatabase.update(car);
            }
        }
    }

    @Override
    public void redactMark(String vin) {
        String mark;
        List list =crudDatabase.read(vin,"empty",true,"any");
        ListIterator listIter = list.listIterator();

        while(listIter.hasNext()){
            Car car=(Car)listIter.next();
            if (car.getVin().equals(vin)) {
                System.out.println("current mark " + car.getMark());
                System.out.println("Enter new mark");
                car.setMark(mark = sc.next());
                System.out.println("Entered new mark " + mark);
                crudDatabase.update(car);
            }
        }
    }

    @Override
    public void redactModel(String vin) {
        String model;
        List list =crudDatabase.read(vin,"empty",true,"any");
        ListIterator listIter = list.listIterator();

        while(listIter.hasNext()){
            Car car=(Car)listIter.next();
            if (car.getVin().equals(vin)) {
                System.out.println("current model " + car.getModel());
                System.out.println("Enter new model");
                car.setModel(model = sc.next());
                System.out.println("Entered new model " + model);
                crudDatabase.update(car);
            }
        }
    }

    @Override
    public void redactMileage(String vin) {
        String mileage;
        List list =crudDatabase.read(vin,"empty",true,"any");
        ListIterator listIter = list.listIterator();

        while(listIter.hasNext()){
            Car car=(Car)listIter.next();
            if (car.getVin().equals(vin)) {
                System.out.println("current mileage " + car.getMileage());
                System.out.println("Enter new mileage");
                car.setMileage(mileage = sc.next());
                System.out.println("Entered new mileage " + mileage);
                crudDatabase.update(car);
            }
        }
    }

    @Override
    public void redactYear(String vin) {
        String year;
        List list =crudDatabase.read(vin,"empty",true,"any");
        ListIterator listIter = list.listIterator();

            while(listIter.hasNext()){
                Car car=(Car)listIter.next();
                if (car.getVin().equals(vin)){
                    System.out.println("current year "+car.getYear());
                    System.out.println("Enter new year");
                    car.setYear(year=sc.next());
                    System.out.println("Entered new year "+year);
                    crudDatabase.update(car);
                }
            }
        }

    @Override
    public void redactColor(String vin) {
        String color;
        List list =crudDatabase.read(vin,"empty",true,"any");
        ListIterator listIter = list.listIterator();

        while(listIter.hasNext()){
            Car car=(Car)listIter.next();
            if (car.getVin().equals(vin)){
                System.out.println("current color "+car.getColor());
                System.out.println("Enter new color");
                car.setColor(color=sc.next());
                System.out.println("Entered new color "+color);
                crudDatabase.update(car);
            }
        }
    }

    @Override
    public void redactBody(String vin) {
        String body;
        List list =crudDatabase.read(vin,"empty",true,"any");
        ListIterator listIter = list.listIterator();

        while(listIter.hasNext()){
                Car car = (Car) listIter.next();
            if (car.getVin().equals(vin)) {
                System.out.println("current body " + car.getBody());
                System.out.println("Enter new body");
                car.setBody(body = sc.next());
                System.out.println("Entered new body " + body);
                crudDatabase.update(car);
            }
        }
    }

    @Override
    public void redactPrice(String vin) {
        String price;
        List list =crudDatabase.read(vin,"empty",true,"any");
        ListIterator listIter = list.listIterator();

        while(listIter.hasNext()){
            Car car=(Car)listIter.next();
            if (car.getVin().equals(vin)) {
                System.out.println("current price " + car.getPrice());
                System.out.println("Enter new price");
                car.setPrice(price = sc.next());
                System.out.println("Entered new price " + price);
                crudDatabase.update(car);
            }
        }
    }
}
