package pixel.academy.crud_app.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pixel.academy.crud_app.entity.Student;

import java.util.List;

@Repository
public class StudentDAOImplementation implements StudentDAO {

    // field for EntityManage(will be used to interact with db)
    private EntityManager entityManager;

    // inject EntityManager with constructor
    @Autowired
    public StudentDAOImplementation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {

        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);

        return theQuery.getResultList();
    }

    @Override
    public List<Student> findNyLastName(String theLastName) {

        // creare query

        // setarea parametrilor

        // returnarea rezultatelor query

        return null;
    }
}
