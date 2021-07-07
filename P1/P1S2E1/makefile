SRC = src
INC = include
OBJ = obj
BIN = bin
CXX = g++
LIB = lib
CPPFLAGS = -Wall -g -I$(INC) -std=c++11


all: $(BIN)/Cliente 


# ************ Compilación de módulos ************

# ************ Cliente ************
$(BIN)/Cliente: $(OBJ)/Cliente.o $(OBJ)/VisitanteEquipo.o $(OBJ)/VisitantePrecio.o $(OBJ)/VisitantePrecioDetalle.o $(OBJ)/ComponenteEquipo.o $(OBJ)/Bus.o $(OBJ)/Disco.o $(OBJ)/Tarjeta.o $(OBJ)/Equipo.o
	$(CXX) $(CPPFLAGS) $(OBJ)/Cliente.o $(OBJ)/VisitanteEquipo.o $(OBJ)/VisitantePrecio.o $(OBJ)/VisitantePrecioDetalle.o $(OBJ)/ComponenteEquipo.o $(OBJ)/Bus.o $(OBJ)/Disco.o $(OBJ)/Tarjeta.o $(OBJ)/Equipo.o -o $(BIN)/Cliente

$(OBJ)/Cliente.o : $(SRC)/Cliente.cpp $(INC)/Equipo.h $(INC)/VisitanteEquipo.h $(INC)/VisitantePrecio.h $(INC)/VisitantePrecioDetalle.h $(INC)/Bus.h $(INC)/Disco.h $(INC)/Tarjeta.h
	$(CXX) -c $(CPPFLAGS) $(SRC)/Cliente.cpp -o $(OBJ)/Cliente.o

# ************ Equipo ************
$(OBJ)/Equipo.o : $(SRC)/Equipo.cpp $(INC)/Equipo.h $(INC)/VisitanteEquipo.h $(INC)/Bus.h $(INC)/Disco.h $(INC)/Tarjeta.h
	$(CXX) -c $(CPPFLAGS) $(SRC)/Equipo.cpp -o $(OBJ)/Equipo.o

# ************ ComponenteEquipo ************
$(OBJ)/ComponenteEquipo.o : $(SRC)/ComponenteEquipo.cpp $(INC)/ComponenteEquipo.h $(INC)/VisitanteEquipo.h
	$(CXX) -c $(CPPFLAGS) $(SRC)/ComponenteEquipo.cpp -o $(OBJ)/ComponenteEquipo.o

# ************ Componentes ************

$(OBJ)/Bus.o : $(SRC)/Bus.cpp $(INC)/Bus.h $(INC)/ComponenteEquipo.h $(INC)/VisitanteEquipo.h
	$(CXX) -c $(CPPFLAGS) $(SRC)/Bus.cpp -o $(OBJ)/Bus.o

$(OBJ)/Disco.o : $(SRC)/Disco.cpp $(INC)/Disco.h $(INC)/ComponenteEquipo.h $(INC)/VisitanteEquipo.h
	$(CXX) -c $(CPPFLAGS) $(SRC)/Disco.cpp -o $(OBJ)/Disco.o

$(OBJ)/Tarjeta.o : $(SRC)/Tarjeta.cpp $(INC)/Tarjeta.h $(INC)/ComponenteEquipo.h $(INC)/VisitanteEquipo.h
	$(CXX) -c $(CPPFLAGS) $(SRC)/Tarjeta.cpp -o $(OBJ)/Tarjeta.o

# ************ Visitante ************
$(OBJ)/VisitanteEquipo.o : $(SRC)/VisitanteEquipo.cpp $(INC)/VisitanteEquipo.h
	$(CXX) -c $(CPPFLAGS) $(SRC)/VisitanteEquipo.cpp -o $(OBJ)/VisitanteEquipo.o

$(OBJ)/VisitantePrecio.o : $(SRC)/VisitantePrecio.cpp $(INC)/VisitantePrecio.h  $(INC)/VisitanteEquipo.h $(INC)/Bus.h $(INC)/Disco.h $(INC)/Tarjeta.h
	$(CXX) -c $(CPPFLAGS) $(SRC)/VisitantePrecio.cpp -o $(OBJ)/VisitantePrecio.o

$(OBJ)/VisitantePrecioDetalle.o : $(SRC)/VisitantePrecioDetalle.cpp $(INC)/VisitantePrecioDetalle.h  $(INC)/VisitanteEquipo.h $(INC)/Bus.h $(INC)/Disco.h $(INC)/Tarjeta.h
	$(CXX) -c $(CPPFLAGS) $(SRC)/VisitantePrecioDetalle.cpp -o $(OBJ)/VisitantePrecioDetalle.o

# ************ Limpieza ************
clean :
	-rm $(OBJ)/* $(SRC)/*~ $(INC)/*~ ./*~

mrproper : clean
	-rm $(BIN)/* -R $(DOC)
