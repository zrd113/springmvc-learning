package org.zrd.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Author zrd
 * @Date 2020/12/11
 */
public class MyClass {

    @NotNull(message = "{myClass.id.notnull}")
    @Max(value = 20, message = "{myClass.id.error}")
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
