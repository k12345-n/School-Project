package pizza.ordering.system;

import java.util.Scanner;

public class PizzaOrderingSystem {
    static boolean a = false;
    static Scanner scan = new Scanner(System.in);
    static int b = 0;
    static int c;
    static int d = 0;
    static String[] name = new String[100];
    static int[] id = new int[100];
    static String[] address = new String[100];
    static String[] emailaddress = new String[100];
    static int[][] pizzasize = new int[100][100];
    static int[][][] pizzatop = new int[100][100][3];
    static int price = 0;
    static int[][] oldpizzasize = new int[100][100];
    static int[][][] oldpizzatop = new int[100][100][3];
            
    public static void main(String[] args) {
        System.out.println("Hello welcome to Pizza Ordering System\n");
        do{
            System.out.println("");
            System.out.println("1. Customer Registration");
            System.out.println("2. Customer Order History");
            System.out.println("3. Order a Pizza");
            System.out.println("4. View Cart");
            System.out.println("5. Edit Order");
            System.out.println("6. Checkout");
            System.out.println("7. Exit");
            System.out.print("Choose between 1-7 : ");
        
            do{
                int x = scan.nextInt();

                switch(x) {
                    case 1:
                        a = false;
                        b++;
                        custregister();
                        break;
                    case 2:
                        a = false;
                        cusorderhistory();
                        break;
                    case 3:
                        a = false;
                        orderpiz();
                        break;
                    case 4:
                        a = false;
                        viewcart();
                        break;
                    case 5:
                        a = false;
                        editorder();
                        break;
                    case 6:
                        a = false;
                        checkout();
                        break;
                    case 7:
                        System.out.println("Have a nice day.");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Please choose between 1-7:");
                        a = true;
                        break;
                }
            }while (a);
        }while (true);
    }
    
    public static void custregister (){
        System.out.print("Please write your name: ");
        name[b-1] = scan.nextLine();
        scan.nextLine();
        System.out.print("Please write your home address: ");
        address[b-1] = scan.nextLine();
        System.out.print("");
        id[b-1] = b;
        System.out.print("Please write your email address: ");
        emailaddress[b-1] = scan.nextLine();
        System.out.println("Your id is " + id[b-1]);
    }
    
    public static void findcustomer() {
        
        if(id[0] != 0){
            System.out.print("Please enter your id:");
            int cusid =scan.nextInt();
            c = 0;
        
            for(int i = 0; i < id.length; i++){
                if(cusid == id[i]){
                    c = i + 1;
                    break;
                }
            }
            if(c == 0){
                System.out.println("Your id was not found.");
            }
        }else if(c == 0){
            System.out.println("There is no person register yet.");
        }
    }
    
    public static void cusorderhistory(){
        findcustomer();
        if (c != 0){
            if(oldpizzasize[c][0] != 0){
                for(int i = 0; i < oldpizzasize[c][i] && oldpizzasize[c][i] != 0; i++){
                    System.out.println();
                    System.out.println("Pizza " + (i+1) + ":");
                    if(oldpizzasize[c][i] == 1){
                        System.out.println("Size : large RM 5");
                    }else if(oldpizzasize[c][i] == 2){
                        System.out.println("Size : medium RM 4");
                    }else if(oldpizzasize[c][i] == 3){
                        System.out.println("Size : small RM 3");
                    }
                    for(int j = 0; j < oldpizzatop[c][i].length && oldpizzatop[c][i][j] != 0;j++){
                        System.out.print("topping " + (j+1) + ":");
                        if(oldpizzatop[c][i][j] == 1){
                            System.out.println("tomato - RM 1");
                        }else if(oldpizzatop[c][i][j] == 2){
                            System.out.println("pineapple - RM 2");
                        }else if(oldpizzatop[c][i][j] == 3){
                            System.out.println("hotdog - RM3");
                        }
                    }
                }
            }else{
                System.out.println("you does not have any order history yet.");
            }
        }
    }
    
    public static void pizzasize(){
        System.out.println("Please choose the size:");
        System.out.println("1. large - RM 5");
        System.out.println("2. medium - RM 4");
        System.out.println("3. small - RM3");
    }
    
    public static void topping(){
        System.out.println("Select the topping:");
        System.out.println("1. tomato - RM 1");
        System.out.println("2. pineapple - RM 2");
        System.out.println("3. hotdog - RM3");
    }
    
    public static void orderpiz(){
        findcustomer();
        while(c != 0 ){
            d = 0;
            while(pizzasize[c][d] != 0){
                d++;
            }
            pizzasize();
            pizzasize[c][d] = scan.nextInt();
            System.out.println("Select the number of topping you wish. (Max: 3)");
            int num = scan.nextInt();
            for (int i = 0; i < num; i++){
                topping();
                pizzatop[c][d][i] = scan.nextInt();
            }
            break;
        }
    }
    
    public static void viewcart(){
        findcustomer();
        while(c != 0 && pizzasize[c][0] != 0){
            price = 0;
            for (int i = 0; i < pizzatop[c].length && pizzasize[c][i] != 0; i++){
                System.out.println();
                System.out.println("Pizza " + (i+1) + ":");
                if(pizzasize[c][i] == 1){
                    System.out.println("Size : large RM 5");
                    price += 5;
                }else if(pizzasize[c][i] == 2){
                    System.out.println("Size : medium RM 4");
                    price += 4;
                }else if(pizzasize[c][i] == 3){
                    System.out.println("Size : small RM 3");
                    price += 3;
                }
                for(int j = 0; j < pizzatop[c][i].length && pizzatop[c][i][j] != 0;j++){
                    System.out.print("topping " + (j+1) + ":");
                    if(pizzatop[c][i][j] == 1){
                        System.out.println("tomato - RM 1");
                        price += 1;
                    }else if(pizzatop[c][i][j] == 2){
                        System.out.println("pineapple - RM 2");
                        price += 2;
                    }else if(pizzatop[c][i][j] == 3){
                        System.out.println("hotdog - RM3");
                        price += 3;
                    }
                }
            }
            System.out.println("The total price : RM " + price);
            break;
        }
        if (pizzasize[c][0] == 0){
            System.out.println("You did not order any pizza yet");
        }
    }
    
    public static void editorder(){
        findcustomer();
        while(c != 0 && pizzasize[c][0] != 0){
            for (int i = 0; i < pizzatop[c].length && pizzasize[c][i] != 0; i++){
                System.out.println();
                System.out.println("Pizza " + (i+1) + ":");
                if(pizzasize[c][i] == 1){
                    System.out.println("Size : large RM 5");
                }else if(pizzasize[c][i] == 2){
                    System.out.println("Size : medium RM 4");
                }else if(pizzasize[c][i] == 3){
                    System.out.println("Size : small RM 3");
                }
                for(int j = 0; j < pizzatop[c][i].length && pizzatop[c][i][j] != 0;j++){
                    System.out.print("topping " + (j+1) + ":");
                    if(pizzatop[c][i][j] == 1){
                        System.out.println("tomato - RM 1");
                    }else if(pizzatop[c][i][j] == 2){
                        System.out.println("pineapple - RM 2");
                    }else if(pizzatop[c][i][j] == 3){
                        System.out.println("hotdog - RM3");
                    }
                }
            }
            System.out.println();
            System.out.println("State which pizza you wish to edit (in number)");
            int edit = scan.nextInt() - 1;
            System.out.println("You wish to edit size or topping?");
            System.out.println("1. Pizza size");
            System.out.println("2. Topping");
            int st = scan.nextInt();
            if (st == 1){
                pizzasize();
                System.out.print("Select the size you wish:");
                int esize = scan.nextInt();
                pizzasize[c][edit] = esize;
            }else{
                System.out.println("Select the number of topping you wish. (Max: 3)");
                int num = scan.nextInt();
                for (int i = 0; i < 3; i++){
                    pizzatop[c][edit][i] = 0;
                }
                for (int i = 0; i < num; i++){
                    topping();
                    pizzatop[c][edit][i] = scan.nextInt();
                }
            }
            break;
        }
        if (pizzasize[c][0] == 0){
            System.out.println("You did not order any pizza yet");
        }
    }
    
    public static void checkout(){
        viewcart();
        while(c != 0 && pizzasize[c][0] != 0){
            d = 0;
            while (oldpizzasize[c][d] != 0){
                d++;
            }
            
            System.out.println("The total is RM " + price + ". How much would you like to pay?");
            int pay = scan.nextInt();
            do{
                if (pay > price){
                    System.out.println("Thank you! Here is your change of RM " + (pay - price));
                    a = false;
                }else if (pay == price){
                    System.out.println("Thank you! That is the exact amount.");
                    a = false;
                }else {
                    System.out.println("The total is RM " + price + ".Please do not give less than RM " + price);
                    pay = scan.nextInt();
                    a = true;
                }
            }while(a);

            for(int i = 0; i < pizzasize[c].length && pizzasize[c][i] != 0; i++){
                oldpizzasize[c][d] = pizzasize[c][i];
                pizzasize[c][i] = 0;
                for(int j = 0; j < pizzatop[c][i].length && pizzatop[c][i][j] != 0; j++){
                    oldpizzatop[c][d][j] = pizzatop[c][i][j];
                    pizzatop[c][i][j] = 0;
                }
                d++;
            }
            break;
        }
        if (pizzasize[c][0] != 0){
            System.out.println("You did not order any pizza yet.");
        }
    }
}