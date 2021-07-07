#include "../include/VisitantePrecio.h"

/*************************************************************************/
// Constructor (establece a 0 el precio acumulado)
/*************************************************************************/
VisitantePrecio::VisitantePrecio() {
	precioTotal = 0.0;
}

/*************************************************************************/
// Una vez el visitante termina su visita devuelve el precio (string) y 
// lo establece a 0 para otra futura visita
/*************************************************************************/
string VisitantePrecio::getInformacion() {
	string precioTotalStr = "Precio del equipo: " + to_string(precioTotal);
	precioTotal = 0.0; //Se establece a 0 para una futura visita
	return precioTotalStr;
}

/*************************************************************************/
// Visita un bus para obtener su precio y acumularlo
/*************************************************************************/
void VisitantePrecio::visitarBus(Bus bus) {
	precioTotal = precioTotal + bus.getPrecio();
}

/*************************************************************************/
// Visita un disco para obtener su precio y acumularlo
/*************************************************************************/
void VisitantePrecio::visitarDisco(Disco disco) {
	precioTotal = precioTotal + disco.getPrecio();
}

/*************************************************************************/
// Visita una tarjeta para obtener su precio y acumularlo
/*************************************************************************/
void VisitantePrecio::visitarTarjeta(Tarjeta tarjeta) {
	precioTotal = precioTotal + tarjeta.getPrecio();
}