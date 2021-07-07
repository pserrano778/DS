#ifndef __Equipo__
#define __Equipo__

#include "./Bus.h"
#include "./Disco.h"
#include "./Tarjeta.h"
#include "./VisitanteEquipo.h"
#include <string>

using namespace std;

class Equipo
{
private:
    Bus bus;
    Disco disco;
    Tarjeta tarjeta;

public:
    Equipo(Bus unBus, Disco unDisco, Tarjeta unaTarjeta);

    //Metodo para que el visitente visite cada componente
    string getInformacion(VisitanteEquipo* visitante, Cliente* cliente);
};

#endif