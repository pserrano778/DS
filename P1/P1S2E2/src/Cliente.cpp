#include "../include/Cliente.h"

Cliente::Cliente(){
    descuento = 0;
}

int Cliente::getDescuento() const{
    return descuento;
}

void Cliente::setDescuento (int unDescuento) {
    descuento = unDescuento;
}