package com.company.cardatabaseproj.menu;

public class MenuRedacInstantCar  implements  MenuState{
    @Override
    public void next(Menu menu) {

    }

    @Override
    public void previous(Menu menu) {

    }

    @Override
    public void printState() {
        System.out.println("Menu redacting instant car: ");
        System.out.println("1-change number");
        System.out.println("2-change mark");
        System.out.println("3-change model");
        System.out.println("4-change mileage");
        System.out.println("5-change year");
        System.out.println("6-change color");
        System.out.println("7-change body");
        System.out.println("8-change price");
        System.out.println("0-back");
        System.out.println("make your chose: ");
    }

}
