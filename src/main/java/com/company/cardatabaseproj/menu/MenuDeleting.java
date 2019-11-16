package com.company.cardatabaseproj.menu;

public class MenuDeleting implements MenuState {

    @Override
    public void next(Menu menu) {
       // menu.setState(new MenuDeleteInstantCar());
    }

    @Override
    public void previous(Menu menu) {
       // menu.setState(new MenuDeleting());
    }

    @Override
    public void printState() {

        System.out.println("\n"+"Menu deleting:\n1-delete by vin\n2-delete by number\n3-delete by by mark and model\n" +
                "4-delete by mileage\n5-delete by price\n6-delete by year\n7-delete all cars\n0-back\nmake your chose: \n ");

    }
}
