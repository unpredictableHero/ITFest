import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import impl.Student;

public class Example1 {

    public static void main(String[] args) {

        List<Student> studentList;
        studentList = readStudents();
        studentList.forEach(s -> System.out.println(s.getName()));

        studentList.stream().filter(s -> s.getName().startsWith("a")).forEach(s -> System.out.println(s.getCnp()));
    }

    private static List<Student> readStudents() {

        List<Student> studentList2 = null;
        try {
            studentList2 = Files.lines(Paths.get(Example1.class.getResource("Students").toURI()))
                    .map(line -> line.split("~"))
                    .map(student -> new Student(Double.parseDouble(student[0]), student[1],
                            Integer.parseInt(student[2]))).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return studentList2;
    }

}
