/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uesocc.edu.sv.ingenieria.prn335.control;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import uesocc.edu.sv.ingenieria.prn335.entities.Marca;

/**
 *
 * @author oapaises
 */
@Stateless
public class Utilidades {

    @PersistenceContext(unitName = "uesocc.edu.sv.ingenieria.prn335_guia05_war_1.0-SNAPSHOTPU", type = PersistenceContextType.TRANSACTION)
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("Utilidades");
    EntityManager em = emf.createEntityManager();

    public void insert(Marca entity) throws Exception {
        em.flush();
        em.clear();//flush y clear, Por si el búffer se llena 
        try {
            if (em != null) {
                em.getTransaction().begin(); //Inicio de la transaccion
               em.persist(entity); //Inserta los parametro dado
               em.getTransaction().commit();//Fin de la transaccion
            }
        } catch (Exception e) {
            Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, e);
            em.getTransaction().rollback(); //corta toda la transaccion si ocurre un error y no guarda nada, además si la PK se deja vacia no guarda la transaccion
        }
    }

    public void update(Marca entity) throws Exception {
         em.flush();//flush y clear, Por si el búffer se llena 
        em.clear();
        try {
            if (em != null) {
                em.getTransaction().begin();//Inicio de la transaccion
                em.merge(entity); //actualiza ls parametro dado
                em.getTransaction().commit();//Fin de la transaccion
            }
        } catch (EntityNotFoundException notFound) {
            Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, notFound);
            em.getTransaction().rollback(); //corta toda la transaccion si ocurre un error y no guarda nada, además si la PK se deja vacia no guarda la transaccion
        }
    }

    public void delete(Marca entity) throws Exception {
        em.flush();//flush y clear, Por si el búffer se llena 
        em.clear();
        try {
            if (em != null) {
                em.getTransaction().begin();//Inicio de la transaccion
                em.remove(entity); //Borra los parametro dado
                 em.getTransaction().commit();//Fin de la transaccion
            } 
        }catch (Exception e) {
            Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, e);
            em.getTransaction().rollback(); //corta toda la transaccion si ocurre un error y no guarda nada, además si la PK se deja vacia no guarda la transaccion
        }
    }

    public List<Marca> selectAll() throws Exception {//Este método devolverá la lista de todos lo elementos de la entidad
        em.flush();
        em.clear();//flush y clear, Por si el búffer se llena 
        List<Marca> Lista= new ArrayList<>(); //Creamos un arraylist con base en List<Marca>
        try {
            if (em != null) {
                Query query = em.createQuery("SELECT m from Marcas m");
                Lista = query.getResultList(); //Pasamos la consulta al arrayList
            }
        } catch (Exception e) {
            Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, e);
            em.getTransaction().rollback(); //corta toda la transaccion si ocurre un error y no guarda nada, además si la PK se deja vacia no guarda la transaccion
        }
        return Lista; //retornamos la lista
    }

    public List<Marca> findByCampos(String busqueda) {//Este método deberá devolver una lista de todos los campos de la entidad asignada, donde se encuentre el texto mandado como parámetro, y la búsqueda será en base todos los campos de la tabla
        em.flush();//flush y clear, Por si el búffer se llena 
        em.clear();
         List<Marca> ListaBusqueda= new ArrayList<>(); //Creamos un arraylist con base en List<Marca>
        try {
            if (em != null) {
                Query query = em.createQuery("SELECT m from Marcas m WHERE m.idMarca LIKE "+busqueda+" OR m.nombre LIKE "+busqueda+" OR m.activo LIKE "+busqueda+" OR m.descripcion LIKE "+busqueda+"");
                ListaBusqueda = query.getResultList(); //Pasamos la consulta al arrayList
            }
        } catch (Exception e) {
            Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, e);
            em.getTransaction().rollback(); //corta toda la transaccion si ocurre un error y no guarda nada, además si la PK se deja vacia no guarda la transaccion
        }
        return ListaBusqueda; //retornamos la lista
    }
//Método que devuelve una lista con los registros de la entidad asignada comprendidos en el rango que se le indique.

    public List<Marca> findRange(int inicio, int fin) {
       List<Marca> ListaRangos= new ArrayList<>(); //Creamos un arraylist con base en List<Marca>
        em.flush();//flush y clear, Por si el búffer se llena 
        em.clear();
        try {
            if (em != null) {
                Query query = em.createQuery("SELECT m from Marcas m WHERE m.idMarca BETWEEN "+inicio+" AND "+fin+" ORDER BY m.idMarca ASC");
                ListaRangos = query.getResultList(); //Ingresamos la consulta al array
            }
        } catch (Exception e) {
            Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, e);
            em.getTransaction().rollback(); //corta toda la transaccion si ocurre un error y no guarda nada, además si la PK se deja vacia no guarda la transaccion
        }
        return ListaRangos;
    }
//Este método devuelve una lista de los campos que cumplen con los criterios de búsqueda. Recibirá dos arrays de tipo String, uno con los campos a buscar y el otro con los criterios de búsqueda. La búsqueda debe hacerse de manera que todos los campos cumplan con los criterios de búsqueda.

    public List<Marca> findByMultiple(String[] campos, String[] busquedas) {//Este método devuelve una lista de los campos que cumplen con los criterios de búsqueda. Recibirá dos arrays de tipo String, uno con los campos a buscar y el otro con los criterios de búsqueda. La búsqueda debe hacerse de manera que todos los campos cumplan con los criterios de búsqueda.

        try {
            if (em != null) {

            }
        } catch (EntityNotFoundException notFound) {

        }

        return null;
    }

}
