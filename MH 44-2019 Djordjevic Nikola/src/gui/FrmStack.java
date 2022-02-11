package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Point;
import geometry.Rectangle;

import java.awt.GridBagLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.Stack;
import java.awt.event.ActionEvent;

public class FrmStack extends JFrame {

	private JPanel contentPane;
	private DefaultListModel<Rectangle> dlm = new DefaultListModel<Rectangle>();
	Stack <Rectangle> stk=new Stack<Rectangle>();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmStack frame = new FrmStack();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmStack() {
		setTitle("Djordjevic Nikola MH44/2019");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		JList<Rectangle> listRect = new JList<Rectangle>();
		listRect.setModel(dlm);
		
		JPanel pnlWest = new JPanel();
		contentPane.add(pnlWest, BorderLayout.WEST);
		GridBagLayout gbl_pnlWest = new GridBagLayout();
		gbl_pnlWest.columnWidths = new int[]{0, 0};
		gbl_pnlWest.rowHeights = new int[]{0, 0, 0};
		gbl_pnlWest.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_pnlWest.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		pnlWest.setLayout(gbl_pnlWest);
		
		JButton btnDodaj = new JButton("Dodaj");
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgAddRect dlg=new DlgAddRect();
				dlg.setVisible(true);
				dlg.enInput();
				Point p=new Point(dlg.getOne(),dlg.getTwo());
				Rectangle r=new Rectangle(p,dlg.getThree(),dlg.getFour());
				if(r.getHeight()>0&&r.getWidth()>0)
				{

					stk.push(r);
					dlm.add(0, r);	
				}
			}
		});
		GridBagConstraints gbc_btnDodaj = new GridBagConstraints();
		gbc_btnDodaj.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnDodaj.insets = new Insets(0, 0, 5, 0);
		gbc_btnDodaj.gridx = 0;
		gbc_btnDodaj.gridy = 0;
		pnlWest.add(btnDodaj, gbc_btnDodaj);
		
		JButton btnIzuzmi = new JButton("Izuzmi");
		btnIzuzmi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgAddRect dlg=new DlgAddRect();
				dlg.setModal(true);
				dlg.disInput();
				Rectangle re=listRect.getModel().getElementAt(0);
				dlg.setTextX(Integer.toString(re.getUpperLeft().getX()));
				dlg.setTextY(Integer.toString(re.getUpperLeft().getY()));
				dlg.setTextHeight(Integer.toString(re.getHeight()));
				dlg.setTextWidth(Integer.toString(re.getWidth()));
				if(dlm != null && !dlm.isEmpty())
				{
					stk.pop();
					dlm.removeElementAt(0);
				}
				dlg.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnIzuzmi = new GridBagConstraints();
		gbc_btnIzuzmi.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnIzuzmi.gridx = 0;
		gbc_btnIzuzmi.gridy = 1;
		pnlWest.add(btnIzuzmi, gbc_btnIzuzmi);
		
		JPanel pnlCenter = new JPanel();
		contentPane.add(pnlCenter, BorderLayout.CENTER);
		GridBagLayout gbl_pnlCenter = new GridBagLayout();
		gbl_pnlCenter.columnWidths = new int[]{0, 0};
		gbl_pnlCenter.rowHeights = new int[]{0, 0};
		gbl_pnlCenter.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_pnlCenter.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		pnlCenter.setLayout(gbl_pnlCenter);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		pnlCenter.add(scrollPane, gbc_scrollPane);
		
		scrollPane.setViewportView(listRect);
		
		
		
	}

}
