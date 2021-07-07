#include "../include/Bus.h"
#include "../include/Disco.h"
#include "../include/Tarjeta.h"
#include "../include/VisitanteEquipo.h"
#include "../include/VisitantePrecio.h"
#include "../include/VisitantePrecioDetalle.h"
#include "../include/Equipo.h"
#include <iostream>

using namespace std;

int main() {
	Bus bus(100, "UnBus");
	Disco disco(170, "UnDisco");
	Tarjeta tarjeta(400, "UnaTarjeta");

	Bus bus2(200, "otroBus");
	Disco disco2(350, "otroDisco");
	Tarjeta tarjeta2(630, "otraTarjeta");

	Equipo equipo1(bus, disco, tarjeta);
    Equipo equipo2(bus2, disco2, tarjeta2);

	VisitanteEquipo* visitantePrecio = new VisitantePrecio();
	VisitanteEquipo* visitantePrecioDetalle = new VisitantePrecioDetalle();

	cout << "Equipo1" << endl;
	cout << equipo1.getInformacion(visitantePrecio) << endl;
	cout << equipo1.getInformacion(visitantePrecioDetalle) << endl;

	cout << "Equipo2" << endl;
	cout << equipo2.getInformacion(visitantePrecio) << endl;
	cout << equipo2.getInformacion(visitantePrecioDetalle) << endl;

	return 0;
}
