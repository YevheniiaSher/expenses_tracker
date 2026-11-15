package ExpenseTracker;

import java.util.Scanner;
import java.time.LocalDate;

public class ConsoleApp {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        ExpenseRepository repo = new FileExpenseRepository();

        while(true){
            System.out.println("1. Add 2.List 3.Update 4.Delete 0.Exit");
            String choice = scanner.nextLine();
            if(choice.equals("1")){
                try{
                    System.out.println("Indicate the category:");
                    Category category = Category.valueOf(scanner.nextLine().toUpperCase());
                    System.out.println("Insert the amount spent:");
                    double amount = Double.parseDouble(scanner.nextLine());
                    System.out.println("Indicate short description");
                    String description = scanner.nextLine();

                    Expense expense = new Expense(repo.getNextId(), LocalDate.now(), category, description, amount);
                    repo.add(expense);
                    System.out.println("Successfully added!");
                }catch(IllegalArgumentException e){
                    System.out.println("Wrong input:" + e.getMessage());
                }
            }else if (choice.equals("2")){
                for(Expense e : repo.findAll()){
                    System.out.println(e.toLine());
                }
            }else if (choice.equals("0")){
                break;
            }
        }
    }
}
