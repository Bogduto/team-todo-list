package core.tasks;

public class TaskGroup {
//    Короче тут буде логика

    private String groupName;

    private String groupId;

    private TaskManeger taskManeger;


    public TaskGroup(String groupId, String groupName, TaskManeger taskManeger) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.taskManeger = taskManeger;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public TaskManeger getTaskManeger() {
        return taskManeger;
    }
}
