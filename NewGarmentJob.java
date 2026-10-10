package tailoringshop;

public class NewGarmentJob extends Job {
    private double fabricCost;

    public NewGarmentJob(String id, String customerName, boolean isLoyal, double fabricCost) throws InvalidJobException {
        super(id, customerName, isLoyal);
        if (fabricCost <= 0) throw new InvalidJobException("Fabric cost must be positive.");
        this.fabricCost = fabricCost;
    }

    @Override
    public double calculateCharge() {
        double baseCharge = fabricCost + 20.0; // tailoring fee
        return isLoyal() ? baseCharge * 0.95 : baseCharge; // 5% discount
    }

    @Override
    public String toString() {
        return super.toString() + " [Fabric cost=" + fabricCost + "]";
    }
}
