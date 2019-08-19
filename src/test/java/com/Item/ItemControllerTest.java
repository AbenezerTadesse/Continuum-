package com.Item;

import com.Item.controller.ItemController;
import com.Item.model.Item;
import com.Item.repository.ItemRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ItemControllerTest {

    @InjectMocks
    private ItemController testItemController;
    private List<Item> testItemList;

    @Mock
    private ItemRepository itemRepository;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);

        Item Item1 = new Item(1,"Item1",null, null);
        Item Item2 = new Item(2,"Item2",null, null);
        Item Item3 = new Item(3,"Item3",null, null);

        Item Item10 = new Item(4,"Item10",Item1, null);
        Item Item11 = new Item(5,"Item11",Item1, null);
        Item Item12 = new Item(6,"Item12",Item1, null);

        Item Item100 = new Item(7,"Item100",Item10, null);
        Item Item101 = new Item(8,"Item101",Item10, null);
        Item Item102 = new Item(9,"Item102",Item10, null);

        Item Item30 = new Item(10,"Item30",Item3, null);
        Item Item31 = new Item(11,"Item31",Item3, null);
        Item Item32 = new Item(12,"Item32",Item3, null);

        ArrayList<Item> subItemsof1 = new ArrayList<Item>(){
            {
                add(Item10);
                add(Item11);
                add(Item12);
            }
        };
        ArrayList<Item> subItemsof10 = new ArrayList<Item>(){
            {
                add(Item100);
                add(Item101);
                add(Item102);
            }
        };
        ArrayList<Item> subItemsof3 = new ArrayList<Item>(){
            {
                add(Item30);
                add(Item31);
                add(Item32);
            }
        };

        Item1.setSubItem(subItemsof1);
        Item10.setSubItem(subItemsof10);
        Item3.setSubItem(subItemsof3);

        testItemList = new ArrayList<Item>();
        testItemList.add(Item1);
        testItemList.add(Item2);
        testItemList.add(Item3);
        testItemList.add(Item10);
        testItemList.add(Item11);
        testItemList.add(Item12);
        testItemList.add(Item100);
        testItemList.add(Item101);
        testItemList.add(Item102);
        testItemList.add(Item30);
        testItemList.add(Item31);
        testItemList.add(Item32);
    }

    @Test
    public void testItemList(){
        when(itemRepository.findAll()).thenReturn(testItemList);
        assertEquals(testItemList, itemRepository.findAll());
    }
}
