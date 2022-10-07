package Presentation;

import java.util.ArrayList;

public class DealerMenu {
    private ArrayList<String> menuList = new ArrayList<String>();

    // public getMenu() return menuList
    public DealerMenu() {
        menuList.add("1. Add new dealer");
        menuList.add("2. Search a dealer");
        menuList.add("3. Remove a dealer");
        menuList.add("4. Update a dealer");
        menuList.add("5. Print all dealers");
        menuList.add("6. Print continuing dealers");
        menuList.add("7. Print UN-continuing dealers");
        menuList.add("8. Write to file");
        // Other for quit
        // Choose 1-8 to do the function
        menuList.add("Others for quit");
    }

    // DealerMenu constructor add menu to menuList
    public ArrayList<String> getMenuList() {
        return menuList;
    }
}
