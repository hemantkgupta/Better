
public class My_Segment_Intersect_Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Point p1 = new Point(1, 1);
		Point p2 = new Point(10, 1);
		Point p3 = new Point(1, 2);
		Point p4 = new Point(10, 2);			   
	 
		System.out.println(segments_Intersect(p1, p2, p3, p4));	

	}
	
	// To find orientation of ordered triplet (p, q, r).
		// The function returns following values
		// 0 --> p, q and r are colinear
		// 1 --> Clockwise
		// 2 --> Counterclockwise
	//calculate cross product (r - p) X ( q - p )
	public static int direction(Point p, Point q, Point r)
	{	
		//r * p - q * p
	    int val = ( r.getX()- p.getX() ) * ( q.getY() - p.getY() ) -
	    		  ( q.getX() - p.getX() ) * ( r.getY() - p.getY() );
	 
	    		
	    if (val == 0) return 0;  // colinear
	 
	    return (val > 0)? 1: 2; // clock or counterclock wise
	}
	
	
	public static boolean segments_Intersect(Point p1, Point p2, Point p3, Point p4)
	{
	    // Find the four orientations needed for general and
	    // special cases
	    int d1 = direction(p3, p4, p1);
	    int d2 = direction(p3, p4, p2);
	    int d3 = direction(p1, p2, p3);
	    int d4 = direction(p1, p2, p4);
	 
	    // General case
	    if (d1 != d2 && d3 != d4)
	        return true;
	 
	    // Special Cases
	    // p3, p4 and p1 are colinear and p2 lies on segment p3p4
	    if (d1 == 0 && on_Segment(p3, p4, p1)) return true;
	 
	    // p3, p4 and p2 are colinear and p1 lies on segment p3p4
	    if (d2 == 0 && on_Segment(p3, p4, p2)) return true;
	 
	    // p1, p2 and p3 are colinear and p4 lies on segment p1p2
	    if (d3 == 0 && on_Segment(p1, p2, p3)) return true;
	 
	     // p1, p2 and p4 are colinear and p3 lies on segment p1p2
	    if (d4 == 0 && on_Segment(p1, p2, p4)) return true;
	 
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
