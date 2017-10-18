package projet.frigo.A3;

import java.awt.EventQueue;

//help: https://www.youtube.com/watch?v=tdXyggglt_M

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
					//On appelle la vue depuis le controler
					View frame = new View();
					frame.setVisible(true);
					//On lie le Model à la View
					Arduino main = new Arduino(frame);
				    main.initialize();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
        
    }
}
