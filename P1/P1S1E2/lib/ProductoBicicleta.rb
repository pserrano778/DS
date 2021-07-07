public
class ProductoBicicleta

	# @ReturnType int
	public
	def getID()
		return @iD
	end

	# @ParamType iD int
	# @ReturnType void
	public
	def setID(iD)
		@iD = iD
	end

	# @ReturnType String
	public
	def toString()
		return "Bicicleta " + @iD.to_s
	end

	# @ReturnType ProductoBicicleta
	public
	def clone()
    return Marshal.load(Marshal.dump(self)) #Copia Profunda
	end
  
  public
  def comienzaCarrera(segundoRetirada)
    for i in (0..segundoRetirada - 1)
      puts toString + " en el segundo " + i.to_s + "\n"
      
      sleep(1) #Duerme 1 segundo
    end
    
    puts toString + " se retira en el segundo " + segundoRetirada.to_s + "\n"
  end

	public
	def initialize()
    if(self.class == ProductoBicicleta) #Si se está intentando instanciar ProductoBicicleta
      raise "ProductoBicicleta no debe ser instanciado"
    else
      # @AttributeType int
      @iD
    end
	end
end
