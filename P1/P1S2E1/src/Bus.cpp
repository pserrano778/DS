#include "../include/Bus.h"

Bus::Bus(){}
/*************************************************************************/
// Constructor con argumentos (precio y nombre del componente)
/*************************************************************************/
Bus::Bus(double precioComp, string nombreComp) : ComponenteEquipo(precioComp, nombreComp){}


/*************************************************************************/
// Metodo accept para que el visitante visite este Bus
/*************************************************************************/
void Bus::accept(VisitanteEquipo* visitante) {
	(*visitante).visitarBus(*this);
}