package p02_ExtendedDatabase;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import javax.xml.crypto.Data;

public class TestExtendedDatabase {
    private Database db;
    @Before
    public void createDb() throws OperationNotSupportedException {
        Person person1=new Person(1,"Valeri");
        Person person2=new Person(2,"Ivan");
        db=new Database(person1,person2);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testThrowExceptionIfThereAreMultipleUsersWithSameId() throws OperationNotSupportedException {
        db.add(new Person(1,"Eesho"));
    }
    @Test(expected = OperationNotSupportedException.class)
    public void testThrowExceptionIfThereAreNegativeId() throws OperationNotSupportedException {
        db.add(new Person(-21,"Pesho"));
    }

    @Test(expected = OperationNotSupportedException.class)
    public void ThrownExceptionIfThereIsNoUserWithUsername() throws OperationNotSupportedException {
        db.findByUsername("Mameno");
    }
    @Test(expected = OperationNotSupportedException.class)
    public void ThrownExceptionIfUsernameParameterIsNull() throws OperationNotSupportedException {
        db.findByUsername(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void doesMethodThrowExceptionIfThereIsNoPresentId() throws OperationNotSupportedException {
        db.findById(21);
    }

}
