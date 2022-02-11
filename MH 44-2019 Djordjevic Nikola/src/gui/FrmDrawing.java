package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Circle;
import geometry.Donut;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import geometry.Shape;

import java.awt.GridBagLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JColorChooser;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JToggleButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmDrawing extends JFrame {

	private JPanel contentPane;
	private ButtonGroup group=new ButtonGroup();
	private ArrayList<Shape> shapes=new ArrayList<>();
	private ArrayList<Shape> selektovani=new ArrayList<>();
	private int brklk;
	private Point pl1,pl2;
	private Color colr;
	
	
	
	public Point getPl1() {
		return pl1;
	}

	public void setPl1(Point pl1) {
		this.pl1 = pl1;
	}

	public Point getPl2() {
		return pl2;
	}

	public void setPl2(Point pl2) {
		this.pl2 = pl2;
	}

	public int getBrklk() {
		return brklk;
	}

	public void setBrklk(int brklk) {
		this.brklk = brklk;
	}

	private Color boja;
	
	

	public Color getBoja() {
		return boja;
	}

	public void setBoja(Color boja) {
		this.boja = boja;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmDrawing frame = new FrmDrawing();
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
	public FrmDrawing() {
		setTitle("Djordjevic Nikola MH44/2019");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 321);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pnlWest = new JPanel();
		contentPane.add(pnlWest, BorderLayout.WEST);
		GridBagLayout gbl_pnlWest = new GridBagLayout();
		gbl_pnlWest.columnWidths = new int[]{0, 0};
		gbl_pnlWest.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_pnlWest.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_pnlWest.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlWest.setLayout(gbl_pnlWest);
		
		JToggleButton tglbtnPoint = new JToggleButton("Point");
		GridBagConstraints gbc_tglbtnPoint = new GridBagConstraints();
		gbc_tglbtnPoint.fill = GridBagConstraints.BOTH;
		gbc_tglbtnPoint.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtnPoint.gridx = 0;
		gbc_tglbtnPoint.gridy = 0;
		pnlWest.add(tglbtnPoint, gbc_tglbtnPoint);
		group.add(tglbtnPoint);
		
		JToggleButton tglbtnLine = new JToggleButton("Line");
		GridBagConstraints gbc_tglbtnLine = new GridBagConstraints();
		gbc_tglbtnLine.fill = GridBagConstraints.BOTH;
		gbc_tglbtnLine.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtnLine.gridx = 0;
		gbc_tglbtnLine.gridy = 1;
		pnlWest.add(tglbtnLine, gbc_tglbtnLine);
		group.add(tglbtnLine);
		
		JToggleButton tglbtnRect = new JToggleButton("Rectangle");
		GridBagConstraints gbc_tglbtnRect = new GridBagConstraints();
		gbc_tglbtnRect.fill = GridBagConstraints.BOTH;
		gbc_tglbtnRect.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtnRect.gridx = 0;
		gbc_tglbtnRect.gridy = 2;
		pnlWest.add(tglbtnRect, gbc_tglbtnRect);
		group.add(tglbtnRect);
		
		JToggleButton tglbtnCircle = new JToggleButton("Circle");
		GridBagConstraints gbc_tglbtnCircle = new GridBagConstraints();
		gbc_tglbtnCircle.fill = GridBagConstraints.BOTH;
		gbc_tglbtnCircle.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtnCircle.gridx = 0;
		gbc_tglbtnCircle.gridy = 3;
		pnlWest.add(tglbtnCircle, gbc_tglbtnCircle);
		group.add(tglbtnCircle);
		
		JToggleButton tglbtnDonut = new JToggleButton("Donut");
		GridBagConstraints gbc_tglbtnDonut = new GridBagConstraints();
		gbc_tglbtnDonut.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtnDonut.fill = GridBagConstraints.BOTH;
		gbc_tglbtnDonut.gridx = 0;
		gbc_tglbtnDonut.gridy = 4;
		pnlWest.add(tglbtnDonut, gbc_tglbtnDonut);
		group.add(tglbtnDonut);
		
		JToggleButton tglbtnIzmeni = new JToggleButton("Izmeni");
		tglbtnIzmeni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i=0;
				int j=shapes.size()-1;
				while(j>=0&&i==0)
				{
					if(shapes.get(j).isSelected())
					{
						if(shapes.get(j) instanceof Point)
						{
							Point p=(Point) shapes.get(j);
							DlgModPoint dlg=new DlgModPoint();
							dlg.setTextX(Integer.toString(p.getX()));
							dlg.setTextY(Integer.toString(p.getY()));
							dlg.setVisible(true);
							int xm=dlg.getX();
							int ym=dlg.getY();
							setBoja(dlg.getClr());
							shapes.get(j).moveTo(xm, ym);
							shapes.get(j).setSelected(false);
							i=1;
							repaint();
						}
						else if(shapes.get(j) instanceof Line)
						{
							Line l=(Line) shapes.get(j);
							DlgModLine dlg=new DlgModLine();
							
							Point spo=l.getStartPoint();
							Point epo=l.getEndPoint();
							dlg.setTextX1(Integer.toString(spo.getX()));
							dlg.setTextY1(Integer.toString(spo.getY()));
							dlg.setTextX2(Integer.toString(epo.getX()));
							dlg.setTextY2(Integer.toString(epo.getY()));
							dlg.setVisible(true);
							Point sp=new Point(dlg.getX1(),dlg.getY1());
							Point ep=new Point(dlg.getX2(),dlg.getY2());
							setBoja(dlg.getClr());
							Line a=new Line();
							a.setStartPoint(sp);
							a.setEndPoint(ep);
							shapes.remove(j);
							shapes.add(j,a);
							repaint();
							i=1;
						}
						else if(shapes.get(j) instanceof Rectangle)
						{
							Rectangle r=(Rectangle) shapes.get(j);
							DlgRectMod dlg=new DlgRectMod();
							dlg.setTextX(Integer.toString(r.getUpperLeft().getX()));
							dlg.setTextY(Integer.toString(r.getUpperLeft().getY()));
							dlg.setTextHeight(Integer.toString(r.getHeight()));
							dlg.setTextWidth(Integer.toString(r.getWidth()));
							dlg.setVisible(true);
							Point p=new Point(dlg.getX(),dlg.getY());
							r.moveTo(dlg.getX(), dlg.getY());
							r.setHeight(dlg.getH());
							r.setWidth(dlg.getW());
							setBoja(dlg.getClr());
							shapes.remove(j);
							shapes.add(j, r);
							shapes.get(j).setSelected(false);
							repaint();
							i=1;
						}
						else if(shapes.get(j) instanceof Circle)
						{
							Donut b=(Donut)shapes.get(j);
							int a=b.getInnerRadius();
							if(a!=0)
							{
								Donut d=(Donut) shapes.get(j);
								DlgModDonunt dlg=new DlgModDonunt();
								dlg.setTextX(Integer.toString(d.getCenter().getX()));
								dlg.setTextY(Integer.toString(d.getCenter().getY()));
								dlg.setTextR(Integer.toString(d.getRadius()));
								dlg.setTextI(Integer.toString(d.getInnerRadius()));
								dlg.setVisible(true);
								d.moveTo(dlg.getX(), dlg.getY());
								d.setRadius(dlg.getR());
								d.setInnerRadius(dlg.getI());
								setBoja(dlg.getClr());
								shapes.remove(j);
								shapes.add(j,d);
								shapes.get(j).setSelected(false);
								repaint();
								i=1;
							}
							else
							{
								Circle c=(Circle) shapes.get(j);
								DlgModCircle dlg=new DlgModCircle();
								dlg.setTextX(Integer.toString(c.getCenter().getX()));
								dlg.setTextY(Integer.toString(c.getCenter().getY()));
								dlg.setTextRadius(Integer.toString(c.getRadius()));
								dlg.setVisible(true);
								c.moveTo(dlg.getX(), dlg.getY());
								c.setRadius(dlg.getR());
								setBoja(dlg.getClr());
								shapes.remove(j);
								shapes.add(j, c);
								shapes.get(j).setSelected(false);
								repaint();
								i=1;
							}
						}					
					}
					j--;
				}
				repaint();
			}
		});
		GridBagConstraints gbc_tglbtnIzmeni = new GridBagConstraints();
		gbc_tglbtnIzmeni.fill = GridBagConstraints.BOTH;
		gbc_tglbtnIzmeni.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtnIzmeni.gridx = 0;
		gbc_tglbtnIzmeni.gridy = 5;
		pnlWest.add(tglbtnIzmeni, gbc_tglbtnIzmeni);
		group.add(tglbtnIzmeni);
		
		JToggleButton tglbtnObrisi = new JToggleButton("Obrisi");
		tglbtnObrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i=0;
				int j=shapes.size()-1;
				//Iterator<Shape> it=shapes.iterator();
				while(j>=0&&i==0)
				{
					if(shapes.get(j).isSelected())
					{
						int input = JOptionPane.showConfirmDialog(null, "Pritisnite OK da potvrdite brisanje", "Brisanje", JOptionPane.DEFAULT_OPTION);
						if(input==0)
						{
							shapes.remove(j);
							i=1;
						}
					}
					j--;
				}
				repaint();
			}
		});
		GridBagConstraints gbc_tglbtnObrisi = new GridBagConstraints();
		gbc_tglbtnObrisi.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtnObrisi.fill = GridBagConstraints.BOTH;
		gbc_tglbtnObrisi.gridx = 0;
		gbc_tglbtnObrisi.gridy = 6;
		pnlWest.add(tglbtnObrisi, gbc_tglbtnObrisi);
		group.add(tglbtnObrisi);
		
		JToggleButton tglbtnSelect = new JToggleButton("Selektuj");
		GridBagConstraints gbc_tglbtnSelect = new GridBagConstraints();
		gbc_tglbtnSelect.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtnSelect.fill = GridBagConstraints.BOTH;
		gbc_tglbtnSelect.gridx = 0;
		gbc_tglbtnSelect.gridy = 7;
		pnlWest.add(tglbtnSelect, gbc_tglbtnSelect);
		group.add(tglbtnSelect);
		
		JButton btnBoja = new JButton("Izaberi boju");
		btnBoja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				colr=JColorChooser.showDialog(null, "Izaberi boju", colr);
				setBoja(colr);
				repaint();
			}
		});
		GridBagConstraints gbc_btnBoja = new GridBagConstraints();
		gbc_btnBoja.gridx = 0;
		gbc_btnBoja.gridy = 8;
		pnlWest.add(btnBoja, gbc_btnBoja);
		
		PnlDrawing pnlCenter = new PnlDrawing();
		pnlCenter.setShapes(shapes);
		pnlCenter.setClr(getBoja());
		pnlCenter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(tglbtnPoint.isSelected())
				{
					Point p=new Point(e.getX(),e.getY());
					shapes.add(p);
				}
				else if(tglbtnLine.isSelected())
				{
					int i=getBrklk();
					Point p1=new Point();
					Point p2=new Point();
					if(i!=1)
					{
						p1.setX(e.getX());
						p1.setY(e.getY());
						setPl1(p1);
						setBrklk(1);
					}
					else if(i==1)
					{
						p2.setX(e.getX());
						p2.setY(e.getY());
						setPl2(p2);
						setBrklk(0);
						if(getPl1().getX()>0 && getPl1().getY()>0 && getPl2().getX()>0 && getPl2().getY()>0)
						{
							Line l=new Line();
							l.setStartPoint(getPl1());
							l.setEndPoint(getPl2());
							shapes.add(l);
						}

					}
				}
				else if(tglbtnRect.isSelected())
				{
					Point p=new Point(e.getX(),e.getY());
					DlgRect dlg=new DlgRect();
					dlg.setVisible(true);
					setBoja(dlg.getClr());
					Rectangle r=new Rectangle(p,dlg.getThree(),dlg.getFour());
					if(r.getHeight()>0&&r.getWidth()>0)
					{
						shapes.add(r);
					}
					
				}
				else if(tglbtnCircle.isSelected())
				{
					DlgCircle dlgc=new DlgCircle();
					Point p=new Point(e.getX(),e.getY());
					dlgc.setVisible(true);
					setBoja(dlgc.getClr());
					int rad=dlgc.getRadius();
					
					Circle c=new Circle(p,rad);
					if(c.getRadius()>0)
					{
						shapes.add(c);
					}
				}
				else if(tglbtnDonut.isSelected())
				{
					DlgDonut dlgd=new DlgDonut();
					Point p=new Point(e.getX(),e.getY());
					dlgd.setVisible(true);
					setBoja(dlgd.getClr());
					int rad=dlgd.getRadius();
					int inrad=dlgd.getInRadius();
					Donut d=new Donut(p,rad,inrad);
					if(d.getRadius()>0 && d.getInnerRadius()>0 && d.getRadius()>d.getInnerRadius())
					{
						shapes.add(d);
					}
				}
				else if(tglbtnSelect.isSelected())
				{
					int i=0;
					int j=0;
					Point p=new Point(e.getX(),e.getY());
					while(i<shapes.size())
					{
						if(shapes.get(i).contains(p.getX(),p.getY()))
						{
							selektovani.add(shapes.get(i));
						}
						i++;
					}
					while(j<shapes.size()&&selektovani.size()!=0)
					{
						if(shapes.get(j).equals(selektovani.get(selektovani.size()-1)))
						{
							shapes.get(j).setSelected(true);
						}
						j++;
					}
					selektovani.clear();
				}
				pnlCenter.setClr(getBoja());
				repaint();
			}
		});
		contentPane.add(pnlCenter, BorderLayout.CENTER);
	}

}
