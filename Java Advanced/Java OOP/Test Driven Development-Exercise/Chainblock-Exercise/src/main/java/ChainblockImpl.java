import java.util.*;
import java.util.stream.Collectors;

public class ChainblockImpl implements Chainblock{
    Map<Integer,Transaction>  transactions;

    public ChainblockImpl() {
        this.transactions = new TreeMap<>();
    }

    public int getCount() {
        return this.transactions.size();
    }

    public void add(Transaction transaction) {
        if(!contains(transaction.getId())){
            this.transactions.put(transaction.getId(),transaction);
        }

    }

    public boolean contains(Transaction transaction) {
        return this.transactions.containsValue(transaction);
    }

    public boolean contains(int id) {
        return this.transactions.containsKey(id);
    }

    public void changeTransactionStatus(int id, TransactionStatus newStatus) {
        if(!this.transactions.containsKey(id)){
            throw new IllegalArgumentException();
        }
        this.transactions.get(id).setStatus(newStatus);

    }

    public void removeTransactionById(int id) {
        if(!this.transactions.containsKey(id)){
            throw new IllegalArgumentException();
        }
        this.transactions.remove(id);

    }

    public Transaction getById(int id) {
        if(!this.transactions.containsKey(id)){
            throw new IllegalArgumentException();
        }
        return this.transactions.get(id);
    }

    public Iterable<Transaction> getByTransactionStatus(TransactionStatus status) {
        List<Transaction> collection = this.transactions.values().stream().filter(e -> e.getStatus() == status).sorted((p1,p2)->Double.compare(p2.getAmount(),p1.getAmount())).collect(Collectors.toList());
        if(collection.isEmpty())
        {
            throw new IllegalArgumentException();
        }
        return collection;
    }

    public Iterable<String> getAllSendersWithTransactionStatus(TransactionStatus status) {
        List<String>matches=this.transactions.values().stream().filter(e->e.getStatus()==status).map(Transaction::getSender).collect(Collectors.toList());
        if(matches.isEmpty()){
            throw new IllegalArgumentException();
        }
                return matches;
    }

    public Iterable<String> getAllReceiversWithTransactionStatus(TransactionStatus status) {
        List<String>matches=this.transactions.values().stream().filter(e->e.getStatus()==status).map(Transaction::getReceiver).collect(Collectors.toList());
       if(matches.isEmpty()){
           throw new IllegalArgumentException();
       }

        return matches;
    }
    //ne pishi
    @Override
    public Iterable<Transaction> getAllOrderedByAmountDescendingThenById() {
        List<Transaction>match= this.transactions.values().stream().sorted((p1,p2)->{
            int comparator=Double.compare(p2.getAmount(),p1.getAmount());
            if(comparator==0){
                comparator=Integer.compare(p1.getId(),p2.getId());
            }
            return comparator;
        }).collect(Collectors.toList());

        return match;

    }


    public Iterable<Transaction> getBySenderOrderedByAmountDescending(String sender) {
        List<Transaction>matches=this.transactions.values().stream().filter(e->e.getSender().equals(sender)).sorted((p1,p2)->
                Double.compare(p2.getAmount(),p1.getAmount())).collect(Collectors.toList());

        if(matches.isEmpty()){
            throw  new IllegalArgumentException();
        }
        return matches;
    }

    public Iterable<Transaction> getByReceiverOrderedByAmountThenById(String receiver) {
       List<Transaction>match= this.transactions.values().stream().filter(e->e.getReceiver().equals(receiver)).sorted((p1,p2)->{
            int comparator=Double.compare(p2.getAmount(),p1.getAmount());
            if(comparator==0){
                comparator=Integer.compare(p1.getId(),p2.getId());
            }
            return comparator;
        }).collect(Collectors.toList());
       if(match.isEmpty()){
           throw new IllegalArgumentException();
       }
       return match;
    }

    public Iterable<Transaction> getByTransactionStatusAndMaximumAmount(TransactionStatus status, double amount) {
        List<Transaction>matches=this.transactions.values().stream().filter(e->e.getStatus().equals(status)&&e.getAmount()<=amount).sorted((p1,p2)->Double.compare(p2.getAmount(),p1.getAmount())).collect(Collectors.toList());
        return matches;
    }

    public Iterable<Transaction> getBySenderAndMinimumAmountDescending(String sender, double amount) {
        List<Transaction>matches=this.transactions.values().stream().filter(e->e.getSender().equals(sender)&&e.getAmount()>amount).sorted((p1,p2)->Double.compare(p2.getAmount(),p1.getAmount())).collect(Collectors.toList());
        if(matches.isEmpty()){
            throw  new IllegalArgumentException();
        }
        return matches;
    }

    public Iterable<Transaction> getByReceiverAndAmountRange(String receiver, double lo, double hi) {
        List<Transaction>matches=this.transactions.values().stream().filter(e->e.getReceiver().equals(receiver)&&e.getAmount()>lo&&e.getAmount()<=hi).sorted((p1,p2)->{
            int comparator=Double.compare(p2.getAmount(),p1.getAmount());
            if(comparator==0){
                comparator=Integer.compare(p1.getId(),p2.getId());
            }
            return comparator;
        }).collect(Collectors.toList());
        if(matches.isEmpty()){
            throw new IllegalArgumentException();
        }

        return matches;
    }

    public Iterable<Transaction> getAllInAmountRange(double lo, double hi) {
        List<Transaction>matches=this.transactions.values().stream().filter(e->e.getAmount()>lo&&e.getAmount()<=hi).collect(Collectors.toList());
        return matches;
    }

    public Iterator<Transaction> iterator() {

        return null;
    }
}
