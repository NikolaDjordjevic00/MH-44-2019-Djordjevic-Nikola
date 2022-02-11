package gui;


import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.*;

import geometry.*;
import geometry.Point;
import geometry.Rectangle;
import geometry.Shape;





public class PnlDrawing extends JPanel{
	private ArrayList<Shape> shapes=new ArrayList<>();
	private Color clr;
	
	public Color getClr() {
		return clr;
	}

	public void setClr(Color clr) {
		this.clr = clr;
	}

	public ArrayList<Shape> getShapes() {
		return shapes;
	}

	public void setShapes(ArrayList<Shape> shapes) {
		this.shapes = shapes;
	}

	public void paint(Graphics g)
	{
		g.setColor(getClr());
		Iterator<Shape> it = shapes.iterator();
		while(it.hasNext()) {
			Shape s=it.next();
			s.draw(g);
			}
	}

	
	

}
