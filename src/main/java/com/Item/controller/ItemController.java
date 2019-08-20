package com.Item.controller;


import com.Item.View.Views;
import com.Item.model.Item;
import com.Item.repository.ItemRepository;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @JsonView(Views.Modified.class)  //Returns list of Item in a custom serialized JSON
    @RequestMapping(value = "/items", method = RequestMethod.GET, produces = "application/json")
    public List<Item> list(){
        return itemRepository.findAll();
    }

    /*@RequestMapping(value = "/items", method = RequestMethod.GET, produces = "application/json")
    public List<ItemDTO> list(){
        return stripList(itemRepository.findAll());
    }

    public ItemDTO stripItem (Item itemEntity){

        ItemDTO itemDTO = new ItemDTO(itemEntity.getItemName());
        ArrayList<ItemDTO> childrenDto = new ArrayList<>();
        if(! itemEntity.getSubItem().isEmpty())
        {
            for(Item items: itemEntity.getSubItem()){
                ItemDTO itemDTO1 = new ItemDTO(items.getItemName());
                itemDTO1.setChildItems(stripList(items.getSubItem()));
                childrenDto.add(itemDTO1);
            }
        }
        itemDTO.setChildItems(childrenDto);
        return itemDTO;
    }

    public List<ItemDTO> stripList (List<Item> itemEntities)
    {
        List<ItemDTO> resultStriped = new ArrayList<>();
        if(! itemEntities.isEmpty()){
            for(Item entityItem: itemEntities){
                resultStriped.add(stripItem(entityItem));
            }
        }

        return resultStriped;
    }
*/

}
