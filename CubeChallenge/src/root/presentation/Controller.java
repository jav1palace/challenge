package root.presentation;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.json.JSONObject;

import root.infrastructure.Factories;
import root.model.Cube;

@ManagedBean(name = "controller")
@RequestScoped
public class Controller {

	private Cube cube1 = new Cube();
	private Cube cube2 = new Cube();

	private JSONObject info;

	public void calculate() {
		this.cube1.buildMinMax();
		this.cube2.buildMinMax();

		this.info = Factories.getServices().intersect(cube1, cube2);
	}

	public Cube getCube1() {
		return this.cube1;
	}

	public Cube getCube2() {
		return this.cube2;
	}

	public JSONObject getInfo() {
		return this.info;
	}

	public void setCube1(Cube cube1) {
		this.cube1 = cube1;
	}

	public void setCube2(Cube cube2) {
		this.cube2 = cube2;
	}

	public void setInfo(JSONObject info) {
		this.info = info;
	}
}
