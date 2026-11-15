package ExpenseTracker;

import java.time.format.DateTimeParseException;
import java.util.Objects;
import java.time.LocalDate;
import java.util.Optional;


enum Category{ CAR, PET, SAVINGS, FOOD, FUN, STUDY, OTHER}

public class Expense{

    private final int id;
    private String description;
    private double amount;
    private Category category;
    private LocalDate date;

    public Expense(int id, LocalDate date, Category category, String description, double amount){
        this.id = id;
        setDate(date);
        setCategory(category);
        setAmount(amount);
        setDescription(description);

    }

    //getters & setters
    /*getters
     setters*/
    public LocalDate getDate(){
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Category getCategory() {
        return category;
    }

    public void setAmount(double amount) {
        if(amount<=0){
            throw new IllegalArgumentException("Amount spent must be more than zero");
        }this.amount = amount;

    }
    public void setDescription(String description){
        if (description == null || description.isBlank()){
            throw new IllegalArgumentException("Description must not be empty");
        }
        if(description.contains("|")){ //need another method to put other symbols "@", "#", "$", "%", "^", "&", "*", "|"
            throw new IllegalArgumentException("Description can't contain symbols");}
         this.description = description.trim();
    }
    public void setCategory(Category category){
        this.category = Objects.requireNonNull(category, "Category must not be null");
    }
    public void setDate(LocalDate date){
        this.date = Objects.requireNonNull(date, "Date must not be null");
    }

    public String toLine(){
        return id+ "|" + date + "|" + category + "|" + description + "|" + amount;
    }

    public static Optional <Expense> fromLine(String line){
        String [] d = line.split("\\|", -1);
        if(d.length !=5) return Optional.empty();
        try{
            return Optional.of(new Expense(
                    Integer.parseInt(d[0]),
                    LocalDate.parse(d[1]),
                    Category.valueOf(d[2]),
                    d[3],
                    Double.parseDouble(d[4])));
        }catch (IllegalArgumentException | DateTimeParseException e){
            return Optional.empty();
        }
    }

}
