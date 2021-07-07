#ifndef __Visitante_equipo__
#define __Visitante_equipo__

#include <string>

using namespace std;

class Bus;
class Disco;
class Tarjeta;

class VisitanteEquipo
{
public:
    VisitanteEquipo();

    //Obtener la informacion acumulada por el visitante
    virtual string getInformacion()=0;
    
    // Visitar Bus
    virtual void visitarBus(Bus bus)=0;

    // Visitar Disco
    virtual void visitarDisco(Disco disco)=0;

    // Visitar Tarjeta
    virtual void visitarTarjeta(Tarjeta tarjeta)=0;
};

#endif