import processing.core.*;

public class App extends PApplet {
    public static void main(String[] args) {
        PApplet.main("App");
    }

    float darkGreenRectX = 375; 
    float darkGreenRectY = 50;
    float darkGreenRectSize = 50; // Floats create the first rectangle
    float darkGreenOffsetX, darkGreenOffsetY; // Offset for first rectangle
    boolean darkGreenDragging = false; // First rectangle dragging is false

    float blueRectX = 450;
    float blueRectY = 550;
    float blueRectSize = 50; // Creating the second rectangle
    float blueOffsetX, blueOffsetY; // Offset for second rectangle
    boolean blueDragging = false; // Second rectangle dragging is false

    float darkGreenTargetX = 450;
    float darkGreenTargetY = 90;
    float darkGreenTargetSize = 50;

    float blueTargetX = 350;
    float blueTargetY = 90;
    float blueTargetSize = 50;

    boolean darkGreenInTarget = false;
    boolean blueInTarget = true;

    public void setup() {
        background(40040);
        strokeWeight(20);

    }

    public void settings() {
        size(600, 600);
    }

    public void draw() {
        background(40040); // Clear background every frame

        stroke(0);
        textSize(15);
        fill(00, 00, 00);
        text("Complete the puzzle as shown on the left.", 315, 25);

        stroke(0);
        textSize(15);
        fill(00, 00, 00);
        text("If a shape turns green, it's in the right place.", 315, 40);

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

        // First draggable rectangle
        if (!darkGreenDragging) {  // Only draw the rectangle if it's not being dragged
            stroke(0);
            strokeWeight(10);
            fill(0, 50, 5);
            rect(darkGreenRectX, darkGreenRectY, darkGreenRectSize, darkGreenRectSize);
        } else {
            // Draw the new rectangle at the mouse location while dragging
            stroke(0);
            strokeWeight(10);
            fill(0, 50, 5);  // You can change the color or appearance here
            rect(mouseX + darkGreenOffsetX, mouseY + darkGreenOffsetY, darkGreenRectSize, darkGreenRectSize);
        }

        // Second draggable rectangle
        if (!blueDragging) {  // Only draw the rectangle if it's not being dragged
            stroke(0);
            strokeWeight(10);
            fill(5, 5, 150);
            rect(blueRectX, blueRectY, blueRectSize, blueRectSize);
        } else {
            // Draw the new rectangle at the mouse location while dragging
            stroke(0);
            strokeWeight(10);
            fill(5, 5, 150);  // You can change the color or appearance here
            rect(mouseX + blueOffsetX, mouseY + blueOffsetY, blueRectSize, blueRectSize);
        }
     

        if (!darkGreenDragging) {
            if (darkGreenRectX > darkGreenTargetX && darkGreenRectX < darkGreenTargetX + darkGreenTargetSize &&
                darkGreenRectY > darkGreenTargetY && darkGreenRectY < darkGreenTargetY + darkGreenTargetSize) {
                // If the rectangle is inside the target space, make it green

                fill(0, 255, 0);
                darkGreenInTarget = true;
            } else {
                // Otherwise, keep its normal color
                fill(0, 50, 5);
                darkGreenInTarget = false;
            }
            stroke(0);
            strokeWeight(10);
            rect(darkGreenRectX, darkGreenRectY, darkGreenRectSize, darkGreenRectSize);
        } else {
            // Draw the rectangle at the mouse location while dragging
            stroke(0);
            strokeWeight(10);
            fill(0, 50, 5);
            rect(mouseX + darkGreenOffsetX, mouseY + darkGreenOffsetY, darkGreenRectSize, darkGreenRectSize);
        }

        if (!blueDragging) {
            if (blueRectX > blueTargetX && blueRectX < blueTargetX + blueTargetSize &&
                blueRectY > blueTargetY && blueRectY < blueTargetY + blueTargetSize) {
                // If the rectangle is inside the target space, make it green

                fill(0, 255, 0);
                blueInTarget = true;
            } else {
                // Otherwise, keep its normal color
                fill(5, 5, 150);
                blueInTarget = false;
            }
            stroke(0);
            strokeWeight(10);
            rect(blueRectX, blueRectY, blueRectSize, blueRectSize);
        } else {
            // Draw the rectangle at the mouse location while dragging
            stroke(0);
            strokeWeight(10);
            fill(5, 5, 150);
            rect(mouseX + blueOffsetX, mouseY + blueOffsetY, blueRectSize, blueRectSize);
        }

        if (darkGreenInTarget == true && blueInTarget == true) {
            stroke(0);
            textSize(70);
            fill(00, 00, 00);
            text("Complete!", 135, 300);
        } else {
            // Nothing else is needed here
        }
    }

    public void mousePressed() {
        // Check if the first rectangle is clicked
        if (mouseX > darkGreenRectX && mouseX < darkGreenRectX + darkGreenRectSize &&
            mouseY > darkGreenRectY && mouseY < darkGreenRectY + darkGreenRectSize) {
            darkGreenDragging = true; // Start dragging the first rectangle
            darkGreenOffsetX = darkGreenRectX - mouseX; // Calculate offset for the first rectangle
            darkGreenOffsetY = darkGreenRectY - mouseY;
        }

        // Check if the second rectangle is clicked
        if (mouseX > blueRectX && mouseX < blueRectX + blueRectSize &&
            mouseY > blueRectY && mouseY < blueRectY + blueRectSize) {
            blueDragging = true; // Start dragging the second rectangle
            blueOffsetX = blueRectX - mouseX; // Calculate offset for the second rectangle
            blueOffsetY = blueRectY - mouseY; }
        }

       
    public void mouseReleased() {
        if (darkGreenDragging) {
            // Update the position of the first rectangle to where the mouse is released
            darkGreenRectX = mouseX + darkGreenOffsetX;
            darkGreenRectY = mouseY + darkGreenOffsetY;
            darkGreenDragging = false;  // Stop dragging the first rectangle
        }

        if (blueDragging) {
            // Update the position of the second rectangle to where the mouse is released
            blueRectX = mouseX + blueOffsetX;
            blueRectY = mouseY + blueOffsetY;
            blueDragging = false;  // Stop dragging the second
        }
}
    }
