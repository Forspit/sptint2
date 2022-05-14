import java.util.ArrayList;

public class CheckReport {
    public static void checkRep() {
        ArrayList<Integer> monthIncome = MonthlyReport.getSumIncome();
        ArrayList<Integer> monthExpense = MonthlyReport.getSumExpense();
        ArrayList<Integer> yearExpense = YearReport.getYearExpense();
        ArrayList<Integer> yearIncome = YearReport.getYearIncome();

        if (monthIncome.isEmpty() || monthExpense.isEmpty() ||
                yearExpense.isEmpty() || yearIncome.isEmpty()) {
            System.out.println("Сначала считайте файл");
        } else {

            for (int i = 0; i < monthIncome.size(); i++) {
                if (!monthIncome.get(i).equals(yearIncome.get(i))) {
                    System.out.println("Несоответствие суммы доходов за месяц" + (i + 1) +
                            "\nЗначение в отчете за месяц: " + monthIncome.get(i) +
                            " Значение в отчете за год: " + yearIncome.get(i));
                } else {
                    System.out.println("Доходы за " + (i+1) + " совпадают с годовым отчетом");
                }
            }
            for (int i = 0; i < monthExpense.size(); i++) {
                if (!monthExpense.get(i).equals(yearExpense.get(i))) {
                    System.out.println("Несоответствие суммы расходов за " + (i+1) +
                            "\nЗначение в отчете за месяц: " + monthExpense.get(i) +
                            " Значение в отчете за год: " + yearExpense.get(i));
                } else {
                    System.out.println("Расходы за " + (i+1) + " совпадают с годовым отчетом");
                }
            }
        }
    }
}
