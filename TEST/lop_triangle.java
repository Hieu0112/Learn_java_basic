
package TEST;

import java.util.Scanner;
class Point{
    private double x,y;

    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }
    public static Point nextPoint(Scanner sc){
        double x1 = sc.nextDouble();
        double x2 = sc.nextDouble();
        return new Point(x1,x2);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
    
    public double distance(Point secondPoint){
        double distanceX = secondPoint.getX() - x;
        double distanceY = secondPoint.getY() -y;
        return Math.sqrt(distanceX*distanceX + distanceY*distanceY);
    }
}
class Triangle {
    private Point p1;
    private Point p2;
    private Point p3;
    
    public Triangle(Point x, Point y, Point z){
       this.p1 = x;
       this.p2 = y;
       this.p3 = z;
    }
    public boolean valid(){
        double ab = p1.distance(p2);
        double bc = p2.distance(p3);
        double ca = p3.distance(p1);
        if(ab + bc <= ca || ab + ca <= bc || bc + ca <= ab) return false;
        return true;
    }
    public String getPerimeter(){
        return String.format("%.3f", p1.distance(p2)+p2.distance(p3)+p3.distance(p1));
    }
    
}
public class lop_triangle{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0){
            Triangle a = new Triangle(Point.nextPoint(sc), Point.nextPoint(sc), Point.nextPoint(sc));
            if(!a.valid()){
                System.out.println("INVALID");
            } else{
                System.out.println(a.getPerimeter());
            }
        }
    }
}

