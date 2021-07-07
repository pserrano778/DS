require('./ProductoCarrera.rb');

public
class CarreraCarretera < ProductoCarrera

	# @ReturnType String
	public
	def toString()
	  super + "\nTipo: Carretera\nPorcentaje de retirada: " + self.porcentajeRetirada.to_s + "%"
	end

	public
	def initialize()
		super(10)
	end
end
