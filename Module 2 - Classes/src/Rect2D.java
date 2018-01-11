public class Rect2D {

    public double x;
    public double y;
    public double height;
    public double width;
    public String rectName;

    public Rect2D () {
        x = 0.0;
        y = 0.0;
        height = 1;
        width = 1;
        rectName = "blank";
    }

    public Rect2D (double x, double y, double height, double width, String rectangleName){
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        this.rectName = rectangleName;
    }

    public double getArea(){
        return height * width;
    }

    public double getPerimeter(){
        return ( (2 * height) + (2 * width) );
    }

    public boolean contains(double x, double y){
        // Readability...
        double halfWidth = width / 2;
        double halfHeight = height / 2;

        // Check within x range and y range
        return (x >= this.x - halfWidth && x <= this.x + halfWidth && y >= this.y - halfHeight && y <= this.y + halfHeight);
    }

    public boolean contains(Rect2D r){
        double rHalfWidth = r.width / 2;
        double rHalfHeight = r.height / 2;

        boolean upperLeftCheck = this.contains(r.x - rHalfWidth, r.y + rHalfHeight);
        boolean lowerLeftCheck = this.contains(r.x - rHalfWidth, r.y - rHalfHeight);
        boolean upperRightCheck = this.contains(r.x + rHalfWidth, r.y + rHalfHeight);
        boolean lowerRightCheck = this.contains(r.x + rHalfWidth, r.y - rHalfHeight);

        // debug
        //System.out.println(this.rectName + ", " + r.rectName);
        //System.out.println(upperLeftCheck && lowerLeftCheck && upperRightCheck && lowerRightCheck);

        return (upperLeftCheck && lowerLeftCheck && upperRightCheck && lowerRightCheck);
    }

    public boolean overlaps(Rect2D r){
        double rHalfWidth = r.width / 2;
        double rHalfHeight = r.height / 2;

        boolean upperLeftCheck = this.contains(r.x - rHalfWidth, r.y + rHalfHeight);
        boolean lowerLeftCheck = this.contains(r.x - rHalfWidth, r.y - rHalfHeight);
        boolean upperRightCheck = this.contains(r.x + rHalfWidth, r.y + rHalfHeight);
        boolean lowerRightCheck = this.contains(r.x + rHalfWidth, r.y - rHalfHeight);

        //debug
        System.out.println(this.rectName + ", " + r.rectName);
        System.out.println(upperLeftCheck || lowerLeftCheck || upperRightCheck || lowerRightCheck);


        return (upperLeftCheck || lowerLeftCheck || upperRightCheck || lowerRightCheck);
    }
}
