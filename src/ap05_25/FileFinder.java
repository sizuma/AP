package ap05_25;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileFinder {

    List<Path> subDirectories(final Path base) throws IOException{
        List<Path> dirs = Files.list(base).filter(Files::isDirectory).collect(Collectors.toList());
        List<Path> result = new ArrayList<>();
        result.addAll(dirs);
        dirs.forEach(p -> {
            List<Path> sub;
            try { sub = subDirectories(p); }
            catch (IOException e){ sub = new ArrayList<>(); };
            result.addAll(sub);
        });
        return result;
    }

    void run(final String fileName,final String dirName) throws IOException{
        List<Path> sub = subDirectories(Paths.get(dirName));
        sub.add(Paths.get(dirName));
        sub.stream().flatMap(dir -> {
            File[] files = dir.toFile().listFiles(File::isFile);
            if(files != null)return Arrays.stream(files);
            else return Stream.empty();
        }).filter(f -> f.getName().equals(fileName)).forEach(System.out::println);
    }

   public static void main(String[] args) throws IOException{
       new FileFinder().run(args[0],args[1]);
   }
}
