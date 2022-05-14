import java.util.ArrayList;

class YearReport {
    private static int year = 2021;
    static String pathYear = "./resources/y." + year + ".csv";

    public static ArrayList<Integer> getYearIncome() {
        return yearIncome;
    }

    public static ArrayList<Integer> getYearExpense() {
        return yearExpense;
    }

    private static ArrayList<Integer> yearIncome = new ArrayList<>();
    private static ArrayList<Integer> yearExpense = new ArrayList<>();


    public static void readYearlyReport() {
        if(readFileContentsOrNull.readFileContentsOrNull(pathYear) == null){
            System.out.println("Невозможно прочитать файл с годовым отчётом. Возможно, файл не находится в нужной директории.");

        }else{
            String fileContents = readFileContentsOrNull.readFileContentsOrNull(pathYear);
            String[] lines = fileContents.split(("\\n"));
            for (int i = 1; i < lines.length; i++) {
                String[] line = lines[i].split(",");
                int value = Integer.parseInt(line[1]);
                if(line[2].equals("true")) {
                    yearExpense.add(value);
                }else{
                    yearIncome.add(value);
                }
            }
            System.out.println("Считывание отчета за год завершено");
        }
    }

    private static double getAverageExpenseYear(){ //средний расход
        int sum=0;
        for (int Expense : yearExpense){
            sum += Expense;
        }
        int averageExpense = sum/ yearExpense.size();
        return averageExpense;
    }

    private static double getAverageIncomeYear(){ //средний доход
        int sum=0;
        for (int Income : yearIncome){
            sum += Income;
        }
        int averageIncome = sum/ yearIncome.size();
        return averageIncome;
    }

    private static void getProfit() { //прибыль по каждому месяцу
        double profitInMonth = 0;
        for (int i = 0; i< yearExpense.size(); i++){
            profitInMonth = yearIncome.get(i) - yearExpense.get(i);
            System.out.println("Прибыль в  месяце " + (i + 1) + ": " + profitInMonth);
        }
    }

    public static void printYearReport(){
        if (!yearIncome.isEmpty() && !yearExpense.isEmpty()) {
            System.out.println("Отчет за "+ year + " год:");
            getProfit();
            System.out.println("Средний расход за все месяцы в году : "+ getAverageExpenseYear());
            System.out.println("Средний доход за все месяцы в году : "+ getAverageIncomeYear());
            System.out.println("Доход по месяцам:");
            System.out.println(yearIncome);
            System.out.println("Расход по месяцам:");
            System.out.println(yearExpense);
        } else {
            System.out.println("Сначала выполните считывание отчета за год");
        }
        System.out.println();
    }
}