public class Month { //сохраняем объекты месяца
    private String item_name;
    private Boolean is_expense;
    private int quantity;
    private int sum_of_one;

    public void setMonth(String item_name, Boolean is_expense, int quantity, int sum_of_one){
        this.item_name = item_name;
        this.is_expense = is_expense;
        this.quantity  = quantity;
        this.sum_of_one = sum_of_one;
    }

    public String getItem_name() {
        return item_name;
    }

    public Boolean getIs_expense() {
        return is_expense;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getSum_of_one() {
        return sum_of_one;
    }
}
