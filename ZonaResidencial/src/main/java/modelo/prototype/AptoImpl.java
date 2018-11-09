package modelo.prototype;



import modelo.persona.Residente;

public class AptoImpl extends ComponenteAptoPrototype{
	private String nombreApto;
	private double valor;

	public AptoImpl() {
	}
	
	
	public AptoImpl(int idAptoImpl) {
		super(idAptoImpl);
	}
	
	

	public AptoImpl(int idAptoImpl, String estado) {
		super(idAptoImpl, estado);
	}


	public AptoImpl(int idAptoImpl, String nombreApto, int numeroApto, float largo, float ancho, int m2, double valor,
			String estado) {
		super(idAptoImpl, nombreApto, numeroApto, largo, ancho, m2, valor, estado);
		this.nombreApto=nombreApto;
		this.valor=valor;
	}
	
	public AptoImpl(int idAptoImpl, String nombreApto, int numeroApto, float largo, float ancho, int m2, double valor) {
		super(idAptoImpl, numeroApto, largo, ancho, m2);
		this.nombreApto=nombreApto;
		this.valor=valor;
	}




	@Override
	public ComponenteAptoPrototype clone() {
		return new AptoImpl (this.getIdAptoImpl(),this.nombreApto,this.getNumeroApto(),this.getLargo(),this.getAncho(),this.getM2(), this.valor, this.getEstado());
	}

	@Override
	public ComponenteAptoPrototype deepClone() {
		AptoImpl clone = new AptoImpl();
    	clone.setNombreApto(this.nombreApto);
		clone.setNumeroApto(this.getNumeroApto());
		clone.setLargo(this.getLargo());
		clone.setAncho(this.getAncho());
		clone.setM2(this.getM2());
		clone.setValor(this.valor);
		clone.setEstado(this.getEstado());
		return clone;
	}

	public String getNombreApto() {
		return nombreApto;
	}

	public void setNombreApto(String nombreApto) {
		this.nombreApto = nombreApto;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	@Override
	public String getDescripcion() {
		// TODO Auto-generated method stub
		return nombreApto;
	}

	@Override
	public double getValorAgregado() {
		// TODO Auto-generated method stub
		return valor;
	}
	
	@Override
	public int getIdApto() {
		// TODO Auto-generated method stub
		return getIdAptoImpl();
	}

	@Override
	public int getNumApto() {
		// TODO Auto-generated method stub
		return getNumeroApto();
	}




	@Override
	public float getAptoLargo() {
		// TODO Auto-generated method stub
		return getLargo();
	}




	@Override
	public float getAptoAncho() {
		// TODO Auto-generated method stub
		return getAncho();
	}




	@Override
	public int getMetro2() {
		// TODO Auto-generated method stub
		return getM2();
	}




	@Override
	public String getEstate() {
		// TODO Auto-generated method stub
		return getEstado();
	}
	
	/*
	private int idAptoImpl;
	private String nombreApto;
    private int numeroApto;
    private float largo;
    private float ancho;
    private int m2;
    private double valor;
    private Residente residente;
    
    
	
	public AptoImpl(int idAptoImpl, float largo, float ancho, int m2, double valor,int numeroApto,
			Residente residente, String nombreApto) {
		this.idAptoImpl = idAptoImpl;
		this.nombreApto = nombreApto;
		this.numeroApto = numeroApto;
		this.largo = largo;
		this.ancho = ancho;
		this.m2 = m2;
		this.valor = valor;
		this.residente = residente;
	}

	public AptoImpl(String nombreApto,int numeroApto, float largo, float ancho, int m2, double valor,
			Residente residente) {
		this.nombreApto=nombreApto;
		this.numeroApto = numeroApto;
		this.largo = largo;
		this.ancho = ancho;
		this.m2 = m2;
		this.valor = valor;
		this.residente = residente;
	}
	

	public AptoImpl(int idAptoImpl, float largo, float ancho, int m2, double valor,int numeroApto) {
		this.idAptoImpl = idAptoImpl;
		this.numeroApto = numeroApto;
		this.largo = largo;
		this.ancho = ancho;
		this.m2 = m2;
		this.valor = valor;
	}

	public AptoImpl(int numeroApto) {
		this.numeroApto = numeroApto;
	}

	public AptoImpl() {
    }
    
    public int getIdAptoImpl() {
		return idAptoImpl;
	}

	public void setIdAptoImpl(int idAptoImpl) {
		this.idAptoImpl = idAptoImpl;
	}

	public float getLargo() {
		return largo;
	}

	public void setLargo(float largo) {
		this.largo = largo;
	}

	public float getAncho() {
		return ancho;
	}

	public void setAncho(float ancho) {
		this.ancho = ancho;
	}

	public int getM2() {
		return m2;
	}

	public void setM2(int m2) {
		this.m2 = m2;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	public Residente getResidente() {
		return residente;
	}

	public void setResidente(Residente residente) {
		this.residente = residente;
	}
	
	public int getNumeroApto() {
		return numeroApto;
	}

	public void setNumeroApto(int numeroApto) {
		this.numeroApto = numeroApto;
	}
	

	public String getNombreApto() {
		return nombreApto;
	}

	public void setNombreApto(String nombreApto) {
		this.nombreApto = nombreApto;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public AptoImpl clone() {
		return new AptoImpl (this.nombreApto,this.numeroApto,this.largo,this.ancho,this.m2, this.valor,this.residente);
    }

    public AptoImpl deepClone() {
    	AptoImpl clone = new AptoImpl();
    	clone.setNombreApto(nombreApto);
		clone.setNumeroApto(numeroApto);
		clone.setLargo(largo);
		clone.setAncho(ancho);
		clone.setM2(m2);
		clone.setValor(valor);
		clone.setResidente(residente);
		return clone;
    }
    @Override
	public String toString() {
		
		return "Apto=" + nombreApto + ", idApto=\n" + idAptoImpl + ", valor=\n" + valor +", nombreApto=\n" + nombreApto + '}';
	}

	@Override
	public String getDescripcion() {
		// TODO Auto-generated method stub
		return nombreApto;
	}

	@Override
	public double getValorAgregado() {
		// TODO Auto-generated method stub
		return valor;
	}*/

}