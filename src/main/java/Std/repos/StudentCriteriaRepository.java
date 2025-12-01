package Std.repos;

import Std.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentCriteriaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Student> findStudents(String firstname, String lastname, Integer age) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> query = cb.createQuery(Student.class);
        Root<Student> root = query.from(Student.class);

        List<Predicate> predicates = new ArrayList<>();

        if (firstname != null && !firstname.isEmpty()) {
            predicates.add(cb.equal(root.get("firstname"), firstname));
        }

        if (lastname != null && !lastname.isEmpty()) {
            predicates.add(cb.equal(root.get("lastname"), lastname));
        }

        if (age != null) {
            predicates.add(cb.equal(root.get("age"), age));
        }

        query.where(predicates.toArray(new Predicate[0]));

        return entityManager.createQuery(query).getResultList();
    }
}