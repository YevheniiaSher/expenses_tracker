package ExpenseTracker;

import java.util.Optional;
import java.util.List;

public interface ExpenseRepository {
    void add(Expense expense);
    Optional <Expense> findById(int id); //for cases with non-existing id
    boolean update(Expense expense);
    boolean delete(int id);
    int getNextId();
    List <Expense> findAll();

}
