package de.otto.refresher.buisness;

import java.util.Collection;
import java.util.LinkedHashMap;

public class TasksMap extends LinkedHashMap<Long, Task> {

    public TasksMap getUndone() {
        TasksMap undoneTasks = new TasksMap();
        final Collection<Task> tasks = this.values();
        //todo filter undone tasks
        return undoneTasks;
    }

    public TasksMap getDone() {
        TasksMap doneTasks = new TasksMap();
        final Collection<Task> tasks = this.values();
        //todo filter done tasks
        return doneTasks;
    }

    public Task put(Task task) {
        final TasksMap taskMap = this;
        //todo add task to map (der key sollte die id des tasks sein)
        return null;
    }
}
