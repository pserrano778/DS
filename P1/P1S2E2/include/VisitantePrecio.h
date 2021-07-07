#ifndef __Visitante_precio__
#define __Visitante_precio__

#include "./VisitanteEquipo.h"
#include "./Bus.h"
#include "./Disco.h"
#include "./Tarjeta.h"
#include "./Cliente.h"
#include <string>

using namespace std;

class VisitantePrecio : public  VisitanteEquipo
{
private:
    double precioTotal;

public:

    VisitantePrecio();

    //Devuelve el precioTotal acumulado aplicando el descuento del cliente
    string getInformacion(Cliente* cliente) override;
    
    // Visitar Bus
    void visitarBus(Bus bus) override;

    // Visitar Disco
    void visitarDisco(Disco disco) override;

    // Visitar Tarjeta
    void visitarTarjeta(Tarjeta tarjeta) override;
};

#endif
