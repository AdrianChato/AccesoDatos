package Service;

import Model.Usuario;
import Repository.UsuarioRepository;

public class UsuarioService {
	private UsuarioRepository repo;

	public UsuarioService() {
		super();
		this.repo = new UsuarioRepository();
	}
	
	public void altaUsuario(Usuario u) {
		repo.AltaUsuario(u);
	}

	public UsuarioRepository getRepo() {
		return repo;
	}

	public void setRepo(UsuarioRepository repo) {
		this.repo = repo;
	}
	
	
}
