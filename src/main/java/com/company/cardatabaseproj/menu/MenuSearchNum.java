package com.company.cardatabaseproj.menu;

public class MenuSearchNum implements MenuState {

    @Override
    public void next(Menu menu) {

    }

    @Override
    public void previous(Menu menu) {

    }

    @Override
    public void printState() {
        System.out.println("search by Number");
        System.out.println("type number or 0 to go out");
    }
}
