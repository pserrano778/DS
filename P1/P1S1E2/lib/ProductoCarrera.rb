require('./ProductoBicicleta.rb');

public
class ProductoCarrera
	# @AttributeType int
	private
	@@DURACION = 60
  
  attr_accessor :porcentajeRetirada
  attr_reader :bicisEnCarrera

	# @ReturnType ProductoCarrera
	public
	def clone()
		return Marshal.load(Marshal.dump(self)) #Copia Profunda
	end

	# @ReturnType int
	public
	def self.getDuracion()
		return @@DURACION
	end

	# @ParamType num int
	# @ReturnType int
	public
	def getIDBicicleta(num)
		return @bicisEnCarrera[num].getID
	end

	# @ReturnType int
	public
	def getPorcentajeRetirada()
		return @porcentajeRetirada
	end

	# @ReturnType ArrayList
	private
	def retiradaAntesDeTiempo
    bicis_retirar = []
    num_retirar = (@bicisEnCarrera.length*@porcentajeRetirada/100.0).round #Numero de bicis que se retiraran antes de tiempo
    
    for i in (0..num_retirar-1) do #Se inicializa a -1
      bicis_retirar << -1
    end
    
    retiradas = 0
    
    while retiradas < num_retirar #Mientras no se seleccionen num_retirar
      num_bici = rand(0..@bicisEnCarrera.length-1) #Se selecciona una bicicleta aleatoria
      retirada = false
      indice = 0
      
      while !retirada && (retiradas > indice) #Se comprueba si la bicicleta ya ha sido retirada
        if(bicis_retirar[indice] == num_bici)
          retirada = true
        end
        
        indice = indice + 1
      end
      
      if(!retirada) #Si no se ha retirado se retira
        bicis_retirar[indice] = num_bici
        retiradas = retiradas + 1
      end
    end
    
    return bicis_retirar
	end

	# @ReturnType void
	public
	def iniciarCarrera()
    segundo_retirada_antes = rand(1..59) #Segundo donde se retirarán bicis antes de tiempo
    bicis_retirar = retiradaAntesDeTiempo() #Bicis que se retiran antes de DURACION
    hebras = [] #Array de Hebras
    mutex = Mutex.new #Objeto para exclusión mutua
    
    #Informacion sobre la carrera (participantes, duracion, tipo, etc)
    puts toString
    
    #Informacion de las bicicletas que retiran antes de tiempo (Numero de bicicletas, Segundo e ID de las bicicletas
    puts "Se van a retirar " + bicis_retirar.length.to_s + " bicicletas en el segundo " + segundo_retirada_antes.to_s + "\n"
    
    for i in (0..bicis_retirar.length - 1)
      mensaje = "Se retirara la bici: " + (bicis_retirar[i] + 1).to_s
      puts mensaje
    end
    
    for i in @bicisEnCarrera #Se recorren las bicicletas de la carrera
      mutex.synchronize{ #Utilizando exclusion mutua (debido a que "array" << "object" no es operacion segura)
        segundoRetirada = @@DURACION #Se establece el segundo de retirada de una bici en duracion
        bici = i
        if (bicis_retirar.include?(bici.getID-1)) #Si la bicicleta se tiene que retirar antes de tiempo
          segundoRetirada = segundo_retirada_antes #Se establece el nuevo segundo de retirada
        end
        hebras << Thread.new{bici.comienzaCarrera(segundoRetirada)}} #Se añade la hebra al vector con la operación de la bici
    end
    hebras.each{|thread| thread.join} #Se espera a que todas las hebras finalicen
    
	end

	# @ReturnType String
	public
	def toString()
		return "Datos de la carrera:\nDuracion: " +@@DURACION.to_s + " segundos\nParticipantes: " + @bicisEnCarrera.length.to_s
	end
  
  public
  def inicializarCarrera(nbicis, factoria)
    
    if(nbicis > 1) #Minimo 2 bicis en la carrera
      for i in (1..nbicis)
        bici = factoria.crearBicicleta #Se crea la bicicleta usando la factoria
        bici.setID(i) #Se asigna un identificador
        @bicisEnCarrera << bici #Se añade al array
      end
    else
      raise "Numero de bicis en la carrera invalido"
    end
  end

	public
	def initialize(tasaRetirada)
    if(self.class == ProductoCarrera) #Si se está intentando instanciar ProductoCarrera
      raise "ProductoCarrrera no debe ser instanciado"
    else
      # @AttributeType int
      @porcentajeRetirada = tasaRetirada
      # @AttributeType ProductoBicicleta
      # # @AssociationType ProductoBicicleta
      @bicisEnCarrera = []
    end
	end

  protected :porcentajeRetirada, :bicisEnCarrera
end
