package utils;

public enum Argentina {
	JUJUY(0),
	SALTA(1),
	CATAMARCA(2),
	TUCUMAN(3),
	SANTIAGO_DEL_ESTERO(4),
	CORDOBA(5),
	SANTA_FE(6), 
	BUENOS_AIRES(7),
	CABA(8),
	LA_PAMPA(9),
	SAN_LUIS(10),
    LA_RIOJA(11),
    SAN_JUAN(12),
    MENDOZA(13),
    NEUQUEN(14),
    RIO_NEGRO(15),
    CHUBUT(16),
    SANTA_CRUZ(17),
    TIERRA_DEL_FUEGO(18),
    FORMOSA(19),
    CHACO(20),
    CORRIENTES(21),
    MISIONES(22),
    ENTRE_RIOS(23);

    private final int value;

    Argentina(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
    
    public static Argentina getProvinciaPorNumero(int numero) {
        for (Argentina provincia : Argentina.values()) {
            if (provincia.getValue() == numero) {
                return provincia;
            }
        }
        return null;  // Devuelve null si no se encuentra ninguna provincia con ese número
    }
}
