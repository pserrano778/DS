require('./ProductoBicicleta.rb');

public
class BicicletaMontania < ProductoBicicleta
  
  public
  def toString
    super + " Tipo: Montania"
  end

	public
	def initialize()
		#Empty
	end
end
