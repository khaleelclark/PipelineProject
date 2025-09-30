package org.zindel;

public class Task {
    private String taskName;
    private boolean taskStatus;
    private String taskId;

    public Task(String taskName, boolean taskStatus, String taskId) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.taskStatus = taskStatus;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
    public boolean isTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(boolean taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String taskStatus () {
        if (taskStatus) {
            return "Completed ✓";
        } else {
            return "Incomplete ✗";
        }
    }

    public String getTaskInformation() {
        return "ID: " + taskId + " | Task Name: " + taskName + " | Status: " + (taskStatus ? "Completed ✓" : "Incomplete ✗");
    }

}

