package entity;

public class Subject {
    private int id;
    private String name;
    private int totalLesson;
    private int totalTheoryLesson;
    private int expense;

    public Subject(int id, String name, int totalLesson, int totalTheoryLesson, int expense) {
        this.id = id;
        this.name = name;
        this.totalLesson = totalLesson;
        this.totalTheoryLesson = totalTheoryLesson;
        this.expense = expense;
    }

    public Subject() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalLesson() {
        return totalLesson;
    }

    public void setTotalLesson(int totalLesson) {
        this.totalLesson = totalLesson;
    }

    public int getTotalTheoryLesson() {
        return totalTheoryLesson;
    }

    public void setTotalTheoryLesson(int totalTheoryLesson) {
        this.totalTheoryLesson = totalTheoryLesson;
    }

    public int getExpense() {
        return expense;
    }

    public void setExpense(int expense) {
        this.expense = expense;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", totalLesson=" + totalLesson +
                ", totalTheoryLesson=" + totalTheoryLesson +
                ", expense=" + expense +
                '}';
    }
}
