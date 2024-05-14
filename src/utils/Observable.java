package utils;

public interface Observable {
	void agregarObserver(String evento, Observer observer);

	void notificar(String evento, Object dto);
}
