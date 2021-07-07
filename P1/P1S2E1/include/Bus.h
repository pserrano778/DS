#ifndef __Bus__
#define __Bus__

#include "./VisitanteEquipo.h"
#include "./ComponenteEquipo.h"
#include <string>

using namespace std;

class Bus : public ComponenteEquipo
{

public:
    Bus();
    Bus(double precioComp, string nombreComp);
    
    //Metodo de la clase padre que se sobreescribe
    void accept(VisitanteEquipo* visitante) override;
};

#endif