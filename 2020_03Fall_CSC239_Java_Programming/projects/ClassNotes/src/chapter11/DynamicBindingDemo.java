package chapter11;

public class DynamicBindingDemo {
  public static void main(String[] args) {
	Object o = new GraduateStudent(); // implicit casting
	
	Object o1 = new Object();
	
	if (o1 instanceof GraduateStudent) {
	  System.out.println("Never got here");
	  GraduateStudent gs = (GraduateStudent)o1; // explicit casting
          System.out.printf("1: ");
          m(gs);
	}
        if (o instanceof GraduateStudent) {
          System.out.printf("2: ");
	  Person gs = (GraduateStudent)o; // explicit casting
          m(gs);
	}
	
    System.out.printf("3: ");
    m(o);
    System.out.printf("4: ");
    m(new Student());
    System.out.printf("5: ");
    m(new Person());
    System.out.printf("6: ");
    m(new Object());
  }

  public static void m(Object x) {
    System.out.println(x.toString());
  }
}

class GraduateStudent extends Student {
    public String toString() {
    return "Grad";
  }
}

class Student extends Person {
  public String toString() {
    return "Student";
  }
}

class Person extends Object {
  public String toString() {
    return "Person";
  }
}
