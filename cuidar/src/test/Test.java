package test;

import java.time.LocalDate;
import java.util.logging.Level;
import datos.Ubicacion;
import datos.Localidad;
import datos.Permiso;
import negocio.LugarABM;
import negocio.PermisoABM;

public class Test {

	public static void main(String[] args) {
		
		java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);
		
		LugarABM lugarAbm = new LugarABM();
		PermisoABM permisoAbm = new PermisoABM();
		
		System.out.println("----- 1) Traer permiso id=4 -----\n");
		
		Permiso permiso = permisoAbm.traerPermiso(4);
		System.out.println(permiso + "\nPersona: " + permiso.getPersona().getNombre() + " " + permiso.getPersona().getApellido() + "\nRodado: " + permiso.getRodado().getVehiculo());
		
		System.out.println("\n----- 2)Traer objeto Localidad con todos sus atributos id=3 -----\n");
		
		Localidad localidad = lugarAbm.traerLocalidad(3);
		System.out.println(localidad);
		
		System.out.println("\n----- 3) ¿El lugar id=3 el día 2021-05-12 tiene el ingreso habilitado para el permiso id=4? -----\n");

		System.out.println("Ingreso habilitado = " + localidad.ingresoHabilitado(permisoAbm.traerPermiso(4), LocalDate.of(2021, 5, 12)));
	
		System.out.println("\n----- 4) ¿El lugar id=3 el día 2021-05-20 tiene el ingreso habilitado para el permiso id=4? -----\n");
		
		System.out.println("Ingreso habilitado = " + localidad.ingresoHabilitado(permisoAbm.traerPermiso(4), LocalDate.of(2021, 5, 20)));
	
		System.out.println("\n----- 5) ¿El lugar id=3 el día 2021-05-25 tiene el ingreso habilitado para el permiso id=4? -----\n");
		
		System.out.println("Ingreso habilitado = " + localidad.ingresoHabilitado(permisoAbm.traerPermiso(4), LocalDate.of(2021, 5, 25)));
	
		System.out.println("\n----- 6) Traer objeto Ubicacion con todos sus atributos id=4 -----\n");
		
		Ubicacion ubicacion = lugarAbm.traerUbicacion(4);
		System.out.println(ubicacion);
	
		System.out.println("\n----- 7) ¿El lugar id=4 el día 2021-04-30 tiene el ingreso habilitado para el permiso id=3? -----\n");
	
		System.out.println("Ingreso habilitado = " + ubicacion.ingresoHabilitado(permisoAbm.traerPermiso(3), LocalDate.of(2021, 4, 30)));
		
		System.out.println("\n----- 8) ¿El lugar id=4 el día 2021-03-31 tiene el ingreso habilitado para el permiso id=3? -----\n");
	
		System.out.println("Ingreso habilitado = " + ubicacion.ingresoHabilitado(permisoAbm.traerPermiso(3), LocalDate.of(2021, 3, 31)));
		
	}

}
