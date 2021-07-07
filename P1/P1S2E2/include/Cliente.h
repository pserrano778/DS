#ifndef __Cliente__
#define __Cliente__

using namespace std;

class Cliente{
private:
    int descuento;
public:
    Cliente();
    //Devuelve el descuento
    int getDescuento() const;
protected:
    void setDescuento (int unDescuento);
};

#endif
