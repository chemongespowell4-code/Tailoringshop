package tailoringshop;

import javax.swing.*;
import java.awt.*;

public class TailoringGUI extends JFrame {
    private JobManager manager = new JobManager();

    public TailoringGUI() {
        setTitle("Tailoring Shop System");
        setSize(450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JButton addRepairBtn = new JButton("Add RepairJob");
        JButton addGarmentBtn = new JButton("Add NewGarmentJob");
        JButton reportBtn = new JButton("Show Report");
        JButton findBtn = new JButton("Find Job by ID");
        JButton removeBtn = new JButton("Remove Job");
        JButton summaryBtn = new JButton("Show Summary");

        add(addRepairBtn);
        add(addGarmentBtn);
        add(reportBtn);
        add(findBtn);
        add(removeBtn);
        add(summaryBtn);

        addRepairBtn.addActionListener(e -> addRepairJob());
        addGarmentBtn.addActionListener(e -> addNewGarmentJob());
        reportBtn.addActionListener(e -> showReport());
        findBtn.addActionListener(e -> findJob());
        removeBtn.addActionListener(e -> removeJob());
        summaryBtn.addActionListener(e -> showSummary());
    }

    private void addRepairJob() {
        try {
            String id = JOptionPane.showInputDialog("Enter Job ID:");
            String name = JOptionPane.showInputDialog("Enter Customer Name:");
            boolean loyal = JOptionPane.showConfirmDialog(this, "Is Loyal Customer?") == JOptionPane.YES_OPTION;
            int items = Integer.parseInt(JOptionPane.showInputDialog("Enter number of items:"));

            RepairJob rj = new RepairJob(id, name, loyal, items);
            manager.addJob(rj);
            JOptionPane.showMessageDialog(this, "RepairJob added: " + rj);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    private void addNewGarmentJob() {
        try {
            String id = JOptionPane.showInputDialog("Enter Job ID:");
            String name = JOptionPane.showInputDialog("Enter Customer Name:");
            boolean loyal = JOptionPane.showConfirmDialog(this, "Is Loyal Customer?") == JOptionPane.YES_OPTION;
            double fabricCost = Double.parseDouble(JOptionPane.showInputDialog("Enter fabric cost:"));

            NewGarmentJob ngj = new NewGarmentJob(id, name, loyal, fabricCost);
            manager.addJob(ngj);
            JOptionPane.showMessageDialog(this, "NewGarmentJob added: " + ngj);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    private void showReport() {
        StringBuilder sb = new StringBuilder("Job Report:\n");
        for (Job job : manager.getReport()) {
            sb.append(job).append("\n");
        }
        JOptionPane.showMessageDialog(this, sb.toString());
    }

    private void findJob() {
        String id = JOptionPane.showInputDialog("Enter Job ID to find:");
        Job job = manager.findJobById(id);
        if (job != null) {
            JOptionPane.showMessageDialog(this, "Found: " + job);
        } else {
            JOptionPane.showMessageDialog(this, "Job not found.");
        }
    }

    private void removeJob() {
        String id = JOptionPane.showInputDialog("Enter Job ID to remove:");
        boolean removed = manager.removeJob(id);
        if (removed) {
            JOptionPane.showMessageDialog(this, "Job removed successfully.");
        } else {
            JOptionPane.showMessageDialog(this, "Job not found.");
        }
    }

    private void showSummary() {
        JOptionPane.showMessageDialog(this, "Total charges = " + manager.getTotalCharges());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TailoringGUI().setVisible(true));
    }
}
