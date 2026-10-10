package tailoringshop;

public class RepairJob extends Job {
    private int items;

    public RepairJob(String id, String customerName, boolean isLoyal, int items) throws InvalidJobException {
        super(id, customerName, isLoyal);
        if (items <= 0) throw new InvalidJobException("Items must be positive.");
        this.items = items;
    }

    @Override
    public double calculateCharge() {
        double baseCharge = items * 5.0; // 5 per item
        return isLoyal() ? baseCharge * 0.9 : baseCharge; // 10% discount
    }

    @Override
    public String toString() {
        return super.toString() + " [Repair items=" + items + "]";
    }
}
