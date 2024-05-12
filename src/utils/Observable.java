package utils;

public interface Observable {
	void addObserver(String event, Observer observer);
	void notify(String event, Object dto);
}
