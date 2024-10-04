import java.util.Comparator;

public class NameComparator implements Comparator<Student>{

    @Override
    public int compare(Student o1, Student o2) {

        Student s1=(Student)o1;  
        Student s2=(Student)o2;  

        return s1.getName().compareTo(s2.getName());
    }
    
}
