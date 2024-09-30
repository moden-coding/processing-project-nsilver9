import processing.core.*;

public class App extends PApplet{
    public static void main(String[] args)  {
        PApplet.main("App");
    }

    float rectX = 400;
    float rectY = 200;
    float rectSize = 100;
    boolean dragging = false;
    float offsetX, offsetY; // To track the difference between the mouse and circle position


    public void setup(){
        background(10010);
       
        strokeWeight(20);
        fill(00);
        textSize(16);

        text("Complete the puzzle as shown on the left.", 315, 30);
    }

    public void settings(){
        size(600, 600);
    }

    public void draw(){
       stroke(00);
       strokeWeight(20);
       line(300, 600, 300, 0);

       stroke(0);
       strokeWeight(50);
       fill(0, 50, 5);
       rect(25, 200, 75, 100);

       stroke(0);
       strokeWeight(50);
       fill(50, 0, 0);
       ellipse(100, 500, 100, 150);

       stroke(0);
       strokeWeight(50);
       fill(0, 50, 5);
       rect(rectX, rectY, rectSize, rectSize);

       if (dragging) {
        rectX = mouseX + offsetX;
        rectY = mouseY + offsetY;
       }
       stroke(0);
       strokeWeight(50);
       fill(50, 0, 0);
       ellipse(400, 400, 100, 150);
    }

    public void mousePressed() {
        float distance = dist(mouseX, mouseY, rectX, rectY);
  if (distance < rectSize / 2) {
    dragging = true; // Start dragging the circle
    offsetX = rectX - mouseX; // Calculate the offset between the circle's position and the mouse
    offsetY = rectY - mouseY;
    }
    }

    public void mouseReleased() {
        dragging = false;
    }
}

