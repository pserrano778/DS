SRC = src
INC = include
OBJ = obj
BIN = bin
CXX = g++
LIB = lib
CPPFLAGS = -Wall -g -I$(INC) -std=c++11
DOC = documentacion


all: $(BIN)/main


# ************ Compilación de módulos ************

# ************ Main ************
$(BIN)/main: $(OBJ)/main.o $(OBJ)/VisitanteEquipo.o $(OBJ)/VisitantePrecio.o $(OBJ)/VisitantePrecioDetalle.o $(OBJ)/ComponenteEquipo.o $(OBJ)/Bus.o $(OBJ)/Disco.o $(OBJ)/Tarjeta.o $(OBJ)/Equipo.o  $(OBJ)/Cliente.o  $(OBJ)/Estudiante.o  $(OBJ)/Mayorista.o
	$(CXX) $(CPPFLAGS) $(OBJ)/main.o $(OBJ)/VisitanteEquipo.o $(OBJ)/VisitantePrecio.o $(OBJ)/VisitantePrecioDetalle.o $(OBJ)/ComponenteEquipo.o $(OBJ)/Bus.o $(OBJ)/Disco.o $(OBJ)/Tarjeta.o $(OBJ)/Equipo.o  $(OBJ)/Cliente.o  $(OBJ)/Estudiante.o  $(OBJ)/Mayorista.o -o $(BIN)/main

$(OBJ)/main.o : $(SRC)/main.cpp $(INC)/Equipo.h $(INC)/VisitanteEquipo.h $(INC)/VisitantePrecio.h $(INC)/VisitantePrecioDetalle.h $(INC)/Bus.h $(INC)/Disco.h $(INC)/Tarjeta.h $(INC)/Cliente.h $(INC)/Estudiante.h $(INC)/Mayorista.h
	$(CXX) -c $(CPPFLAGS) $(SRC)/main.cpp -o $(OBJ)/main.o

# ************ Cliente ***********
$(OBJ)/Cliente.o : $(SRC)/Cliente.cpp $(INC)/Cliente.h
	$(CXX) -c $(CPPFLAGS) $(SRC)/Cliente.cpp -o $(OBJ)/Cliente.o

# ************ Estudiante ***********
$(OBJ)/Estudiante.o : $(SRC)/Estudiante.cpp $(INC)/Estudiante.h
	$(CXX) -c $(CPPFLAGS) $(SRC)/Estudiante.cpp -o $(OBJ)/Estudiante.o

# ************ Mayorista ***********
$(OBJ)/Mayorista.o : $(SRC)/Mayorista.cpp $(INC)/Mayorista.h
	$(CXX) -c $(CPPFLAGS) $(SRC)/Mayorista.cpp -o $(OBJ)/Mayorista.o

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
$(OBJ)/VisitanteEquipo.o : $(SRC)/VisitanteEquipo.cpp $(INC)/VisitanteEquipo.h $(INC)/Cliente.h
	$(CXX) -c $(CPPFLAGS) $(SRC)/VisitanteEquipo.cpp -o $(OBJ)/VisitanteEquipo.o

$(OBJ)/VisitantePrecio.o : $(SRC)/VisitantePrecio.cpp $(INC)/VisitantePrecio.h  $(INC)/VisitanteEquipo.h $(INC)/Bus.h $(INC)/Disco.h $(INC)/Tarjeta.h $(INC)/Cliente.h
	$(CXX) -c $(CPPFLAGS) $(SRC)/VisitantePrecio.cpp -o $(OBJ)/VisitantePrecio.o

$(OBJ)/VisitantePrecioDetalle.o : $(SRC)/VisitantePrecioDetalle.cpp $(INC)/VisitantePrecioDetalle.h  $(INC)/VisitanteEquipo.h $(INC)/Bus.h $(INC)/Disco.h $(INC)/Tarjeta.h $(INC)/Cliente.h
	$(CXX) -c $(CPPFLAGS) $(SRC)/VisitantePrecioDetalle.cpp -o $(OBJ)/VisitantePrecioDetalle.o

# ************ Limpieza ************
clean :
	-rm $(OBJ)/* $(SRC)/*~ $(INC)/*~ ./*~

mrproper : clean
	-rm $(BIN)/* -R $(DOC)
