

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author clarencegrimaldo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws InterruptedException {
        /* ----------------------- prepare ----------------------- */
        // books
        Product book1 = new Product("One Piece", 9.99, 24, "Book");
        Product book2 = new Product("Harry Potter", 14.99, 53, "Book");
        Product book3 = new Product("Hunger Games", 19.99, 48, "Book");

        // cds

        Product cd1 = new Product("The Modern Western World | Vansire",15.99,78,"CD");
        Product cd2 = new Product("Trench | Twenty One Pilots", 12.99, 84, "CD");
        Product cd3 = new Product("Black Parade | My Chemical Romance",17.99,32, "CD");

        // dvds
        Product dvd1 = new Product("Avenger's Infinity War", 23.99, 51, "DVD");
        Product dvd2 = new Product("John Wick", 25.99, 32, "DVD");
        Product dvd3 = new Product("How to Train Your Dragon", 19.99, 81, "DVD");

        // inventory
        ArrayList<Product> productList = new ArrayList<Product>();
        productList.add(book1);
        productList.add(book2);
        productList.add(book3);
        productList.add(cd1);
        productList.add(cd2);
        productList.add(cd3);
        productList.add(dvd1);
        productList.add(dvd2);
        productList.add(dvd3);


        // members
        Member m1 = new Member("Josh",1,"1111-2222-3333-4444", "Regular", false, false, 54.99);
        Member m2 = new Member( "Morgan", 2, "5555-6666-7777-8888", "Premium",true,false,128.99);
        Member m3 = new Member("Haley",1,"2222-1111-3333-1111","Regular", false, false, 21.99);
        Member m4 = new Member("Gunner",2, "7777-4444-6666-2222","Premium", true,true,231.99);
        Member m5 = new Member("Brendan",1, "1111-6666-5555-3333", "Regular", true, false,72.99);
        Member m6 = new Member( "Andrew", 2, "3333-8888-9999-4444",  "Premium",  true, true, 323.99 );

        ArrayList<Member> listOfMembers = new ArrayList<Member>();
        ArrayList<Member> listOfPremiumMembers = new ArrayList<Member>();

        listOfMembers.add(m1);
        listOfMembers.add(m2);
        listOfMembers.add(m3);
        listOfMembers.add(m4);
        listOfMembers.add(m5);
        listOfMembers.add(m6);
        listOfPremiumMembers.add(m2);
        listOfPremiumMembers.add(m4);
        listOfPremiumMembers.add(m5);
        listOfPremiumMembers.add(m6);


        /* ----------------------- start ----------------------- */
        boolean hasExitedProgram = false;
        Scanner scan = new Scanner(System. in);

        System.out.println("Welcome to the Bookstore ");
        Thread.sleep(2500);
        System.out.println("\nPlease select an operation number:");


        while (hasExitedProgram == false) {
            System.out.println("-----------------------");
            System.out.println("1. Make a purchase");
            System.out.println("2. Check inventory");
            System.out.println("3. Check members");
            System.out.println("4. Exit");
            System.out.println("-----------------------");
            int input = scan.nextInt();

            switch (input) {
                    /* ----------------------- MAKING A PURCHASE ----------------------- */
                case 1:
                    // Shopping
                    ArrayList<Product> cart = new ArrayList<Product>();
                    boolean finishedShopping = false;
                    double total = 0.0;
                    while (finishedShopping == false) {
                        //displayPurchase(scan, productList);
                        System.out.println("-----------------------");
                        System.out.println("What would you like to purchase:\n");
                        int count = 1;
                        for (Product item : productList) {
                            System.out.println(count + ". " + item.productDisplay());
                            count++;
                        }

                        int input2 = scan.nextInt();
                        input2--; // normalize to match indexes of list

                        cart.add(productList.get(input2));
                        total += productList.get(input2).getPrice();

                        System.out.println(
                            "You have " + cart.size() + " in your cart, are you finished shopping? (Y/N)"
                        );
                        String input3 = scan.next();

                        Thread.sleep(2500);

                        System.out.println("-----------------------");
                        if (input3.equals("y") || input3.equals("Y")) {
                            System.out.println("You're total is $" + total);
                            finishedShopping = true;
                            System.out.println("-----------------------");
                        }
                    }

                    Thread.sleep(2500);//this just pauses the program temporarily

                    // Membership
                    Member currentMember = new Member(null, listOfMembers.size(), null, null, false, false, 0.00);
                    System.out.println("\n-----------------------");
                    System.out.println("Are you currently a member? (Y/N)");
                    String input4 = scan.next();

                    if (input4.equals("y") || input4.equals("Y")) {
                        System.out.println("-----------------------");
                        System.out.println(
                            "Please input # corresponding to your membership account:\n"
                        );
                        int count = 1;
                        for (Member account : listOfMembers) {
                            System.out.println(count + ". " + account.memberDisplay());
                            count++;
                        }
                        int input5 = scan.nextInt() - 1;
                        for (int i = 0; i < listOfMembers.size(); i++) {
                            if (input5 == i) {
                                currentMember = listOfMembers.get(i);
                            }
                        }
                    } else {
                        System.out.println("-----------------------");
                        System.out.println("Lets make you a new account");

                        //create member
                        Member newMember = new Member(null, (listOfMembers.size() + 1), null, null, false, false, 0.0);

                        // make new scanners to fix debit card and membership type not being scanned by
                        // input
                        Scanner debitScan = new Scanner(System. in);
                        Scanner typeScan = new Scanner(System. in);
                        System.out.println("\n1. What is your name?");
                        String inName = scan.next();
                        newMember.setName(inName);

                        System.out.println(
                            "\n2. Please put in your debit card number for membership and item purchases."
                        );
                        String inDebit = debitScan.next();
                        newMember.setCardInfo(inDebit);

                        System.out.println(
                            "\n3. And finally, would you like a premium membership? (Y/N)"
                        );
                        String inType = typeScan.next();
                        if (inType.equals("y") || inType.equals("Y")) {
                            newMember.setMembershipType("Premium");
                            Product premiumMembership = new Product("Premium", 9.99, 1, "Membership");
                            cart.add(premiumMembership);
                        } else {
                            newMember.setMembershipType("Regular");
                        }

                        listOfMembers.add(newMember);
                        currentMember = newMember;
                    }

                    Thread.sleep(2500);

                    System.out.println("-----------------------");
                    System.out.println(
                        "Membership obtained! Welcome back, " + currentMember.getName() + "!"
                    );
                    currentMember.addTotalToBalance(total);

                    // Reciept
                    Thread.sleep(1000);
                    System.out.println(
                        "\n----------------------- RECEIPT -----------------------\n"
                    );
                    System.out.println(currentMember.memberDisplay());

                    for (Product boughtItem : cart) {
                        // decrease inventory for each item bought
                        /*
                        if (boughtItem.getType().equals("Book")) {
                            boughtItem.decreaseBook();
                        }

                        if (boughtItem.getType().equals("CD")) {
                            boughtItem.decreaseCD();
                        }

                        if (boughtItem.getType().equals("DVD")) {
                            boughtItem.decreaseDVD();
                        }
                        */
                        boughtItem.decreaseAmount();
                        System.out.println(
                            " - (" + boughtItem.getType() + ")" + boughtItem.getName() + " | $" +
                            boughtItem.getPrice()
                        );
                    }

                    System.out.println("Total: $" + total);
                    System.out.println(
                        "\n----------------------- END OF RECEIPT -----------------------\n"
                    );

                    Thread.sleep(2500);

                    break;


                    /* ----------------------- CHECK INVENTORY ----------------------- */
                case 2:
                    int bookTotal = 0;
                    int cdTotal = 0;
                    int dvdTotal = 0;

                    System.out.println("-----------------------");
                    System.out.println("What would you like to check: ");
                    System.out.println("1. Books");
                    System.out.println("2. CDs");
                    System.out.println("3. DVDs");
                    System.out.println("-----------------------");

                    int inventoryInput = scan.nextInt();

                    Thread.sleep(2500);

                    System.out.println("Here is the current inventory: ");

                    // calculate book inventory
                    for (Product product : productList) {
                        if (product.getType().equals("Book")) {
                            bookTotal += product.getAmount();
                        }
                    }

                    // calculate cd inventory
                    for (Product product : productList) {
                        if (product.getType().equals("CD")) {
                            cdTotal += product.getAmount();
                        }
                    }

                    // calculate dvd inventory
                    for (Product product : productList) {
                        if (product.getType().equals("DVD")) {
                            dvdTotal += product.getAmount();
                        }
                    }

                    switch (inventoryInput) {
                        case 1:
                            // Books
                            System.out.println(" - Books: " + bookTotal);
                            for (Product product : productList) {
                                if (product.getType().equals("Book")) {
                                    System.out.println(
                                        "Name: " + product.getName() + " | Amount: " + product.getAmount()
                                    );
                                }
                            }
                            break;
                        case 2:
                            // CDs
                            System.out.println("\n - CDs: " + cdTotal);
                            for (Product product : productList) {
                                if (product.getType().equals("CD")) {
                                    System.out.println(
                                        "Name: " + product.getName() + " | Amount: " + product.getAmount()
                                    );
                                }
                            }
                            break;
                        case 3:
                            // DVDs
                            System.out.println(" - DVDs: " + dvdTotal);
                            for (Product product : productList) {
                                if (product.getType().equals("DVD")) {
                                    System.out.println(
                                        "Name: " + product.getName() + " | Amount: " + product.getAmount()
                                    );
                                }
                            }
                            break;
                        default:
                            System.out.println("Invalid Input");
                            break;
                    }

                    Thread.sleep(2500);

                    break;


                    /* ----------------------- CHECK MEMBERS ----------------------- */
                case 3:
                    System.out.println("-----------------------");
                    System.out.println("Which would you like to view: ");
                    System.out.println("1. All members");
                    System.out.println("2. Regular members");
                    System.out.println("3. Premium members");
                    System.out.println("4. Overdue Payments");
                    int memberInput = scan.nextInt();

                    Thread.sleep(2500);

                    System.out.println("-----------------------");
                    System.out.println("Here are the members:");
                    switch (memberInput) {
                        case 1:
                            for (Member member : listOfMembers) {
                                System.out.println(" - " + member.memberDisplay());
                            }
                            break;
                        case 2:
                            for (Member member : listOfMembers) {
                                if (member.getMembership().equals("Regular")) {
                                    System.out.println(" - " + member.memberDisplay());
                                }
                            }
                            break;
                        case 3:
                            for (Member member : listOfMembers) {
                                if (member.getMembership().equals("Premium")) {
                                    System.out.println(" - " + member.memberDisplay());
                                }
                            }
                            break;
                        case 4:
                            System.out.println("(Overdue Payments)\n");
                            for (Member member : listOfMembers) {
                                if (member.overduePayments() == true) {
                                    System.out.println(" - " + member.memberDisplay());
                                }
                            }
                            break;
                    }

                    Thread.sleep(2500);

                    break;


                    /* ----------------------- EXIT PROGRAM ----------------------- */
                case 4:
                    System.out.println("Ending Program...");
                    Thread.sleep(2500);
                    hasExitedProgram = true;

                    break;


                    /* ----------------------- DEFAULT ----------------------- */
                default:
                    System.out.println("Please input valid number...");

                    Thread.sleep(2500);

                    break;
            }
        }
    }
}
