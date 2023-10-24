package kiosk_pj;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        menu menu = new menu("name","explanation");
        menu.mainMenu();
        menu.addMenu();
        basket basket = new basket();
        Scanner sc = new Scanner(System.in);
        int List = sc.nextInt();

        switch (List) {
            case 1 :
                menu.bugerList();
                break;
            case 2 :
                menu.drinkList();
                break;
            case 3 :
                menu.beerList();
                break;
            case 4 :

                break;
            case 5 :
                System.out.println(5);
                break;
            default:
                System.out.println("잘못된 값을 입력하였습니다.");
        }
    }
}
