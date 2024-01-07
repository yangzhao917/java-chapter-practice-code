package cn.gotojava.chapter11;

public class Student implements Comparable<Student> {

    // 姓名
    private String name;

    // 年龄
    private int age;

    // 分数
    private double score;

    public Student(String name, int age, double score) {
        this.name = name;
        this.age = age;
        this.score = score;
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

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    /**
     * 按照成绩由高到低排序，如果成绩相等，则按照年龄由低到高排序
     *
     * @param o the object to be compared.
     * @return
     */
    @Override
    public int compareTo(Student o) {
        if (this.score < o.score) {
            return 1;
        } else if (this.score > o.score) {
            return -1;
        } else {
            return this.age - o.age;
        }
    }

    @Override
    public String toString() {
        return "学生信息{" +
                "姓名='" + name + '\'' +
                ", 年龄=" + age +
                ", 分数=" + score +
                '}';
    }
}
