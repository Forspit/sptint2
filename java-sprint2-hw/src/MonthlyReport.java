import java.util.ArrayList;
import java.util.HashMap;

public class MonthlyReport {

    static String FileCSV[] = new String[3];//массив для сторк файла
    static HashMap<Integer, ArrayList<Month>> monthMap = new HashMap<>();//для хранения приведенных строк файла, ключ номер месяца
    public static ArrayList<Integer> sumIncome;
    public static ArrayList<Integer> sumExpense;

    public static void readMonthlyReport() { //считываем файл
        String[] line;
        for(int i = 1; i <= 3; i++){
            ArrayList<Month> monthItemList = new ArrayList<>();//список объектов месяца
            String PathMonth = "./resources/m.20210" + i + ".csv";
            if(readFileContentsOrNull.readFileContentsOrNull(PathMonth) == null){
                System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно, файл не находится в нужной директории.");
                break;
            }else{
                FileCSV[i - 1] = readFileContentsOrNull.readFileContentsOrNull(PathMonth);
                 //приводим файл в объекты приложения (не уверен что следовало впихнуть вторую функцию в метод)
                String[] lines = FileCSV[i - 1].split(("\\n"));
                for (int j = 1; j < lines.length; j++) {
                Month month = new Month();
                line = lines[j].split(",");
                month.setMonth(line[0], Boolean.parseBoolean(line[1]), Integer.parseInt(line[2]), Integer.parseInt(line[3]));
                monthItemList.add(month);
                monthMap.put(i, monthItemList);
                }

                System.out.println("Считывание отчета за месяц " + i + " завершено");
            }
        }
    }

    public static void getMaxIncomeMonth(int i){//ищет максимальный доход месяца и имя товара
        int maxExpense = 0;
        String itemName = " ";
        for (Month item : monthMap.get(i)){
            int monthItemSum = item.getQuantity() * item.getSum_of_one();
            if (!item.getIs_expense()) {
                if ((monthItemSum) > maxExpense){
                    maxExpense = monthItemSum;
                    itemName = item.getItem_name();
                }
            }
        }
        System.out.println("Самый прибыльный товар месяца: " + itemName + "\nСтоимость: " + maxExpense);
    }

    private static void getMaxSpendMonth(int i){//максимальная трата одного месяца
        int maxSpend = 0;
        String itemName = " ";
        for (Month item : monthMap.get(i)) {
            int monthItemSum = item.getQuantity() * item.getSum_of_one();
            if (item.getIs_expense()) {
                if ((monthItemSum) > maxSpend) {
                    maxSpend = monthItemSum;
                    itemName = item.getItem_name();
                }
            }
        }
        System.out.println("Самая большая трата месяца: " + itemName + "\nСтоимость: " + maxSpend) ;
    }

    public static void getMaxExpenseAndSpend(){ //максимальный доход и траты всех месяцев
        if (monthMap.isEmpty()){
            System.out.println("Сначала произведите чтение файлов");
        }
        else {
            for (int i = 1; i <= monthMap.size(); i++) {
                System.out.println("Данные за месяц" + i);
                getMaxIncomeMonth(i);
                getMaxSpendMonth(i);
            }
        }
    }

    public static ArrayList<Integer> getSumIncome() {
        sumIncome = new ArrayList<>();
        for (int i = 1; i <= monthMap.size(); i++) {

            int sumIncomeMonth = 0;
            for (Month item : monthMap.get(i)) {
                int monthSum = item.getQuantity() * item.getSum_of_one();
                if (!item.getIs_expense()) {
                    sumIncomeMonth = sumIncomeMonth + monthSum;
                }
            }
            sumIncome.add(sumIncomeMonth);
        }return sumIncome;
    }


    public static ArrayList<Integer> getSumExpense() {
        sumExpense = new ArrayList<>();
        for (int i = 1; i <= monthMap.size(); i++) {
            int sumExpenseMonth = 0;
            for (Month item : monthMap.get(i)) {
                int monthItemSum = item.getQuantity() * item.getSum_of_one();
                if (item.getIs_expense()) {
                    sumExpenseMonth = sumExpenseMonth + monthItemSum;
                }
            }
            sumExpense.add(sumExpenseMonth);
        }return sumExpense;
    }
}
