package vista;

import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import modelo.adapter.ChequeAdapter;
import modelo.adapter.DebitoAdapter;
import modelo.adapter.Efectivo;
import modelo.adapter.IMetodoPagoAdapter;
import modelo.adapter.OnlineAdapter;
import modelo.builder.Nivel;
import modelo.builder.Torre;
import modelo.builder.Torre.TorreBuilder;
import modelo.chainofresponsibility.AbstractServicioFactory;
import modelo.chainofresponsibility.ServicioFactory;
import modelo.decorator.PisoMadera;
import modelo.factorymethod.AptoDAO;
import modelo.factorymethod.CuentaCorrienteDAO;
import modelo.factorymethod.NivelDAO;
import modelo.factorymethod.TorreDAO;
import modelo.persona.Residente;
import modelo.prototype.AptoImpl;
import modelo.prototype.AptoPrototype;
import modelo.prototype.ComponenteAptoPrototype;
import modelo.singleton.AdministradorSingleton;
import modelo.singleton.ConjuntoResidencialSingleton;
import modelo.singleton.CuentaCorrienteSingleton;

public class Main {

	public static void main(String[] args) {
		
		Date fecha= new Date();
		
		/*
		IMetodoPagoAdapter pagoDebito=new DebitoAdapter(200000,fecha,5432);
		pagoDebito.pagar();
		
		IMetodoPagoAdapter pagoCheque=new ChequeAdapter();
		pagoCheque.pagar();
		
		IMetodoPagoAdapter pagoEfectivo=new Efectivo(200000,fecha);
		pagoEfectivo.pagar();*/
		
		/*CuentaCorrienteSingleton CC1=CuentaCorrienteSingleton.getInstance();
		CuentaCorrienteDAO CCSDAO=new CuentaCorrienteDAO();
		
		CC1.sumarSaldo((double) 100000);
		CCSDAO.ModificarCuentaCorriente(CC1);
		System.out.println(CC1.getSaldo());
		
		CC1.sumarSaldo((double) 100000);
		CCSDAO.ModificarCuentaCorriente(CC1);
		System.out.println(CC1.getSaldo());*/
		/*
		Residente r1= new Residente(4321,"John");
		
		IMetodoPagoAdapter pagoDebito=new DebitoAdapter(1000000,fecha,5432);
		pagoDebito.pagar();
		
		IMetodoPagoAdapter pagoCheque=new ChequeAdapter(100000,fecha,00001,"Conjunto",7243);
		pagoCheque.pagar();
		
		IMetodoPagoAdapter pagoOnline=new OnlineAdapter(100000,fecha,5432,r1);
		pagoOnline.pagar();*/
		AbstractServicioFactory fabrica=new ServicioFactory();
		fabrica.ServicioMantenimiento(fecha, 2, 1234);
		
	}

}
