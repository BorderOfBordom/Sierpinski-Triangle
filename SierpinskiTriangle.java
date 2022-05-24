import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
public class SierpinskiTriangle extends JPanel implements KeyListener
{
	JFrame frame;
	ArrayList<Point> points;
	Polygon triangle;
	Color[] randomColors = {Color.WHITE, Color.BLUE, Color.RED, Color.YELLOW, Color.GREEN, Color.ORANGE, Color.PINK};

	public class Point
	{
		Color color;
		int x, y;
		public Point(int x, int y, Color color)
		{
			this.x = x;
			this.y = y;
			this.color = color;
		}

		public int getX()
		{
			return x;
		}

		public int getY()
		{
			return y;
		}

		public Color getColor()
		{
			return color;
		}

		public String toString()
		{
			return "Point: X:"+x+" Y:"+y;
		}
	}

	public SierpinskiTriangle()
	{
		frame = new JFrame("Sierpinski Triangle");
		frame.add(this);
		this.setBackground(Color.BLACK);

		frame.setSize(1200,800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		createSierpinskiTrangle();
		frame.setVisible(true);
		frame.addKeyListener(this);


	}


	//CREATE GRADIENT COLOR METHOD
	/*public Color getRainColor(int x)
	{
		Color output;
		int r,g,b;
		//if(
		return
	}*/

	public void createSierpinskiTrangle()
	{
		points = new ArrayList<Point>();
		points.add(new Point(frame.getWidth()/2, 100, Color.WHITE)); //Top most point
		points.add(new Point(100, frame.getHeight()-100, Color.WHITE));//left point
		points.add(new Point(frame.getWidth()-100, frame.getHeight()-100, Color.WHITE));//right point

		int[] xPoints = {points.get(0).getX(),points.get(1).getX(),points.get(2).getX()};
		int[] yPoints = {points.get(0).getY(),points.get(1).getY(),points.get(2).getY()};
		triangle = new Polygon(xPoints,yPoints,3);

		int x;
		int y;
		do
		{
			x=(int)(Math.random()*frame.getWidth());
			y=(int)(Math.random()*frame.getHeight());
		}while(!triangle.contains(x,y));

		Point point = new Point(x, y, Color.BLACK);
		points.add(point);

	}

	public void findPoints(int amountOfPoints)
	{
		Point point = points.get(points.size()-1);
		for(int i=0; i<amountOfPoints; i++)
		{
			Point pointToHalf = points.get((int)(Math.random()*3));

			point = new Point((pointToHalf.getX()+point.getX())/2,(pointToHalf.getY()+point.getY())/2,randomColors[(int)(Math.random()*randomColors.length)]);
			points.add(point);

		}

	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		for(Point p:points)
		{
			g.setColor(p.getColor());
			g.fillOval(p.getX(), p.getY(), 2,2);
		}
	}

	public void keyReleased(KeyEvent e)
	{

	}

	public void keyPressed(KeyEvent e)
	{
		if(e.getKeyCode() == KeyEvent.VK_1)
		{
			findPoints(1);
		}

		if(e.getKeyCode() == KeyEvent.VK_2)
		{
			findPoints(2);
		}

		if(e.getKeyCode() == KeyEvent.VK_3)
		{
			findPoints(3);
		}

		if(e.getKeyCode() == KeyEvent.VK_4)
		{
			findPoints(4);
		}

		if(e.getKeyCode() == KeyEvent.VK_5)
		{
			findPoints(5);
		}

		if(e.getKeyCode() == KeyEvent.VK_6)
		{
			findPoints(6);
		}

		if(e.getKeyCode() == KeyEvent.VK_7)
		{
			findPoints(7);
		}

		if(e.getKeyCode() == KeyEvent.VK_8)
		{
			findPoints(8);
		}

		if(e.getKeyCode() == KeyEvent.VK_9)
		{
			findPoints(9);
		}

		repaint();
	}

	public void keyTyped(KeyEvent e)
	{

	}

	public static void main(String[] args)
	{
		SierpinskiTriangle app = new SierpinskiTriangle();
	}
}