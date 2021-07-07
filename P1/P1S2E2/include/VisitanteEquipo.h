#ifndef __Visitante_equipo__
#define __Visitante_equipo__

#include <string>
#include "./Cliente.h"

using namespace std;

class Bus;
class Disco;
class Tarjeta;

class VisitanteEquipo
{
public:
    VisitanteEquipo();

    //Obtener la informacion acumulada por el visitante aplicando el descuento del cliente
    virtual string getInformacion(Cliente* cliente)=0;
    
    // Visitar Bus
    virtual void visitarBus(Bus bus)=0;

    // Visitar Disco
    virtual void visitarDisco(Disco disco)=0;

    // Visitar Tarjeta
    virtual void visitarTarjeta(Tarjeta tarjeta)=0;
};

#endif
