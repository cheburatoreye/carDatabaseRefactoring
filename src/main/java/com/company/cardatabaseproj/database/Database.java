package com.company.cardatabaseproj.database;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;
import java.util.*;

public class Database {
    private int fileid=0;//для имен файлов json
    private final Map<String, Car> cars = new HashMap<>();
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

    public Car update(Car car) {
        cars.put(car.getVin(), car);
        return car;
    }

    public boolean delete(String valuefirst, String valuesecond, boolean string, String typeofdata) {
        Car car;

        if (string) {
            switch (typeofdata) {
                case "any": {
                    Iterator it = cars.entrySet().iterator();
                    while (it.hasNext()) {
                        Map.Entry pair = (Map.Entry)it.next();
                        car=(Car)pair.getValue();
                        if (car.getNumber().equals(valuefirst)|car.getMark().equals(valuefirst)|car.getModel().equals(valuesecond)|car.getVin().equals(valuefirst)){
                            it.remove();
                        }
                    }
                    break;
                }
                case "markmodel": {
                    Iterator it = cars.entrySet().iterator();
                    while (it.hasNext()) {
                        Map.Entry pair = (Map.Entry)it.next();
                        car=(Car)pair.getValue();
                        if (car.getMark().equals(valuefirst)&car.getModel().equals(valuesecond)){
                            it.remove();
                        }
                    }
                    break;
                }
            }

        } else {
            switch (typeofdata) {
                case "year": {
                    for (int i = Integer.valueOf(valuefirst); i <= Integer.valueOf(valuesecond); i++) {
                        Iterator it = cars.entrySet().iterator();
                        while (it.hasNext()) {
                            Map.Entry pair = (Map.Entry)it.next();
                            car=(Car)pair.getValue();
                            if (car.getYear().equals(String.valueOf(i))){
                                it.remove();
                            }
                        }
                    }


                    break;
                }
                case "mileage": {
                    for (int i = Integer.valueOf(valuefirst); i <= Integer.valueOf(valuesecond); i++) {
                        Iterator it = cars.entrySet().iterator();
                        while (it.hasNext()) {
                            Map.Entry pair = (Map.Entry)it.next();
                            car=(Car)pair.getValue();
                            if (car.getMileage().equals(String.valueOf(i))){
                                it.remove();
                            }
                        }
                    }
                    break;
                }
                case "price": {
                    for (int i = Integer.valueOf(valuefirst); i <= Integer.valueOf(valuesecond); i++) {
                        Iterator it = cars.entrySet().iterator();
                        while (it.hasNext()) {
                            Map.Entry pair = (Map.Entry)it.next();
                            car=(Car)pair.getValue();
                            if (car.getPrice().equals(String.valueOf(i))){
                                it.remove();
                            }
                        }
                    }
                    break;
                }
                case "all": {
                  cars.clear();
                  System.out.println("database cleared");
                    break;
                }
            }
        }
        return true;
    }

    public List read(String valuefirst,String valuesecond,boolean string,String typeofdata ){
        list.clear();
        if (string){
            switch (typeofdata){
                case"any":{
                    for (Map.Entry<String,Car> entry : cars.entrySet()){
                        if (entry.getValue().getNumber().equals(valuefirst)|entry.getValue().getMark().equals(valuefirst)|entry.getValue().getModel().equals(valuesecond)|entry.getValue().getVin().equals(valuefirst)){
                            list.add(cars.get(entry.getKey()));
                        }
                    }
                    break;
                }
                case"markmodel":{
                    for (Map.Entry<String,Car> entry : cars.entrySet()){
                        if (entry.getValue().getMark().equals(valuefirst)&entry.getValue().getModel().equals(valuesecond)){
                            list.add(cars.get(entry.getKey()));
                        }
                    }
                    break;
                }
            }

        }
        else {
            switch (typeofdata){
                case "year":{
                    for (int i=Integer.valueOf(valuefirst);i<=Integer.valueOf(valuesecond);i++){
                        for (Map.Entry<String,Car> entry : cars.entrySet()){
                            if (entry.getValue().getYear().equals(String.valueOf(i))){
                                list.add(cars.get(entry.getKey()));
                            }
                        }
                    }
                    break;
                }
                case "mileage":{
                    for (int i=Integer.valueOf(valuefirst);i<=Integer.valueOf(valuesecond);i++){
                        for (Map.Entry<String,Car> entry : cars.entrySet()){
                            if (entry.getValue().getMileage().equals(String.valueOf(i))){
                                list.add(cars.get(entry.getKey()));
                            }
                        }
                    }
                    break;
                }
                case "price":{
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

        File file =new File(".");
        file.mkdir();
        String json[]=file.list((f,name)->name.matches("([a-zA-Z0-9\\s_\\\\.\\-\\(\\):])+(.json)$"));

        ObjectMapper objectMapper=new ObjectMapper();
        for (String item:json) {
            System.out.println(item);
            FileInputStream in=new FileInputStream(item);
            Car car=objectMapper.readValue(in,Car.class);
            cars.put(car.getVin(),car);
        }

    }

    public void databaseSave() throws IOException {
        File file =new File(".");
        String json[]=file.list((f,name)->name.matches("([a-zA-Z0-9\\s_\\\\.\\-\\(\\):])+(.json)$"));

        ObjectMapper objectMapper=new ObjectMapper();
        for (Map.Entry<String,Car> entry : cars.entrySet()){
            fileid=fileid+1;
            FileOutputStream out=new FileOutputStream(fileid + ".json");
            out.write(objectMapper.writeValueAsBytes(entry.getValue()));

        }
        fileid=0;
    }

}
