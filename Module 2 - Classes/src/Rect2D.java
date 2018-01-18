public class Rect2D {
  
  public double x, y, height, width;
  public String rectName;
  
  public Rect2D() {
    x = 0.0;
    y = 0.0;
    height = 1;
    width = 1;
    rectName = "blank";
  }
  
  
  public Rect2D(double x, double y, double height, double width, String rectangleName) {
    this.x = x;
    this.y = y;
    this.height = height;
    this.width = width;
    this.rectName = rectangleName;
  }
  
  
  public double getArea() {
    return height * width;
  }
  
  
  public double getPerimeter() {
    return ((2 * height) + (2 * width));
  }
  
  
  public boolean contains(double x, double y) {
    // Readability...
    double halfWidth = width / 2;
    double halfHeight = height / 2;
    
    // Check within x range and y range
    return (x >= (this.x - halfWidth) && x <= (this.x + halfWidth) && y >= this.y - halfHeight && y <= this.y + halfHeight);
  }
  
  
  public boolean contains(Rect2D r) {
    // Distances from center to add from r rectangle
    double rHalfWidth = r.width / 2.0;
    double rHalfHeight = r.height / 2.0;
    
    boolean upperLeftCheck = this.contains(r.x - rHalfWidth, r.y + rHalfHeight);
    boolean lowerLeftCheck = this.contains(r.x - rHalfWidth, r.y - rHalfHeight);
    boolean upperRightCheck = this.contains(r.x + rHalfWidth, r.y + rHalfHeight);
    boolean lowerRightCheck = this.contains(r.x + rHalfWidth, r.y - rHalfHeight);
    
    return (upperLeftCheck && lowerLeftCheck && upperRightCheck && lowerRightCheck);
  }
  
  
  /*
  Approach to solving overlaps:
  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  This one's a little odd, so I figured some explanation might be nice.
  
  Assumptions:
  1. Two rectangles overlap each other
  2. No corners from either rectangle are inside the other rectangle
  
  The result is a cross-ish looking formation. The result also doesn't work using my contains check
  
  I needed to check if an intersection of sides existed.
  
  Solution:
  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  My solution compares the x ranges and the y ranges of both rectangles.
  
  The ranges are compared by checking all four x limits from both rectangles, and all four y limits.
  
  If a x limit from rectangle.1 is between the x limits of rectangle.2, or vice versa, then there is x range overlap.
  
  Apply the above the the y limits.
  
  If there is overlap in BOTH the x and y limits, then we can know that there must be an intersection of sides occuring
  between the two boxes, and we can return true.
   */
  public boolean overlaps(Rect2D r) {
    // Distances from center to add from r rectangle
    double rHalfWidth = r.width / 2.0;
    double rHalfHeight = r.height / 2.0;
    
    // Distances from center to add from self
    double tHalfWidth = this.width / 2.0;
    double tHalfHeight = this.height / 2.0;
    
    // Checks if verticle/horizontal points contain each other... if there's an instance of both horizontal and vertical
    // overlap by one or the other, then an overlap exists.
    boolean verticalCheck = this.alongside(r.y - rHalfHeight, r.y + rHalfHeight, y - tHalfHeight, y + tHalfHeight);
    boolean horizontalCheck = this.alongside(r.x - rHalfWidth, r.x + rHalfWidth, x - tHalfWidth, x + tHalfWidth);
    
    return (verticalCheck && horizontalCheck);
  }
  
  
  private boolean alongside(double rEnd1, double rEnd2, double tEnd1, double tEnd2) {
    // check r points inside t points
    boolean rEnd1Check = (rEnd1 >= tEnd1 && rEnd1 <= tEnd2);
    boolean rEnd2Check = (rEnd2 >= tEnd1 && rEnd2 <= tEnd2);
    
    boolean rEnd = rEnd1Check || rEnd2Check;
    
    // check t points inside r points
    boolean tEnd1Check = (tEnd1 >= rEnd1 && tEnd1 <= rEnd2);
    boolean tEnd2Check = (tEnd2 >= rEnd1 && tEnd2 <= rEnd2);
    
    boolean tEnd = tEnd1Check || tEnd2Check;
    
    // returns true in one "line" overlaps the other "line"
    return rEnd || tEnd;
  }
}
