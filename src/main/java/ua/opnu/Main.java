package ua.opnu;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== Тестування Student ===");

        Student student = new Student("Сутайкін Єгор", 2);

        student.addCourse("Об'єктно-орієнтоване програмування");
        student.addCourse("Бази даних");
        student.addCourse("Теорія алгоритмів");

        System.out.println(student.getName() + ": кількість вивчаємих дисциплін - " + student.getCourseCount());

        System.out.println(student.getName() + ": рік навчання - " + student.getYear());

        System.out.println(student.getName() + ": заплатив за навчання - " + student.getTuition());


        System.out.println("\n=== Тестування TimeSpan ===");
        TimeSpan ts1 = new TimeSpan(1, 45);
        System.out.println("Початковий час: " + ts1); // 1h 45m
        ts1.add(0, 20);
        System.out.println("Після додавання 20 хв: " + ts1); // 2h 5m
        System.out.println("Всього годин: " + ts1.getTotalHours());

        System.out.println("\n=== Тестування BankAccount ===");
        BankAccount acc1 = new BankAccount("User1", 1000);
        BankAccount acc2 = new BankAccount("User2", 0);

        acc1.setTransactionFee(10);

        System.out.println("До переказу: " + acc1 + " | " + acc2);

        boolean success = acc1.transfer(acc2, 100);

        if(success) System.out.println("Переказ успішний!");
        else System.out.println("Помилка переказу.");

        System.out.println("Після переказу: " + acc1 + " | " + acc2);
    }
}