import java.util.List;

public class ExpenseTrackerCLI {
    public static void main(String[] args) {
        ExpenseManager manager = new ExpenseManager();

        if (args.length == 0) {
            showHelp();
            return;
        }

        String command = args[0];

        switch (command) {
            case "add":
                handleAddCommand(manager, args);
                break;
            case "update":
                handleUpdateCommand(manager, args);
                break;
            case "delete":
                handleDeleteCommand(manager, args);
                break;
            case "list":
                handleListCommand(manager);
                break;
            case "summary":
                break;
            default:
                System.out.println("Unknown command");
                showHelp();
        }


    }

    private static void showHelp() {
        System.out.println("Uso: expense-tracker <command>");
        System.out.println("Commands: add, list, delete, update, summary");
    }

    private static void handleAddCommand(ExpenseManager manager, String[] args) {
        String description = null;
        Double amount = null;

        for(int i = 1; i < args.length; i++) {
            switch (args[i]) {
                case "--description":
                    if(i + 1 < args.length) {
                        description = args[++i];
                    }
                    break;
                case "--amount":
                    if(i + 1 < args.length) {
                        try {
                            amount = Double.parseDouble(args[++i]);
                        } catch (NumberFormatException e) {
                            System.out.println("Error: amount must be a valid number");
                            return;
                        }
                    }
                    break;
            }
        }

        if (description == null || amount == null) {
            System.out.println("Error: Missing description and amount arguments. Use: add --description \"Texto\" or --amount 1234.45");
            return;
        }

        manager.addExpense(description, amount);
        System.out.println("Expense added");
    }

    private static void handleListCommand(ExpenseManager manager) {
        List<Expense> expenses = manager.getExpenses();

        System.out.println("Expenses in CURRENT session: " + expenses.size() + " items");
        System.out.println("ID  Date       Description  Amount");
        System.out.println("-----------------------------------");

        for (Expense expense : expenses) {
            System.out.printf("%-3d %-10s %-12s $%.2f%n",
                    expense.getId(),
                    expense.getDate(),
                    expense.getDescription(),
                    expense.getAmount());
        }

        if (expenses.isEmpty()) {
            System.out.println("(List is empty - each command starts fresh)");
        }
    }


    private static void handleDeleteCommand(ExpenseManager manager, String[] args) {
        Long id = null;

        for(int i = 1; i < args.length; i++) {
            if(args[i].equals("--id") && i + 1 < args.length) {
                try{
                    id = Long.parseLong(args[++i]);
                } catch (NumberFormatException e) {
                    System.out.println("Error: id must be a valid number");
                    return;
                }
            }
        }

        if (id == null) {
            System.out.println("Error: Missing --id argument. Use: delete --id 1");
            return;
        }

        boolean deleted = manager.deleteExpense(id);
        if(deleted) {
            System.out.println("Expense deleted");
        } else {
            System.out.println("Error: Expense with ID " + id + " not found");
        }
    }

    private static void handleUpdateCommand(ExpenseManager manager, String[] args) {
        Long id = null;
        String newDescription = null;
        Double newAmount = null;

        for(int i = 1; i < args.length; i++) {
            switch (args[i]) {
                case "--id":
                    if(i + 1 < args.length) {
                        try {
                            id = Long.parseLong(args[++i]);
                        } catch (NumberFormatException e) {
                            System.out.println("Error: id must be a valid number");
                        }
                    }
                    break;

                case "--description":
                    if(i + 1 < args.length) {
                        newDescription = args[++i];
                    }
                    break;

                case "--amount":
                    if(i + 1 < args.length) {
                        try {
                            newAmount = Double.parseDouble(args[++i]);
                        } catch (NumberFormatException e) {
                            System.out.println("Error: amount must be a valid number");
                            return;
                        }
                    }
                    break;
            }
        }
        if (id == null) {
            System.out.println("Error: Missing --id argument. Use: update --id 1");
            return;
        }

        boolean updated = manager.updateExpense(id, newDescription, newAmount);
        if(updated) {
            System.out.println("Expense updated");
        } else {
            System.out.println("Error: Expense with ID " + id + " not found");
        }
    }
}