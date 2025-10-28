package test;

public class Plot {
	private int depth;
	private int width;
	private int x;
	private int y; 
	
	public Plot() {
		this.depth = 1;
		this.width = 1;
		this.x = 0;
		this.y = 0;
	}
	public Plot(int x , int y, int width, int depth) {
		this.depth = depth;
		this.width = width;
		this.x = x;
		this.y = y; 
	}
	public Plot(Plot otherPlot) {
		this.depth = otherPlot.depth;
		this.width = otherPlot.width;
		this.x = otherPlot.x;
		this.y = otherPlot.y;
	}
	//Determines if the given plot is encompassed by (is contained by) this plot.
	public boolean encompasses(Plot plot) {
		int right1 = this.x + this.width; 
		int bottom1 = this.y + this.depth;
		
		int right2 = plot.x + plot.width;
		int bottom2 = plot.y +plot.depth;
		
		return (plot.x >= this.x) && (plot.y >= this.y) && (right2 <= right1) && (bottom2 <= bottom1);
	}
			
	//Determines if the given plot instance is overlapped by the current plot.
		public boolean overlaps(Plot plot) {
			int right1 = this.x + this.width; 
			int bottom1 = this.y + this.depth;
			
			int right2 = plot.x + plot.width;
			int bottom2 = plot.y +plot.depth;
			
			if( right1 <= plot.x || right2 <= this.x || bottom1 <= plot.y || bottom2 <= this.y ) {
				return false;
		    }
			return true; 
		}

	
	//Getter methods 
	public int getDepth() {
		return this.depth; 
	}
	public int getWidth() {
		return this.width; 
	}
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
	
	//Mutator Methods
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	//Represents a Plot object in the following String format.
	public String toString() {
		return x + "," + y + "," + width + "," + depth; 
	}

}
