require('./ProductoCarrera.rb');

public
class CarreraMontania < ProductoCarrera

	# @ReturnType String
	public
	def toString()
		super + "\nTipo: Montania\nPorcentaje de retirada: " + self.porcentajeRetirada.to_s + "%"
	end

	public
	def initialize()
    super(20)
	end
end
