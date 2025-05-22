import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Teacher {
    private String name;
    public Teacher(String name) {
        this.name = name;
    }
}
 class Stuedent implements Cloneable {
    public Teacher teacher;
    public Teacher getTeacher() {
        return teacher;
    }
    public Stuedent(Teacher teacher) {
        this.teacher =teacher;
    }
    public Stuedent clone() throws CloneNotSupportedException {
        return (Stuedent) super.clone();
    }
}
public class Main {
    public static void main(String[] args) {
        // 给定的文本
        String text = "INFO 05-14 09:46:58 metrics.py:349] Avg prompt throughput: 227.3 tokens/s, Avg generation throughput: 1.3 tokens/s, Running: 1 reqs, Swapped:  reqs, Pending: 0 reqs, GPU KV cache usage: 0.6%, CPU KV cache usage: 0.0%";

        // 提取 Running 中的值
        Integer running = extractValue("Running: (\\d+) reqs", text, Integer.class);
        // 提取 Swapped 中的值
        Integer swapped = extractValue("Swapped: (\\d+) reqs", text, Integer.class);
        // 提取 GPU KV cache usage 中的值
        Double gpuCacheUsage = extractValue("GPU KV cache usage: (\\d+\\.*\\d*%)", text, Double.class);
        // 提取 CPU KV cache usage 中的值
        Double cpuCacheUsage = extractValue("CPU KV cache usage: (\\d+\\.*\\d*%)", text, Double.class);

        // 打印结果
        System.out.println("Running: " + running);
        System.out.println("Swapped: " + swapped);
        System.out.println("GPU KV cache usage: " + gpuCacheUsage + "%");
        System.out.println("CPU KV cache usage: " + cpuCacheUsage + "%");
    }

    // 提取指定模式的值
    private static <T> T extractValue(String patternStr, String text, Class<T> clazz) {
        Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            String value = matcher.group(1);
            if (Double.class.isAssignableFrom(clazz)) {
                return (T) (Double) Double.parseDouble(value.replace("%", ""));
            } else {
                return (T) (Integer) Integer.parseInt(value);
            }
        }
        return null;
    }
}