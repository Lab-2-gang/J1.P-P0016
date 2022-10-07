package Presentation;

import java.io.IOException;
import Presentation.Color;
import Database.Account.*;

public class Program {
    public static void main(String[] args) {
        // DealerListManagement dList = new DealerListManagement(logInAcc);
        // dList.initFile();

        // *login

        Menu mnu = new Menu(options);
        int choice;
        do {
            choice = mnu.getChoice("MAIN MENU", true, "Quit");
            switch (choice) {
                case 1:
                    // do {
                    // ? Add thêm dealer, gán các message và thông báo gồm màu chữ như bên dưới đã
                    // comment
                    // Message.showMessage("Add a new dealer".toUpperCase(), Color.YELLOW);
                    // * dList.addDealer();
                    // } while (Tool.getTwoChoice("Do you want to continue adding another dealer?",
                    // "Yes",
                    // "Go back to main menu"));
                    // Message.showMessage("Go back to main menu...", Color.BLUE);
                    break;
                case 2:
                    // ? Search dealer, search bằng id, uppercase lên, và list trống thì ko có để
                    // search, gọi hàm
                    // ? message để in ra các string như bên dưới
                    // do {
                    // Message.showMessage("Search a dealer by id".toUpperCase(), Color.YELLOW);
                    // * dList.searchDealer();
                    // } while (!dList.isEmpty()
                    // && Tool.getTwoChoice("Do you want to continue searching another dealer?",
                    // "Yes",
                    // "Go back to main menu"));
                    // Message.showMessage("Go back to main menu...", Color.BLUE);
                    break;
                case 3:
                    // ? Xóa dealer, trống thì vẫn ko xóa, vẫn gọi hàm message để in ra các thông
                    // báo như bên dưới
                    // do {
                    // Message.showMessage("Remove a dealer by id".toUpperCase(),
                    // Color.YELLOW_BACKGROUND);
                    // * dList.removeDealer();
                    // } while (!dList.isEmpty()
                    // && Tool.getTwoChoice("Do you want to continue removing another dealer?",
                    // "Yes",
                    // "Go back to main menu"));
                    // Message.showMessage("Go back to main menu...", Color.BLUE);
                    break;
                case 4:
                    // ? Update dealer, vẫn như cũ, trống thì ko update được, và in ra thêm các
                    // thông báo tối ưu
                    // do {
                    // Message.showMessage("Update a dealer by id".toUpperCase(),
                    // Color.YELLOW_BACKGROUND);
                    // * dList.updateDealer();
                    // } while (!dList.isEmpty()
                    // && Tool.getTwoChoice("Do you want to continue updating another dealer?",
                    // "Yes",
                    // "Go back to main menu"));
                    // Message.showMessage("Go back to main menu...", Color.BLUE);
                    break;
                case 5:
                    // ? In ra tất cả các dealers trong list, in ra dòng thông báo như bên dưới,
                    // uppercase lên để đẹp
                    // Message.showMessage("List of all dealers".toUpperCase(),
                    // Color.YELLOW_BACKGROUND);
                    // * */ dList.printAllDealers(dList);
                    break;
                case 6:
                    // ?
                    // Message.showMessage("List of all continuing dealers".toUpperCase(),
                    // Color.YELLOW_BACKGROUND);
                    // * dList.printAllDealers(dList.getContinuingList());
                    break;
                case 7:
                    // Message.showMessage("List of all un-continuing dealers".toUpperCase(),
                    // Color.YELLOW_BACKGROUND);
                    // * dList.printAllDealers(dList.getUnContinuingList());
                    break;
                case 8:
                    // ? Lưu dữ liệu vào file, vẫn dùng mesage để show ra các dòng thông báo, và
                    // chức năng này có thêm 1
                    // ? tác dụng là hỏi người dùng xem có muốn xem lại dữ liệu trước khi mình lưu
                    // ? và có thêm chức năng thoát ra lại menu để tiếp tục chỉnh sửa nếu deales bị
                    // lỗi và ko lưu đc
                    // Message.showMessage("Write to file".toUpperCase(), Color.YELLOW_BACKGROUND);
                    // if (dList.isEmpty()) {
                    // Message.showMessage("The list of dealers is empty now!".toUpperCase(),
                    // Color.BLUE);
                    // } else if (Tool.getTwoChoice("Do you want to preview data of dealers before
                    // saving?", "Yes",
                    // "No")) {
                    // Message.showMessage("Previewing data of dealers".toUpperCase(),
                    // Color.YELLOW_BACKGROUND);
                    // * dList.printAllDealers(dList);
                    // }
                    // Message.showMessage("Are you sure want to save?".toUpperCase(), Color.BLUE);
                    // if (Tool.getTwoChoice("Please choose an option", "Yes", "No")) {
                    // * dList.writeDealerToFile();
                    // } else {
                    // Message.showMessage("The dealers are not saved!", Color.BLUE);
                    // }
                    // if (!Tool.getTwoChoice("Do you want to continue the program?", "Yes", "No.
                    // Quit the program")) {
                    // Message.showMessage("Thank you for using".toUpperCase(), Color.PURPLE);
                    // System.exit(0);
                    // } else {
                    // Message.showMessage("Go back to main menu...", Color.BLUE);
                    // }
                    break;
                default:
                    if (dList.isChanged()) {
                        Message.showMessage("Data of dealers was changed.", Color.BLUE);
                        if (Tool.getTwoChoice("Do you want to save to file?", "Yes", "No")) {
                            if (dList.isEmpty()) {
                                Message.showMessage("The list of dealers is empty now!".toUpperCase(), Color.BLUE);
                            } else if (Tool.getTwoChoice("Do you want to preview data of dealers before saving?", "Yes",
                                    "No")) {
                                Message.showMessage("Previewing data of dealers".toUpperCase(),
                                        Color.YELLOW_BACKGROUND);
                                dList.printAllDealers(dList);
                            }
                            Message.showMessage("Are you sure want to save?".toUpperCase(), Color.BLUE);
                            if (Tool.getTwoChoice("Please choose an option", "Yes", "No")) {
                                dList.writeDealerToFile();
                            } else {
                                Message.showMessage("The dealers are not saved!", Color.BLUE);
                            }
                        } else {
                            Message.showMessage("The dealers are not saved!", Color.BLUE);
                        }
                        System.out.println("----------------------");
                    }
            }
        } while (choice > 0 && choice <= mnu.size());
        Message.showMessage("Thank you for using".toUpperCase(), Color.PURPLE);

    }

    // private final Account acc;

    // public main(Account acc) {
    // this.acc = acc;
    // }

    // public static Account inputAccount() {
    // Account newAccount = null;
    // String accName;
    // String password;
    // String role;
    // accName = Tool.readNonBIank("Enter account name").trim();
    // do {
    // password = Tool.readNonBIank("Enter account password").trim();
    // } while (!Validation.isValidPassword(password));
    // role = Tool.readNonBIank("Enter account role").trim();
    // newAccount = new Account(accName, password, role);
    // return newAccount;
    // }

    // public Account getAcc() {
    // return acc;
    // }

    // public static void main(String[] args) throws IOException {
    // Account acc;
    // boolean continuing;
    // boolean valid;
    // Message.showMessage("Welcome to dealer management program".toUpperCase(),
    // Color.PURPLE);
    // do {
    // continuing = false;
    // AccountChecker accCheck = new AccountChecker();
    // acc = inputAccount();
    // valid = accCheck.check(acc);
    // if (!valid) {
    // Message.showMessage("INVALID ACCOUNT", Color.RED);
    // continuing = Tool.getTwoChoice("Want to try again?", "Yes", "No");
    // }
    // if (!valid && !continuing) {
    // Message.showMessage("Thank you for using".toUpperCase(), Color.PURPLE);
    // System.exit(0);
    // }
    // } while (continuing);
    // main logInAcc = new main(acc);

    // // Nếu log in không thành công => Exit
    // if (!acc.getRole().equalsIgnoreCase("ACC-01")) {
    // Message.showMessage("This account is impossible to access dealer mangement
    // program!".toUpperCase(),
    // Color.RED);
    // Message.showMessage("----------------------\nThank you for
    // using".toUpperCase(), Color.PURPLE);
    // System.exit(0);
    // }

    // // Nếu log in thành công
    // Message.showMessage(
    // "LOG IN SUCCESSFULLY", Color.GREEN);
    // String[] options = { "Add new dealer", "Search a dealer", "Remove a dealer",
    // "Update a dealer", "Print all dealers",
    // "Print continuing dealers", "Print UN-continuing dealers",
    // "Write to file"
    // };
    // DealerListManagement dList = new DealerListManagement(logInAcc);
    // dList.initFile();
    // Menu mnu = new Menu(options);
    // int choice;
    // do {
    // choice = mnu.getChoice("MAIN MENU", true, "Quit");
    // switch (choice) {
    // case 1:
    // do {
    // Message.showMessage("Add a new dealer".toUpperCase(), Color.YELLOW);
    // dList.addDealer();
    // } while (Tool.getTwoChoice("Do you want to continue adding another dealer?",
    // "Yes",
    // "Go back to main menu"));
    // Message.showMessage("Go back to main menu...", Color.BLUE);
    // break;
    // case 2:
    // do {
    // Message.showMessage("Search a dealer by id".toUpperCase(), Color.YELLOW);
    // dList.searchDealer();
    // } while (!dList.isEmpty()
    // && Tool.getTwoChoice("Do you want to continue searching another dealer?",
    // "Yes",
    // "Go back to main menu"));
    // Message.showMessage("Go back to main menu...", Color.BLUE);
    // break;
    // case 3:
    // do {
    // Message.showMessage("Remove a dealer by id".toUpperCase(),
    // Color.YELLOW_BACKGROUND);
    // dList.removeDealer();
    // } while (!dList.isEmpty()
    // && Tool.getTwoChoice("Do you want to continue removing another dealer?",
    // "Yes",
    // "Go back to main menu"));
    // Message.showMessage("Go back to main menu...", Color.BLUE);
    // break;
    // case 4:
    // do {
    // Message.showMessage("Update a dealer by id".toUpperCase(),
    // Color.YELLOW_BACKGROUND);
    // dList.updateDealer();
    // } while (!dList.isEmpty()
    // && Tool.getTwoChoice("Do you want to continue updating another dealer?",
    // "Yes",
    // "Go back to main menu"));
    // Message.showMessage("Go back to main menu...", Color.BLUE);
    // break;
    // case 5:
    // Message.showMessage("List of all dealers".toUpperCase(),
    // Color.YELLOW_BACKGROUND);
    // dList.printAllDealers(dList);
    // break;
    // case 6:
    // Message.showMessage("List of all continuing dealers".toUpperCase(),
    // Color.YELLOW_BACKGROUND);
    // dList.printAllDealers(dList.getContinuingList());
    // break;
    // case 7:
    // Message.showMessage("List of all un-continuing dealers".toUpperCase(),
    // Color.YELLOW_BACKGROUND);
    // dList.printAllDealers(dList.getUnContinuingList());
    // break;
    // case 8:
    // Message.showMessage("Write to file".toUpperCase(), Color.YELLOW_BACKGROUND);
    // if (dList.isEmpty()) {
    // Message.showMessage("The list of dealers is empty now!".toUpperCase(),
    // Color.BLUE);
    // } else if (Tool.getTwoChoice("Do you want to preview data of dealers before
    // saving?", "Yes",
    // "No")) {
    // Message.showMessage("Previewing data of dealers".toUpperCase(),
    // Color.YELLOW_BACKGROUND);
    // dList.printAllDealers(dList);
    // }
    // Message.showMessage("Are you sure want to save?".toUpperCase(), Color.BLUE);
    // if (Tool.getTwoChoice("Please choose an option", "Yes", "No")) {
    // dList.writeDealerToFile();
    // } else {
    // Message.showMessage("The dealers are not saved!", Color.BLUE);
    // }
    // if (!Tool.getTwoChoice("Do you want to continue the program?", "Yes", "No.
    // Quit the program")) {
    // Message.showMessage("Thank you for using".toUpperCase(), Color.PURPLE);
    // System.exit(0);
    // } else {
    // Message.showMessage("Go back to main menu...", Color.BLUE);
    // }
    // break;
    // default:
    // if (dList.isChanged()) {
    // Message.showMessage("Data of dealers was changed.", Color.BLUE);
    // if (Tool.getTwoChoice("Do you want to save to file?", "Yes", "No")) {
    // if (dList.isEmpty()) {
    // Message.showMessage("The list of dealers is empty now!".toUpperCase(),
    // Color.BLUE);
    // } else if (Tool.getTwoChoice("Do you want to preview data of dealers before
    // saving?", "Yes",
    // "No")) {
    // Message.showMessage("Previewing data of dealers".toUpperCase(),
    // Color.YELLOW_BACKGROUND);
    // dList.printAllDealers(dList);
    // }
    // Message.showMessage("Are you sure want to save?".toUpperCase(), Color.BLUE);
    // if (Tool.getTwoChoice("Please choose an option", "Yes", "No")) {
    // dList.writeDealerToFile();
    // } else {
    // Message.showMessage("The dealers are not saved!", Color.BLUE);
    // }
    // } else {
    // Message.showMessage("The dealers are not saved!", Color.BLUE);
    // }
    // System.out.println("----------------------");
    // }
    // }
    // } while (choice > 0 && choice <= mnu.size());
    // Message.showMessage("Thank you for using".toUpperCase(), Color.PURPLE);
    // }
}
