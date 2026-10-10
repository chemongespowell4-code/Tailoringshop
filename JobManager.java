package tailoringshop;

import java.util.*;

public class JobManager {
    private final List<Job> jobs = new ArrayList<>();

    public void addJob(Job job) {
        if (job != null && !jobs.contains(job)) {
            jobs.add(job);
        }
    }

    public Job findJobById(String id) {
        if (id == null || id.trim().isEmpty()) return null;
        for (Job job : jobs) {
            if (job.getId().equalsIgnoreCase(id.trim())) {
                return job;
            }
        }
        return null;
    }

    public boolean removeJob(String id) {
        Job job = findJobById(id);
        if (job != null) {
            jobs.remove(job);
            return true;
        }
        return false;
    }

    public double getTotalCharges() {
        double total = 0;
        for (Job job : jobs) {
            total += job.calculateCharge();
        }
        return total;
    }

    public List<Job> getReport() {
        jobs.sort(Comparator.comparing(Job::getCustomerName, String.CASE_INSENSITIVE_ORDER));
        return new ArrayList<>(jobs);
    }

    public void printReport() {
        System.out.println("Job Report (sorted by customer name):");
        for (Job job : getReport()) {
            System.out.println(job);
        }
    }
}
