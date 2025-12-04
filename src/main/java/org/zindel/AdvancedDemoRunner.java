package org.zindel;

public class AdvancedDemoRunner {
    //test change for test commit

    public static void main(String[] args) {
        Logger.info("=== FINAL PROJECT DEMO START ===");

        sleep(6000);
        Logger.info("Creating demo tasks...");

        addTask("Finish final project video");
        sleep(6000);
        addTask("Write README and documentation");
        sleep(6000);
        addTask("Record presentation");

        Logger.info("Marking first task as completed...");
        sleep(6000);

        if (!TaskManager.taskList.isEmpty()) {
            Task first = TaskManager.taskList.getFirst();
            first.setTaskStatus(true);
            Logger.info("Completed task: " + first.getTaskInformation());
        }

        sleep(6000);
        Logger.info("Displaying all tasks:");
        for (Task t : TaskManager.taskList) {
            System.out.println(t.getTaskInformation());
        }

        sleep(7000);
        Logger.info("Displaying completed tasks:");
        TaskManager.taskList.getCompletedTasks();

        sleep(7000);
        Logger.info("Displaying incomplete tasks:");
        TaskManager.taskList.getIncompleteTasks();

        sleep(8000);
        Logger.info("Starting CPU spike incident simulation...");

        burnCpu(30);

        Logger.info("CPU spike completed.");

        Logger.info("Adding follow-up tasks after incident...");

        addTask("Monitor spike on grafana");
        sleep(6000);
        addTask("Keep recording a wonderful demo");
        sleep(6000);
        addTask("Ace your presentation");

        sleep(6000);
        Logger.info("Displaying all tasks:");
        for (Task t : TaskManager.taskList) {
            System.out.println(t.getTaskInformation());
        }

        Logger.info("Cooling system after incident.");
        sleep(60000);

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
        long warnAt = System.currentTimeMillis() + 10000; // 10 seconds into the burn
        boolean warned = false;

        long warnAt2 = System.currentTimeMillis() + 20000;
        boolean warned2 = false;

        while (System.currentTimeMillis() < end) {
            Math.sqrt(Math.random()); // keep CPU busy

            if (!warned && System.currentTimeMillis() >= warnAt) {
                Logger.warning("High CPU usage detected. System under stress.");
                warned = true;
            }

            if (!warned2 && System.currentTimeMillis() >= warnAt2) {
                Logger.warning("Sustained high CPU detected. Potential overload.");
                warned2 = true;
            }
        }
        Logger.info("CPU burn finished.");
    }
}
