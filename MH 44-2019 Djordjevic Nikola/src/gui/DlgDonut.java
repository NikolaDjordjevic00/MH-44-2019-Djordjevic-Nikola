package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DlgDonut extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private int radius,inRadius;
	private JTextField textField2;
	private Color clr;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgDonut dialog = new DlgDonut();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgDonut() {
		setModal(true);
		
		setTitle("Donut");
		setBounds(100, 100, 313, 175);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{33, 31, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			{
				JLabel lblNewLabel = new JLabel("Unesite poluprecnik");
				GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
				gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel.gridx = 0;
				gbc_lblNewLabel.gridy = 0;
				contentPanel.add(lblNewLabel, gbc_lblNewLabel);
			}
		}
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				if(c<'0' || c>'9' || c==KeyEvent.VK_SPACE)
				{
					e.consume();
				}
			}
		});
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		contentPanel.add(textField, gbc_textField);
		textField.setColumns(10);
		{
			JLabel lblUnesiteUnutrasnjiPoluprecnik = new JLabel("Unesite unutrasnji poluprecnik");
			GridBagConstraints gbc_lblUnesiteUnutrasnjiPoluprecnik = new GridBagConstraints();
			gbc_lblUnesiteUnutrasnjiPoluprecnik.anchor = GridBagConstraints.EAST;
			gbc_lblUnesiteUnutrasnjiPoluprecnik.insets = new Insets(0, 0, 5, 5);
			gbc_lblUnesiteUnutrasnjiPoluprecnik.gridx = 0;
			gbc_lblUnesiteUnutrasnjiPoluprecnik.gridy = 1;
			contentPanel.add(lblUnesiteUnutrasnjiPoluprecnik, gbc_lblUnesiteUnutrasnjiPoluprecnik);
		}
		{
			textField2 = new JTextField();
			textField2.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char c=e.getKeyChar();
					if(c<'0' || c>'9' || c==KeyEvent.VK_SPACE)
					{
						e.consume();
					}
				}
			});
			GridBagConstraints gbc_textField2 = new GridBagConstraints();
			gbc_textField2.insets = new Insets(0, 0, 5, 0);
			gbc_textField2.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField2.gridx = 1;
			gbc_textField2.gridy = 1;
			contentPanel.add(textField2, gbc_textField2);
			textField2.setColumns(10);
		}
		{
			JButton btnColor = new JButton("Izaberi boju");
			btnColor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					clr=JColorChooser.showDialog(btnColor, "Izaberi boju", clr);
				}
			});
			GridBagConstraints gbc_btnColor = new GridBagConstraints();
			gbc_btnColor.gridx = 1;
			gbc_btnColor.gridy = 2;
			contentPanel.add(btnColor, gbc_btnColor);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							radius=Integer.parseInt(textField.getText());
							inRadius=Integer.parseInt(textField2.getText());
						}
						catch(Exception e2)
						{
							JOptionPane.showMessageDialog(null, "Input must not be empty", "Incorrect input", JOptionPane.ERROR_MESSAGE);
						}
						dispose();
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}

	}
	public void setTextRadius(String X) {
		textField.setText(X);
	}
	public int getRadius() {
		return radius;
	}
	public int getInRadius() {
		return inRadius;
	}
	public Color getClr() {
		return clr;
	}

}
