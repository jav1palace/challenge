package root.business;

import org.json.JSONObject;

import root.model.Cube;

public class Services {

	public JSONObject intersect(Cube cube1, Cube cube2) {

		double result = 1;

		result = (cube1.getMin().getX() < cube2.getMin().getX()) ? cube1
				.getIntersectedVolume(cube2) : cube2
				.getIntersectedVolume(cube1);

		JSONObject jsonObject = new JSONObject();
		boolean intersected = (result != 0) ? true : false;

		jsonObject.put("intersect", intersected);
		jsonObject.put("sharedVolume", result);

		return jsonObject;

	}
}
