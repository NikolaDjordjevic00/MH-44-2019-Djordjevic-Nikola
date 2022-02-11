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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgRectMod extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textX;
	private JTextField textY;
	private JTextField textWidth;
	private JTextField textHeight;
	private Color clr;
	private int x,y,w,h;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgRectMod dialog = new DlgRectMod();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgRectMod() {
		setModal(true);
		setBounds(100, 100, 482, 391);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			{
				JLabel lblNewLabel = new JLabel("Koordinata X");
				GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
				gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel.gridx = 0;
				gbc_lblNewLabel.gridy = 0;
				contentPanel.add(lblNewLabel, gbc_lblNewLabel);
			}
		}
		textX = new JTextField();
		textX.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				if(c<'0' || c>'9' || c==KeyEvent.VK_SPACE)
				{
					e.consume();
				}
			}
		});
		GridBagConstraints gbc_textX = new GridBagConstraints();
		gbc_textX.insets = new Insets(0, 0, 5, 0);
		gbc_textX.fill = GridBagConstraints.HORIZONTAL;
		gbc_textX.gridx = 2;
		gbc_textX.gridy = 0;
		contentPanel.add(textX, gbc_textX);
		textX.setColumns(10);
		{
			{
				JLabel lblNewLabel_1 = new JLabel("Koordinata Y");
				GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
				gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel_1.gridx = 0;
				gbc_lblNewLabel_1.gridy = 2;
				contentPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
			}
		}
		textY = new JTextField();
		textY.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				if(c<'0' || c>'9' || c==KeyEvent.VK_SPACE)
				{
					e.consume();
				}
			}
		});
		textY.setText("");
		GridBagConstraints gbc_textY = new GridBagConstraints();
		gbc_textY.insets = new Insets(0, 0, 5, 0);
		gbc_textY.fill = GridBagConstraints.HORIZONTAL;
		gbc_textY.gridx = 2;
		gbc_textY.gridy = 2;
		contentPanel.add(textY, gbc_textY);
		textY.setColumns(10);
		{
			{
				JLabel lblNewLabel_2 = new JLabel("Sirina");
				GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
				gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel_2.gridx = 0;
				gbc_lblNewLabel_2.gridy = 4;
				contentPanel.add(lblNewLabel_2, gbc_lblNewLabel_2);
			}
		}
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
		gbc_textWidth.gridx = 2;
		gbc_textWidth.gridy = 4;
		contentPanel.add(textWidth, gbc_textWidth);
		textWidth.setColumns(10);
		{
			{
				JLabel lblNewLabel_3 = new JLabel("Visina");
				GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
				gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel_3.gridx = 0;
				gbc_lblNewLabel_3.gridy = 6;
				contentPanel.add(lblNewLabel_3, gbc_lblNewLabel_3);
			}
		}
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
		textHeight.setText("");
		GridBagConstraints gbc_textHeight = new GridBagConstraints();
		gbc_textHeight.insets = new Insets(0, 0, 5, 0);
		gbc_textHeight.fill = GridBagConstraints.HORIZONTAL;
		gbc_textHeight.gridx = 2;
		gbc_textHeight.gridy = 6;
		contentPanel.add(textHeight, gbc_textHeight);
		textHeight.setColumns(10);
		{
			JButton btnColor = new JButton("Izaberi boju");
			btnColor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					clr=JColorChooser.showDialog(btnColor, "Izaberi boju", clr);
				}
			});
			GridBagConstraints gbc_btnColor = new GridBagConstraints();
			gbc_btnColor.anchor = GridBagConstraints.SOUTH;
			gbc_btnColor.gridx = 2;
			gbc_btnColor.gridy = 7;
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
							x=Integer.parseInt(textX.getText());
							y=Integer.parseInt(textY.getText());
							w=Integer.parseInt(textWidth.getText());
							h=Integer.parseInt(textHeight.getText());
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
	public void setTextX(String X) {
		textX.setText(X);
	}

	public void setTextY(String Y) {
		textY.setText(Y);
	}

	public void setTextWidth(String W) {
		textWidth.setText(W);
	}

	public void setTextHeight(String H) {
		textHeight.setText(H);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getW() {
		return w;
	}

	public int getH() {
		return h;
	}

	public Color getClr() {
		return clr;
	}
	
	
	

}
