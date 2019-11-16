package com.company.cardatabaseproj.menu;

public class MenuRedacting implements MenuState {

    @Override
    public void next(Menu menu) {
        menu.setState(new MenuRedacInstantCar());
    }

    @Override
    public void previous(Menu menu) {
        menu.setState(new MenuRedacting());

    }

    @Override
    public void printState() {
        System.out.println("Menu redacting: ");
    }
}
