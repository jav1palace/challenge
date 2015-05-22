package root.infrastructure;

import root.business.Services;

public class Factories {
	private static Services services = null;

	public static Services getServices() {
		if (services == null)
			services = new Services();
		return services;
	}
}
