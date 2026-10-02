class OnlineFoodDelivery {
    static class DeliveryTask extends Thread {
        private final String activity;

        DeliveryTask(String name, int priority, String activity) {
            super(name);
            this.activity = activity;
            setPriority(priority);
        }

        @Override
        public void run() {
            for (int i = 1; i <= 3; i++) {
                System.out.println("Thread: " + getName()
                        + " | Priority: " + getPriority()
                        + " | Activity: " + activity + " (" + i + ")");
                try {
                    Thread.sleep(250);
                } catch (InterruptedException exception) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread orderProcessing = new DeliveryTask(
                "OrderProcessing", Thread.MAX_PRIORITY, "Processing customer order");
        Thread deliveryTracking = new DeliveryTask(
                "DeliveryTracking", Thread.NORM_PRIORITY, "Tracking delivery location");
        Thread notification = new DeliveryTask(
                "Notification", Thread.MIN_PRIORITY, "Sending order-status notification");

        orderProcessing.start();
        deliveryTracking.start();
        notification.start();

        orderProcessing.join();
        deliveryTracking.join();
        notification.join();
    }
}
