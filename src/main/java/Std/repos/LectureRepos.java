package Std.repos;

import Std.model.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LectureRepos extends JpaRepository<Lecture, Long> {

}
