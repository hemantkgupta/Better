
public class Segments_Intersect_Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Point p1 = new Point(1, 1);
		Point q1 = new Point(10, 1);
		Point p2 = new Point(1, 2);
		Point q2 = new Point(10, 2);
			   
	 
		System.out.println(segments_Intersect(p1, q1, p2, q2));
	 /*
	    p1 = {10, 0}, q1 = {0, 10};
	    p2 = {0, 0}, q2 = {10, 10};
	    doIntersect(p1, q1, p2, q2)? cout << "Yes\n": cout << "No\n";
	 
	    p1 = {-5, -5}, q1 = {0, 0};
	    p2 = {1, 1}, q2 = {10, 10};
	    doIntersect(p1, q1, p2, q2)? cout << "Yes\n": cout << "No\n";*/
	}
	
	// To find orientation of ordered triplet (p, q, r).
	// The function returns following values
	// 0 --> p, q and r are colinear
	// 1 --> Clockwise
	// 2 --> Counterclockwise
	public static int direction(Point p, Point q, Point r)
	{	
		//()
	    int val = (q.getY() - p.getY()) * (r.getX() - q.getX()) -
	              (q.getX() - p.getX()) * (r.getY() - q.getY());
	 
	    if (val == 0) return 0;  // colinear
	 
	    return (val > 0)? 1: 2; // clock or counterclock wise
	}
	
	
	public static int direction2(Point p0, Point p1, Point p2)
	{	
		//((y1-y0)*(x2-x1)) - ((x1-x0)*(y2-y1))
	    int val = (p1.getY() - p0.getY()) * (p2.getX() - p1.getX()) -
	              (p1.getX() - p0.getX()) * (p2.getY() - p1.getY());
	 
	    if (val == 0) return 0;  // colinear
	 
	    return (val > 0)? 1: 2; // clock or counterclock wise
	}
	public static boolean segments_Intersect(Point p1, Point q1, Point p2, Point q2)
	{
	    // Find the four orientations needed for general and
	    // special cases
	    int d1 = direction(p1, q1, p2);
	    int d2 = direction(p1, q1, q2);
	    int d3 = direction(p2, q2, p1);
	    int d4 = direction(p2, q2, q1);
	 
	    // General case
	    if (d1 != d2 && d3 != d4)
	        return true;
	 
	    // Special Cases
	    // p1, q1 and p2 are colinear and p2 lies on segment p1q1
	    if (d1 == 0 && on_Segment(p1, p2, q1)) return true;
	 
	    // p1, q1 and p2 are colinear and q2 lies on segment p1q1
	    if (d2 == 0 && on_Segment(p1, q2, q1)) return true;
	 
	    // p2, q2 and p1 are colinear and p1 lies on segment p2q2
	    if (d3 == 0 && on_Segment(p2, p1, q2)) return true;
	 
	     // p2, q2 and q1 are colinear and q1 lies on segment p2q2
	    if (d4 == 0 && on_Segment(p2, q1, q2)) return true;
	 
	    return false; // Doesn't fall in any of the above cases
	}
	
	public static boolean on_Segment(Point p, Point q, Point r)
	{
	    if (q.getX() <= Math.max(p.getX(), r.getX()) && q.getX() >= Math.min(p.getX(), r.getX()) &&
	        q.getY() <= Math.max(p.getY(), r.getY()) && q.getY() >= Math.min(p.getY(), r.getY()))
	       return true;
	 
	    return false;
	}
	 

}

class Point{
	private int x;
	private int y;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}
