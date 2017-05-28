package aplicaciones;

import java.util.Comparator;

public class OrdenaPesos implements Comparator<Aplicacion> {

	@Override
	public int compare(Aplicacion app1, Aplicacion app2) {
		if ((app1.getCantidad() < app2.getCantidad())
				|| (app1.getCantidad() == app2.getCantidad() && app1.getPeso() > app2.getPeso())
				|| (app1.getCantidad() == app2.getCantidad() && app1.getPeso() == app2.getPeso()
						&& app1.getPosicion() < app2.getPosicion())) {
			return -1;
		}
		return 0;
	}

}
