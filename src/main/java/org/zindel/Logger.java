package org.zindel;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Logger {
    private static final ObjectMapper mapper = new ObjectMapper();

    public static void info(String msg) {
        log("INFO", msg, null);
    }

    public static void warning(String msg) {
        log("WARNING", msg, null);
    }

    public static void error(String msg, Throwable t) {
        log("ERROR", msg, t);
    }

    private static void log(String level, String msg, Throwable t) {
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("ts", Instant.now().toString());
            map.put("level", level);
            map.put("message", msg);
            if (t != null) map.put("error", t.toString());
            System.out.println(mapper.writeValueAsString(map));
        } catch (Exception e) {
            System.out.println("LOGGER_FALLBACK " + msg);
        }
    }
}
