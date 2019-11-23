package com.company.cardatabaseproj.menu;

import com.company.cardatabaseproj.database.Car;
import com.company.cardatabaseproj.database.Database;
import com.company.cardatabaseproj.enums.DataTypeEnum;
import com.company.cardatabaseproj.facade.UserFacade;
import com.company.cardatabaseproj.facade.UserFacadeMethods;

import java.io.IOException;
import java.util.Scanner;

public class ClientMenuMethods implements ClientMenu {

    Menu menu=new Menu();
    private  Scanner sc=new Scanner(System.in);

    private UserFacade userFasad= UserFacadeMethods.getInstance();
    private  static ClientMenu clientmenu=new ClientMenuMethods();
    private ClientMenuMethods(){}
    public  static final ClientMenu getInstance(){
        return clientmenu;
    }

    @Override
    public void menuStart() throws IOException, ClassNotFoundException {
        int exit=1;
        int search=0;
        String vin;
        String number;
        userFasad.DatabaseInit();


        while (exit==1){

            switch (search){
                //------------------------------------------------------------------------------------------------------
                // Menu main
                case 0:{
                    menu.setState(new MenuStart());
                    menu.printState();
                    search = sc.nextInt();
                    break;
                }
                //------------------------------------------------------------------------------------------------------
                // Menu search
                case 1:{
                    menu.setState(new MenuSearch());
                    menu.printState();
                    search = sc.nextInt();
                    switch (search){
                        //----------------------------------------------------------------------------------------------
                        // Menu search by VIN sub menu search
                        case 1:{
                            if (search==1){
                                menu.next();
                                menu.printState();
                                vin = sc.next();
                                if (vin.equals("0")){
                                    search=0;
                                }
                                else {
                                    System.out.println( "Enter VIN for search or type 0 to go back .");
                                    if (!vin.equals("0")){
                                        System.out.println(userFasad.read(vin,"empty",true, DataTypeEnum.any));
                                    }
                                }
                                if (search==0){
                                   menu.previous();
                                    search=1;
                                }
                            }
                            break;
                        }
                        //----------------------------------------------------------------------------------------------
                        // Menu search by NUMBER sub menu search
                        case 2:{
                            System.out.println( "Enter car number for search or type 0 to go back .");
                            number=sc.next();
                            if (!number.equals("0")){
                                System.out.println(userFasad.read(number,"empty",true, DataTypeEnum.any));
                            }
                            search=1;
                            break;
                        }
                        //----------------------------------------------------------------------------------------------
                        // Menu search by MARK and MODEL sub menu search
                        case 3:{
                            for (Car car : userFasad.searchByMarkModel()) {
                                System.out.println(car);
                            }
                            search=1;
                            break;
                        }
                        //----------------------------------------------------------------------------------------------
                        // Menu search by YEAR sub menu search
                        case 4:{
                            for (Car car : userFasad.searchByYear()) {
                                System.out.println(car);
                            }
                            search=1;
                            break;
                        }
                        //----------------------------------------------------------------------------------------------
                        // Menu search by MILEAGE sub menu search
                        case 5:{
                            for (Car car : userFasad.searchByMileage()) {
                                System.out.println(car);
                            }
                            search=1;
                            break;
                        }
                        //----------------------------------------------------------------------------------------------
                        // Menu search by PRICE sub menu search
                        case 6: {
                            for (Car car : userFasad.searchByPrice()) {
                                System.out.println(car);
                            }
                            search = 1;
                            break;
                        }
                        //----------------------------------------------------------------------------------------------
                        // Menu search ALL sub menu search
                        case 7:{
                            System.out.println( "The list of the cars in database: ");
                            for (Car item:userFasad.getAll()) {
                                System.out.println(item);
                            }
                            search=1;
                            break;
                        }
                        //----------------------------------------------------------------------------------------------
                        // Menu search by MARK sub menu search
                        case 8:{
                            for (Car car : userFasad.searchByMark()) {
                                System.out.println(car);
                            }
                            search=1;
                            break;
                        }
                        //----------------------------------------------------------------------------------------------
                    }
                    break;
                }
                //------------------------------------------------------------------------------------------------------
                // Menu adding
                case 2:{
                    menu.setState(new MenuAddingCars());
                    menu.printState();
                    userFasad.save();
                    userFasad.databaseSave();
                    search=0;
                    break;
                }
                //------------------------------------------------------------------------------------------------------
                // Menu redact
                case 3:{
                    menu.setState(new MenuRedacting());
                    menu.printState();
                    do {
                        String choise;
                        System.out.println( "Enter car VIN to redact car information or 0 to go back .");
                        vin=sc.next();
                        if (!vin.equals("0")){
                            menu.next();
                            menu.printState();
                            choise=sc.next();
                            do {
                                boolean repeat=false;
                                if (!repeat){
                                    userFasad.redactCar(choise,vin);
                                    System.out.println("corrected");
                                }
                                menu.printState();
                                repeat=true;
                                choise=sc.next();
                            }while (!choise.equals("0"));
                        }
                        else {
                            break;
                        }

                    }while (!vin.equals("0"));
                    search=0;
                    break;
                }
                //------------------------------------------------------------------------------------------------------
                // Menu deleting
                case 4:{
                    menu.setState(new MenuDeleting());
                    String choise;
                        do {
                            menu.printState();
                            choise=sc.next();
                            if (!choise.equals("0")){
                                if (userFasad.deleteByValue(choise)){
                                    userFasad.databaseSave();
                                    System.out.println("deleted");
                                }
                            }
                        }while (!choise.equals("0"));
                    search=0;
                    break;
                }
                //------------------------------------------------------------------------------------------------------
                // Menu exit
                case -1:{
                    exit = 0;
                    userFasad.databaseSave();
                    System.out.println("Goodbye see you :)");
                    break;
                }
                //------------------------------------------------------------------------------------------------------
            }
        }

}
}
