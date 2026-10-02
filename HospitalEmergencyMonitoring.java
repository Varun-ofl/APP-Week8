class HospitalEmergencyMonitoring {
    static class HospitalTask extends Thread {
        private final String activity;

        HospitalTask(String name, int priority, String activity) {
            super(name);
            this.activity = activity;
            setPriority(priority);
        }

        @Override
        public void run() {
            for (int i = 1; i <= 3; i++) {
                System.out.println(getName() + " | Priority: " + getPriority()
                        + " | " + activity + " (" + i + ")");
                try {
                    Thread.sleep(300);
                } catch (InterruptedException exception) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread emergencyAlert = new HospitalTask(
                "EmergencyAlert", Thread.MAX_PRIORITY, "Handling critical patient alert");
        Thread vitalMonitor = new HospitalTask(
                "VitalMonitor", Thread.NORM_PRIORITY, "Checking patient vital signs");
        Thread reportGenerator = new HospitalTask(
                "ReportGenerator", Thread.MIN_PRIORITY, "Preparing routine report");

        emergencyAlert.start();
        vitalMonitor.start();
        reportGenerator.start();

        emergencyAlert.join();
        vitalMonitor.join();
        reportGenerator.join();
    }
}
