#include "../include/Equipo.h"

/*************************************************************************/
// Constructor con argumentos (Bus, Disco y Tarjeta)
/*************************************************************************/
Equipo::Equipo(Bus unBus, Disco unDisco, Tarjeta unaTarjeta) {
	bus = unBus;
	disco = unDisco;
	tarjeta = unaTarjeta;
}

/*************************************************************************/
// Hace que el visitante visite cada elemento
/*************************************************************************/
string Equipo::getInformacion(VisitanteEquipo* visitante, Cliente* cliente) {
	bus.accept(visitante);
	disco.accept(visitante);
	tarjeta.accept(visitante);

	return (*visitante).getInformacion(cliente);
}
