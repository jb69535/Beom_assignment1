package Beom_assignment1;

import java.util.*;
import java.io.*;

public class LinkedListDriver {

    public char INSERT = 'i';
    public char DELETE = 'd';
    public char SEARCH = 's';
    public char GET_NEXT = 'n';
    public char RESET_LIST = 'r';
    public char DEL_ALT = 'a';
    public char MERGE = 'm';
    public char INTERSECTION = 't';
    public char PRINT_ALL = 'p';
    public char LENGTH = 'l';
    public char QUIT = 'q';

    public static void main(String args[]) {

        System.out.println("Commands:");
        System.out.println("(i) - Insert value");
        System.out.println("(d) - Delete value");
        System.out.println("(s) - Search value");
        System.out.println("(n) - Print next iterator value");
        System.out.println("(r) - Reset iterator");
        System.out.println("(a) - Delete alternate nodes");
        System.out.println("(m) - Merge lists");
        System.out.println("(t) - Find intersection");
        System.out.println("(p) - Print list");
        System.out.println("(l) - Print length");
        System.out.println("(q) - Quit program");

        SortedLinkedList sList = new SortedLinkedList();
        boolean quitDoWhile = false;

        try {
            if (args.length > 0) {
                File file = new File(args[0]);
                Scanner fileScanner = new Scanner(file);

                while (fileScanner.hasNext()) {
                    int fileNum = fileScanner.nextInt();
                    sList.insertItem(new ItemType(fileNum));
                }
            }
        } catch (FileNotFoundException fnfe) {
            System.err.println(fnfe);
        }

        Scanner command = new Scanner(System.in);

        do {
            System.out.print("Enter a command : ");
            String commandInput = command.next();
            switch (commandInput) {
                case "p":
                    System.out.println("The list is: " + sList);
                    break;
                case "l":
                    System.out.print("The length of the list is: " + sList.getLength() + "\n");
                    break;
                case "i":
                    System.out.print("Enter a number to insert : ");
                    int insert = command.nextInt();
                    System.out.println("Original list : " + sList);
                    sList.insertItem(new ItemType(insert));
                    System.out.println("New List : " + sList);
                    break;
                case "d":
                    System.out.print("Enter a number to delete : ");
                    int delete = command.nextInt();
                    if (sList.getLength() != 0) {
                        System.out.println("Original list : " + sList);
                        sList.deleteItem(new ItemType(delete));
                        System.out.println("New List : " + sList);
                    } else {
                        System.out.println("You cannot delete from an empty list");
                    }
                    break;
                case "s":
                    System.out.print("Enter a number to search: ");
                    int searchNum = command.nextInt();
                    System.out.println("Original list: " + sList);
                    int search = sList.searchItem(new ItemType(searchNum));
                    if (sList.getLength() == 0) {
                        System.out.println("The list is empty");
                    } else if (search < 0) {
                        System.out.println("Item is not present in the list");
                    } else {
                        System.out.println("The item is present at index " + search);
                    }
                    break;
                case "n":
                    System.out.println(sList.getNextItem().getValue());
                    break;
                case "r":
                    sList.resetList();
                    System.out.println("Iterator is reset");
                    break;
                case "a":
                    System.out.println("Original list: " + sList);
                    SortedLinkedList alt = sList;
                    sList.DeleteAlternate();
                    System.out.println("Modified list: " + sList);
                    sList = alt;
                    break;
                case "m":
                    System.out.print("Enter the length of the new list: ");
                    SortedLinkedList temp = new SortedLinkedList();
                    alt = sList;
                    int merge = command.nextInt();
                    System.out.print("Enter the numbers: ");
                    for (int i = 0; i < merge; i++) {
                        int l = command.nextInt();
                        temp.insertItem(new ItemType(l));
                    }
                    System.out.println("The list 1: " + sList);
                    System.out.println("The list 2: " + temp);
                    sList.mergeList(sList, temp);
                    System.out.println("Merged List: " + temp);// check implementation
                    sList = alt;
                    break;
                case "t":
                    System.out.print("Enter the length of the new list: ");
                    temp = new SortedLinkedList();
                    alt = sList;
                    int intersectionNum = command.nextInt();
                    System.out.print("Enter the numbers: ");
                    for (int i = 0; i < intersectionNum; i++) {
                        int l = command.nextInt();
                        temp.insertItem(new ItemType(l));
                    }
                    System.out.println("The list 1: " + sList);
                    System.out.println("The list 2: " + temp);
                    System.out.print("Intersection of lists: ");
                    sList.intersection(temp);
                    sList = alt;
                    break;
                case "q":
                    quitDoWhile = true;
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid Command, try again!");
                    break;
            }
        } while (!quitDoWhile);

        command.close();
    }
}