package org.jeet.codechef.div3_493;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Gears {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int c, m, n, v, x, y, t, xp, yp; 
		n = scanner.nextInt();
		m = scanner.nextInt();
		
		Map<Integer,N> graph = new HashMap<Integer, N>();
		
		S[] sets = new S[n+1];
		
		for (int i = 1; i <= n; i++) {
			t=scanner.nextInt();
			graph.put(i, new N(i, t));
			sets[i]=new S(i,0);
		}

		for (int i = 1; i <= m; i++) {
			t=scanner.nextInt();
			switch (t) {
		
			case 1:
				x = scanner.nextInt();
				c = scanner.nextInt();
				graph.get(x).t=c;
				break;

			case 2:
				x = scanner.nextInt();
				y = scanner.nextInt();
				graph.get(x).addN(graph.get(y));
				graph.get(y).addN(graph.get(x));
				boolean block=false;
				xp=findParent(sets, x);
				yp=findParent(sets, y);
				if(graph.get(xp).block || graph.get(yp).block || xp==yp) {
					block=true;
				}
				if(xp!=yp) {
					//union(sets, x, y);
					int xr = sets[xp].r;
					int yr = sets[yp].r;
					if(xr<yr) {
						sets[xp].p=yp;
					} else if(yr<xr) {
						sets[yp].p=xp;
					} else {
						sets[xp].r++;
						sets[yp].p=xp;
					}
				}
				xp=findParent(sets, x);
				graph.get(xp).block=block;
				break;

			case 3:
				x = scanner.nextInt();
				y = scanner.nextInt();
				v = scanner.nextInt();
				xp = findParent(sets, x);
				yp = findParent(sets, y);
				if(xp!=yp || graph.get(yp).block) {
					System.out.println("0");
					break;
				}
				Queue<N> q = new LinkedList<N>();
				boolean[] visited= new boolean[n+1];
				Spd[] speeds = new Spd[n+1];
				q.add(graph.get(x));
				visited[x]=true;
				speeds[x]=new Spd(1, BigInteger.valueOf(v), BigInteger.ONE);
				while(q.size()>0) {
					N cur=q.poll();
					for(N near:cur.near) {
						if(!visited[near.n]) {
							visited[near.n]=true;
							speeds[near.n]=new Spd(-1, BigInteger.valueOf(cur.t), BigInteger.valueOf(near.t));
							speeds[near.n].addSpd(speeds[cur.n]);
							q.add(near);
						}
						if(near.n==y) {
							break;
						}
					}
				}
				System.out.println(speeds[y]);
				break;

			default:
				break;
			}
		}
		scanner.close();
	}

	static int findParent(S[] sets, int x) {
		if(sets[x].p!=x) 
			sets[x].p=findParent(sets, sets[x].p);
		return sets[x].p;
	}
	
	static void union(S[] sets, int x, int y) {
		int xp = findParent(sets, x);
		int yp = findParent(sets, y);
		int xr = sets[xp].r;
		int yr = sets[yp].r;
		if(xr<yr) {
			sets[xp].p=yp;
		} else if(yr<xr) {
			sets[yp].p=xp;
		} else {
			sets[xp].r++;
			sets[yp].p=xp;
		}
	}

	static class N{
		public int n;
		public int t;
		public List<N> near;
		public boolean block;
		public N(int n_, int t_) {
			n=n_;
			t=t_;
			near=new LinkedList<N>();
		}
		public void addN(N n_) {
			near.add(n_);
		}

	}

	static class Spd{
		int s;
		BigInteger x;
		BigInteger y;
		public Spd(int s_, BigInteger x_, BigInteger y_) {
			s=s_;
			BigInteger gcd=x_.gcd(y_);
			x=x_.divide(gcd);
			y=y_.divide(gcd);
		}
		
		public void addSpd(Spd spd) {
			s=spd.s*s;
			BigInteger gcd = x.multiply(spd.x).gcd(y.multiply(spd.y));
			if(gcd==BigInteger.ZERO) {
				x=BigInteger.ZERO;
				y=BigInteger.ONE;
			}
			else {
				x=x.multiply(spd.x).divide(gcd);
				y=y.multiply(spd.y).divide(gcd);
			}
		}
		
//		public long gcd(long x, long y) {
//			if(x==0) return y;
//			return gcd(y%x, x);
//		}
		
		@Override
		public String toString() {
			if(x==BigInteger.ZERO) return "0";
			String res =x+"/"+y;
			if(s<0) return "-"+res;
			return res;
			
		}
	}
	
	static class S{
		public int p;
		public int r;
		public S(int p_, int r_) {
			p=p_;
			r=r_;
		}
	}

}