package src;

import src.core.Helper;
import src.view.LoginView;

import javax.swing.*;

public class App {
    public static void  main(String[] args){
        Helper.setTheme();
        LoginView loginView= new LoginView();
    }
}
