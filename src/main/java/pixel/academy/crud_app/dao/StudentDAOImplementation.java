package pixel.academy.crud_app.dao;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pixel.academy.crud_app.entity.Student;

@Repository
public class StudentDAOImplementation implements StudentDAO {

    // field for EntityManage(will be used to interact with db)
    private EntityManager entitymanager;

    // inject EntityManager with constructor
    @Autowired
    public StudentDAOImplementation(EntityManager entityManager) {
        this.entitymanager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student theStudent) {

    }
}
