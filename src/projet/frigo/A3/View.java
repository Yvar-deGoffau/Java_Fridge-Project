package projet.frigo.A3;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class View extends JFrame {
	
	public final JPanel contentPane;
	public final JLabel fieldTemperature;
	public final JLabel fieldHumidity;
	public final JLabel labelConsigne;
	public final JButton buttonConsignePlus;
	public final JLabel fieldPoint_rosee;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
	}

	/**
	 * Create the frame.
	 */
	public View() {
		setTitle("Frigo GUI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 621, 247);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Temp\u00E9rature :");
		lblNewLabel.setFont(new Font("Cambria", Font.PLAIN, 18));
		
		JLabel lblHumidit = new JLabel("Humidit\u00E9 :");
		lblHumidit.setFont(new Font("Cambria", Font.PLAIN, 18));
		
		JLabel lblConsigne = new JLabel("Temp\u00E9rature de consigne :");
		lblConsigne.setFont(new Font("Cambria", Font.PLAIN, 18));
		
		fieldTemperature = new JLabel("0");
		fieldTemperature.setForeground(Color.RED);
		fieldTemperature.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		fieldHumidity = new JLabel("0");
		fieldHumidity.setForeground(Color.CYAN);
		fieldHumidity.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		labelConsigne = new JLabel("0\u00B0C");
		labelConsigne.setForeground(Color.ORANGE);
		labelConsigne.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		buttonConsignePlus = new JButton("+");
		buttonConsignePlus.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton buttonConsigneMinus = new JButton("-");
		buttonConsigneMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonConsigneMinus.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton buttonGraphicTemp = new JButton("Interface Graphique");
		buttonGraphicTemp.setFont(new Font("Cambria", Font.PLAIN, 17));
		
		JButton buttonGraphicHumi = new JButton("Interface Graphique");
		buttonGraphicHumi.setFont(new Font("Cambria", Font.PLAIN, 17));
		buttonGraphicHumi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JLabel lblc = new JLabel("\u00B0C");
		lblc.setForeground(Color.RED);
		lblc.setFont(new Font("Cambria", Font.PLAIN, 18));
		
		JLabel label = new JLabel("%");
		label.setForeground(Color.CYAN);
		label.setFont(new Font("Cambria", Font.PLAIN, 18));
		
		JLabel lblPointDeRose = new JLabel("Point de ros\u00E9e:");
		lblPointDeRose.setFont(new Font("Cambria", Font.PLAIN, 18));
		
		fieldPoint_rosee = new JLabel("0");
		fieldPoint_rosee.setForeground(Color.PINK);
		fieldPoint_rosee.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel label_1 = new JLabel("\u00B0C");
		label_1.setForeground(Color.PINK);
		label_1.setFont(new Font("Cambria", Font.PLAIN, 18));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(fieldTemperature, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblHumidit, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(fieldHumidity, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(label, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblc, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
							.addGap(48)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addComponent(buttonConsignePlus, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
									.addComponent(buttonGraphicHumi, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE))
								.addComponent(buttonGraphicTemp, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE))
							.addContainerGap(58, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblConsigne, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(labelConsigne, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(buttonConsigneMinus, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
							.addGap(830))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblPointDeRose, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(fieldPoint_rosee, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(320, Short.MAX_VALUE))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addComponent(fieldTemperature, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblc, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(buttonGraphicHumi)
								.addComponent(lblHumidit, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addComponent(fieldHumidity, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addComponent(label, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)))
						.addComponent(buttonGraphicTemp))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblConsigne, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(labelConsigne, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(buttonConsigneMinus)
						.addComponent(buttonConsignePlus))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblPointDeRose, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(fieldPoint_rosee, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
