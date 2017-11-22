package org.catalin.projects.main;

import org.catalin.projects.annotations.DatabaseColumn;
import org.catalin.projects.annotations.TableName;
import org.catalin.projects.model.Person;

import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.catalin.projects.services.SQLDatabaseService.*;

/**
 * Created by cci on 20.11.2017.
 */
public class Main {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, SQLException {
        List<Person> personList = createPersonList();
        updateDatabase(personList);
    }

    public static void updateDatabase(List<Person> persons) throws NoSuchFieldException, IllegalAccessException, SQLException {
        Class<Person> personClass = Person.class;
        String tableName = personClass.getAnnotation(TableName.class).tableName();
        String column = null;
        String value = null;
        resetRows(tableName);
        for (Person person : persons) {
            createEmptyRow(tableName);
            Field[] fields = person.getClass().getDeclaredFields();

            for (Field field : fields) {
                if (field.isAnnotationPresent(DatabaseColumn.class)) {
                    field.setAccessible(true);
                    column = field.getAnnotation(DatabaseColumn.class).columnName();
                    value = field.get(person).toString();
                }
                updateRows(tableName, column, value);
            }

        }

    }

    public static List<Person> createPersonList() {
        Person person = new Person();
        person.setName("Catalin");
        person.setLastName("Ciobanu");
        person.setAge(23);
        person.setFieldNebun("da");
        Person person1 = new Person();
        person1.setName("Ana");
        person1.setLastName("Borlovan");
        person1.setAge(24);
        person1.setFieldNebun("nuu");
        Person person2 = new Person();
        person2.setName("Crist");
        person2.setLastName("Iliescu");
        person2.setAge(27);
        person2.setFieldNebun("xxx");

        List<Person> personList = new ArrayList<>();
        personList.add(person);
        personList.add(person1);
        personList.add(person2);
        return personList;
    }

}
