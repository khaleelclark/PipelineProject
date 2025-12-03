package org.zindel;

public class AdvancedDemoRunner {

    public static void main(String[] args) {
        Logger.info("=== FINAL PROJECT DEMO START ===");

        sleep(1500);
        Logger.info("Creating demo tasks...");

        addTask("Finish final project video");
        sleep(1000);
        addTask("Write README and documentation");
        sleep(1000);
        addTask("Record presentation");

        Logger.info("Marking first task as completed...");
        sleep(1500);

        if (!TaskManager.taskList.isEmpty()) {
            Task first = TaskManager.taskList.get(0);
            first.setTaskStatus(true);
            Logger.info("Completed task: " + first.getTaskInformation());
        }

        sleep(1500);
        Logger.info("Displaying all tasks:");
        for (Task t : TaskManager.taskList) {
            System.out.println(t.getTaskInformation());
        }

        sleep(2000);
        Logger.info("Displaying completed tasks:");
        TaskManager.taskList.getCompletedTasks();

        sleep(2000);
        Logger.info("Displaying incomplete tasks:");
        TaskManager.taskList.getIncompleteTasks();

        sleep(2000);
        Logger.info("Starting CPU spike incident simulation...");

        burnCpu(15);

        Logger.info("CPU spike completed.");
        Logger.info("=== FINAL PROJECT DEMO END ===");
    }

    private static void addTask(String name) {
        String id = TaskManager.generateTaskId();
        Task t = new Task(name, false, id);
        TaskManager.taskList.add(t);
        Logger.info("Added task: " + t.getTaskInformation());
    }

    private static void sleep(int ms) {
        try { Thread.sleep(ms); }
        catch (InterruptedException ignored) {}
    }

    private static void burnCpu(int seconds) {
        Logger.info("CPU burn started for " + seconds + " seconds.");
        long end = System.currentTimeMillis() + (seconds * 1000L);
        while (System.currentTimeMillis() < end) {
            Math.sqrt(Math.random());
        }
        Logger.info("CPU burn finished.");
    }
}
