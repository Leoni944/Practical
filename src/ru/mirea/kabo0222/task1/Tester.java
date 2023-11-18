package ru.mirea.kabo0222.task1;
import java.util.Scanner;
class CardItem {
    private String name;
    private int age;

    public void readAttributesFromConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя: ");
        name = scanner.nextLine();
        System.out.print("Введите возраст: ");
        age = scanner.nextInt();
    }

    public void displayAttributes() {
        System.out.println("Имя: " + name);
        System.out.println("Возраст: " + age);
    }
}

// Контейнерный класс для хранения списка элементов
class CardList {
    private static final int MAX_SIZE = 100;
    private CardItem[] items;
    private int size;

    public CardList() {
        items = new CardItem[MAX_SIZE];
        size = 0;
    }

    public void addCardItem(CardItem item) {
        if (size < MAX_SIZE) {
            items[size] = item;
            size++;
            System.out.println("Элемент добавлен в список.");
        } else {
            System.out.println("Список полон, невозможно добавить элемент.");
        }
    }

    public void removeCardItem(int index) {
        if (index >= 0 && index < size) {
            for (int i = index; i < size - 1; i++) {
                items[i] = items[i + 1];
            }
            items[size - 1] = null;
            size--;
            System.out.println("Элемент удален из списка.");
        } else {
            System.out.println("Неверный индекс элемента.");
        }
    }

    public void displayCardItem(int index) {
        if (index >= 0 && index < size) {
            CardItem item = items[index];
            item.displayAttributes();
        } else {
            System.out.println("Неверный индекс элемента.");
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        items = new CardItem[MAX_SIZE];
        size = 0;
        System.out.println("Список очищен.");
    }
}

// Класс Тестер
public class Tester {
    public static void main(String[] args) {
        CardList cardList = new CardList();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nМеню:\n1. Создать пустой список\n2. Добавить элемент\n3. Удалить элемент\n4. Вывести элемент\n5. Проверить список на пустоту\n6. Очистить список\n7. Выйти из программы");
            System.out.print("Введите выбранный пункт меню: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера после считывания числа

            switch (choice) {
                case 1:
                    cardList = new CardList();
                    System.out.println("Создан пустой список.");
                    break;
                case 2:
                    CardItem newItem = new CardItem();
                    newItem.readAttributesFromConsole();
                    cardList.addCardItem(newItem);
                    break;
                case 3:
                    System.out.print("Введите индекс элемента для удаления: ");
                    int removeIndex = scanner.nextInt();
                    cardList.removeCardItem(removeIndex);
                    break;
                case 4:
                    System.out.print("Введите индекс элемента для вывода: ");
                    int displayIndex = scanner.nextInt();
                    cardList.displayCardItem(displayIndex);
                    break;
                case 5:
                    boolean isEmpty = cardList.isEmpty();
                    System.out.println("Список пустой: " + isEmpty);
                    break;
                case 6:
                    cardList.clear();
                    break;
                case 7:
                    System.out.println("Программа завершена.");
                    break;
                default:
                    System.out.println("Неверный выбор.");
                    break;
            }
        } while (choice != 7);
    }
}