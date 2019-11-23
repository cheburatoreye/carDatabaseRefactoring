package com.company.cardatabaseproj.builder;

import com.company.cardatabaseproj.database.Car;
import com.company.cardatabaseproj.enums.DataTypeEnum;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CarConstructor {
    private static class Helper{
        private  static  final CarConstructor carConstructor =new CarConstructor();
    }

    private CarConstructor(){}
    public  static  final  CarConstructor getInstance(){
        return  Helper.carConstructor;
    }

    private Scanner sc=new Scanner(System.in);

    private String getFromUser(DataTypeEnum datatype){
        Pattern p;
        Matcher m;
        String value;//value used to return entered string inside builder
        switch (datatype){
            case vin:{
                boolean repeat=false;
                do {
                    if (repeat){
                        System.out.println("try again format:1 digit,10 letter or digits,6 digits ");
                    }
                    else {
                        System.out.println("type vin for example '5JDHFY49FEO132654' or 0 to quit");
                    }
                    p= Pattern.compile("^[0-9]{1}+[A-Z&0-9]{10}+[0-9]{6}$");
                    m=p.matcher(value=sc.next());
                    repeat=true;
                    if (value.equals("0")){
                        value="empty";
                        break;
                    }
                }while (!m.find());
                m.reset();

                return value;
            }
            case number:{
                boolean repeat=false;
                do {
                    if (repeat){
                        System.out.println("try again format:2 letters,4 digits,2 digits ");
                    }
                    else {
                        System.out.println("type number for example 'ВН3265АР' or 0 to quit");
                    }
                    p= Pattern.compile("^[A-Z]{2}+[0-9]{4}+[A-Z]{2}|[А-Я]{2}+[0-9]{4}+[А-Я]{2}$");
                    m=p.matcher(value=sc.next());
                    repeat=true;
                    if (value.equals("0")){
                        value="empty";
                        break;
                    }
                }while (!m.find());
                m.reset();

                return value;
            }
            case year:{
                boolean repeat=false;
                do {
                    if (repeat){
                        System.out.println("try again format:4 digits");
                    }
                    else {
                        System.out.println("type year only digits or 0 to quit");
                    }
                    p= Pattern.compile("^[0-9]{4}$");
                    m=p.matcher(value=sc.next());
                    repeat=true;
                    if (value.equals("0")){
                        value="empty";
                        break;
                    }
                }while (!m.find());
                m.reset();
                if (!value.equals("empty"))
                    if (Integer.valueOf(value)> LocalDate.now().getYear()){
                        System.out.println("Current year is "+LocalDate.now().getYear()+"  entered year: "+value);
                    }
                return value;
            }
            case mileage:{

                do {
                    p= Pattern.compile("^\\d+$");
                    System.out.println("type mileage only digits or 0 to quit");
                    m=p.matcher(value=sc.next());
                    if (value.equals("0")){
                        value="empty";
                        break;
                    }
                }while (!m.find());
                m.reset();

                return value;
            }
            case mark:{
                do {
                    p= Pattern.compile("^\\w+$");
                    System.out.println("type mark only chars or 0 to quit");
                    m=p.matcher(value=sc.next());
                    if (value.equals("0")){
                        value="empty";
                        break;
                    }
                }while (!m.find());
                m.reset();

                return value;
            }
            case model:{
                do {
                    p= Pattern.compile("^\\w+$");
                    System.out.println("type model only chars or 0 to quit");
                    m=p.matcher(value=sc.next());
                    if (value.equals("0")){
                        value="empty";
                        break;
                    }
                }while (!m.find());
                m.reset();

                return value;
            }
            case color:{
                do {
                    p= Pattern.compile("^\\w+$");
                    System.out.println("type color only chars or 0 to quit");
                    m=p.matcher(value=sc.next());
                    if (value.equals("0")){
                        value="empty";
                        break;
                    }
                }while (!m.find());
                m.reset();

                return value;
            }
            case body:{
                do {
                    p= Pattern.compile("^\\w+$");
                    System.out.println("type body only chars or 0 to quit");
                    m=p.matcher(value=sc.next());
                    if (value.equals("0")){
                        value="empty";
                        break;
                    }
                }while (!m.find());
                m.reset();

                return value;
            }
            case price:{
                do {
                    p= Pattern.compile("^\\d+$");
                    System.out.println("type price only chars or 0 to quit");
                    m=p.matcher(value=sc.next());
                    if (value.equals("0")){
                        value="empty";
                        break;
                    }
                }while (!m.find());
                m.reset();

                return value;
            }
        }
        return  "";
    }

    public Car buildCar(){

        String vin ;
        String number ;
        String mark ;
        String model;
        String mileage;
        String year;
        String color ;
        String body ;
        String price ;
        System.out.println("Enter car data: ");

        vin=getFromUser(DataTypeEnum.vin);
        if (vin.equals("empty")){
            System.out.println("empty vin, car not created. Exit...");
        }
        else {
            number=getFromUser(DataTypeEnum.number);
            mark=getFromUser(DataTypeEnum.mark);
            model=getFromUser(DataTypeEnum.model);
            mileage=getFromUser(DataTypeEnum.mileage);
            year=getFromUser(DataTypeEnum.year);
            color=getFromUser(DataTypeEnum.color);
            body=getFromUser(DataTypeEnum.body);
            price=getFromUser(DataTypeEnum.price);
            Car car=Car.builder()
                    .vin(vin)
                    .number(number)
                    .mark(mark)
                    .model(model)
                    .mileage(mileage)
                    .year(year)
                    .color(color)
                    .body(body)
                    .price(price)
                    .build();
            return car;
        }
        return Car.builder().build();
    }
}
