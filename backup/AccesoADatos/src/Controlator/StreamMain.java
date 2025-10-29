package Controlator;

import Model.Usuario;
import Service.UsuarioService;

public class StreamMain {
	public static void main(String[] args) {
		Usuario u = new Usuario();
		UsuarioService usuarioServicio = new UsuarioService();
		usuarioServicio.altaUsuario(u);
		
		System.out.println(usuarioServicio.getRepo().getUsuarios());
	}
}
