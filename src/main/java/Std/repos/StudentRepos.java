package Std.repos;

import Std.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepos extends JpaRepository<Student,Long> {
}
