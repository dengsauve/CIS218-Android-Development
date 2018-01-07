import java.util.Scanner;

// This only took 23 lines of code in Ruby...
class Main {
    public static void main(String[] args) {
        // Get user input
        Scanner scanner = new Scanner(System.in);
        System.out.print("How long should the side be (2+): ");
        int sideLength = scanner.nextInt();

        //print shapes
        System.out.println(RegularTriangle(sideLength));
        System.out.println(ReverseTriangle(sideLength));
        System.out.println(Diamond(sideLength));
    }

    // Returns a solid? string
    public static String BodyLine(int filler, Boolean isSolid){
        String returnString = "*";
        for(int i=0; i<filler; i++){
            returnString += isSolid ? "*" : " ";
        }
        returnString += "*\n";

        return returnString;
    }

    // Returns a string of spaces
    public static String Space(int length){
        String returnString = "";
        for(int i=0; i<length; i++){
            returnString += " ";
        }

        return returnString;
    }

    // Returns a line like [space?][*][space?][*][space?]
    public static String DiamondLine(int sideLength, int i){
        String returnString = Space(sideLength - (i+1)) + "*" + Space(1 + (2 * (i-1))) + "*" + Space(sideLength - (i+1)) + "\n";
        return returnString;
    }

    // Returns a string with an * in the middle
    public static String DiamondPoints(int sideLength){
        String returnString = Space(sideLength - 1) + "*" + Space(sideLength - 1) + "\n";
        return returnString;
    }


    public static String RegularTriangle(int sideLength){
        //top of triangle
        String returnString = "*\n";

        //body of triangle
        for(int i=1; i<sideLength - 1; i++){
            returnString += BodyLine(i-1, false);
        }

        //base of triangle
        returnString += BodyLine(sideLength - 2, true);

        return returnString;
    }

    public static String ReverseTriangle(int sideLength){
        //top of triangle
        String returnString = Space(sideLength - 1) + "*\n";

        //body of triangle
        for(int i=1; i < sideLength - 1; i++){
            returnString += Space(sideLength - (i+1)) + BodyLine(i - 1, false);
        }

        //footer of triangle
        returnString += BodyLine(sideLength - 2, true);

        return returnString;
    }

    public static String Diamond(int sideLength){
        //top of diamond
        String returnString = DiamondPoints(sideLength);

        //top body of diamond
        for(int i=1; i < sideLength - 1; i++){
            returnString += DiamondLine(sideLength, i);
        }

        //middle of diamond
        returnString += BodyLine((sideLength * 2) - 3, false);

        //lower body of diamond
        for(int i=(sideLength - 2); i > 0; i--){
            returnString += DiamondLine(sideLength, i);
        }

        //base of diamond
        returnString += DiamondPoints(sideLength);

        return returnString;
    }
}