package modelo.facade;

import java.util.Date;

import javax.swing.JOptionPane;

import modelo.persona.Residente;

public class OnlinePagoFacade extends AbstractPagoFacadeAdaptee {
	private CRMSystem crmSystem;
	private BankSystem bankSystem;
	
	public OnlinePagoFacade() {
		crmSystem=new CRMSystem();
		bankSystem=new BankSystem();
	}
	
	@Override
	public boolean pagarOnline(Residente residente, double cantidad, int numeroTarjeta, Date fecha) {
		boolean estado=false;
		if(crmSystem.verificarResidente(residente)==bankSystem.verificarSaldo(cantidad, numeroTarjeta)) {
			
			estado=true;
		}
		else if(crmSystem.verificarResidente(residente)!=bankSystem.verificarSaldo(cantidad, numeroTarjeta)){
			estado=false;
		}
		return estado;
	}
	

	public CRMSystem getCrmSystem() {
		return crmSystem;
	}

	public void setCrmSystem(CRMSystem crmSystem) {
		this.crmSystem = crmSystem;
	}

	public BankSystem getBankSystem() {
		return bankSystem;
	}

	public void setBankSystem(BankSystem bankSystem) {
		this.bankSystem = bankSystem;
	}

}
