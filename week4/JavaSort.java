import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Student {
  private int id;
  private String fname;
  private double cgpa;

  public Student(int id, String fname, double cgpa) {
    this.id = id;
    this.fname = fname;
    this.cgpa = cgpa;
  }

  public int getId() {
    return id;
  }

  public String getFname() {
    return fname;
  }

  public double getCgpa() {
    return cgpa;
  }
}

class StudentComparator implements Comparator<Student> {
  @Override
  public int compare(Student x, Student y) {
    if (Double.compare(y.getCgpa(), x.getCgpa()) != 0) {
      return Double.compare(y.getCgpa(), x.getCgpa());
    }

    int nameCompare = x.getFname().compareTo(y.getFname()); //
    if (nameCompare != 0) {
      return nameCompare;
    }

    return Integer.compare(x.getId(), y.getId());
  }
}

public class JavaSort {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int testCases = Integer.parseInt(in.nextLine());

    List<Student> studentList = new ArrayList<>();
    while (testCases > 0) {
      int id = in.nextInt();
      String fname = in.next();
      double cgpa = in.nextDouble();

      Student st = new Student(id, fname, cgpa);
      studentList.add(st);

      testCases--;
    }

    Collections.sort(studentList, new StudentComparator());

    for (Student st : studentList) {
      System.out.println(st.getFname());
    }

    in.close();
  }
}