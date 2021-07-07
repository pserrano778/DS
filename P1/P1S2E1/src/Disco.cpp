#include "../include/Disco.h"

Disco::Disco(){}
/*************************************************************************/
// Constructor con argumentos (precio y nombre del componente)
/*************************************************************************/
Disco::Disco(double precioComp, string nombreComp) : ComponenteEquipo(precioComp, nombreComp){}

/*************************************************************************/
// Metodo accept para que el visitante visite este Disco
/*************************************************************************/
void Disco::accept(VisitanteEquipo* visitante) {
	(*visitante).visitarDisco(*this);
}