package com.company.cardatabaseproj.menu;

public interface MenuState {
    void next(Menu menu);
    void previous(Menu menu);
    void printState();

}
