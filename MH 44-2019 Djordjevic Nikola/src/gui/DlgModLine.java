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

public class DlgModLine extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textX1;
	private JTextField textY1;
	private JTextField textX2;
	private JTextField textY2;
	private int x1,y1,x2,y2;
	private Color clr;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgModLine dialog = new DlgModLine();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgModLine() {
		setModal(true);
		setBounds(100, 100, 446, 240);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblNewLabel = new JLabel("Koordinata X pocetne tacke");
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 0;
			gbc_lblNewLabel.gridy = 0;
			contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			textX1 = new JTextField();
			textX1.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char c=e.getKeyChar();
					if(c<'0' || c>'9' || c==KeyEvent.VK_SPACE)
					{
						e.consume();
					}
				}
			});
			GridBagConstraints gbc_textX1 = new GridBagConstraints();
			gbc_textX1.insets = new Insets(0, 0, 5, 0);
			gbc_textX1.fill = GridBagConstraints.HORIZONTAL;
			gbc_textX1.gridx = 1;
			gbc_textX1.gridy = 0;
			contentPanel.add(textX1, gbc_textX1);
			textX1.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Koordinata Y pocetne tacke");
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_1.gridx = 0;
			gbc_lblNewLabel_1.gridy = 1;
			contentPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		}
		{
			textY1 = new JTextField();
			textY1.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char c=e.getKeyChar();
					if(c<'0' || c>'9' || c==KeyEvent.VK_SPACE)
					{
						e.consume();
					}
				}
			});
			GridBagConstraints gbc_textY1 = new GridBagConstraints();
			gbc_textY1.insets = new Insets(0, 0, 5, 0);
			gbc_textY1.fill = GridBagConstraints.HORIZONTAL;
			gbc_textY1.gridx = 1;
			gbc_textY1.gridy = 1;
			contentPanel.add(textY1, gbc_textY1);
			textY1.setColumns(10);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Koordinata X krajnje tacke");
			GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
			gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_2.gridx = 0;
			gbc_lblNewLabel_2.gridy = 2;
			contentPanel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		}
		{
			textX2 = new JTextField();
			textX2.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char c=e.getKeyChar();
					if(c<'0' || c>'9' || c==KeyEvent.VK_SPACE)
					{
						e.consume();
					}
				}
			});
			GridBagConstraints gbc_textX2 = new GridBagConstraints();
			gbc_textX2.insets = new Insets(0, 0, 5, 0);
			gbc_textX2.fill = GridBagConstraints.HORIZONTAL;
			gbc_textX2.gridx = 1;
			gbc_textX2.gridy = 2;
			contentPanel.add(textX2, gbc_textX2);
			textX2.setColumns(10);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Koordinata Y krajnje tacke");
			GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
			gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_3.gridx = 0;
			gbc_lblNewLabel_3.gridy = 3;
			contentPanel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		}
		{
			textY2 = new JTextField();
			textY2.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char c=e.getKeyChar();
					if(c<'0' || c>'9' || c==KeyEvent.VK_SPACE)
					{
						e.consume();
					}
				}
			});
			GridBagConstraints gbc_textY2 = new GridBagConstraints();
			gbc_textY2.insets = new Insets(0, 0, 5, 0);
			gbc_textY2.fill = GridBagConstraints.HORIZONTAL;
			gbc_textY2.gridx = 1;
			gbc_textY2.gridy = 3;
			contentPanel.add(textY2, gbc_textY2);
			textY2.setColumns(10);
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
			gbc_btnColor.gridy = 4;
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
							x1=Integer.parseInt(textX1.getText());
							y1=Integer.parseInt(textY1.getText());
							x2=Integer.parseInt(textX2.getText());
							x2=Integer.parseInt(textY2.getText());
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
	public void setTextX1(String X1) {
		textX1.setText(X1);
	}

	public void setTextY1(String Y1) {
		textY1.setText(Y1);
	}

	public void setTextX2(String X2) {
		textX2.setText(X2);
	}

	public void setTextY2(String Y2) {
		textY2.setText(Y2);
	}

	public int getX1() {
		return x1;
	}

	public int getY1() {
		return y1;
	}

	public int getX2() {
		return x2;
	}

	public int getY2() {
		return y2;
	}

	public Color getClr() {
		return clr;
	}

}
