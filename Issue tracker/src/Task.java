public class Task {
    static String nameTask; //название задачи
    static String detailsTask; //описание задачи
    static String status; // статус задачи, NEW, IN_PROGRESS, DONE

    public static void setTask(String NameTask, String DetailsTusk, String Status) {
        nameTask = NameTask;
        detailsTask = DetailsTusk;
        if(status == "NEW" || status == "IN_PROGRESS" || status == "DONE") {
            status = Status;
        }
    }



    public String getNameTask() {
        return nameTask;
    }

    public String getDetailsTask() {
        return detailsTask;
    }

    public String getStatus() {
        return status;
    }
}
