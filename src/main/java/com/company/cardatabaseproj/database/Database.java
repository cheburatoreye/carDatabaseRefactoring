package com.company.cardatabaseproj.database;
import com.company.cardatabaseproj.enums.DataTypeEnum;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;



import java.io.*;
import java.util.*;

public class Database {
    private   final  Map<String,Car > cars = new HashMap<>();
    private List<Car> list = new ArrayList<>();//для возврата пользователю данных в виде списка
    public void insert(Car car) {
        if (car == null) return;
        cars.put(car.getVin(), car);
    }
    private Database() {
    }
    private static class Helper{
        private  static  final Database instance=new Database();
    }
    public static Database getInstance(){
        return  Helper.instance;
    }
    private  ObjectMapper objectMapper=new ObjectMapper();


    public Car update(Car car) {
        cars.put(car.getVin(),car);
        return car;
    }

    public boolean delete(String valuefirst, String valuesecond, boolean string, DataTypeEnum typeofdata) {
        Car car;

        if (string) {
            switch (typeofdata) {
                case any: {
                    Iterator<Map.Entry<String,Car>> it = cars.entrySet().iterator();
                    while (it.hasNext()) {
                        Map.Entry<String,Car> pair = it.next();
                        car=pair.getValue();
                        if (car.getNumber().equals(valuefirst)||car.getMark().equals(valuefirst)||car.getModel().equals(valuesecond)|car.getVin().equals(valuefirst)){
                            it.remove();
                        }
                    }
                    break;
                }
                case markmodel: {
                    Iterator<Map.Entry<String,Car>> it = cars.entrySet().iterator();
                    while (it.hasNext()) {
                        Map.Entry<String,Car> pair = it.next();
                        car=pair.getValue();
                        if (car.getMark().equals(valuefirst)&&car.getModel().equals(valuesecond)){
                            it.remove();
                        }
                    }
                    break;
                }
            }

        } else {
            switch (typeofdata) {
                case year: {
                    for (int i = Integer.valueOf(valuefirst); i <= Integer.valueOf(valuesecond); i++) {
                        Iterator<Map.Entry<String,Car>> it = cars.entrySet().iterator();
                        while (it.hasNext()) {
                            Map.Entry<String,Car> pair = it.next();
                            car=pair.getValue();
                            if (car.getYear().equals(String.valueOf(i))){
                                it.remove();
                            }
                        }
                    }


                    break;
                }
                case mileage: {
                    for (int i = Integer.valueOf(valuefirst); i <= Integer.valueOf(valuesecond); i++) {
                        Iterator<Map.Entry<String,Car>> it = cars.entrySet().iterator();
                        while (it.hasNext()) {
                            Map.Entry<String,Car> pair = it.next();
                            car=pair.getValue();
                            if (car.getMileage().equals(String.valueOf(i))){
                                it.remove();
                            }
                        }
                    }
                    break;
                }
                case price: {
                    for (int i = Integer.valueOf(valuefirst); i <= Integer.valueOf(valuesecond); i++) {
                        Iterator<Map.Entry<String,Car>> it = cars.entrySet().iterator();
                        while (it.hasNext()) {
                            Map.Entry<String,Car> pair = it.next();
                            car=pair.getValue();
                            if (car.getPrice().equals(String.valueOf(i))){
                                it.remove();
                            }
                        }
                    }
                    break;
                }
                case all: {
                  cars.clear();
                  System.out.println("database cleared");
                    break;
                }
            }
        }
        return true;
    }

    public List<Car> read(String valuefirst, String valuesecond, boolean string, DataTypeEnum typeofdata ){
        list.clear();
        if (string){
            switch (typeofdata){
                case any:{
                    for (Map.Entry<String,Car> entry : cars.entrySet()){
                        if (entry.getValue().getNumber().equals(valuefirst)||entry.getValue().getMark().equals(valuefirst)||
                                entry.getValue().getModel().equals(valuesecond)||entry.getValue().getVin().equals(valuefirst)){
                            list.add(cars.get(entry.getKey()));
                        }
                    }
                    break;
                }
                case markmodel:{
                    for (Map.Entry<String,Car> entry : cars.entrySet()){
                        if (entry.getValue().getMark().equals(valuefirst)&&entry.getValue().getModel().equals(valuesecond)){
                            list.add(cars.get(entry.getKey()));
                        }
                    }
                    break;
                }
            }

        }
        else {
            switch (typeofdata){
                case year:{
                    for (int i=Integer.valueOf(valuefirst);i<=Integer.valueOf(valuesecond);i++){
                        for (Map.Entry<String,Car> entry : cars.entrySet()){
                            if (entry.getValue().getYear().equals(String.valueOf(i))){
                                list.add(cars.get(entry.getKey()));
                            }
                        }
                    }
                    break;
                }
                case mileage:{
                    for (int i=Integer.valueOf(valuefirst);i<=Integer.valueOf(valuesecond);i++){
                        for (Map.Entry<String,Car> entry : cars.entrySet()){
                            if (entry.getValue().getMileage().equals(String.valueOf(i))){
                                list.add(cars.get(entry.getKey()));
                            }
                        }
                    }
                    break;
                }
                case price:{
                    for (int i=Integer.valueOf(valuefirst);i<=Integer.valueOf(valuesecond);i++){
                        for (Map.Entry<String,Car> entry : cars.entrySet()){
                            if (entry.getValue().getPrice().equals(String.valueOf(i))){
                                list.add(cars.get(entry.getKey()));
                            }
                        }
                    }
                    break;
                }
            }

        }

        return list;
    }

    public Collection<Car> getAll(){
        return cars.values();
    }

    public void databaseInit() throws IOException {
        File jsonFile = new File("map.json");
        cars.putAll(objectMapper.readValue(jsonFile, new TypeReference<Map<String, Car>>() {}));
    }

    public void databaseSave() throws IOException {
        objectMapper.writeValue(new File("map.json"), cars);
    }



}


