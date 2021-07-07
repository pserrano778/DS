require('./ProductoBicicleta.rb');

public
class BicicletaCarretera < ProductoBicicleta
  
  public
  def toString
    super + " Tipo: Carretera"
  end

	public
	def initialize()
    #Empty		
	end
end
