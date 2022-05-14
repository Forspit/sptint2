public class Main {
    public static void main(String[] args) {
    Task task = new Task();
    Task.setTask("task", "check", "NEW");
    Manager.manager(task, 1);
    Manager.manager(task,2);
    System.out.println();
    }


}
