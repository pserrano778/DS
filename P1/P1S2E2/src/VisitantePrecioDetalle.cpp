#include "../include/VisitantePrecioDetalle.h"

/*************************************************************************/
// Constructor (Inicializa el vector)
/*************************************************************************/
VisitantePrecioDetalle::VisitantePrecioDetalle() {
	precioDetalle.resize(3);

	for (unsigned int i=0; i<precioDetalle.size(); i++){
		precioDetalle[i].first = "";
		precioDetalle[i].second = 0.0;
	}
}

/*************************************************************************/
// Una vez el visitante termina su visita devuelve el precio detallado
/*************************************************************************/
string VisitantePrecioDetalle::getInformacion(Cliente* cliente) {
	int descuento = (*cliente).getDescuento();
	string precioDetalleStr = "Precio del equipo en detalle aplicando descuento del " + to_string(descuento) +"%:\n";
	string componente = "";
	for (unsigned int i=0; i<precioDetalle.size(); i++){
		if (i==0){ //Bus
			componente = "Bus";
		}
		else if (i==1){ //Disco
			componente = "Disco";
		}
		else { //Tarjeta
			componente = "Tarjeta";
		}
		precioDetalleStr = precioDetalleStr + componente + ":\n\tNombre ---> " + precioDetalle[i].first + "\n\tPrecio ---> " + to_string(precioDetalle[i].second * (1.0 - (descuento/100.0))) + "\n";
	}
	return precioDetalleStr;
}

/*************************************************************************/
// Visita un bus para obtener su precio y acumularlo
/*************************************************************************/
void VisitantePrecioDetalle::visitarBus(Bus bus) {
	precioDetalle[0].first = bus.getNombre();
	precioDetalle[0].second = bus.getPrecio();
}

/*************************************************************************/
// Visita un disco para obtener su precio y acumularlo
/*************************************************************************/
void VisitantePrecioDetalle::visitarDisco(Disco disco) {
	precioDetalle[1].first = disco.getNombre();
	precioDetalle[1].second = disco.getPrecio();
}

/*************************************************************************/
// Visita una tarjeta para obtener su precio y acumularlo
/*************************************************************************/
void VisitantePrecioDetalle::visitarTarjeta(Tarjeta tarjeta) {
	precioDetalle[2].first = tarjeta.getNombre();
	precioDetalle[2].second = tarjeta.getPrecio();
}
