import processing.core.*;

public class App extends PApplet {
    public static void main(String[] args) {
        PApplet.main("App");
    }

    float rectX = 375; 
    float rectY = 50;
    float rectSize = 50; // Floats create the first rectangle
    float offsetX1, offsetY1; // Offset for first rectangle
    boolean dragging = false; // First rectangle dragging is false
    float rect2X = 450;
    float rect2Y = 550;
    float rect2Size = 50; // Creating the second rectangle
    float offsetX2, offsetY2; // Offset for second rectangle
    boolean dragging2 = false; // Second rectangle dragging is false

    public void setup() {
        background(40040);
        strokeWeight(20);

        fill(00);
        textSize(50);
        text("Complete the puzzle as shown on the left.", 315, 50);
    }

    public void settings() {
        size(600, 600);
    }

    public void draw() {
        background(40040); // Clear background every frame

        // Line divider
        stroke(0);
        strokeWeight(20);
        line(300, 600, 300, 0);

        // Static rectangles on the left
        stroke(0);
        strokeWeight(10);
        fill(0, 50, 5);
        rect(190, 100, 50, 50);

        stroke(0);
        strokeWeight(10);
        fill(5, 5, 150);
        rect(50, 100, 50, 50);

        stroke(0);
        strokeWeight(10);
        fill(100, 50, 5);
        rect(30, 200, 25, 25);

        stroke(0);
        strokeWeight(10);
        fill(40, 225, 60);
        rect(50, 250, 25, 25);

        stroke(0);
        strokeWeight(10);
        fill(200, 0, 15);
        rect(70, 300, 25, 25);
        
        stroke(0);
        strokeWeight(10);
        fill(0, 0, 15);
        rect(110, 300, 25, 25);
        
        stroke(0);
        strokeWeight(10);
        fill(0, 100, 15);
        rect(150, 300, 25, 25);

        // First draggable rectangle
        if (!dragging) {  // Only draw the rectangle if it's not being dragged
            stroke(0);
            strokeWeight(10);
            fill(0, 50, 5);
            rect(rectX, rectY, rectSize, rectSize);
        } else {
            // Draw the new rectangle at the mouse location while dragging
            stroke(0);
            strokeWeight(10);
            fill(0, 50, 5);  // You can change the color or appearance here
            rect(mouseX + offsetX1, mouseY + offsetY1, rectSize, rectSize);
        }

        // Second draggable rectangle
        if (!dragging2) {  // Only draw the rectangle if it's not being dragged
            stroke(0);
            strokeWeight(10);
            fill(100, 50, 5);
            rect(rect2X, rect2Y, rect2Size, rect2Size);
        } else {
            // Draw the new rectangle at the mouse location while dragging
            stroke(0);
            strokeWeight(10);
            fill(100, 50, 5);  // You can change the color or appearance here
            rect(mouseX + offsetX2, mouseY + offsetY2, rect2Size, rect2Size);
        }
    }

    public void mousePressed() {
        // Check if the first rectangle is clicked
        if (mouseX > rectX && mouseX < rectX + rectSize &&
            mouseY > rectY && mouseY < rectY + rectSize) {
            dragging = true; // Start dragging the first rectangle
            offsetX1 = rectX - mouseX; // Calculate offset for the first rectangle
            offsetY1 = rectY - mouseY;
        }

        // Check if the second rectangle is clicked
        if (mouseX > rect2X && mouseX < rect2X + rect2Size &&
            mouseY > rect2Y && mouseY < rect2Y + rect2Size) {
            dragging2 = true; // Start dragging the second rectangle
            offsetX2 = rect2X - mouseX; // Calculate offset for the second rectangle
            offsetY2 = rect2Y - mouseY;
        }
    }

    public void mouseReleased() {
        if (dragging) {
            // Update the position of the first rectangle to where the mouse is released
            rectX = mouseX + offsetX1;
            rectY = mouseY + offsetY1;
            dragging = false;  // Stop dragging the first rectangle
        }

        if (dragging2) {
            // Update the position of the second rectangle to where the mouse is released
            rect2X = mouseX + offsetX2;
            rect2Y = mouseY + offsetY2;
            dragging2 = false;  // Stop dragging the second
    }
    


}
 }
