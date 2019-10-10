package p01_database;

import org.junit.Assert;
import org.junit.Test;
import p01_Database.Database;

import javax.naming.OperationNotSupportedException;
import javax.xml.crypto.Data;

public class DatabaseTest {
            private static final Integer[]ELEMENTS={13,42,69,23};

    @Test
    public void storingArrayCapacityMustBeCorrectly() throws OperationNotSupportedException {
        Database db=new Database(ELEMENTS);

        Assert.assertArrayEquals(ELEMENTS,db.getElements());


    }
    @Test(expected = OperationNotSupportedException.class)
    public void creatingDatabaseWithZeroElementsShouldThrowException() throws OperationNotSupportedException {
        Database database=new Database();
    }

    @Test(expected = OperationNotSupportedException.class)
    public void creatingDatabaseWithMoreThanSixteenElementsShouldThrowException() throws OperationNotSupportedException {
        Database database=new Database(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17);
    }

    @Test
    public  void testIfAddIsAddingOnNextFreeCell() throws OperationNotSupportedException {
        Database db=new Database(1,2,3,4,5,6);
        db.add(69);
        Integer[] array=db.getElements();
        int  a =array[6];


        Assert.assertEquals(69,a);
    }
    @Test(expected = OperationNotSupportedException.class)
    public  void testIfAddIsThrowingAException() throws OperationNotSupportedException {
        Database db=new Database(1,2,3,4,5,6);
        db.add(null);

    }

    @Test
    public void testIfRemoveMethodIsWorkingProperly() throws OperationNotSupportedException {
        Database db=new Database(1,2,3,4,5,6);
        db.remove();
        int a = db.getElements()[4];

        Assert.assertEquals(5,a);
    }
    @Test(expected = OperationNotSupportedException.class)
    public void testIfRemoveMethodIsThrowingAnExeption() throws OperationNotSupportedException {
        Database db=new Database(1);
        db.remove();
        db.remove();
    }
    @Test
    public void testIfGetElementsReturnArray() throws OperationNotSupportedException {
        Database db=new Database(1,2,3,4,5,6);
        Integer[]elements=db.getElements();
        Assert.assertArrayEquals(elements,db.getElements());
    }
}
