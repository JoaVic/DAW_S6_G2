package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Producto;


public class Demo7 {
	// Listado de TODOS los productos, mostrando la informacion
	//del proveedor(nombre y telefono), asi como su categoria
	public static void main(String[] args) {
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
		EntityManager manager = fabrica.createEntityManager();
		
		//select * from tb_usuarios ---> lista
		
		String jpql = "select p from Producto p";
		List<Producto> lstProductos = manager.createQuery(jpql, Producto.class).getResultList();
		
		//mostrar el listado
		System.out.println("Listado de Usuarios");
		for(Producto p : lstProductos) {
			
			System.out.println("Codigo.....: " + p.getId_prod());
			System.out.println("Nombre....: " + p.getDes_prod());
			System.out.println("Categoria....." + p.getObjCategoria().getDescripcion());
			System.out.println("Proveedor....." + p.getObjProveedor().getNombre_rs() + "-" +
			                                      p.getObjProveedor().getTelefono());
			System.out.println("-------------------------");
		}
		
		manager.close();
		
		
	}
}
