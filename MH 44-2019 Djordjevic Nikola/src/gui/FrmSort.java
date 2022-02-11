package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Point;
import geometry.Rectangle;

import javax.swing.JScrollPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmSort extends JFrame {

	private JPanel contentPane;
	private DefaultListModel<Rectangle> dlm=new DefaultListModel<Rectangle>();
	private ArrayList<Rectangle> arl=new ArrayList<Rectangle>();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmSort frame = new FrmSort();
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
	public FrmSort() {
		setTitle("Djordjevic Nikola MH44/2019");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelWest = new JPanel();
		contentPane.add(panelWest, BorderLayout.WEST);
		GridBagLayout gbl_panelWest = new GridBagLayout();
		gbl_panelWest.columnWidths = new int[]{0, 0};
		gbl_panelWest.rowHeights = new int[]{0, 0, 0};
		gbl_panelWest.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panelWest.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panelWest.setLayout(gbl_panelWest);
		
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
					arl.add(r);
				}
				Collections.sort(arl);
				dlm.clear();
				dlm.addAll(0, arl);
			}
		});
		GridBagConstraints gbc_btnDodaj = new GridBagConstraints();
		gbc_btnDodaj.fill = GridBagConstraints.BOTH;
		gbc_btnDodaj.insets = new Insets(0, 0, 5, 0);
		gbc_btnDodaj.gridx = 0;
		gbc_btnDodaj.gridy = 0;
		panelWest.add(btnDodaj, gbc_btnDodaj);
		
		JButton btnIzuzmi = new JButton("Izuzmi");
		btnIzuzmi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				arl.remove(0);

				Collections.sort(arl);
				dlm.clear();
				dlm.addAll(0, arl);
				
			}
		});
		GridBagConstraints gbc_btnIzuzmi = new GridBagConstraints();
		gbc_btnIzuzmi.fill = GridBagConstraints.BOTH;
		gbc_btnIzuzmi.gridx = 0;
		gbc_btnIzuzmi.gridy = 1;
		panelWest.add(btnIzuzmi, gbc_btnIzuzmi);
		
		JPanel panelCenter = new JPanel();
		contentPane.add(panelCenter, BorderLayout.CENTER);
		GridBagLayout gbl_panelCenter = new GridBagLayout();
		gbl_panelCenter.columnWidths = new int[]{0, 0};
		gbl_panelCenter.rowHeights = new int[]{0, 0};
		gbl_panelCenter.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelCenter.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panelCenter.setLayout(gbl_panelCenter);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		panelCenter.add(scrollPane, gbc_scrollPane);
		
		JList list = new JList();
		list.setModel(dlm);
		scrollPane.setViewportView(list);
	}

}
