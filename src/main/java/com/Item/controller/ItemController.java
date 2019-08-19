package com.Item.controller;


import com.Item.model.Item;
import com.Item.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;
    private ArrayList<Item> visitedItems;

    @RequestMapping(value = "/items", method = RequestMethod.GET, produces = "application/json")
    public List<Item> list(){
        return itemRepository.findAll();
    }

}
