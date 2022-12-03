package datos;

import java.time.LocalDate;

public class Localidad extends Lugar {

	private String codPostal;
	private boolean cumplirCuarentena;
	public Localidad() {
		super();
	}
	public Localidad(String lugar, String codPostal, boolean cumplirCuarentena) {
		super(lugar);
		this.codPostal = codPostal;
		this.cumplirCuarentena = cumplirCuarentena;
	}
	public String getCodPostal() {
		return codPostal;
	}
	public void setCodPostal(String codPostal) {
		this.codPostal = codPostal;
	}
	public boolean isCumplirCuarentena() {
		return cumplirCuarentena;
	}
	public void setCumplirCuarentena(boolean cumplirCuarentena) {
		this.cumplirCuarentena = cumplirCuarentena;
	}
	@Override
	public String toString() {
		return "Localidad [idLugar=" + idLugar + ", lugar=" + lugar + ", codPostal=" + codPostal
				+ ", cumplirCuarentena=" + cumplirCuarentena + "]";
	}
	
	// FechaInicio: fecha del permiso
	// FechaVencimiento: Si dura 1 día, al otro día de la fecha inicio vence. Se le suma la cantidad de dias
	// Retorna true si 'dia'  está entre esas 2 fechas
	@Override
	public boolean ingresoHabilitado(Permiso permiso, LocalDate dia) {
		LocalDate fechaInicio = permiso.getFecha();
		LocalDate fechaVencimiento = fechaInicio.plusDays(permiso.getCantDias());
		return dia.isAfter(fechaInicio.minusDays(1)) && dia.isBefore(fechaVencimiento.plusDays(1));
	}
	
	
	
}
