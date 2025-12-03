package org.zindel;

public class DemoRunner {

    public static void main(String[] args) {
        Logger.info("Demo run started");

        //Add a few demo tasks
        addDemoTask("Finish final project video");
        addDemoTask("Write README for final");
        addDemoTask("Submit final project");

        //Mark one task as completed
        if (!TaskManager.taskList.isEmpty()) {
            Task firstTask = TaskManager.taskList.get(0);
            firstTask.setTaskStatus(true);
            Logger.info("Marked task as completed: " + firstTask.getTaskInformation());
        }

        //Show all tasks
        Logger.info("All current tasks:");
        for (Task t : TaskManager.taskList) {
            System.out.println(t.getTaskInformation());
        }

        //Show completed vs incomplete using existing TaskList methods
        Logger.info("Completed tasks:");
        TaskManager.taskList.getCompletedTasks();

        Logger.info("Incomplete tasks:");
        TaskManager.taskList.getIncompleteTasks();

        //Simulate CPU spike (incident) so it shows in Grafana
        burnCpu(20);

        Logger.info("Demo run finished");
    }

    private static void addDemoTask(String name) {
        String id = TaskManager.generateTaskId();
        Task task = new Task(name, false, id);
        TaskManager.taskList.add(task);
        Logger.info("Added task: " + task.getTaskInformation());
    }

    //Incident simulation / CPU stress
    private static void burnCpu(int seconds) {
        Logger.info("Starting CPU spike for " + seconds + " seconds...");
        long end = System.currentTimeMillis() + seconds * 1000L;
        while (System.currentTimeMillis() < end) {
            Math.sqrt(Math.random()); // busy work
        }
        Logger.info("CPU spike finished");
    }
}
