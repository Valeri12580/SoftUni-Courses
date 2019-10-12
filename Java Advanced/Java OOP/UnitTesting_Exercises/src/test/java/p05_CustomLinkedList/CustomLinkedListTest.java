package p05_CustomLinkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class CustomLinkedListTest {
   private  CustomLinkedList<Integer>list;
    @Before
    public void creating(){
        list=new CustomLinkedList<>();
    }
    @Test
    public void methodShouldAddElementsCorrectly(){

        list.add(12);
        Assert.assertTrue(list.contains(12));
    }

    @Test
    public void indexOfShouldReturnFirstOccurrencedValue(){
        list.add(15);
        list.add(18);
        list.add(22);
        list.add(15);
        Assert.assertEquals(0,list.indexOf(15));
    }
    @Test(expected =IllegalArgumentException.class)
    public void setShouldThrowAnExceptionIfIndexIsBelowZero(){

        list.set(-1,15);
    }
    @Test(expected =IllegalArgumentException.class)
    public void setShouldThrowAnExceptionIfIndexIsAboveTheSize(){

        list.add(15);
        list.add(352);
        list.set(2,123123);
    }
    @Test(expected = IllegalArgumentException.class)
    public void removeAtShoudThrowAnExceptionIfTheIndexIsBelowZero(){
        list.removeAt(-1);

    }
    @Test(expected = IllegalArgumentException.class)
    public void removeAtShoudThrowAnExceptionIfTheIndexIsAboveTheSize(){
      list.add(1);
      list.add(1);
      list.add(1);
      list.removeAt(4);

    }
    @Test
    public void removeShoudRemoveSearchedItem(){
        list.add(15);
        list.add(352);
        list.add(21);
        list.remove(352);
        assertFalse(list.contains(352));
    }
    @Test
    public void removeShoudReturnNegativeOneIfThereIsNoElement(){
        list.add(15);
        list.add(352);
        list.add(21);
        Assert.assertEquals(-1,list.remove(323));

    }



}