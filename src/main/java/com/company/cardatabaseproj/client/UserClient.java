package com.company.cardatabaseproj.client;

import com.company.cardatabaseproj.database.Car;
import com.company.cardatabaseproj.facade.UserFacade;
import com.company.cardatabaseproj.facade.UserFacadeMethods;
import com.company.cardatabaseproj.menu.ClientMenu;
import com.company.cardatabaseproj.menu.ClientMenuMethods;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

public class UserClient {

    private UserFacade userFasad= UserFacadeMethods.getInstance();
    private ClientMenu clientmenu= ClientMenuMethods.getInstance();
    public List create(String vin){
        Car car=Car.builder().build();
        car.setVin(vin);
        return  userFasad.save();
    }

    public Collection<Car> getAll(){
        return  userFasad.getAll();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
       UserClient userClint=new UserClient();
        userClint.clientmenu.menuStart();
    }
}
