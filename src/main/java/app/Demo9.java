package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import model.Usuario;

public class Demo9 {
	
	public static void main(String[] args) {
		
		String usuario = JOptionPane.showInputDialog("Ingresar su Usuario: ");
		String clave = JOptionPane.showInputDialog("Ingrese su clave : ");
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
		EntityManager manager = fabrica.createEntityManager();
		
		String sql = "select u from Usuario u where u.usr_usua = :xusr and u.cla_usua= :xcla "; 
		try {
			Usuario u = manager.createQuery(sql, Usuario.class).
				setParameter("xusr", usuario). 
			 	setParameter("xcla", clave).
			 	getSingleResult(); 
			
			JOptionPane.showMessageDialog(null, "Bienvenido " + u.getNom_usua());
			//Abri la venta principal
			FrmManteProd v = new FrmManteProd();
			v.setVisible(true);
			//dispose();
			
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error!! Usuario o clave incorrecto");
		}
		
		manager.close();
		
	}
}
