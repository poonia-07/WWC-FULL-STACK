import java.util.*;

class Student {
    private String id, name;
    private int marks;

    public Student(String id, String name, int marks){
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public String getId(){ return id; }
    public int getMarks(){ return marks; }

    public String getRole(){ return "Undergrad"; }

    @Override
    public String toString(){
        return id + " - " + name + " (" + marks + ") " + getRole();
    }
}

class GraduateStud extends Student {
    private String area;

    public GraduateStud(String id, String name, int marks, String area){
        super(id, name, marks);
        this.area = area;
    }

    @Override
    public String getRole(){
        return "Grad (" + area + ")";
    }
}

class HonorsStudent extends Student{
    private int BonusMarks;
    public HonorsStudent(String id, String name, int marks, int BonusMarks){
        super(id, name, marks);
        this.BonusMarks = BonusMarks;
    }
    @Override
    public String getRole(){
        return "Honors (" + BonusMarks + ")";
    }
}

class Repo<T>{
    private Map<String, T> data = new HashMap<>();

    public void save(String id, T obj){
        data.put(id, obj);
    }
    public T find(String id){
        return data.get(id);
    }
    public void delete(String id){
        data.remove(id);
    }
}

public class Main {
    public static Student findTopper(List<Student> list){
        if(list.isEmpty()) return null;

        Student topper = list.get(0);

        for(Student s : list){
            if(s.getMarks() > topper.getMarks()){
                topper = s;
            }
        }

        return topper;
    }

    
    public static void main(String[] args){

        List<Student> list = new ArrayList<>();

        list.add(new Student("S1", "Harsh", 90));
        list.add(new Student("S2", "Umang", 97));
        list.add(new Student("S3", "Nikhil", 85));

        list.add(new GraduateStud("G1", "Happy", 99, "CS"));
        
        list.add(new HonorsStudent("A1","Avin",50,20));
        

        Repo<Student> repo = new Repo<>();

        for(Student s : list)
            repo.save(s.getId(), s);

        System.out.println("ALL:");
        list.forEach(System.out::println);

        System.out.println("\nLOOKUP S2: ");
        Student found = repo.find("S2");
        System.out.println(found != null ? found : "not found");
        
        System.out.println("\nTopper is: ");
        System.out.println(findTopper(list));

        Iterator<Student> it = list.iterator();

        while(it.hasNext()){
            Student st = it.next();
            if(st.getMarks() < 90){
                it.remove();
                repo.delete(st.getId());
            }
        }

        System.out.println("\nAfter Removal:");
        list.forEach(System.out::println);
    }
}
