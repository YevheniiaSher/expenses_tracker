package ExpenseTracker;
import java.util.Locale;
import java.util.Scanner;

public class Update {
    public static void main(String[] args){
        updateExpences();
    }
    public static void updateExpences(){
        System.out.println("Enter the ID you'd like you update:");
        Scanner update = new Scanner(System.in);
        Budged expences = null;
        try{
            int id = update.nextInt();
            expences = Storage.getById(id);
            if (expences == null){
                System.out.println("ID doesn't exist");
                return;
            }
            System.out.println("ID:" + expences.getById());
            System.out.println("Date:" + expences.getDate());
            System.out.println("Category:" + expences.getCategory());
            System.out.println("Description:" + expences.getDescription());
            System.out.println("Amount:" + expences.getAmount());
        } catch (Exception e) {
            System.out.println("ID must be a number");
        }
        System.out.println("Enter new date or Press Enter to skip");
        try{
            String newDate = update.next();
            if(!newDate.isBlank()){
                expences.setDate(newDate);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("Enter new category or Press Enter to skip");
        try{
            String newCategory = String.valueOf(Category.valueOf(update.next().toUpperCase()));
            if(!newCategory.isBlank()){
                expences.setCategory(newCategory);
            }
        } catch (Exception e) {
            System.out.println("Category doesn't exist");
        }
        System.out.println("Enter new description or Press Enter to skip");
        try{
            String newDescription = update.next();
            if(!newDescription.isBlank()){
                expences.setDescription(newDescription);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("Enter new amount spent or Press Enter to skip");
        try{
            double newAmount = update.nextDouble();
            if(newAmount > 0){
                expences.setAmount(newAmount);}
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Storage.updateExpense(expences.id, expences.date, expences.category, expences.description, expences.amount);
    }
}
