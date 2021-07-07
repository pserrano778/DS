require('./ProductoBicicleta.rb');
require('./ProductoCarrera.rb');
require('./CarreraCarretera.rb')
require('./CarreraMontania.rb')
require('./BicicletaCarretera.rb')
require('./BicicletaMontania')

public
class FactoriaDeportePrototype
  @@TIPOPROTOTIPOS = ["carretera", "montania"] #Tipos de Prototipos

	# @ReturnType void
	public
	def crearCarrera(nbicis) #Crea un prototipo de carrera
    carrera = @carrera.clone #Clona el objeto carrera
    carrera.inicializarCarrera(nbicis, self) #Lo inicializa con un numero de bicis que participan en la carrera
    
    return carrera
	end

	# @ReturnType void
	public
	def crearBicicleta()
    return @bicicleta.clone #Clona el objeto bicicleta
	end

	public
	def initialize(tipo)
		# @AttributeType ProductoBicicleta
		# # @AssociationType ProductoBicicleta
		@bicicleta
		# @AttributeType ProductoCarrera
		# # @AssociationType ProductoCarrera
		@carrera
    
		if tipo == @@TIPOPROTOTIPOS[0] #Prototipos de tipo "carrera"
      @carrera = CarreraCarretera.new
      @bicicleta = BicicletaCarretera.new
    else tipo == @@TIPOPROTOTIPOS[1] #Prototipos de tipo "montania"
      @carrera = CarreraMontania.new
      @bicicleta = BicicletaMontania.new
    end
	end
  
  public
  def self.getTipos()
    return @@TIPOPROTOTIPOS
  end
end
