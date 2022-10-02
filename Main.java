import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;


class Demo extends Frame {
  public Demo(){
     super("Demo");
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

     Line2D vect = new Line2D.Double();
     vect.setLine(100,100,400,400);  
     g2.setColor(Color.blue);
     g2.draw (vect);
  }
}
public class Main {
   public static void main(String[] args) {
      Demo awtGraphicsDemo = new Demo();  
      awtGraphicsDemo.setVisible(true);
   }      
}