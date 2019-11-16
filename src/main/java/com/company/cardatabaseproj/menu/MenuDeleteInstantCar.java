package com.company.cardatabaseproj.menu;

public class MenuDeleteInstantCar  implements  MenuState{
    @Override
    public void next(Menu menu) {

    }

    @Override
    public void previous(Menu menu) {

    }

    @Override
    public void printState() {
        System.out.println("Menu deleting instant car: ");
        System.out.println("1-delete by vin");
        System.out.println("2-delete by number");
        System.out.println("3-delete by markmodel");
        System.out.println("4-delete by mileage");
        System.out.println("5-delete by year");
        System.out.println("6-delete by price");
        System.out.println("7-delete all");
        System.out.println("0-back");
        System.out.println("make your chose: ");
    }

}
