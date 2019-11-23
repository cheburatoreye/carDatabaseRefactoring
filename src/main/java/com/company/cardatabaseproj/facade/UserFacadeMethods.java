package com.company.cardatabaseproj.facade;
import com.company.cardatabaseproj.database.Car;
import com.company.cardatabaseproj.database.Database;
import com.company.cardatabaseproj.enums.DataTypeEnum;
import com.company.cardatabaseproj.service.CarService;
import com.company.cardatabaseproj.service.CarServiceMethods;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserFacadeMethods implements UserFacade {
    private Scanner sc=new Scanner(System.in);
    private static  final UserFacade facade =new UserFacadeMethods();
    private UserFacadeMethods(){}
    public  static  final UserFacade getInstance(){
        return facade;
    }
    private static CarService carService= CarServiceMethods.getInstance();
    private String getFromUser(String type){

        Pattern p;
        Matcher m;
        String value;
        switch (type){
            case "digits":{

                do {
                    p= Pattern.compile("^\\d+$");
                    System.out.println("only digits");
                    m=p.matcher(value=sc.next());
                    if (value.equals("0")){
                        break;
                    }
                }while (!m.find());
                m.reset();
                return value;
            }
            case "strings":{
                do {
                    p= Pattern.compile("^\\w+$");
                    System.out.println("only chars");
                    m=p.matcher(value=sc.next());
                    if (value.equals("0")){
                        break;
                    }
                }while (!m.find());
                m.reset();
                return value;
            }
        }

        return  "";
    }

    @Override
    public List<Car> save() {
            Car car=carService.create();
            carService.read(car.getVin(),"empty",true, DataTypeEnum.empty);
        return carService.read(car.getVin(),"empty",true,DataTypeEnum.empty);
    }

    @Override
    public Collection<Car> getAll() {
        return carService.list();
    }

    @Override
    public List<Car> read(String valuefirst, String valuesecond, boolean string, DataTypeEnum typeofdata) {
        return carService.read(valuefirst,valuesecond,string,typeofdata);
    }

    @Override
    public void DatabaseInit() throws IOException, ClassNotFoundException {
        carService.databaseInit();
    }

    @Override
    public void databaseSave() throws IOException {
        carService.databaseSave();
    }


    @Override
    public void redactCar(String correct,String vin) {

        switch (correct){

                case"1":{
                    carService.redactNumber(vin);
                    break;
                }
                case"2":{
                    carService.redactMark(vin);
                    break;
                }
                case"3":{
                    carService.redactModel(vin);
                    break;
                }
                case"4":{
                    carService.redactMileage(vin);
                    break;
                }
                case"5":{
                    carService.redactYear(vin);
                    break;
                }
                case"6":{
                    carService.redactColor(vin);
                    break;
                }
                case"7":{
                    carService.redactBody(vin);
                    break;
                }
                case"8":{
                    carService.redactPrice(vin);
                    break;
                }
            }
    }

    @Override
    public List<Car> searchByYear() {
        String yearstart;
        String yearstop;
        System.out.println( "Enter car year start searching than type end year or type 0 to go back .");
        yearstart=getFromUser("digits");

        System.out.println("Now type end year or type 0 to go back: ");
        yearstop=getFromUser("digits");

        if (Integer.valueOf(yearstart)>Integer.valueOf(yearstop)){
            System.out.println("First year less than second, try again");
            return new ArrayList();
        }
        else {
           return carService.read(yearstart,yearstop,false, DataTypeEnum.year);
        }
    }

    @Override
    public List<Car> searchByMileage() {
        String mileagestart;
        String mileagestop;
        System.out.println( "Enter car mileage start searching than type end mileage or type 0 to go back .");
        mileagestart=getFromUser("digits");

        System.out.println("Now type end mileage or type 0 to go back: ");
        mileagestop=getFromUser("digits");

        if (Integer.valueOf(mileagestart)>Integer.valueOf(mileagestop)){
            System.out.println("First mileage less than second, try again");
            return new ArrayList();
        }
        else {
           return carService.read(mileagestart,mileagestop,false, DataTypeEnum.mileage);
        }
    }

    @Override
    public List<Car> searchByPrice() {
        String pricestart;
        String pricestop;
        System.out.println("Enter car price start searching than type end price or type 0 to go back .");
        pricestart = getFromUser("digits");

        System.out.println("Now type end price or type 0 to go back: ");
        pricestop = getFromUser("digits");

        if (Integer.valueOf(pricestart) > Integer.valueOf(pricestop)) {
            System.out.println("First price less than second, try again");
            return  new ArrayList();
        } else {
            return  carService.read(pricestart, pricestop, false, DataTypeEnum.price);
        }
    }

    @Override
    public List<Car> searchByMarkModel() {
        String mark;
        String model;
        System.out.println( "Enter car mark than type model or type 0 to go back .");
        mark=getFromUser("strings");
        System.out.println("Now type model or type 0 to go back: ");
        model=getFromUser("strings");
        return carService.read(mark,model,true, DataTypeEnum.markmodel);
    }

    @Override
    public List<Car> searchByMark() {
        String mark;
        System.out.println( "Enter car mark than type model or type 0 to go back .");
        mark=getFromUser("strings");
       return carService.read(mark,"empty",true, DataTypeEnum.any);
    }

    @Override
    public boolean deleteByValue(String value) throws IOException {
        String vin;
        String number;
        String mark;
        String model;
        String mileagestart;
        String mileagestop;
        String yearstart;
        String yearstop;
        String pricestart;
        String pricestop;

        switch (value){
            case"1":{
                System.out.println("Enter start vin:");
                vin=getFromUser("strings");
               return carService.delete(vin,"empty",true, DataTypeEnum.any);
            }
            case"2":{
                System.out.println("Enter number:");
                number=getFromUser("strings");
               return carService.delete(number,"empty",true, DataTypeEnum.any);
            }
            case"3":{
                System.out.println("Enter mark:");
                mark=getFromUser("strings");
                System.out.println("Enter model:");
                model=getFromUser("strings");
              return   carService.delete(mark,model,true, DataTypeEnum.markmodel);
            }
            case"4":{
                System.out.println("Enter start mileage:");
                mileagestart=getFromUser("digits");
                System.out.println("Enter end mileage:");
                mileagestop=getFromUser("digits");
               return carService.delete(mileagestart,mileagestop,false, DataTypeEnum.mileage);
            }
            case"5":{
                System.out.println("Enter start year:");
                yearstart=getFromUser("digits");
                System.out.println("Enter end year:");
                yearstop=getFromUser("digits");
               return carService.delete(yearstart,yearstop,false, DataTypeEnum.year);
            }
            case"6":{
                System.out.println("Enter start price:");
                pricestart=getFromUser("digits");
                System.out.println("Enter end price:");
                pricestop=getFromUser("digits");
               return carService.delete(pricestart,pricestop,false, DataTypeEnum.price);
            }
            case"7":{
                return carService.delete("empty","empty",false, DataTypeEnum.all);
            }

        }
        return false;
    }
}
