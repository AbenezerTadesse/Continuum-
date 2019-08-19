package com.Item.model;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ITEM_ID", insertable = false)
    private Integer Id;

    @Column(name="ITEM_NAME")
    private String itemName;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="SUB_ITEM_OF_ID")
    private Item subItemOf;

    @OneToMany(mappedBy = "subItemOf")
    @OrderBy("itemName asc")
    private List <Item> subItem = new ArrayList<Item>();

    public Item(){
        super();
    }

    public Item(Integer _id, String _intemName, Item _subItemOf, List<Item>subItemList){
        this.Id = _id;
        this.itemName = _intemName;
        this.subItemOf = _subItemOf;
        this.subItem = subItemList;
    }

    /*public Item(int _id, String _itemName, List _subItem){
        this.Id = _id;
        this.itemName = _itemName;
        this.subItem = _subItem;
    }*/

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


