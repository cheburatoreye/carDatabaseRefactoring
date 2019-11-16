package com.company.cardatabaseproj.menu;

public class MenuSubSearch implements MenuState {

    @Override
    public void next(Menu menu) {

    }

    @Override
    public void previous(Menu menu) {
        menu.setState(new MenuSearch());
    }

    @Override
    public void printState() {
        System.out.println("search by VIN");
        System.out.println("type VIN or 0 to go out");
    }
}
