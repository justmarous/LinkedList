import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Demo {

    public static void main(String[] args) {

        System.out.println("Start");
        LinkedList<String> placesToVisit = new LinkedList<String>();

        inOrder(placesToVisit,"Sydney");
        inOrder(placesToVisit,"Melbourne");
        inOrder(placesToVisit,"Brisbane");
        inOrder(placesToVisit,"Perth");
        inOrder(placesToVisit,"Canberra");
        inOrder(placesToVisit,"Adelaide");

        printList(placesToVisit);

        inOrder(placesToVisit,"Alice Springs");
        inOrder(placesToVisit,"Sydney");

        printList(placesToVisit);

        visit(placesToVisit);

    }

    private static void visit(LinkedList cities ){
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean goingForward = true;
        ListIterator<String> listIterator = cities.listIterator();

        if(cities.isEmpty())
            {
                System.out.println("No cities");
            }

        else {
            System.out.println("Now visiting "+listIterator.next());
            printMenu();
        }

        while(!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("Holiday is over");
                    quit = true;
                    break;
                case 1:
                    if(!goingForward)
                    {
                        if(listIterator.hasNext())listIterator.next();
                        goingForward = true;
                    }
                    if(listIterator.hasNext())
                      System.out.println("Now visiting "+listIterator.next());
                    else {
                        System.out.println("Reached the end of the list.");
                        goingForward = false;
                    }
                    break;
                case 2:
                    if(goingForward)
                    {
                        if(listIterator.hasPrevious())listIterator.previous();
                        goingForward=false;
                    }
                    if(listIterator.hasPrevious())
                    {
                        System.out.println("Now visiting "+listIterator.previous());
                    }
                    else {
                        System.out.println("We are on the start!");
                        goingForward = true;
                    }
                    break;
                case 3:
                    printMenu();
            }
        }
    }

    private static void printMenu()
    {
        System.out.println("0 -> Finish holidays\n1 -> Visit next city\n2 -> Visit previous city\n3 -> Repeat instruction");
    }

    private static void printList(LinkedList<String> linkedList)
    {
        Iterator<String> i = linkedList.iterator();

        while(i.hasNext()) //jeżeli jest cokolwiek dalej
        {
            System.out.println("Now visiting "+i.next()); //kolejna wartość i
        }
        System.out.println("====================");
    }

    private static boolean inOrder(LinkedList<String> linkedList,String newCity)
    {
        ListIterator<String> stringListIterator = linkedList.listIterator();

        while(stringListIterator.hasNext())
        {
            int comparison = stringListIterator.next().compareTo(newCity); //if 0 -> matched
            if(comparison ==0) //equal, do not add
            {
                System.out.println(newCity+" is already included as a destination.");
                return false;
            }
            else if(comparison>0)
            {
                //new city should appear before this one
                //Brisbane ->Adelaide

                stringListIterator.previous();
                stringListIterator.add(newCity);
                return true;
            }
            else if(comparison<0)
            {
                //move to the next city
            }
        }
        stringListIterator.add(newCity);
        return true;
    }

}
