public class Petal {
	private Animation myAni;
	private float x;
	private float y;
	static Petal petal = null;
	private float color1 = (float)(Math.random() * 255);
	private float color2 = (float)(Math.random() * 255);
	private float color3 = (float)(Math.random() * 255);
	public Petal(float x, float y, Animation myAni) {
		this.x = x;
		this.y = y;
		this.myAni = myAni;
	}
	
	public void display() {
		myAni.stroke(255);
		myAni.fill(color1, color2, color3);
		if (myAni.mousePressed == true &&
				(myAni.mouseX >= (x - 25)) &&
				(myAni.mouseX <= (x + 25)) &&
				(myAni.mouseY >= (y - 25)) &&
				(myAni.mouseY <= (y+25)) &&  
				(petal == null || petal == this)) {
			x = myAni.mouseX;
			y = myAni.mouseY;
			petal = this;
		}
		myAni.circle(x, y, 50);
	}
	
}
	