package kiosk_pj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private String name;
    private String explanation;

    //food List 생성
    private List<Product> bugerlist = new ArrayList<>();
    private List<Product> dirnklist = new ArrayList<>();
    private List<Product> beerlist = new ArrayList<>();

    public Menu(String  name, String explanation){
        this.name = name;
        this.explanation=explanation;
    }
    public String getName() {
        return name;
    }

    public String getExplanation() {
        return explanation;
    }

    public void mainMenu() {
        System.out.println("SHAKESHACK BURGER 에 오신걸 환영합니다.");
        System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.");
        System.out.println();
        System.out.println("[ SHAKESHACK MENU ]");
        System.out.println("1. Burgers         | 앵거스 비프 통살을 다져만든 버거");
        System.out.println("2. Drinks          | 매장에서 직접 만드는 음료");
        System.out.println("3. Beer            | 뉴욕 브루클린 브루어리에서 양조한 맥주");
        System.out.println();
        System.out.println("[ ORDER MENU ]");
        System.out.println("5. Order       | 장바구니를 확인 후 주문합니다.");
        System.out.println("6. Cancel      | 진행중인 주문을 취소합니다.");
    }

    public void addMenu() {
        bugerlist.add(new Product("ShackBurger","토마토, 양상추, 쉑소스가 토핑된 치즈버거",6900));
        bugerlist.add(new Product("SmokeShack","베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거",8900));
        bugerlist.add(new Product("Shroom Burger","몬스터 치즈와 체다 치즈로 속을 채운 베지테리안 버거",9400));
        bugerlist.add(new Product("Cheeseburger","포테이토 번과 비프패티, 치즈가 토핑된 치즈버거",6900));


        dirnklist.add(new Product("Coke","콜라는 역시 펩시 콜라!",2000));
        dirnklist.add(new Product("Zero Coke","건강 챙겨야 하는 현대인을 위한 제로 콜라!",3000));
        dirnklist.add(new Product("Sprite","국내 1위 이거 마시면 우리..",2500));

        beerlist.add(new Product("Draft Beer","생맥주는 역시 클라우드 생 드래프트",3500));
        beerlist.add(new Product("Dark Beer","5주년 기념으로 만들어진 특별 기네스 생맥주",5000));
        beerlist.add(new Product("Bottled beer","수락산의 정기를 담은 수제 맥주",7000));
    }

    public void bugerList() {
        System.out.println("[구매하실 제품번호를 입력해 장바구니에 담아주세요]");
        int index = 1;
        for (Product buger : bugerlist) {
            System.out.println((index++) + "." + buger);
        }
        //어떤 버거를 선택했는지 스캔을 받는다.
        // 스캔된 것을 오더로 넘긴다.
        System.out.println();
        Scanner sc = new Scanner(System.in);
        int selectNumber = sc.nextInt();
        if (selectNumber == 1) {
            order1(bugerlist.get(1));
        } else if (selectNumber == 2) {
            order1(bugerlist.get(2));
        } else if (selectNumber == 3) {
            order1(bugerlist.get(3));
        } else if (selectNumber == 4) {
            order1(bugerlist.get(4));
        } else {
            System.out.println("잘못된 입력값입니다.");
        }
    }
    public void drinkList() {
        System.out.println("[구매하실 제품번호를 입력해 장바구니에 담아주세요]");
        int index = 1;
        for (Product drink : dirnklist) {
            System.out.println((index++) + "." + drink);
        }
        System.out.println();
        Scanner sc = new Scanner(System.in);
        int selectNumber = sc.nextInt();
        if (selectNumber == 1) {
            order1(dirnklist.get(1));
        } else if (selectNumber == 2) {
            order1(dirnklist.get(2));
        } else if (selectNumber == 3) {
            order1(dirnklist.get(3));
        }
    }

    public void beerList() {
        System.out.println("[구매하실 제품번호를 입력해 장바구니에 담아주세요]");
        int index = 1;
        for (Product beer : beerlist) {
            System.out.println((index++) + "." + beer);
        }
        System.out.println();
        Scanner sc = new Scanner(System.in);
        int selectNumber = sc.nextInt();
        if (selectNumber == 1) {
            order1(dirnklist.get(1));
        } else if (selectNumber == 2) {
            order1(dirnklist.get(2));
        } else if (selectNumber == 3) {
            order1(dirnklist.get(3));
        }
    }
    // 상품확인 후 장바구니로 이동
    public void order1(Product product){
        System.out.println(product);
        System.out.println("선택한 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인        2. 취소");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if (num == 1) {
            System.out.println("장바구니에 추가되었습니다.");
            System.out.println();
            mainMenu();
        } else if (num ==2) {
            System.out.println("취소되었습니다.");
            System.out.println();
            mainMenu();
        }else {
            System.out.println("잘못된 값을 입력했습니다.");
        }
    }
}