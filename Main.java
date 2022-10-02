import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.Scanner;  // Import the Scanner class


class Vector {
  public int x;
  public int y;
  public Vector(String xIn, String yIn){
    x = Integer.parseInt(xIn);
    y = Integer.parseInt(yIn);
  }
  public int Angle(Vector v2){
    return 2; // I'm not implementing this lol
  }
  @Override
  public String toString() {
      return "Vec(" + x + "," + y + ")";
  }
}
class Demo extends Frame {
  Vector[] vecs;
  public Demo(Vector[] vecsIn){
    super("Demo");
    vecs = vecsIn;
    prepareGUI();
  }
  private void prepareGUI(){
     setSize(400,400);
     addWindowListener(new WindowAdapter() {
        public void windowClosing(WindowEvent windowEvent){
           System.exit(0);
        }        
     }); 
  }    

  @Override
  public void paint(Graphics g) {
    Graphics2D g2 = (Graphics2D) g; 

    Line2D yAxis = new Line2D.Double();
    yAxis.setLine(200,0,200,400);  
    g2.draw (yAxis);

    Line2D xAxis = new Line2D.Double();
    xAxis.setLine(0,200,400,200);  
    g2.draw (xAxis);

    g2.setColor(Color.blue);
    g2.setStroke(new BasicStroke(4f));
    for(int i=0;i<vecs.length;i++){
      Line2D vect = new Line2D.Double();
      vect.setLine(
        200,
        200, 
        200 + vecs[i].x,
         200 - vecs[i].y
      ); // online said something about userspace, so for some reason that means the y-axis is flipped??
      g2.draw (vect);
    }
  }
}
public class Main {
  public static Vector[] GetInput(){
    Scanner keys = new Scanner(System.in);
    System.out.print("Enter a vector in the form of (int,int): ");
    String[] input1 =  keys.next().split(",");
    //String[] input1 =  "100,100".split(",");
    Vector v1 = new Vector(input1[0], input1[1]);

    System.out.print("Enter a vector in the form of (int,int): ");
    String[] input2 =  keys.next().split(",");
    //String[] input2 =  "-50,100".split(","); //keys.next().split(",");
    Vector v2 = new Vector(input2[0], input2[1]);
    keys.close(); // no leaks!

    System.out.println("The angle between vectors " + v1 + " and " + v2 + " is: " +v1.Angle(v2));

    Vector[] vecs = {v1, v2};
    return vecs;
  }
   public static void main(String[] args) {
      Vector[] vecs = GetInput();
      Demo awtGraphicsDemo = new Demo(vecs);  
      awtGraphicsDemo.setVisible(true);
   }      
}