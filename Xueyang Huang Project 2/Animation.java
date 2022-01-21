import processing.core.PApplet;
public class Animation extends PApplet {
	Petal petal1, petal2, petal3, petal4, petal5, petal6;
	public float a = width/2;
     public static void main(String[] args) {
          PApplet.main("Animation");
     } 
     public void settings() {
         size(500, 500);
         petal1 = new Petal(223,203,this);
         petal2 = new Petal(195,250,this);
         petal3 = new Petal(223,297,this);
         petal4 = new Petal(277,297,this);
         petal5 = new Petal(305,250,this);
         petal6 = new Petal(277,203,this);
    }
     public void draw() {
    	 background(255);
    	 stroke(35,195,29);
    	 line(250,280,250,500);
    	 noStroke();
    	 fill(253,230,20);
    	 circle(250, 250, 60);
    	 textSize(28);
    	 fill(206,167,245);
    	 text("Feel free to pick the petals", a, 80);
    	 a = (float) (a + 1);
    	 if (a > width) {
    		 a = -360;
    	 }
         petal1.display();
    	 petal2.display();
    	 petal3.display();
    	 petal4.display();
    	 petal5.display();
    	 petal6.display(); 
    	}
     
     public void mouseReleased() {
    	 Petal.petal = null;
     }
     
}