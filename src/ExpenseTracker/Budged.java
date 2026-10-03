package ExpenseTracker;


enum Category{
    BASIC,
    FUN,
    GROCERY,
    CAR,
    PET,
    SAVINGS;
}
public class Budged {

    public int id;
    public String description;
    public double amount;
    public String category;
    public String date;


    public Budged(int currentId, String description, String category, double amount, String date){
        this.id = currentId;
        this.amount = amount;
        this.category = category;
        this.description = description;
        this.date = date;

    }

    //getters-setters
    public String getDate(){
        return date;
    }
    public String getCategory(){

        return category;
    }
    public double getAmount(){

        return amount;
    }
    public String getDescription(){

        return description;
    }
    public int getById(){
        return id;
    }
    public void setDate(String date){
        this.date = date;
    }
    public void setCategory(String category){
        this.category = category;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public void setAmount(double amount){
        this.amount = amount;
    }

}
