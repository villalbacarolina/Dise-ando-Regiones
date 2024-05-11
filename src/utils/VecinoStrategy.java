package utils;

import java.util.List;

@FunctionalInterface
public interface VecinoStrategy {
    List<Integer> obtenerVecinos(int locationId);
}