package com.Item.model;


import com.Item.View.Views;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import java.util.List;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ITEM_ID", insertable = false)
    private Integer Id;

    @JsonView(Views.Modified.class) //added on itemName and List of subItems. Customize serialized attributes of Item
    @Column(name="ITEM_NAME")
    private String itemName;

    @JsonBackReference  //to omit from serialization. Avoids stackOverFlow
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="SUB_ITEM_OF_ID")
    private Item subItemOf;

    @JsonManagedReference //serialize this so that subItems are printed out under parent Item
    @JsonView(Views.Modified.class)
    @OneToMany(mappedBy = "subItemOf")
    @OrderBy("itemName asc")
    private List <Item> subItem ;

    public Item(){
        super();
    }

    public Item(Integer _id, String _intemName, Item _subItemOf, List<Item>subItemList){
        this.Id = _id;
        this.itemName = _intemName;
        this.subItemOf = _subItemOf;
        this.subItem = subItemList;
    }



    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Item getSubItemOf() {
        return subItemOf;
    }

    public void setSubItemOf(Item subItemOf) {
        this.subItemOf = subItemOf;
    }

    public List<Item> getSubItem() {
        return subItem;
    }

    public void setSubItem(List<Item> subItem) {
        this.subItem = subItem;
    }
}


