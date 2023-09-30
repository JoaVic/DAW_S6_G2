package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo5 {
	// Listado de TODOS los usuarios 
	public static void main(String[] args) {
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
		EntityManager manager = fabrica.createEntityManager();
		
		//select * from tb_usuarios ---> lista
		
		String jpql = "select u from Usuario u";
		List<Usuario> lstUsuarios = manager.createQuery(jpql, Usuario.class).getResultList();
		
		//mostrar el listado
		System.out.println("Listado de Usuarios");
		for(Usuario u : lstUsuarios) {
			
			System.out.println("Codigo.....: " + u.getCod_usua());
			System.out.println("Nombre....: " + u.getNom_usua() + "" + u.getApe_usua());
			System.out.println("Tipo....." + u.getIdtipo());
			System.out.println("-------------------------");
		}
		
		manager.close();
		
		
	}
}
