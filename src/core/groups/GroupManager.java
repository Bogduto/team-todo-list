package core.groups;

import core.tasks.TaskManeger;
import models.Group;

import java.util.ArrayList;
import java.util.UUID;


public class GroupManager {
    private ArrayList<Group> groups;

    public GroupManager(ArrayList<Group> groups) {
        if (groups == null) {
            this.groups = new ArrayList<Group>();
        } else {
            this.groups = groups;
        }
    }

    public void addGroup(String groupName) {
        String id = UUID.randomUUID().toString();
        Group group = new Group(id, groupName, new TaskManeger(null), null);
        groups.add(group);
    }

    public void removeGroupById(String groupId) {
        groups.removeIf(g -> g.getGroupId().equals(groupId));
    }

    public Group getGroupById(String groupId) {
        return groups.stream()
                .filter(g -> g.getGroupId().equals(groupId))
                .findFirst()
                .orElse(null);
    }

    public ArrayList<Group> getAllGroups() {
        return groups;
    }
}
