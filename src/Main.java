import java.util.Scanner;

public class Main {
    private static Catalog catalog = Catalog.get();
    private static Cart cart = Cart.get();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Добро пожаловать в магазин \"Электро\"!");

        Product product1 = new Product("Игрушка", "Игромир", "Машинка на пульте управления", 10, "Toy");
        Product product2 = new Product("Игрушка", "Игромир", "Игрушечный автомат", 5, "Toy");
        Product product3 = new Product("Игрушка", "Малыш", "Машинка BMW", 7, "Toy");
        Product product4 = new Product("Кондиционер", "Ballu", "Ballu j35", 200, "Technic");
        Product product5 = new Product("Телевизор", "LG", "LG 22LN420V", 500, "TV");
        Product product6 = new Product("Смартфон", "Aplle", "IPhone 13", 700, "Device");
        Service service1 = new Service("Расширенная гарантия на 1 год", 10);
        Service service2 = new Service("Установка и настройка", 5);
        Service service3 = new Service("Замена экрана", 2);
        Service service4 = new Service("Установка кондиционера", 9);

        catalog.displayAvailableArticles();
        requestForProductToCart();
    }

    public static void requestForProductToCart() {
        boolean flagToExit = false;
        while (true) {
            System.out.print("\nВведите номер товара для помещения в корзину или \"0\" для оформления заказа: ");
            int answer = scanner.nextInt();

            if ((answer > 0) && (answer <= catalog.getCatalogSize())) {
                cart.addToCart(catalog.getProductFromCatalog(answer - 1));
            } else if (answer == 0) {
                flagToExit = true;
            }

            if (flagToExit) {
                System.out.println("Заказ на " + cart.getTotalCartSum() + "$ оформлен.");
                System.out.println("СПАСИБО ЗА ЗАКАЗ!");
                break;
            }

        }
    }

}