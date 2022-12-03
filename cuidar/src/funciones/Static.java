package funciones;

import java.time.LocalDate;

public class Static {

	public static String imprimirFecha(LocalDate fecha) {
		return fecha.getDayOfMonth() + "/" + fecha.getMonthValue() + "/" + fecha.getYear();
	}
	
	public static String imprimirBoolean(boolean dato) {
		String texto = "No";
		if(dato) texto = "Sí";
		return texto;
	}
	
}
