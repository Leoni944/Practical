package ru.mirea.kabo0222.task2;
import java.util.Scanner;

class Node {
    String name;
    int age;
    Node prev;
    Node next;

    public Node(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void readAttributes() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя: ");
        name = scanner.nextLine();
        System.out.print("Введите возраст: ");
        age = scanner.nextInt();
        scanner.nextLine();
    }

    void printAttributes() {
        System.out.println("Имя: " + name);
        System.out.println("Возраст: " + age);
    }
}

class LinkedList {
    Node head;

    boolean isEmpty() {
        return head == null;
    }

    void addNode(Node node) {
        if (isEmpty()) {
            head = node;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
            node.prev = current;
        }
    }

    void deleteNode(Node node) {
        if (head == node) {
            head = node.next;
            if (head != null) {
                head.prev = null;
            }
        } else {
            Node current = head;
            while (current != null && current != node) {
                current = current.next;
            }
            if (current != null) {
                current.prev.next = current.next;
                if (current.next != null) {
                    current.next.prev = current.prev;
                }
            }
        }
    }

    void printList() {
        Node current = head;
        while (current != null) {
            current.printAttributes();
            current = current.next;
        }
    }

    void clear() {
        head = null;
    }
}

class Tester {
    LinkedList linkedList = new LinkedList();

    Node inputNodeAttributes() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя: ");
        String name = scanner.nextLine();
        System.out.print("Введите возраст: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        return new Node(name, age);
    }

    void mainMenu() {
        System.out.println("1. Создать пустой список");
        System.out.println("2. Добавить элемент в список");
        System.out.println("3. Удалить элемент из списка");
        System.out.println("4. Вывести элементы списка");
        System.out.println("5. Очистить список");
        System.out.println("6. Проверить список на пустоту");
        System.out.println("7. Закончить программу");
    }

    void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            mainMenu();
            System.out.print("Выберите пункт меню: ");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                linkedList.clear();
            } else if (choice.equals("2")) {
                Node node = inputNodeAttributes();
                linkedList.addNode(node);
            } else if (choice.equals("3")) {
                Node node = inputNodeAttributes();
                linkedList.deleteNode(node);
            } else if (choice.equals("4")) {
                if (linkedList.isEmpty()) {
                    System.out.println("Список пуст");
                } else {
                    linkedList.printList();
                }
            } else if (choice.equals("5")) {
                linkedList.clear();
            } else if (choice.equals("6")) {
                if (linkedList.isEmpty()) {
                    System.out.println("Список пуст");
                } else {
                    System.out.println("Список не пуст");
                }
            } else if (choice.equals("7")) {
                break;
            } else {
                System.out.println("Некорректный выбор");
            }
        }
    }

    public static void main(String[] args) {
        Tester tester = new Tester();
        tester.run();
    }
}