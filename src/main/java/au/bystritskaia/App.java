package au.bystritskaia;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    private static final List<Student> students = List.of(
            new Student("Вася", 26, 4.4D),
            new Student("Вера", 28, 4.7D),
            new Student("Николай", 29, 4.3D)
    );

    private static final File resultJSONFile = new File("C:/temp/students.json");
    private static final File resultJXMLFile = new File("C:/temp/students.xml");
    public static void main( String[] args )
    {


        try {
            JsonMapper mapper = new JsonMapper();
            mapper.writeValue(resultJSONFile, students);

            XmlMapper xmlMapper = new XmlMapper();
            mapper.writeValue(resultJXMLFile, students);

            mapper.readValue(resultJSONFile, new TypeReference<List<Student>>() {
            }).forEach(System.out::println);

            xmlMapper.readValue(resultJXMLFile,new TypeReference<List<Student>>() {
            }).forEach(System.out::println);

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Не удалось сериализовать файл");
            System.out.println(ex.getMessage());
        }


    }
}
