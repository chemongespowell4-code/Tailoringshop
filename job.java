package tailoringshop;

public abstract class Job implements Chargeable {
    private String id;
    private String customerName;
    private boolean isLoyal;

    public Job(String id, String customerName, boolean isLoyal) throws InvalidJobException {
        if (id == null || id.trim().isEmpty()) {
            throw new InvalidJobException("Job ID cannot be blank.");
        }
        if (customerName == null || customerName.trim().isEmpty()) {
            throw new InvalidJobException("Customer name cannot be blank.");
        }
        this.id = id.trim();
        this.customerName = customerName.trim();
        this.isLoyal = isLoyal;
    }

    public String getId() { return id; }
    public String getCustomerName() { return customerName; }
    public boolean isLoyal() { return isLoyal; }

    public void setId(String id) throws InvalidJobException {
        if (id == null || id.trim().isEmpty()) {
            throw new InvalidJobException("Job ID cannot be blank.");
        }
        this.id = id.trim();
    }

    public void setCustomerName(String name) throws InvalidJobException {
        if (name == null || name.trim().isEmpty()) {
            throw new InvalidJobException("Customer name cannot be blank.");
        }
        this.customerName = name.trim();
    }

    public void setIsLoyal(boolean loyal) {
        this.isLoyal = loyal;
    }

    @Override
    public abstract double calculateCharge();

    @Override
    public String toString() {
        return String.format("Job[ID=%s, Customer=%s, Loyal=%s, Charge=%.2f]",
                id, customerName, isLoyal, calculateCharge());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Job)) return false;
        Job other = (Job) obj;
        return id.equals(other.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
