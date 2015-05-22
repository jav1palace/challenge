package root.model;

public class Point {
	private double x, y, z;

	public Point() {

	}

	public Point(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getZ() {
		return z;
	}

	public Point max(Point point) {
		return new Point(Math.max(point.getX(), x), Math.max(point.getY(), y),
				Math.max(point.getZ(), z));
	}

	public Point min(Point point) {
		return new Point(Math.min(point.getX(), x), Math.min(point.getY(), y),
				Math.min(point.getZ(), z));
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

	public void setZ(double z) {
		this.z = z;
	}

	@Override
	public String toString() {
		return new StringBuffer(" x : ").append(this.x).append(" y : ")
				.append(this.y).append(" z : ").append(this.z).toString();
	}
}
