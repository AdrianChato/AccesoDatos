package Simulacion.Utilidades;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import Simulacion.Modelos.CentroLogistico;
import Simulacion.Modelos.TipoPersonal;
import Simulacion.Modelos.Trabajador;
import Unidad1.Modelo.Empleado;

public class XMLDomBancoDeAlimentos {
	private static final Logger logger = LogManager.getLogger(XMLDomBancoDeAlimentos.class);
	private static final String rutaResources = "src\\main\\resources\\";


	private  CentroLogistico getCentroFromElement(Element elemento) //unico que cambia
	{
		CentroLogistico e = new CentroLogistico();
			String nombre = elemento.getElementsByTagName("Nombre").item(0).getTextContent();
			int comedores = Integer.parseInt(elemento.getElementsByTagName("ComedoresAbastecidos").item(0).getTextContent());
			String ciudad = elemento.getElementsByTagName("Ciudad").item(0).getTextContent();
			String id = elemento.getAttribute("ID"); // La etiqueta empleado tiene el atributo identificador
			e.setCiudad(ciudad);
			e.setComedores(comedores);
			e.setNombre(nombre);
			e.setId(id);
			return e;
		}
	
	private Document getDocumentFromXML(String nombrefichero) {
		File file = new File(rutaResources + nombrefichero);
		Document documento = null;
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			documento = dBuilder.parse(file);

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return documento;
	} 
	
	/*public Empleado leerEmpleadoDesdeXML(String rutaFichero) throws Exception {
	       Document doc = getDocumentFromXML(rutaFichero);
	       // Obtener el elemento raíz (el único <empleado>)
	       Element elementoEmpleado = doc.getDocumentElement(); //Para uno
	       // Usar tu método
	       return getEmpleadoFromElement(elementoEmpleado);
	   }*/
	
	private  Trabajador getTrabajadorFromElement(Element elemento) //unico que cambia
	{
		Trabajador e = new Trabajador();
			String nombre = elemento.getElementsByTagName("Nombre").item(0).getTextContent();
			String fecha_nacimiento = elemento.getElementsByTagName("FechaNacimiento").item(0).getTextContent();
			String dni = elemento.getAttribute("DNI"); // La etiqueta empleado tiene el atributo identificador
			String tipo = elemento.getElementsByTagName("Tipo").item(0).getTextContent().trim();
			TipoPersonal tipoTrabajador = TipoPersonal.valueOf(tipo.toUpperCase());
			e.setDni(dni);
			e.setFecha_nacimiento(fecha_nacimiento);
			e.setNombre(nombre);
			e.setTipo(tipoTrabajador);
			return e;
		}
	
	public Set<CentroLogistico> leerCentrosDesdeXML(String nombreFichero) {

	    Set<CentroLogistico> centros = new HashSet<>();

	    try {
	        Document doc = getDocumentFromXML(nombreFichero);
	        NodeList listaCentros = doc.getElementsByTagName("CentroLogistico");

	        for (int i = 0; i < listaCentros.getLength(); i++) {
	            Element elementoCentro = (Element) listaCentros.item(i);
	            CentroLogistico centro = getCentroFromElement(elementoCentro);

	            // Leer los trabajadores dentro del centro
	            NodeList listaTrabajadores = elementoCentro.getElementsByTagName("Trabajador");
	            List<Trabajador> trabajadores = new ArrayList<>();

	            for (int j = 0; j < listaTrabajadores.getLength(); j++) {
	                Element elementoTrabajador = (Element) listaTrabajadores.item(j);
	                Trabajador trabajador = getTrabajadorFromElement(elementoTrabajador);
	                trabajadores.add(trabajador);
	            }

	            // Asignar lista de trabajadores al centro
	            centro.setPersonal(trabajadores);
	            centros.add(centro);
	        }

	        logger.info("Centros cargados: " + centros.size());

	    } catch (Exception e) {
	        logger.error("Error al leer los centros: " + e.getMessage());
	    }

	    return centros;
	}



	
}

