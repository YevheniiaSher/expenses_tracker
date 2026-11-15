package ExpenseTracker;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.nio.file.*;

public class FileExpenseRepository implements ExpenseRepository{

    private static final Path FILE = Path.of("data.txt");

    //helpers
    private List<String> readLines(){
        if(!Files.exists(FILE)){
            return new ArrayList<>();
        } try{
            return new ArrayList<>(Files.readAllLines(FILE));
        } catch (IOException e) {
            throw new UncheckedIOException("Error reading file", e);
        }
    }
    private void writeLines(List <String> lines){
        try{
            Files.write(FILE, lines);
        } catch (IOException e) {
            throw new UncheckedIOException("Error writing to file",e);
        }
    }

    @Override //create new record in a file
    public void add(Expense expense){
        try{
            Files.write(FILE, List.of(expense.toLine()),StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new UncheckedIOException("Error writing the file", e);
        }
    };
    @Override //find by id
    public Optional<Expense> findById(int id){

        for(String line : readLines()){
            Optional <Expense> e = Expense.fromLine(line);
            if (e.isPresent() && e.get().getId() == id){
                return e;
            }
        }return Optional.empty();

    };
    @Override //update existing record
    public boolean update(Expense expense){
        List<String> lines = readLines();
        for(int i = 0; i < lines.size(); i ++){
            Optional <Expense> current = Expense.fromLine(lines.get(i));
            if(current.isPresent() && current.get().getId() == expense.getId()){
                lines.set(i, expense.toLine());
                writeLines(lines);
                return true;
            }
        }return false;

    };
    @Override //delete existing record
    public boolean delete(int id){
        List<String> lines = readLines();
        for(int i = 0; i < lines.size(); i ++);{
            Optional <Expense> current = Expense.fromLine(lines.get(id));
            if(current.isPresent() && current.get().getId() == id){
                lines.remove(id);
                writeLines(lines);
                return true;
            }return false;
        }
    };
    @Override
    public int getNextId(){
        int max = 0;
        for(String line : readLines()){
            Optional <Expense> e = Expense.fromLine(line);
            if(e.isPresent() && e.get().getId() > max){
                max = e.get().getId();
            }
        }return max +1;
    }
    @Override
    public List <Expense> findAll(){
        List <Expense> result = new ArrayList<>();
        for(String line : readLines()){
            Expense.fromLine(line).ifPresent(result::add);
        }return result;
    }


}
