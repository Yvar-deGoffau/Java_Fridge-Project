package projet.frigo.A3;

import java.awt.EventQueue;

public class Main {
    public static void main(String[] args) throws Exception {
        
        Thread t = new Thread() {
            public void run() {
                //the following line will keep this app alive for 1000 seconds,
                //waiting for events to occur and responding to them (printing incoming messages to console).
                try {
                    Thread.sleep(1000000);
                } catch (InterruptedException ie) {
                }
            }
        };
        t.start();
        System.out.println("Started");
        
        EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Calling View
					View frame = new View();
					frame.setVisible(true);
					Arduino main = new Arduino(frame);
				    main.initialize();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
    }
}
