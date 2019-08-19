package com.Item.controller;

import java.util.ArrayList;
import java.util.List;

//DTO object is used to strip Item objects and hold only the info we need.
//Makes the data lighter so that we can process it in JSON format
//Otherwise itemRepository.findAll() gives a stack overflow error

public class ItemDTO {
    private String itemName;
    private List<ItemDTO > childItems = new ArrayList<ItemDTO>();

    public ItemDTO(){ }

    public ItemDTO(String _itemName, List<ItemDTO> _childItems){
        this.itemName = _itemName;
        this.childItems = _childItems;
    }

    public ItemDTO(String _itemName){
        this.itemName = _itemName;
    }

    public ItemDTO(List<ItemDTO> _childItems){
        this.childItems = _childItems;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public List<ItemDTO> getChildItems() {
        return childItems;
    }

    public void setChildItems(List<ItemDTO> childItems) {
        this.childItems = childItems;
    }
}

