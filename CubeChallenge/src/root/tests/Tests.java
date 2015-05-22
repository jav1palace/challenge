package root.tests;

import static org.junit.Assert.assertEquals;

import org.json.JSONObject;
import org.junit.Test;

import root.infrastructure.Factories;
import root.model.Cube;
import root.model.Point;

public class Tests {

	@Test
	public void testBorder() {

		double size1, size2;
		Point p1 = new Point(0, 0, 0);
		Point p2 = new Point(2, 2, 2);

		size1 = 1;
		size2 = 1;

		try {
			Cube cube1, cube2;
			cube1 = new Cube(p1, size1);
			cube2 = new Cube(p2, size2);
			JSONObject info = Factories.getServices().intersect(cube1, cube2);

			assertEquals(info.get("intersect"), false);
			assertEquals(info.get("sharedVolume"), 0.0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testInside() {

		double size1, size2;
		Point p1 = new Point(0, 0, 0);
		Point p2 = new Point(0, 0, 0);

		size1 = 1;
		size2 = 2;

		try {

			Cube cube1, cube2;
			cube1 = new Cube(p1, size1);
			cube2 = new Cube(p2, size2);
			JSONObject info = Factories.getServices().intersect(cube1, cube2);

			assertEquals(info.get("intersect"), true);
			assertEquals(info.get("sharedVolume"), 1.0);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testIntersect1() {

		double size1, size2;
		Point p1 = new Point(10, 10, 0);
		Point p2 = new Point(9, 9, 0);

		size1 = 5;
		size2 = 2;

		try {
			Cube cube1, cube2;
			cube1 = new Cube(p1, size1);
			cube2 = new Cube(p2, size2);
			JSONObject info = Factories.getServices().intersect(cube1, cube2);

			assertEquals(info.get("intersect"), true);
			assertEquals(info.get("sharedVolume"), 8.0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testIntersect2() {

		double size1, size2;
		Point p1 = new Point(9, 9, 0);
		Point p2 = new Point(10, 10, 0);

		size1 = 5;
		size2 = 2;

		try {
			Cube cube1, cube2;
			cube1 = new Cube(p1, size1);
			cube2 = new Cube(p2, size2);
			JSONObject info = Factories.getServices().intersect(cube1, cube2);

			assertEquals(info.get("intersect"), true);
			assertEquals(info.get("sharedVolume"), 8.0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testIntersect3() {

		double size1, size2;
		Point p1 = new Point(0, 0, 0);
		Point p2 = new Point(6, 6, 0);

		size1 = 10;
		size2 = 4;

		try {
			Cube cube1, cube2;
			cube1 = new Cube(p1, size1);
			cube2 = new Cube(p2, size2);
			JSONObject info = Factories.getServices().intersect(cube1, cube2);

			assertEquals(info.get("intersect"), true);
			assertEquals(info.get("sharedVolume"), 4.0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testIntersect4() {

		double size1, size2;
		Point p1 = new Point(6, 6, 0);
		Point p2 = new Point(0, 0, 0);

		size1 = 10;
		size2 = 4;

		try {
			Cube cube1, cube2;
			cube1 = new Cube(p1, size1);
			cube2 = new Cube(p2, size2);
			JSONObject info = Factories.getServices().intersect(cube1, cube2);

			assertEquals(info.get("intersect"), true);
			assertEquals(info.get("sharedVolume"), 4.0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
