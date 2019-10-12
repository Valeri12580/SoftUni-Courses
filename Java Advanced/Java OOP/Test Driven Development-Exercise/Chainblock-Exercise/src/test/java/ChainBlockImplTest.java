import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class ChainBlockImplTest {
    private Chainblock chainBlock;
    @Before
    public  void createInstance(){
        this.chainBlock=new ChainblockImpl();
    }


    @Test
    public  void addShouldAddIfThereIsNoDuplicates(){
        Transaction transaction=new TransactionImpl(5,TransactionStatus.SUCCESSFUL,"Valeri","Kacho",5);
        chainBlock.add(transaction);
        Assert.assertEquals(1,chainBlock.getCount());

    }
    @Test
    public  void addShouldNotAddIfThereIsDuplicates(){
        Transaction transaction=new TransactionImpl(5,TransactionStatus.SUCCESSFUL,"Valeri","Kacho",5);
        chainBlock.add(transaction);
        chainBlock.add(transaction);
        Assert.assertEquals(1,chainBlock.getCount());
    }
    @Test
    public void getCountShouldReturnSizeCorrect(){
        Transaction transaction=new TransactionImpl(5,TransactionStatus.SUCCESSFUL,"Valeri","Kacho",5);
        chainBlock.add(transaction);
        Assert.assertEquals(1,chainBlock.getCount());
    }
    @Test
    public void containsByIdShouldReturnTrueIfTransactionIsPresent(){
        Transaction transaction=new TransactionImpl(5,TransactionStatus.SUCCESSFUL,"Valeri","Kacho",5);
        chainBlock.add(transaction);
        Assert.assertTrue(chainBlock.contains(5));

    }
    @Test
    public void containsByIdShouldReturnFalseIfTransactionIsPresent(){
        Transaction transaction=new TransactionImpl(1,TransactionStatus.SUCCESSFUL,"Valeri","Kacho",5);
        chainBlock.add(transaction);
        Assert.assertFalse(chainBlock.contains(5));

    }
    @Test
    public void containsByTransactionShouldReturnTrueIfTransactionIsPresent(){
        Transaction transaction=new TransactionImpl(5,TransactionStatus.SUCCESSFUL,"Valeri","Kacho",5);
        chainBlock.add(transaction);
        Assert.assertTrue(chainBlock.contains(transaction));

    }
    @Test
    public void containsByTransactionShouldReturnFalseIfTransactionIsPresent(){
        Transaction transaction=new TransactionImpl(1,TransactionStatus.SUCCESSFUL,"Valeri","Kacho",5);
        chainBlock.add(transaction);
        Assert.assertFalse(chainBlock.contains(new TransactionImpl(123,TransactionStatus.ABORTED,"Kacho","Valeri",10)));

    }
    @Test(expected = IllegalArgumentException.class)
    public void changeTransactionStatusShouldThrowExceptionIfIdIsNotPresent(){
        Transaction transaction=new TransactionImpl(1,TransactionStatus.SUCCESSFUL,"Valeri","Kacho",5);
        chainBlock.add(transaction);

        chainBlock.changeTransactionStatus(3002301,TransactionStatus.FAILED);

    }
    @Test
    public void changeTransactionStatusShouldChangeStatusCorrectly(){
        Transaction transaction=new TransactionImpl(1,TransactionStatus.SUCCESSFUL,"Valeri","Kacho",5);
        chainBlock.add(transaction);

        chainBlock.changeTransactionStatus(1,TransactionStatus.FAILED);
        Assert.assertEquals(TransactionStatus.FAILED,this.chainBlock.getById(1).getStatus());

    }

    @Test(expected = IllegalArgumentException.class)
    public void removeTransactionByIdShouldThrowExceptionIfThereIsNoSuchId(){
        Transaction transaction=new TransactionImpl(1,TransactionStatus.SUCCESSFUL,"Valeri","Kacho",5);
        chainBlock.add(transaction);

        chainBlock.removeTransactionById(132132232);

    }
    @Test()
    public void removeTransactionByIdShouldWorkCorrect(){
        Transaction transaction=new TransactionImpl(1,TransactionStatus.SUCCESSFUL,"Valeri","Kacho",5);
        chainBlock.add(transaction);

        chainBlock.removeTransactionById(1);
        Assert.assertEquals(0, this.chainBlock.getCount());

    }
    @Test(expected = IllegalArgumentException.class)
    public  void getByIdShouldThrowExceptionIfThereIsValidId(){
        Transaction transaction=new TransactionImpl(1,TransactionStatus.SUCCESSFUL,"Valeri","Kacho",5);
        chainBlock.add(transaction);
        this.chainBlock.getById(231);

    }
    @Test()
    public  void getByIdShouldWorkCorrectly(){
        Transaction transaction=new TransactionImpl(1,TransactionStatus.SUCCESSFUL,"Valeri","Kacho",5);
        chainBlock.add(transaction);
        Transaction byId = this.chainBlock.getById(1);

        Assert.assertEquals(transaction, byId);

    }

    @Test(expected =  IllegalArgumentException.class)
    public void getByTransactionStatusShouldThrowExceptionIfNoTransactionsExist(){
        Transaction transaction=new TransactionImpl(1,TransactionStatus.SUCCESSFUL,"Valeri","Kacho",5);
        Transaction transaction2=new TransactionImpl(2,TransactionStatus.SUCCESSFUL,"Kacho","Valeri",5);
        chainBlock.add(transaction);
        chainBlock.add(transaction2);

        this.chainBlock.getByTransactionStatus(TransactionStatus.ABORTED);
    }

    @Test
    public void getByTransactionStatusShouldWorkProperly(){
        Transaction transaction=new TransactionImpl(1,TransactionStatus.SUCCESSFUL,"Valeri","Kacho",5);
        Transaction transaction2=new TransactionImpl(2,TransactionStatus.SUCCESSFUL,"Kacho","Valeri",5213);
        Transaction transaction3=new TransactionImpl(3,TransactionStatus.UNAUTHORIZED,"Ciganin","Simona",51);
        chainBlock.add(transaction);
        chainBlock.add(transaction2);
        chainBlock.add(transaction3);
        Iterable<Transaction> matches = this.chainBlock.getByTransactionStatus(TransactionStatus.SUCCESSFUL);
        int count=0;
        for (Transaction match : matches) {
            count++;
            if(count==1){
                Assert.assertEquals(transaction2,match);
            }else if (count==2){
                Assert.assertEquals(transaction,match);
            }
        }


    }
    @Test(expected = IllegalArgumentException.class)
    public void getAllSendersWithTransactionStatusShouldThrowException(){
        Transaction transaction=new TransactionImpl(1,TransactionStatus.SUCCESSFUL,"Valeri","Kacho",5);
        Transaction transaction2=new TransactionImpl(2,TransactionStatus.SUCCESSFUL,"Valeri","Kacho",5213);
        Transaction transaction3=new TransactionImpl(3,TransactionStatus.UNAUTHORIZED,"Ciganin","Simona",51);
        Transaction transaction4=new TransactionImpl(4,TransactionStatus.SUCCESSFUL,"Ciganin","Simona",531231);
        chainBlock.add(transaction);
        chainBlock.add(transaction2);
        chainBlock.add(transaction3);
        chainBlock.add(transaction4);

       this.chainBlock.getAllSendersWithTransactionStatus(TransactionStatus.ABORTED);
    }

    @Test
    public void getAllSendersWithTransactionStatusShouldWorkCorrect(){
        Transaction transaction=new TransactionImpl(1,TransactionStatus.SUCCESSFUL,"Valeri","Kacho",5);
        Transaction transaction2=new TransactionImpl(2,TransactionStatus.SUCCESSFUL,"Valeri","Kacho",5213);
        Transaction transaction3=new TransactionImpl(3,TransactionStatus.UNAUTHORIZED,"Ciganin","Simona",51);
        Transaction transaction4=new TransactionImpl(4,TransactionStatus.SUCCESSFUL,"Ciganin","Simona",531231);
        chainBlock.add(transaction);
        chainBlock.add(transaction2);
        chainBlock.add(transaction3);
        chainBlock.add(transaction4);

        List<String> matches= (List<String>) this.chainBlock.getAllSendersWithTransactionStatus(TransactionStatus.SUCCESSFUL);
        Assert.assertEquals(3,matches.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void getAllReceiversWithTransactionStatusShouldThrowException(){
        Transaction transaction=new TransactionImpl(1,TransactionStatus.SUCCESSFUL,"Valeri","Kacho",5);
        Transaction transaction2=new TransactionImpl(2,TransactionStatus.SUCCESSFUL,"Valeri","Kacho",5213);
        Transaction transaction3=new TransactionImpl(3,TransactionStatus.UNAUTHORIZED,"Ciganin","Simona",51);
        Transaction transaction4=new TransactionImpl(4,TransactionStatus.SUCCESSFUL,"Ciganin","Simona",531231);
        chainBlock.add(transaction);
        chainBlock.add(transaction2);
        chainBlock.add(transaction3);
        chainBlock.add(transaction4);

        this.chainBlock.getAllReceiversWithTransactionStatus(TransactionStatus.ABORTED);
    }
    @Test
    public void getAllReceiversWithTransactionStatusShouldWorkProperly(){
        Transaction transaction=new TransactionImpl(1,TransactionStatus.SUCCESSFUL,"Valeri","Kacho",5);
        Transaction transaction2=new TransactionImpl(2,TransactionStatus.SUCCESSFUL,"Valeri","Kacho",5213);
        Transaction transaction3=new TransactionImpl(3,TransactionStatus.UNAUTHORIZED,"Ciganin","Simona",51);
        Transaction transaction4=new TransactionImpl(4,TransactionStatus.SUCCESSFUL,"Ciganin","Simona",531231);
        chainBlock.add(transaction);
        chainBlock.add(transaction2);
        chainBlock.add(transaction3);
        chainBlock.add(transaction4);

     List<String>matches= (List<String>) this.chainBlock.getAllReceiversWithTransactionStatus(TransactionStatus.SUCCESSFUL);
     Assert.assertEquals(3,matches.size());
    }

   @Test(expected = IllegalArgumentException.class)
    public void getBySenderOrderedByAmountDescendingShouldThrowException(){
       Transaction transaction=new TransactionImpl(1,TransactionStatus.SUCCESSFUL,"Valeri","Kacho",5);
       Transaction transaction2=new TransactionImpl(2,TransactionStatus.SUCCESSFUL,"Valeri","Kacho",5213);
       Transaction transaction3=new TransactionImpl(3,TransactionStatus.UNAUTHORIZED,"Ciganin","Simona",51);
       Transaction transaction4=new TransactionImpl(4,TransactionStatus.SUCCESSFUL,"Ciganin","Simona",531231);
       chainBlock.add(transaction);
       chainBlock.add(transaction2);
       chainBlock.add(transaction3);
       chainBlock.add(transaction4);
       this.chainBlock.getBySenderOrderedByAmountDescending("Pesho");

   }

    @Test
    public void getBySenderOrderedByAmountDescendingShouldWorkCorrect(){
        Transaction transaction=new TransactionImpl(1,TransactionStatus.SUCCESSFUL,"Valeri","Kacho",5);
        Transaction transaction2=new TransactionImpl(2,TransactionStatus.SUCCESSFUL,"Valeri","Kacho",5213);
        Transaction transaction3=new TransactionImpl(3,TransactionStatus.UNAUTHORIZED,"Ciganin","Simona",51);
        Transaction transaction4=new TransactionImpl(4,TransactionStatus.SUCCESSFUL,"Ciganin","Simona",531231);
        chainBlock.add(transaction);
        chainBlock.add(transaction2);
        chainBlock.add(transaction3);
        chainBlock.add(transaction4);
        List<Transaction> matches = (List<Transaction>) this.chainBlock.getBySenderOrderedByAmountDescending("Valeri");
        Assert.assertEquals(2,matches.size());


    }
    @Test(expected = IllegalArgumentException.class)
    public void getByReceiverOrderedByAmountThenByIdShouldThrowException(){
        Transaction transaction=new TransactionImpl(1,TransactionStatus.SUCCESSFUL,"Valeri","Kacho",5);
        Transaction transaction2=new TransactionImpl(2,TransactionStatus.SUCCESSFUL,"Valeri","Kacho",5213);
        Transaction transaction3=new TransactionImpl(3,TransactionStatus.UNAUTHORIZED,"Ciganin","Simona",51);
        Transaction transaction4=new TransactionImpl(4,TransactionStatus.SUCCESSFUL,"Ciganin","Simona",531231);
        chainBlock.add(transaction);
        chainBlock.add(transaction2);
        chainBlock.add(transaction3);
        chainBlock.add(transaction4);
        this.chainBlock.getByReceiverOrderedByAmountThenById("Simondasd");


    }

    @Test
    public void getByReceiverOrderedByAmountThenByIdShouldWorkCorrectly(){
        Transaction transaction=new TransactionImpl(1,TransactionStatus.SUCCESSFUL,"Valeri","Kacho",5);
        Transaction transaction2=new TransactionImpl(2,TransactionStatus.SUCCESSFUL,"Valeri","Kacho",5213);
        Transaction transaction3=new TransactionImpl(3,TransactionStatus.UNAUTHORIZED,"Ciganin","Simona",51);
        Transaction transaction4=new TransactionImpl(4,TransactionStatus.SUCCESSFUL,"Ciganin","Simona",531231);
        Transaction transaction5=new TransactionImpl(5,TransactionStatus.SUCCESSFUL,"Ciganin","Simona",531231);
        Transaction transaction6=new TransactionImpl(6,TransactionStatus.SUCCESSFUL,"Ciganin","Simona",53211231);
        chainBlock.add(transaction);
        chainBlock.add(transaction2);
        chainBlock.add(transaction3);
        chainBlock.add(transaction4);
        chainBlock.add(transaction5);
        chainBlock.add(transaction6);

        List<Transaction>match= (List<Transaction>) this.chainBlock.getByReceiverOrderedByAmountThenById("Simona");
        Assert.assertEquals(3,match.size());


    }

    @Test
    public void getByTransactionStatusAndMaximumAmountShouldReturnEmptyCollectionIfThereIsNoContainedElements(){
        Transaction transaction=new TransactionImpl(1,TransactionStatus.SUCCESSFUL,"Valeri","Kacho",5);
        Transaction transaction2=new TransactionImpl(2,TransactionStatus.SUCCESSFUL,"Valeri","Kacho",5213);
        Transaction transaction3=new TransactionImpl(3,TransactionStatus.UNAUTHORIZED,"Ciganin","Simona",51);
        Transaction transaction4=new TransactionImpl(4,TransactionStatus.SUCCESSFUL,"Ciganin","Simona",531231);
        chainBlock.add(transaction);
        chainBlock.add(transaction2);
        chainBlock.add(transaction3);
        chainBlock.add(transaction4);
        List<Transaction>matches=(List<Transaction>)this.chainBlock.getByTransactionStatusAndMaximumAmount(TransactionStatus.SUCCESSFUL,1);
        Assert.assertTrue(matches.isEmpty());
    }
    @Test
    public void getByTransactionStatusAndMaximumAmountShouldWorkCorrectly(){
        Transaction transaction=new TransactionImpl(1,TransactionStatus.SUCCESSFUL,"Valeri","Kacho",5);
        Transaction transaction2=new TransactionImpl(2,TransactionStatus.SUCCESSFUL,"Valeri","Kacho",5213);
        Transaction transaction3=new TransactionImpl(3,TransactionStatus.UNAUTHORIZED,"Ciganin","Simona",51);
        Transaction transaction4=new TransactionImpl(4,TransactionStatus.SUCCESSFUL,"Ciganin","Simona",531231);
        chainBlock.add(transaction);
        chainBlock.add(transaction2);
        chainBlock.add(transaction3);
        chainBlock.add(transaction4);
        List<Transaction>matches=(List<Transaction>)this.chainBlock.getByTransactionStatusAndMaximumAmount(TransactionStatus.SUCCESSFUL,5213);
        Assert.assertEquals(2,matches.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void getBySenderAndMinimumAmountDescendingShouldThrowExceptionIfThereAreNoElements(){
        Transaction transaction=new TransactionImpl(1,TransactionStatus.SUCCESSFUL,"Valeri","Kacho",5);
        Transaction transaction2=new TransactionImpl(2,TransactionStatus.SUCCESSFUL,"Valeri","Kacho",5213);
        Transaction transaction3=new TransactionImpl(3,TransactionStatus.UNAUTHORIZED,"Ciganin","Simona",51);
        Transaction transaction4=new TransactionImpl(4,TransactionStatus.SUCCESSFUL,"Ciganin","Simona",531231);
        chainBlock.add(transaction);
        chainBlock.add(transaction2);
        chainBlock.add(transaction3);
        chainBlock.add(transaction4);
        this.chainBlock.getBySenderAndMinimumAmountDescending("Mingo",6);

    }
    @Test
    public void getBySenderAndMinimumAmountDescendingShouldWorkCorrectly(){
        Transaction transaction=new TransactionImpl(1,TransactionStatus.SUCCESSFUL,"Valeri","Kacho",5);
        Transaction transaction2=new TransactionImpl(2,TransactionStatus.SUCCESSFUL,"Valeri","Kacho",5213);
        Transaction transaction3=new TransactionImpl(3,TransactionStatus.UNAUTHORIZED,"Ciganin","Simona",51);
        Transaction transaction4=new TransactionImpl(4,TransactionStatus.SUCCESSFUL,"Ciganin","Simona",531231);
        chainBlock.add(transaction);
        chainBlock.add(transaction2);
        chainBlock.add(transaction3);
        chainBlock.add(transaction4);
        List<Transaction>matches= (List<Transaction>) this.chainBlock.getBySenderAndMinimumAmountDescending("Valeri",6);
        Assert.assertEquals(1,matches.size());


    }
    @Test(expected = IllegalArgumentException.class)
    public void getByReceiverAndAmountRangeShouldThrowExceptionIfThereAreNoElements(){
        Transaction transaction=new TransactionImpl(1,TransactionStatus.SUCCESSFUL,"Valeri","Kacho",5);
        Transaction transaction2=new TransactionImpl(2,TransactionStatus.SUCCESSFUL,"Valeri","Kacho",623);
        Transaction transaction3=new TransactionImpl(3,TransactionStatus.UNAUTHORIZED,"Ciganin","Simona",51);
        Transaction transaction4=new TransactionImpl(4,TransactionStatus.SUCCESSFUL,"Ciganin","Simona",531231);
        chainBlock.add(transaction);
        chainBlock.add(transaction2);
        chainBlock.add(transaction3);
        chainBlock.add(transaction4);
        this.chainBlock.getByReceiverAndAmountRange("Kendi",1,800);

    }
    @Test
    public void getByReceiverAndAmountRangeShouldWorkCorrect(){
        Transaction transaction=new TransactionImpl(1,TransactionStatus.SUCCESSFUL,"Valeri","Kacho",5);
        Transaction transaction2=new TransactionImpl(2,TransactionStatus.SUCCESSFUL,"Valeri","Kacho",623);
        Transaction transaction3=new TransactionImpl(3,TransactionStatus.UNAUTHORIZED,"Ciganin","Kacho",51);
        Transaction transaction5=new TransactionImpl(5,TransactionStatus.UNAUTHORIZED,"Ciganin","Kacho",51);
        Transaction transaction4=new TransactionImpl(4,TransactionStatus.SUCCESSFUL,"Ciganin","Kacho",1);
        chainBlock.add(transaction);
        chainBlock.add(transaction2);
        chainBlock.add(transaction3);
        chainBlock.add(transaction4);
        chainBlock.add(transaction5);
        List<Transaction>matches= (List<Transaction>) this.chainBlock.getByReceiverAndAmountRange("Kacho",1,800);
        Assert.assertEquals(4,matches.size());

    }
    @Test
    public void getAllInAmountRangeShouldReturnEmptyCollectionIfThereAreNoElements(){
        Transaction transaction=new TransactionImpl(1,TransactionStatus.SUCCESSFUL,"Valeri","Kacho",5);
        Transaction transaction2=new TransactionImpl(2,TransactionStatus.SUCCESSFUL,"Valeri","Kacho",623);
        Transaction transaction3=new TransactionImpl(3,TransactionStatus.UNAUTHORIZED,"Ciganin","Kacho",51);
        Transaction transaction5=new TransactionImpl(5,TransactionStatus.UNAUTHORIZED,"Ciganin","Kacho",51);
        Transaction transaction4=new TransactionImpl(4,TransactionStatus.SUCCESSFUL,"Ciganin","Kacho",1);
        chainBlock.add(transaction);
        chainBlock.add(transaction2);
        chainBlock.add(transaction3);
        chainBlock.add(transaction4);
        chainBlock.add(transaction5);
        List<Transaction>matches= (List<Transaction>) this.chainBlock.getAllInAmountRange(3123,32133);
        Assert.assertTrue(matches.isEmpty());
    }
    @Test
    public void getAllInAmountRangeShouldReturnElementsIfThreyPresent(){
        Transaction transaction=new TransactionImpl(1,TransactionStatus.SUCCESSFUL,"Valeri","Kacho",5);
        Transaction transaction2=new TransactionImpl(2,TransactionStatus.SUCCESSFUL,"Valeri","Kacho",623);
        Transaction transaction3=new TransactionImpl(3,TransactionStatus.UNAUTHORIZED,"Ciganin","Kacho",51);
        Transaction transaction5=new TransactionImpl(5,TransactionStatus.UNAUTHORIZED,"Ciganin","Kacho",51);
        Transaction transaction4=new TransactionImpl(4,TransactionStatus.SUCCESSFUL,"Ciganin","Kacho",1);
        chainBlock.add(transaction);
        chainBlock.add(transaction2);
        chainBlock.add(transaction3);
        chainBlock.add(transaction4);
        chainBlock.add(transaction5);
        List<Transaction>matches= (List<Transaction>) this.chainBlock.getAllInAmountRange(4,624);
        Assert.assertEquals(4,matches.size());
    }
    @Test
    public void getAllOrderedByAmountDescendingThenById(){
        Transaction transaction=new TransactionImpl(1,TransactionStatus.SUCCESSFUL,"Valeri","Kacho",5);
        Transaction transaction2=new TransactionImpl(2,TransactionStatus.SUCCESSFUL,"Valeri","Kacho",623);
        Transaction transaction3=new TransactionImpl(3,TransactionStatus.UNAUTHORIZED,"Ciganin","Kacho",51);
        Transaction transaction5=new TransactionImpl(5,TransactionStatus.UNAUTHORIZED,"Ciganin","Kacho",51);
        Transaction transaction4=new TransactionImpl(4,TransactionStatus.SUCCESSFUL,"Ciganin","Kacho",1);
        chainBlock.add(transaction);
        chainBlock.add(transaction2);
        chainBlock.add(transaction3);
        chainBlock.add(transaction4);
        chainBlock.add(transaction5);
        List<Transaction>matches= (List<Transaction>) this.chainBlock.getAllOrderedByAmountDescendingThenById();
        Assert.assertEquals(transaction3,matches.get(1));
    }



}
