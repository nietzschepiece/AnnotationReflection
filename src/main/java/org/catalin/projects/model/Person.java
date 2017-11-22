package org.catalin.projects.model;

import org.catalin.projects.annotations.DatabaseColumn;
import org.catalin.projects.annotations.TableName;

/**
 * Created by cci on 21.11.2017.
 */
@TableName(tableName = "Persoane")
public class Person {

    @DatabaseColumn(columnName = "PRENUME")
    private String name;
    @DatabaseColumn(columnName = "NUME")
    private String lastName;
    @DatabaseColumn(columnName = "VARSTA")
    private int age;

    private String fieldNebun;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFieldNebun() {
        return fieldNebun;
    }

    public void setFieldNebun(String fieldNebun) {
        this.fieldNebun = fieldNebun;
    }
}
