package modelo.otros;



public class ServicioMantenimiento {
	private int idServicioMantenimiento;
    private String descripcion;
    private Double costo;
    
    

    public ServicioMantenimiento(int idServicioMantenimiento, String descripcion, Double costo) {
		super();
		this.idServicioMantenimiento = idServicioMantenimiento;
		this.descripcion = descripcion;
		this.costo = costo;
	}

	public ServicioMantenimiento(String descripcion, Double costo) {
		super();
		this.descripcion = descripcion;
		this.costo = costo;
	}


	public ServicioMantenimiento() {
    }

	public int getIdServicioMantenimiento() {
		return idServicioMantenimiento;
	}

	public void setIdServicioMantenimiento(int idServicioMantenimiento) {
		this.idServicioMantenimiento = idServicioMantenimiento;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getCosto() {
		return costo;
	}

	public void setCosto(Double costo) {
		this.costo = costo;
	}
    
    

}