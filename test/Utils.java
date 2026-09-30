package test;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static List<Class<?>> loadAllClasses() {
        List<Class<?>> classes = new ArrayList<>();
        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            URL resource = classLoader.getResource("");
            if (resource != null) {
                File directory = new File(resource.getFile());
                if (directory.exists()) {
                    findClasses(directory, "", classes);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return classes;
    }

    private static void findClasses(File directory, String packageName, List<Class<?>> classes) {
        File[] files = directory.listFiles();
        if (files == null) return;

        for (File file : files) {
            if (file.isDirectory()) {
                String subPackage = packageName.isEmpty() ? file.getName() : packageName + "." + file.getName();
                findClasses(file, subPackage, classes);
            } else if (file.getName().endsWith(".class")) {
                String className = (packageName.isEmpty() ? "" : packageName + ".") 
                        + file.getName().substring(0, file.getName().length() - 6);
                try {
                    classes.add(Class.forName(className));
                } catch (ClassNotFoundException e) {
                    // Ignore unloadable classes
                }
            }
        }
    }
}