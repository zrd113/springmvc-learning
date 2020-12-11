package org.zrd.model;

import java.util.List;

/**
 * @Author zrd
 * @Date 2020/12/11
 */
public class MyClass {

    private Integer id;

    private List<Student> students;

    @Override
    public String toString() {
        return "MyClass{" +
                "id=" + id +
                ", students=" + students +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
