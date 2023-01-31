package com.matskevich.springcourse.repositories;

import com.matskevich.springcourse.models.Item;
import com.matskevich.springcourse.models.Person;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemsRepository {
    //custom methods:
    List<Item> findByItemName(String itemName);

    List<Item> findByOwner(Person owner);
}
