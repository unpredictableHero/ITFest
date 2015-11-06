package impl;

public class Student {

    private double cnp;
    private String name;
    private int age;

    public Student(double cnp, String name, int age) {
        this.cnp = cnp;
        this.name = name;
        this.age = age;
    }

    public String toString() {

        return getCnp() + " " + getName() + " " + getAge();
    }

    public double getCnp() {
        return cnp;
    }

    public void setCnp(double cnp) {
        this.cnp = cnp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
