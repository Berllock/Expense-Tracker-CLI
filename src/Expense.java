import java.time.LocalDate;

public class Expense {

    private Long id;
    private String description;
    private Double amount;
    private LocalDate date;

    public Expense(Long id, String description, Double amount) {
        validateId(id);
        validateDescription(description);

        this.id = id;
        this.description = description;
        this.amount = amount;
        this.date = LocalDate.now();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        validateDescription(description);
        this.description = description;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        validateAmount(amount);
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public Long getId() {
        return id;
    }

    private void validateDescription(String description) {
        if (description == null || description.isEmpty()) {
            throw new IllegalArgumentException("Description cannot be empty");
        }
    }

    private void validateAmount(Double amount) {
        if (amount == null || amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative or null");
        }
    }

    private void validateId(Long id) {
        if (id == null || id < 0) {
            throw new IllegalArgumentException("ID cannot be negative or null");
        }
    }
}
