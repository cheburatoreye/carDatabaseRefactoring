package com.company.cardatabaseproj.menu;

public class MenuSearch implements MenuState {

    @Override
    public void next(Menu menu) {
    menu.setState(new MenuSubSearch());
    }

    @Override
    public void previous(Menu menu) {

    }

    @Override
    public void printState() {
        System.out.print("\n"+"Menu search:\n1-search by VIN\n2-search by number\n3-search by mark and model\n" +
                "4-search by year\n5-search by mileage\n6-search by price\n7-show all cars\n8-search by mark\n" +
                "0-back\nMake your choice\n");
    }
}
