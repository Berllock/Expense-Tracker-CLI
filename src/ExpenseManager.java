import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ExpenseManager {

    private List<Expense> expenses;
    private Long nextId;

    public ExpenseManager() {
        this.expenses = new ArrayList<>();
        this.nextId = 1L;
    }

    public void addExpense(String description, Double amount) {
        Expense newExpense = new Expense(nextId, description, amount);
        expenses.add(newExpense);
        nextId++;
    }

    public List<Expense> getExpenses() {
        return new ArrayList<>(expenses);
    }

    public boolean updateExpense(Long id, String newDescription, Double newAmount) {
        Optional<Expense> expenseUpdate = expenses.stream().filter(exp -> exp.getId().equals(id)).findFirst();

        if (expenseUpdate.isPresent()) {
            Expense expense = expenseUpdate.get();

            expense.setDescription(newDescription);
            expense.setAmount(newAmount);
            return true;
        }
        return false;
    }

    public boolean deleteExpense(Long id) {
        return expenses.removeIf(expense -> expense.getId().equals(id));
    }

}
