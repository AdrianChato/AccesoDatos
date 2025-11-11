package Simulacion.Controlador;

import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Simulacion.Modelos.CentroLogistico;
import Simulacion.Utilidades.XMLDomBancoDeAlimentos;

public class GestionaCentro {
	private static final Logger logger = LogManager.getLogger(XMLDomBancoDeAlimentos.class);

	public static void main(String[] args) {
		XMLDomBancoDeAlimentos xml = new XMLDomBancoDeAlimentos();
		Set <CentroLogistico> c = xml.leerCentrosDesdeXML("bancoAlimentos.xml");
		logger.debug(c);
	}

}
