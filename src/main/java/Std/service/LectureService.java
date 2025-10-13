package Std.service;

import Std.dto.DtoLecture;
import Std.model.Lecture;
import Std.repos.LectureRepos;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LectureService {
    private final LectureRepos lectureRepos;


    public List<DtoLecture> getAll(){
        List<Lecture> lectureList = lectureRepos.findAll();
        List<DtoLecture> dtoLectureList = new ArrayList<>();
        for (Lecture l : lectureList){
            dtoLectureList.add(toDtoLecture(l));}

        return dtoLectureList;
    }

    public DtoLecture getById(Long id){
        return toDtoLecture(lectureRepos.findById(id).orElse(null));
    }

    public void addDtoLecture(DtoLecture dtoLecture){
        Lecture lecture = new Lecture();

        lecture.setId(dtoLecture.getId());
        lecture.setName(dtoLecture.getName());
        lecture.setDescription(dtoLecture.getDescription());

        lectureRepos.save(lecture);
    }

    public void delete(Long id){lectureRepos.deleteById(id);}
    public void updateDtoLecture(Long id, DtoLecture dtoLecture){
        Lecture lecture = lectureRepos.findById(id).orElse(null);

        lecture.setId(dtoLecture.getId());
        lecture.setName(dtoLecture.getName());
        lecture.setDescription(dtoLecture.getDescription());

        lectureRepos.save(lecture);
    }



    public Lecture toLecture(DtoLecture dtoLecture){
        Lecture lecture = new Lecture();

        lecture.setId(dtoLecture.getId());
        lecture.setName(dtoLecture.getName());
        lecture.setDescription(dtoLecture.getDescription());

        return lecture;
    }



    public DtoLecture toDtoLecture(Lecture lecture){
        DtoLecture dtoLecture = new DtoLecture();

        dtoLecture.setId(lecture.getId());
        dtoLecture.setName(lecture.getName());
        dtoLecture.setDescription(lecture.getDescription());

        return dtoLecture;
    }






}
