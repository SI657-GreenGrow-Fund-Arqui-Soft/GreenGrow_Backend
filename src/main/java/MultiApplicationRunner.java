import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MultiApplicationRunner {

    public static void main(String[] args) {
        System.out.println("Directorio de trabajo actual: " + System.getProperty("user.dir"));

        int[] ports = {8761, 8000, 8080, 8081, 8082, 8083, 8084, 8085};
        cleanPorts(ports);

        List<String[]> commands = new ArrayList<>();
        commands.add(new String[]{"java", "-jar", "api-gateway-eureka/target/api-gateway-eureka-1.0-SNAPSHOT.jar"});
        commands.add(new String[]{"java", "-jar", "articles/target/articles-1.0-SNAPSHOT.jar"});
        commands.add(new String[]{"java", "-jar", "article2s/target/article2s-1.0-SNAPSHOT.jar"});
        commands.add(new String[]{"java", "-jar", "courses/target/courses-1.0-SNAPSHOT.jar"});
        commands.add(new String[]{"java", "-jar", "posts/target/posts-1.0-SNAPSHOT.jar"});
        commands.add(new String[]{"java", "-jar", "profiles/target/profiles-1.0-SNAPSHOT.jar"});
        commands.add(new String[]{"java", "-jar", "trends/target/trends-1.0-SNAPSHOT.jar"});

        try {
            Process process = new ProcessBuilder(
                    "java",
                    "-jar",
                    "discovery-server/target/discovery-server-1.0-SNAPSHOT.jar").start();
            waitForDiscoveryServerToStart(process);
            new Thread(() -> printProcessOutput_(process)).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        commands.forEach(command -> {
            System.out.println("Levantando servicio: [" + command[2] + "]");
            ProcessBuilder processBuilder = new ProcessBuilder(command);
            try {
                Process process = processBuilder.start();
                new Thread(() -> printProcessOutput_(process)).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            cleanPorts(ports);
        }));
    }
    static private void waitForDiscoveryServerToStart(Process process) throws IOException {
        System.out.println("Levantando servicio Discovery Server");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("Started")) {
                    System.out.println(line);
                    System.out.println("Servicio levantado: http://localhost:8761/");
                    break;
                }
            }
        }
    }
    private static void printProcessOutput_(Process process) {
        try (BufferedReader inputReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
             BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()))) {
            String line;
            while ((line = inputReader.readLine()) != null) {
                if (line.contains("Started")) {
                    System.out.println(line);
                }
            }
            /*
            System.out.println("Errores del proceso:");
            while ((line = errorReader.readLine()) != null) {
                System.out.println(line);
            }*/
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void cleanPorts(int[] ports) {
        System.out.println("Limpiando puertos");
        String host = "localhost";
        Arrays.stream(ports).forEach((port) -> {
            String cmd = "cmd /c netstat -aon | findstr :" + port;
            Process process = null;
            try {
                process = Runtime.getRuntime().exec(cmd);
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    if (line.contains("LISTENING")) {
                        String pid = line.substring(line.lastIndexOf(" ") + 1);
                        System.out.println("PID: " + pid);
                        killProcess(pid);
                        break;
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

    }

    private static void killProcess(String pid) {
        try {
            Runtime.getRuntime().exec("cmd /c taskkill /PID " + pid + " /F");
            System.out.println("Proceso con PID " + pid + " ha sido terminado.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}