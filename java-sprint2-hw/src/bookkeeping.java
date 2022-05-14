import java.util.Scanner;

public class bookkeeping {
    public static void main(String[] args) {
        printMenu();
        Scanner scanner = new Scanner(System.in);
        while (true){
            switch (scanner.nextInt()){
                case 1:
                    MonthlyReport.readMonthlyReport();
                    printMenu();
                    break;
                case 2:
                    YearReport.readYearlyReport();
                    printMenu();
                    break;
                case 3:
                    CheckReport.checkRep();
                    printMenu();
                    break;
                case 4:
                    MonthlyReport.getMaxExpenseAndSpend();
                    printMenu();
                    break;
                case 5:
                    YearReport.printYearReport();
                    printMenu();
                    break;
                case 0:
                    System.out.println("Завершение программы");
                    return;
                default:
                    System.out.println("Нет такой команды");
                    printMenu();
            }
        }

    }

    public static void printMenu() {
        System.out.println("Доступные варианты команд: ");
        System.out.println("1 - Считать месячные отчёты");
        System.out.println("2 - Считать годовой отчёт");
        System.out.println("3 - Сверить отчёты");
        System.out.println("4 - Информацию о всех месячных отчётах");
        System.out.println("5 - Информация о годовом отчёте");
        System.out.println("0 - Выход");
    }
}
