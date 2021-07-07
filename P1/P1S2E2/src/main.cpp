#include "../include/Bus.h"
#include "../include/Disco.h"
#include "../include/Tarjeta.h"
#include "../include/VisitanteEquipo.h"
#include "../include/VisitantePrecio.h"
#include "../include/VisitantePrecioDetalle.h"
#include "../include/Equipo.h"
#include "../include/Cliente.h"
#include "../include/Estudiante.h"
#include "../include/Mayorista.h"
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

	VisitanteEquipo * visitantePrecio = new VisitantePrecio();
	VisitanteEquipo * visitantePrecioDetalle = new VisitantePrecioDetalle();

	Cliente* cliente = new Cliente();
	Cliente* estudiante = new Estudiante();
	Cliente* mayorista = new Mayorista();

	cout << "Equipo1 para Cliente normal " << endl;
	cout <<  equipo1.getInformacion(visitantePrecio, cliente) << endl;
	cout <<  equipo1.getInformacion(visitantePrecioDetalle, cliente) << endl;

	cout << "Equipo1 para Estudiante: " << endl;
	cout <<  equipo1.getInformacion(visitantePrecio, estudiante) << endl;
	cout <<  equipo1.getInformacion(visitantePrecioDetalle, estudiante) << endl;

	cout << "Equipo1 para Mayorista: " << endl;
	cout <<  equipo1.getInformacion(visitantePrecio, mayorista) << endl;
	cout <<  equipo1.getInformacion(visitantePrecioDetalle, mayorista) << endl;

    cout << endl << endl;

    cout << "Equipo2 para Cliente normal " << endl;
	cout <<  equipo2.getInformacion(visitantePrecio, cliente) << endl;
	cout <<  equipo2.getInformacion(visitantePrecioDetalle, cliente) << endl;

	cout << "Equipo2 para Estudiante: " << endl;
	cout <<  equipo2.getInformacion(visitantePrecio, estudiante) << endl;
	cout <<  equipo2.getInformacion(visitantePrecioDetalle, estudiante) << endl;

	cout << "Equipo2 para Mayorista: " << endl;
	cout <<  equipo2.getInformacion(visitantePrecio, mayorista) << endl;
	cout <<  equipo2.getInformacion(visitantePrecioDetalle, mayorista) << endl;

	return 0;
}
