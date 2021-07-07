#ifndef __Componente_equipo__
#define __Componente_equipo__

#include "./VisitanteEquipo.h"
#include <string>

using namespace std;

class ComponenteEquipo
{
private:
    double precio;
    string nombre;
public:
    ComponenteEquipo();
    ComponenteEquipo(double precioComp, string nombreComp);

    double getPrecio() const;
    void setPrecio(double precioComp);
    string getNombre() const;
    void setNombre(string nombreComp);

    //Metodo virtual que implementaran las clases hijas
    virtual void accept(VisitanteEquipo* visitante)=0;
};
#endif