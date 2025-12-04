# Final Project: Enhanced CI/CD Pipeline with Monitoring, Logging & Incident Response

### Author: Khaleel
### Course: CEN4802C – Software Integration, Configuration & Testing
### Final Project Submission

---

## Project Overview

This project extends the midterm pipeline into a **production-style CI/CD system** that includes:

- **Automated Testing**
- **Structured JSON Logging**
- **Real-time JVM Monitoring**
- **Prometheus Metrics Exporting**
- **Grafana Visualization**
- **Incident Simulation (CPU Spike)**
- **Hands-free DemoRunner for demonstrations**

The goal is to simulate real engineering workflows used for reliability, observability, and deployment stability.

---

## Automated Testing (CI/CD)

Jenkins includes a **Test** stage:

```groovy
stage('Test') {
    steps {
        bat 'mvn test'
        junit '**/target/surefire-reports/*.xml'
    }
}
```
This ensures:

- Every commit triggers a test run  
- JUnit reports are published  
- The build fails if tests fail  

---

### Structured JSON Logging

A custom Logger class outputs clean JSON-formatted logs such as:

```json
{
  "ts": "2025-02-15T05:22:10Z",
  "level": "INFO",
  "message": "Added task with ID 14"
}
```


### Benefits:
- Machine-readable  
- Easy to parse/filter  
- Matches modern observability standards  

---

### Monitoring (Prometheus + JVM Agent)

The application is monitored using:

- `jmx_prometheus_javaagent.jar`  
- A custom `jmx_config.yml`  
- Prometheus scraping metrics from `localhost:9999`  

**Prometheus collects JVM metrics such as:**

- CPU usage  
- Heap memory  
- GC pauses  
- Live thread count
---

### Grafana Dashboards

Grafana reads Prometheus data and displays:

- JVM CPU usage visualization  
- Heap / non-heap memory charts  
- Thread lifecycle metrics  
- CPU spike events  

This demonstrates **observability & incident detection**.

---

### Incident Simulation: CPU Spike

A deliberate CPU burn simulates a performance failure with warning messages:

```java
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
```

When triggered:
- CPU usage spikes in Grafana  
- Prometheus records the event  
- JSON logs mark at start and end of the incident  

---

## Automated Demo Mode

`DemoRunner.java` provides a fully automatic demonstration:

- Creates tasks  
- Completes one task  
- Displays all tasks  
- Produces JSON logs  
- Triggers CPU spike  
- Requires zero user input  

**Run with:**

```sh
java -javaagent:monitoring/jmx_prometheus_javaagent.jar=9999:monitoring/jmx_config.yml -cp target/my-app-1.0-SNAPSHOT.jar org.zindel.DemoRunner

````
## How to Run the Project (Windows)

### 1. Build the JAR
```sh
mvn clean package
````
### Run the app with monitoring enabled
```sh
java -javaagent:monitoring/jmx_prometheus_javaagent.jar=9999:monitoring/jmx_config.yml -cp target/my-app-1.0-SNAPSHOT.jar org.zindel.DemoRunner

```
### Start Prometheus
```sh
prometheus.exe --config.file="monitoring/prometheus.yml"
```




























