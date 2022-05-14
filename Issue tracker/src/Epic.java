import java.util.ArrayList;

public class Epic extends Task{

    ArrayList<SubTask> epicList = new ArrayList<>();// список подзадач эпика

    public void setEpicList(SubTask SubTask) {
       epicList.add(SubTask);

    }

    public ArrayList<SubTask> getEpicList(){
        return epicList;
    }

    public void checkStatus(){
        int check = 0;
        int check2 = 0;
        for(SubTask listSubTask : epicList){
            if (listSubTask.getStatus() == "NEW"){
                check++;
                if(check == epicList.size()){
                    status = "NEW";
                }else status = "IN_PROGRESS";
            }else if(listSubTask.getStatus() == "DONE") {
                check2++;
                if(check2 == epicList.size()){
                    status = "DONE";
                }else status = "IN_PROGRESS";
            }
        }


    }

}
