import java.util.HashMap;
import java.util.Scanner;

public class Manager {
    private static HashMap<Integer, Task> Maptask = new HashMap<>();
    private HashMap<Integer, Epic> Mapepic = new HashMap<>();
    private HashMap<Integer, SubTask> MapsubTask = new HashMap<>();
    static int id = 1;
    Scanner scanner = new Scanner(System.in);

    public static HashMap<Integer, Task> getTask() {
        return Maptask;
    }

    public HashMap<Integer, Epic> getEpic() {
        return Mapepic;
    }

    public HashMap<Integer, SubTask> getSubTask() {
        return MapsubTask;
    }

    public void setTask(HashMap<Integer, Task> task) {
        this.Maptask = task;
    }

    public void setEpic(HashMap<Integer, Epic> epic) {
        this.Mapepic = epic;
    }

    public void setSubTask(HashMap<Integer, SubTask> subTask) {
        this.MapsubTask = subTask;
    }

    public static void manager(Task task, int command) { //мэнеджер для обычной задачи
        /*
        список команд:  1 - создание/сохранить обычную задачу
                        2 - получение списка задач
                        3 - удаление списка задач
          */
        switch (command) {
            case 1:
                Maptask.put(id, task);
                id++;
            case 2:
                getTask();
            case 3:
                Maptask.clear();

        }
    }

    public void manager(Task task, int IDtask, int command) { //мэнеджер для обычной задачи с индифекатором
        /*
        список команд:  1 - обновление задачи по индифекатору
                        2 - получение по индификатору
                        3 - удаление по индификатору
         */
        switch (command) {
            case 1:
                Maptask.put(IDtask, task);
            case 2:
                Maptask.get(IDtask);
            case 3:
                Maptask.remove(IDtask);
        }
    }

    public void manager(Epic epic, int command) { //мэнеджер для ЭПИЧЕСКОЙ задачи
        /*
        список команд:  1 - создание/сохранить задачу
                        2 - получение списка задач
                        3 - удаление списка задач
          */
        switch (command) {
            case 1:
                Mapepic.put(id, epic);
                id++;
            case 2:
                getEpic();
            case 3:
                Mapepic.clear();
        }
    }

    public void manager(Epic epic, int IDepic, int command) { //мэнеджер для обычной задачи с индифекатором
        /*
        список команд:  1 - обновление задачи по индифекатору
                        2 - получение по индификатору
                        3 - удаление по индификатору
                        4 - получение всех подзадач эпика по индификатору
         */
        switch (command) {
            case 1:
                Mapepic.put(IDepic, epic);
                Mapepic.get(IDepic).checkStatus();
            case 2:
                Mapepic.get(IDepic);
            case 3:
                Mapepic.remove(IDepic);
            case 4:
                Mapepic.get(IDepic).getEpicList();
        }
    }
    public void manager(SubTask subTask, int command) { //мэнеджер для ЭПИЧЕСКОЙ задачи
        /*
        список команд:  1 - создание/сохранить задачу
                        2 - получение списка задач
                        3 - удаление списка задач
          */
        switch (command) {
            case 1:
                MapsubTask.put(id, subTask);
                id++;
            case 2:
                getSubTask();
            case 3:
                MapsubTask.clear();
        }
    }

    public void manager(SubTask subTask, int IDsubTusk, int IDepic, int command) { //мэнеджер для подзадачи задачи с индифекатором
        /*
        список команд:  1 - обновление задачи по индифекатору
                        2 - получение по индификатору
                        3 - удаление по индификатору
                        4 - получение всех подзадач по индификатору
         */
        switch (command) {
            case 1:
                MapsubTask.put(IDsubTusk, subTask);
                Mapepic.get(IDepic).setEpicList(subTask);
                Mapepic.get(IDepic).checkStatus();
            case 2:
                MapsubTask.get(IDsubTusk);
            case 3:
                MapsubTask.remove(IDsubTusk);
            case 4:
                MapsubTask.get(IDsubTusk);
        }
    }

}
/*
Mapepic.get(idEpicTask).setEpicList(subTask);
                id++;
                Mapepic.get(idEpicTask).checkStatus(subTask);
 */
