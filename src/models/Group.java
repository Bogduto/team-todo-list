package models;

import core.tasks.TaskManeger;

public class Group {
//    Короче тут буде логика

    private String groupName;

    private String groupId;

    private String listId;

    private TaskManeger taskManeger;


    public Group(String groupId, String groupName, TaskManeger taskManeger, String listId) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.taskManeger = taskManeger;
        this.listId = listId;
    }

    public String getGroupId() {
        return groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public String getListId() {
        return listId;
    }

    public TaskManeger getTaskManeger() {
        return taskManeger;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
