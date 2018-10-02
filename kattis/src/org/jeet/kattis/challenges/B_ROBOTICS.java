package org.jeet.kattis.challenges;

import java.util.ArrayList;
import java.util.Scanner;

class B_ROBOTICS {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int n = scanner.nextInt();
		while(n>0) {
			Point[] pts = new Point[n];
			for (int i = 0; i < n; i++) {
				pts[i]=new Point(scanner.nextInt(), scanner.nextInt());
			}
			double area = convexHullArea(pts, n);
			System.out.println(area);
			n=scanner.nextInt();
		}
		scanner.close();
	}
	
	public static boolean moreCounterClockwise(Point p, Point q, Point r)
    {
        int val = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);
        return (val < 0)? true: false;
    }
     
    public static double convexHullArea(Point points[], int n)
    {
        if (n < 3) return 0;
        ArrayList<Point> hull = new ArrayList<Point>();
        int l = 0;
        for (int i = 1; i < n; i++)
            if (points[i].x < points[l].x)
                l = i;
        int p = l, q;
        do
        {
            hull.add(points[p]);
            q = (p + 1) % n;
            for (int i = 0; i < n; i++)
            {
               if (moreCounterClockwise(points[p], points[i], points[q]))
                   q = i;
            }
            p = q;
        } while (p != l);      
        n=hull.size();
        long area=0;
        int j = n - 1;
        for (int i = 0; i < n; i++)
        {
            area += (hull.get(j).x+hull.get(i).x) * (hull.get(j).y - hull.get(i).y);             
            // j is previous vertex to i
            j = i; 
        }
        area=Math.abs(area);
        return ((double)area)/2.0;
    }

	static class Point {
		public int x;
		public int y;
		Point(int x, int y) {
			this.x=x;
			this.y=y;
		}
	}
}