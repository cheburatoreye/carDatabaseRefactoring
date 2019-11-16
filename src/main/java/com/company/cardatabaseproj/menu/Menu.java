package com.company.cardatabaseproj.menu;

public class Menu {
    private MenuState state;


    public  void next(){
        state.next(this);

    }
    public  void previous(){
        state.previous(this);

    }

    public void setState(MenuState state) {
        this.state = state;
    }

    public  void printState(){
        state.printState();
    }
}
