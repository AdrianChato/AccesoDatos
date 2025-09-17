package Repository;

import java.util.ArrayList;
import java.util.List;

import Model.Retransmision;

public class RetransmisionRepository {

	private List<Retransmision> retransmisiones;

	public RetransmisionRepository() {
		super();
		this.retransmisiones = new ArrayList<Retransmision>();
	}
	
	public void AltaRetransmision (Retransmision r) {
		retransmisiones.add(r);
	}
}
