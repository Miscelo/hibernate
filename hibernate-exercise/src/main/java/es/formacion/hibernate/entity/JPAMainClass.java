/*
 * @ author Michael Schossow
 * 
 * Crear un nuevo proyecto MAVEN, con una aplicación que se conecte a una base de datos, 
 * crear un nuevo registro (fila) en una tabla y 
 * luego realice una consulta para devolver todas las filas de dicha tabla.
 * 
 * Para comenzar el proyecto, te puedes ayudar de la estructura de un proyecto Maven 
 * que se encuentra en C:\Ejercicios\Exercise07
 * Será necesario crear una base de datos llamada exercise07 que contenga una tabla llamada student. 
 * Para ello te puedes ayudar del fichero C:\Ejercicios\exercise07.sql.
 * 
 */


package es.formacion.hibernate.entity;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;




public class JPAMainClass {

	private static final EntityManagerFactory emFactoryObj;
	private static final String PERSISTENCE_UNIT_NAME = "JPAMainClass";
	
	static {
		emFactoryObj = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	}
	
	// Metodo para recibir el EntityManager Object
	public static EntityManager getEntityManager() {
		return emFactoryObj.createEntityManager();
	}
	
	public static void main(String[] args) {
		
		EntityManager entityMgr = getEntityManager();
		entityMgr.getTransaction().begin();
		
		Student studentObj = new Student();
		studentObj.setId(2);
		studentObj.setEmail("michael.schossow@gmail.com");
		studentObj.setFirstName("Michael");
		studentObj.setLastName("Schossow");
		entityMgr.persist(studentObj);
		entityMgr.getTransaction().commit();
		
		entityMgr.close();
		System.out.println("Datos insertado en base de Datos con exito!");
		
	}
}
