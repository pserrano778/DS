#ifndef __Tarjeta__
#define __Tarjeta__

#include "./VisitanteEquipo.h"
#include "./ComponenteEquipo.h"
#include <string>

using namespace std;

class Tarjeta : public ComponenteEquipo
{

public:
    Tarjeta();
    Tarjeta(double precioComp, string nombreComp);
    
    //Metodo de la clase padre que se sobreescribe
    void accept(VisitanteEquipo* visitante) override;
};
#endif