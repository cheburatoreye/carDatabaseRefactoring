package com.company.cardatabaseproj.menu;

public class MenuStart implements  MenuState {

    @Override
    public void next(Menu menu) {
     menu.setState(new MenuSearch());
    }

    @Override
    public void previous(Menu menu) {
        menu.setState(new MenuStart());
    }

    @Override
    public void printState() {
        System.out.println("\n"+"DATABASE V0.0"+"\n");
        System.out.println("Menu: ");
        System.out.println("1-search");
        System.out.println("2-add to database new car");
        System.out.println("3-redact car data through VIN");
        System.out.println("4-delete car from database");
        System.out.println("0-back");
        System.out.println("-1-exit");
        System.out.println("make your chose: ");

    }
}
