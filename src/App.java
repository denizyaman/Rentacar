package src;

import src.business.UserManager;
import src.core.Helper;
import src.view.*;


public class App {
    public static void  main(String[] args){
        Helper.setTheme();
        //LoginView loginView= new LoginView();
        UserManager userManager=new UserManager();
        AdminView adminView =new AdminView(userManager.findByLogin("admin","1234"));
    }
}
