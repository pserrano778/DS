#ifndef __Visitante_precio_detalle__
#define __Visitante_precio_detalle__

#include "./VisitanteEquipo.h"
#include "./Bus.h"
#include "./Disco.h"
#include "./Tarjeta.h"
#include "./Cliente.h"
#include<vector>
#include<utility>
#include <string>

using namespace std;

class VisitantePrecioDetalle : public VisitanteEquipo
{
private:
    vector<pair<string, double> > precioDetalle;

public:
    VisitantePrecioDetalle();

    //Obtiene la informacionDetallada acumulada aplicando el descuento del cliente
    string getInformacion(Cliente* cliente)  override;
    
    // Visitar Bus
    void visitarBus(Bus bus) override;

    // Visitar Disco
    void visitarDisco(Disco disco) override;

    // Visitar Tarjeta
    void visitarTarjeta(Tarjeta tarjeta) override;
};

#endif
