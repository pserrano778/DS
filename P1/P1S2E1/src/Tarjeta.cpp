#include "../include/Tarjeta.h"

Tarjeta::Tarjeta(){}
/*************************************************************************/
// Constructor con argumentos (precio y nombre del componente)
/*************************************************************************/
Tarjeta::Tarjeta(double precioComp, string nombreComp) : ComponenteEquipo(precioComp, nombreComp){}

/*************************************************************************/
// Metodo accept para que el visitante visite esta Tarjeta
/*************************************************************************/
void Tarjeta::accept(VisitanteEquipo* visitante) {
	(*visitante).visitarTarjeta(*this);
}