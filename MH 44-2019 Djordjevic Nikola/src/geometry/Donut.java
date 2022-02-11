package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Donut extends Circle {

	private int innerRadius;
	
	@Override
	public double area() {
		return super.area() - innerRadius*innerRadius*Math.PI;
	}
	
	@Override 
	public boolean contains(int x, int y) {
		return super.contains(x, y) && super.center.distance(new Point(x,y)) >= innerRadius;
	}
	
	@Override
	public boolean contains(Point p) {
		return contains(p.getX(), p.getY());
	}
	
	@Override
	public String toString() {
		return super.toString() + " ,inner radius = " + this.innerRadius;
		 
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Donut) {
			Donut temp = (Donut) obj;
			if(super.center.equals(temp.center) && super.radius == temp.radius && this.innerRadius == temp.innerRadius) {
				return true;
			}
		}return false;
	}
	
	@Override
	public void draw(Graphics g) {
		super.draw(g);
		g.drawOval(center.getX() - innerRadius, center.getY()-innerRadius, innerRadius*2, innerRadius*2);
		if(selected) {
			g.setColor(Color.BLUE);
			g.drawRect(center.getX()-innerRadius-3, center.getY()-3, 6, 6);
			g.drawRect(center.getX()+innerRadius-3, center.getY()-3, 6, 6);
			g.drawRect(center.getX()-3, center.getY()-innerRadius-3, 6, 6);
			g.drawRect(center.getX()-3, center.getY()+innerRadius-3, 6, 6);
		}
	}
	
	@Override
	public int compareTo(Object obj) {
		if(obj instanceof Donut) {
			return (int)(area() - ((Donut)obj).area());
		}
		return 0;
	}
	
	//Konstruktori
	public Donut() {
		
	}
	
	public Donut(Point center, int radius, int innerRadius) {
		super(center, radius);
		this.innerRadius =  innerRadius;
	}
	
	public Donut(Point center, int radius, int innerRadius, boolean selected) {
		this(center,radius,innerRadius);
		this.selected = selected;
	}

	//Get i set metode
	public int getInnerRadius() {
		return innerRadius;
	}

	public void setInnerRadius(int innerRadius) {
		this.innerRadius = innerRadius;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	
}
