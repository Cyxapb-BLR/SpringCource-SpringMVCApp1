package com.matskevich.springcourse.util;

import com.matskevich.springcourse.dao.PersonDAO;
import com.matskevich.springcourse.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PersonValidator implements Validator {
    private final PersonDAO personDAO;

    @Autowired
    public PersonValidator(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Person.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Person person = (Person) o;

        //посмотреть, есть ли человек с таким же email в бд
        if (personDAO.show(person.getEmail()).isPresent()) {
            //поле, код ошибки, сообщение ошибки
            errors.rejectValue("email", "person.getEmail()", "This email already taken");
        }
        //проверяем, чтобы имя начиналось с заглавной буквы
        if (!Character.isUpperCase(person.getName().codePointAt(0)))
            errors.rejectValue("name", "", "Name should start with a capital Letter");
    }
}
