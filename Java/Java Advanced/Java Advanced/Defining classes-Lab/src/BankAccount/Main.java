package BankAccount;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String line;
        Map<Integer,BankAccount>data=new HashMap<Integer, BankAccount>();


        while (!"End".equals(line=reader.readLine())){
            String[]tokens=line.split(" ");

            switch (tokens.length){
                case 1:
                    BankAccount bankAccount=new BankAccount();
                    data.put(bankAccount.getId(),bankAccount);
                    System.out.println(String.format("Account ID%d created",bankAccount.getId()));

                    break;

                case 2:
                    double rate=Double.parseDouble(tokens[1]);
                    BankAccount.setInterestRate(rate);

                    break;

                case 3:
                    int neededId= Integer.parseInt(tokens[1]);
                    if(!data.containsKey(neededId)){
                        System.out.println("Account does not exist");
                        continue;
                    }
                    if("Deposit".equals(tokens[0])){
                        double amount=Double.parseDouble(tokens[2]);

                        data.get(neededId).deposit(amount);
                        System.out.println(String.format("Deposited %.0f to ID%d",amount,neededId));
                    }else{
                        int years=Integer.parseInt(tokens[2]);
                        System.out.println(String.format("%.2f",data.get(neededId).getInterest(years)));
                    }

                    break;

            }

        }
    }
}
