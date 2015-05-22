package root.model;

public class Cube {
	private Point center, min, max;
	private double size;

	public Cube() {
		this.center = new Point();
		this.min = new Point();
		this.max = new Point();

	}

	public Cube(double x, double y, double z, double size) {
		this.center = new Point(x, y, z);
		this.size = size;
		buildMinMax();
	}

	public Cube(Point point, double size) {
		this.center = point;
		this.size = size;
		buildMinMax();
	}

	// Build the maximum's cube apex from center point
	private void buildMax() {
		this.max = new Point(center.getX() + (size / 2), center.getY()
				+ (size / 2), center.getZ() + (size / 2));
	}

	// Build the minimum's cube apex from center point
	private void buildMin() {
		this.min = new Point(center.getX() - (size / 2), center.getY()
				- (size / 2), center.getZ() - (size / 2));
	}

	// Build min and max apex
	public void buildMinMax() {
		buildMax();
		buildMin();
	}

	// Returns the volume shared
	private double calculateVolume(Point extraMin, Point extraMax) {
		double volume = 1;
		volume = volume * Math.max(0, extraMin.getX() - extraMax.getX());
		volume = volume * Math.max(0, extraMin.getY() - extraMax.getY());
		volume = volume * Math.max(0, extraMin.getZ() - extraMax.getZ());

		return volume;
	}

	public Point getCenter() {
		return this.center;
	}

	public double getIntersectedVolume(Cube cube2) {
		Point extraMin, extraMax;

		extraMin = this.max.min(cube2.getMax());
		extraMax = this.min.max(cube2.getMin());

		return calculateVolume(extraMin, extraMax);
	}

	public Point getMax() {
		return this.max;
	}

	public Point getMin() {
		return this.min;
	}

	public double getSize() {
		return this.size;
	}

	public void setCenter(Point center) {
		this.center = center;
	}

	public void setMax(Point max) {
		this.max = max;
	}

	public void setMin(Point min) {
		this.min = min;
	}

	public void setSize(double size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return new StringBuffer(center.toString()).append(" size : ")
				.append(this.size).toString();

	}
}
