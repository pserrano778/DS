#ifndef __Visitante_precio__
#define __Visitante_precio__

#include "./VisitanteEquipo.h"
#include "./Bus.h"
#include "./Disco.h"
#include "./Tarjeta.h"
#include <string>

using namespace std;

class VisitantePrecio : public  VisitanteEquipo
{
private:
    double precioTotal;

public:

    VisitantePrecio();

    //Devuelve el precioTotal acumulado
    string getInformacion() override;
    
    // Visitar Bus
    void visitarBus(Bus bus) override;

    // Visitar Disco
    void visitarDisco(Disco disco) override;

    // Visitar Tarjeta
    void visitarTarjeta(Tarjeta tarjeta) override;
};

#endif