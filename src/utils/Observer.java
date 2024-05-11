package utils;

@FunctionalInterface
public interface Observer {
	void dotClicked(String dotName, int id);
}
