package p03_ListIteratorTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import p03_IteratorTest.ListIterator;

import javax.naming.OperationNotSupportedException;

public class ListIteratorTest {
    private ListIterator ls;
    @Before
    public void createLs() throws OperationNotSupportedException {
        ls=new ListIterator("Valeri","Ivan","Delko");

    }




    @Test(expected = OperationNotSupportedException.class)
    public void addingNullShouldThrowAnException() throws OperationNotSupportedException {
        ls=new ListIterator(null);
    }

    @Test
    public void methodShouldMoveInternalIndexPosition(){
        ls.move();
        Assert.assertEquals("Ivan",ls.print());
    }
    @Test
    public void methodShouldPrintElementAtIndex(){

        Assert.assertEquals("Valeri",ls.print());
    }

    @Test(expected = IllegalStateException.class)
    public void callingPrintMethodOnEmptyCollectionShouldThrowException() throws OperationNotSupportedException {
        ls=new ListIterator();
        ls.print();
    }


}
