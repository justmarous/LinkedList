import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here

    }

    public static void firstExample()
    {

        Customer customer = new Customer("Marek",323);
        Customer anotherCustomer;
        anotherCustomer = customer;
        anotherCustomer.setBalance(56);

        System.out.println("Balance for "+customer.getName()+" "+customer.getBalance());
        System.out.println("Balance for "+anotherCustomer.getName()+" "+anotherCustomer.getBalance());

        ArrayList<Integer> intList = new ArrayList<Integer>();

        intList.add(2);
        intList.add(3);
        intList.add(55);
        intList.add(99);

        for(int i = 0;i<intList.size();i++)
        {
            System.out.println("IntList position "+i+": "+intList.get(i));
        }


        intList.add(1,2);

        for(int i = 0;i<intList.size();i++)
        {
            System.out.println("IntList position "+i+": "+intList.get(i));
        }

    }

}
