package dam.tema9.concesionario;

import org.eclipse.jdt.annotation.NonNull;

/**
 * Clase para ordenar por columnas
 * @author cumpli
 * @version 1.0
 */
public class ColumOrder {
	private int index;
	private String orden;

	public ColumOrder(@NonNull int index, String orden) {
		this.index = index;
		this.orden = orden;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getOrden() {
		return orden;
	}

	public void setOrden(String orden) {
		this.orden = orden;
	}

}
