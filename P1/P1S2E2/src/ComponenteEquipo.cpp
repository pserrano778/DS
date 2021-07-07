#include "../include/ComponenteEquipo.h"

ComponenteEquipo::ComponenteEquipo(){}
/*************************************************************************/
// Constructor con argumentos (precio y nombre del componente)
/*************************************************************************/
ComponenteEquipo::ComponenteEquipo(double precioComp, string nombreComp)
{
    precio = precioComp;
    nombre = nombreComp;
}

/*************************************************************************/
// Devuelve el precio de un componente
/*************************************************************************/
double ComponenteEquipo::getPrecio() const {
	return precio;
}

/*************************************************************************/
// Actualiza el precio de un Componente
/*************************************************************************/
void ComponenteEquipo::setPrecio(double precioComp) {
	precio = precioComp;
}

/*************************************************************************/
// Devuelve el nombre de un componente
/*************************************************************************/
string ComponenteEquipo::getNombre() const {
	return nombre;
}

/*************************************************************************/
// Actualiza el nombre de un componente
/*************************************************************************/
void ComponenteEquipo::setNombre(string nombreComp) {
	nombre = nombreComp;
}