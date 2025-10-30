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
                break;
            case "delete":
                break;
            case "list":
                handleListCommand(manager)ç
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
        
    }
}