require('./FactoriaDeportePrototype.rb');

public
class Cliente
  
	# @ParamType args String*
	# @ReturnType void
	public
	def self.main
    nbicis = rand(10..20) #Numero de bicis que participan en la carrera
    opciones = FactoriaDeportePrototype.getTipos #Tipos de protoripos que ofrece la Factoria ("carretera" y "montania")
    
    #Crea una carrera de carretera y la inicia
    @@factoria = FactoriaDeportePrototype.new(opciones[0])
    @@carrera = @@factoria.crearCarrera(nbicis)
    @@carrera.iniciarCarrera

    #Crea una carrera de montania y la inicia
    @@factoria = FactoriaDeportePrototype.new(opciones[1])
    @@carrera = @@factoria.crearCarrera(nbicis)
    @@carrera.iniciarCarrera
	end

	public
	def initialize()
    #empty
	end
end

Cliente.main