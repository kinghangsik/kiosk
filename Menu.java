package kiosk_pj;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class Menu {
    // name, explanation 변수 선언
    protected String name;
    protected String explanation;

    private int watingNumber;

    //Scanner 사용 준비
    Scanner sc = new Scanner(System.in);

    //    food List - buger, drink, beer 생성
    private List<Product> bugerlist = new ArrayList<>();
    private List<Product> dirnklist = new ArrayList<>();
    private List<Product> beerlist = new ArrayList<>();
    private List<Product> cart = new ArrayList<>();

    public String getName() {
        return name;
    }

    public String getExplanation() {
        return explanation;
    }

    public void welcomeMessage(){
        System.out.println("\"SHAKESHACK BURGER 에 오신걸 환영합니다.\"");
        System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.");
        System.out.println();
    }

    // 메뉴판 정의
    public void mainMenu() {
        setMenu();
        while (true) {
            welcomeMessage();
            System.out.println("[ SHAKESHACK MENU ]");
            System.out.println("1. Burgers         | 앵거스 비프 통살을 다져만든 버거");
            System.out.println("2. Drinks          | 매장에서 직접 만드는 음료");
            System.out.println("3. Beer            | 뉴욕 브루클린 브루어리에서 양조한 맥주");
            System.out.println();
            System.out.println("[ ORDER MENU ]");
            System.out.println("4. Order       | 장바구니를 확인 후 주문합니다.");
            System.out.println("5. Cancel      | 진행중인 주문을 취소합니다.");
            // Scanner 사용
            int choiceMenu = sc.nextInt();
            menuDetail(choiceMenu);
        }
    }

    // 만들어진 배열에 List 추가
    public void setMenu() {
        bugerlist.add(new Product("ShackBurger", "토마토, 양상추, 쉑소스가 토핑된 치즈버거", 6.9));
        bugerlist.add(new Product("SmokeShack", "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거", 8.9));
        bugerlist.add(new Product("Shroom Burger", "몬스터 치즈와 체다 치즈로 속을 채운 베지테리안 버거", 9.4));
        bugerlist.add(new Product("Cheeseburger", "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거", 6.9));

        dirnklist.add(new Product("Coke", "콜라는 역시 펩시 콜라!", 2.0));
        dirnklist.add(new Product("Zero Coke", "건강 챙겨야 하는 현대인을 위한 제로 콜라!", 3.5));
        dirnklist.add(new Product("Sprite", "국내 1위 이거 마시면 우리..", 3.0));

        beerlist.add(new Product("Draft Beer", "생맥주는 역시 클라우드 생 드래프트", 4.2));
        beerlist.add(new Product("Dark Beer", "5주년 기념으로 만들어진 특별 기네스 생맥주", 5.5));
        beerlist.add(new Product("Bottled beer", "수락산의 정기를 담은 수제 맥주", 6.8));
    }

    public void menuDetail(int choiceMenu) {
        switch (choiceMenu) {
            case 1:
                bugerList();
                break;
            case 2:
                drinkList();
                break;
            case 3:
                beerList();
                break;
            case 4:
                orderList();
                break;
            case 5:
                cancleList();
                break;
            default:
                System.out.println("잘못된 입력값입니다.");
        }
    }

    public void bugerList() {
        welcomeMessage();
        for (int i = 0; i < bugerlist.size(); i++) {
            System.out.println((i + 1) + "." + bugerlist.get(i).getName() + " | " +"W"+bugerlist.get(i).getPrice()+ " | " + bugerlist.get(i).getExplanation());
        }
        int select = sc.nextInt();

        System.out.println("\"" + bugerlist.get(select - 1).getName() + " | " +"W"+bugerlist.get(select - 1).getPrice() + " | " + bugerlist.get(select - 1).getExplanation() + "\"");
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니다?");
        System.out.println("1. 확인        2. 취소");
        System.out.println();

        int confirm = sc.nextInt();

        if (confirm == 1) {
            System.out.println(bugerlist.get(select - 1).getName() + "가 장바구니에 추가되었습니다.");
            System.out.println();

            Product selectProduct = bugerlist.get(select - 1);
            cart.add(selectProduct);
        } else if (select == 2) {
            bugerList();
        } else {
            System.out.println("올바른 숫자를 입력해주세요");
            System.out.println();
        }
    }

    public void drinkList() {
        welcomeMessage();
        for (int i = 0; i < dirnklist.size(); i++) {
            System.out.println((i + 1) + "." + dirnklist.get(i).getName() + " | " + "W"+dirnklist.get(i).getPrice() + " | " + dirnklist.get(i).getExplanation());
        }
        int select = sc.nextInt();

        System.out.println("\"" + dirnklist.get(select - 1).getName() + " | " + "W"+dirnklist.get(select - 1).getPrice() + " | " + dirnklist.get(select - 1).getExplanation() + "\"");
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니다?");
        System.out.println("1. 확인        2. 취소");
        System.out.println();

        int confirm = sc.nextInt();

        if (confirm == 1) {
            System.out.println(dirnklist.get(select - 1).getName() + "가 장바구니에 추가되었습니다.");
            System.out.println();

            Product selectProduct = dirnklist.get(select - 1);
            cart.add(selectProduct);
        } else if (select == 2) {
            bugerList();
        } else {
            System.out.println("올바른 숫자를 입력해주세요");
            System.out.println();
        }
    }

    public void beerList() {
        welcomeMessage();
        for (int i = 0; i < beerlist.size(); i++) {
            System.out.println((i + 1) + "." + beerlist.get(i).getName() + " | " + "W"+beerlist.get(i).getPrice() + " | " + beerlist.get(i).getExplanation());
        }
        int select = sc.nextInt();

        System.out.println("\"" + beerlist.get(select - 1).getName() + " | " + "W"+beerlist.get(select - 1).getPrice() + " | " + beerlist.get(select - 1).getExplanation() + "\"");
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니다?");
        System.out.println("1. 확인        2. 취소");
        System.out.println();

        int confirm = sc.nextInt();

        if (confirm == 1) {
            System.out.println(beerlist.get(select - 1).getName() + "가 장바구니에 추가되었습니다.");
            System.out.println();

            Product selectProduct = beerlist.get(select - 1);
            cart.add(selectProduct);
        } else if (select == 2) {
            bugerList();
        } else {
            System.out.println("올바른 숫자를 입력해주세요");
            System.out.println();
        }
    }


    //Order로 보내야 할 것!
    public void orderList() {
        double totalOrderprice = 0;
        System.out.println("아래와 같이 주문 하시겠습니까?");
        System.out.println("\"" + "[ Orders ]" + "\"");
        for (Product item : cart) {
            System.out.println(item.getName() + " | " + "W"+item.getPrice()+ " | " +item.getExplanation());
            totalOrderprice += item.getPrice();
        }
        System.out.println();
        System.out.println();
        System.out.println("\"" + "[Total]" + "\"");
        System.out.println("W"+totalOrderprice);
        System.out.println();
        System.out.println("1. 주문        2. 메뉴판");

        int OrderConfirm = sc.nextInt();

        if (OrderConfirm == 1) {
            System.out.println("대기번호는["+watingNumber+"]번 입니다.");
            watingNumber++;
            System.out.println("(3초후 메뉴판으로 돌아갑니다)");

            try {
                Thread.sleep(3000); //3초
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else if (OrderConfirm == 2) {
            mainMenu();
        }
    }
    public void cancleList() {
        System.out.println("진행하던 주문을 취소하시겠습니까?");
        System.out.println("1. 네        2.아니요");
        int cancleSelect = sc.nextInt();
        if (cancleSelect == 1) {
            cart.clear();
            mainMenu();
        } else if (cancleSelect == 2) {
            mainMenu();
        }
    }
}
