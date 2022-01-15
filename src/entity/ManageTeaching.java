package entity;

import java.util.Arrays;

public class ManageTeaching {
   private Teacher teacher;
   private Subject[] subjectList;
   private int[] numberOfClass;

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Subject[] getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(Subject[] subjectList) {
        this.subjectList = subjectList;
    }

    public int[] getNumberOfClass() {
        return numberOfClass;
    }

    public void setNumberOfClass(int[] numberOfClass) {
        this.numberOfClass = numberOfClass;
    }

    public ManageTeaching(Teacher teacher, Subject[] subjectList, int[] numberOfClass) {
        this.teacher = teacher;
        this.subjectList = subjectList;
        this.numberOfClass = numberOfClass;
    }
    public ManageTeaching() {

    }

    @Override
    public String toString() {
        return "ManageTeachingDeclaration{" +
                "teacher=" + teacher +
                ", subjectList=" + Arrays.toString(subjectList) +
                ", numberOfClass=" + Arrays.toString(numberOfClass) +
                '}';
    }
}
