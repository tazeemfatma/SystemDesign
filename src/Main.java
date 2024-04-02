import java.util.*;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String name="Tazeem";
        Arrays.stream(name.split(""))
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet()
                .stream()
                .forEach(entry->System.out.println(entry.getKey()+" "+entry.getValue()));
        Student s1=new Student("taz","loc");
        Student s2=new Student("taz","loc");
System.out.println(s1==s2);
        System.out.println(s1.equals(s2));
        String pattern = "abc.*"; // The pattern to match
        String text = "abcd";   // The input text

        // Compile the pattern
        Pattern compiledPattern = Pattern.compile(pattern);

        // Create a Matcher object
        Matcher matcher = compiledPattern.matcher(text);
        System.out.println("matched "+matcher.matches());

        LinkedHashMap<Integer,Integer> content=new LinkedHashMap<>();
        content.put(1,10);
        content.put(2,15);
        content.put(3,5);
        content.put(4,10);
        content.put(5,1);
        content.entrySet().forEach(entry->System.out.println(entry.getKey()+" "+entry.getValue()));
        content.put(5,15);
        content.entrySet().forEach(entry->System.out.println(entry.getKey()+" "+entry.getValue()));
    }
}