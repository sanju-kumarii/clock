import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DigitalClock extends JFrame {

    private JLabel timeLabel;  // Label to display the time

    // Constructor to set up the clock
    public DigitalClock() {
        // Set the title of the window
        setTitle("Digital Clock");
        
        // Set the size of the window
        setSize(300, 100);
        
        // Set the layout manager to FlowLayout
        setLayout(new FlowLayout());
        
        // Set the default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a label to show the time
        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Verdana", Font.PLAIN, 30));  // Set font for the label
        timeLabel.setForeground(Color.BLACK);  // Set text color

        // Add the time label to the frame
        add(timeLabel);

        // Make the window visible
        setVisible(true);
        
        // Call the method to update the time
        updateTime();
    }

    // Method to update the time every second
    private void updateTime() {
        // Create a new thread to keep updating the time
        Thread clockThread = new Thread(() -> {
            while (true) {
                // Get the current time
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                String timeString = sdf.format(new Date());
                
                // Update the label text with the current time
                timeLabel.setText(timeString);
                
                // Sleep for 1 second (1000 milliseconds) before updating the time again
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        
        // Start the clock thread
        clockThread.start();
    }

    // Main method to run the clock
    public static void main(String[] args) {
        // Create and display the digital clock
        new DigitalClock();
    }
}

