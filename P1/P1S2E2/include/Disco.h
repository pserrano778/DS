#ifndef __Disco__
#define __Disco__

#include "./VisitanteEquipo.h"
#include "./ComponenteEquipo.h"
#include <string>

using namespace std;

class Disco : public ComponenteEquipo
{

public:
    Disco();
    Disco(double precioComp, string nombreComp);

    //Metodo de la clase padre que se sobreescribe
    void accept(VisitanteEquipo* visitante) override;
};
#endif