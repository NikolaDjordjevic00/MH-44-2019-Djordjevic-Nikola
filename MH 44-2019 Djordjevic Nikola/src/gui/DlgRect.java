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
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DlgRect extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textWidth;
	private JTextField textHeight;
	private int three,four;
	private Color clr;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgRect dialog = new DlgRect();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgRect() {
		setTitle("Add rectangle");
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblNewLabel_2 = new JLabel("Unesi sirinu");
			GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
			gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_2.gridx = 0;
			gbc_lblNewLabel_2.gridy = 3;
			contentPanel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		}
		{
			textWidth = new JTextField();
			textWidth.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char c=e.getKeyChar();
					if(c<'0' || c>'9' || c==KeyEvent.VK_SPACE)
					{
						e.consume();
					}
				}
			});
			GridBagConstraints gbc_textWidth = new GridBagConstraints();
			gbc_textWidth.insets = new Insets(0, 0, 5, 0);
			gbc_textWidth.fill = GridBagConstraints.HORIZONTAL;
			gbc_textWidth.gridx = 1;
			gbc_textWidth.gridy = 3;
			contentPanel.add(textWidth, gbc_textWidth);
			textWidth.setColumns(10);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Unesi visinu");
			GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
			gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_3.gridx = 0;
			gbc_lblNewLabel_3.gridy = 4;
			contentPanel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		}
		{
			textHeight = new JTextField();
			textHeight.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char c=e.getKeyChar();
					if(c<'0' || c>'9' || c==KeyEvent.VK_SPACE)
					{
						e.consume();
					}
				}
			});
			GridBagConstraints gbc_textHeight = new GridBagConstraints();
			gbc_textHeight.insets = new Insets(0, 0, 5, 0);
			gbc_textHeight.fill = GridBagConstraints.HORIZONTAL;
			gbc_textHeight.gridx = 1;
			gbc_textHeight.gridy = 4;
			contentPanel.add(textHeight, gbc_textHeight);
			textHeight.setColumns(10);
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
			gbc_btnColor.gridy = 6;
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
						try{
							three=Integer.parseInt(textWidth.getText());
							four=Integer.parseInt(textHeight.getText());
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

	public void setTextWidth(String Width) {
		textWidth.setText(Width);
	}

	public void setTextHeight(String Height) {
		textHeight.setText(Height);
	}

	public int getThree() {
		return three;
	}

	public int getFour() {
		return four;
	}
	public Color getClr() {
		return clr;
	}
	

}
