import java.util.Objects;

public class Student {
    String name;
    String loc;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student(String name, String loc) {
        this.name = name;
        this.loc = loc;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

  /* @Override
    public boolean equals(Object obj) {
        Student s=(Student)obj ;
        return s.name.equals(this.name);
    }*/
}
