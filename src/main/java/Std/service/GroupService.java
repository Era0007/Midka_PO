package Std.service;

import Std.dto.DtoGroup;
import Std.dto.DtoLecture;
import Std.model.Group;
import Std.model.Lecture;
import Std.repos.GroupRepos;
import Std.repos.LectureRepos;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupService {
    private final GroupRepos groupRepos;


    public List<DtoGroup> getAll(){
        List<Group> groupList = groupRepos.findAll();
        List<DtoGroup> dtogroupList = new ArrayList<>();
        for (Group l : groupList){
            dtogroupList.add(toDtoGroup(l));}

        return dtogroupList;
    }

    public DtoGroup getById(Long id){
        return toDtoGroup(groupRepos.findById(id).orElse(null));
    }

    public void addDtoGroup(DtoGroup dtoGroup){
        Group group = new Group();

        group.setId(dtoGroup.getId());
        group.setName(dtoGroup.getName());
        group.setDescription(dtoGroup.getDescription());

        groupRepos.save(group);
    }

    public void delete(Long id){groupRepos.deleteById(id);}
    public void updateDtoGroup(Long id, DtoGroup dtoGroup){
        Group group = groupRepos.findById(id).orElse(null);

        group.setId(dtoGroup.getId());
        group.setName(dtoGroup.getName());
        group.setDescription(dtoGroup.getDescription());

        groupRepos.save(group);
    }



    public Group toGroup(DtoGroup dtoGroup){
        Group group = new Group();

        group.setId(dtoGroup.getId());
        group.setName(dtoGroup.getName());
        group.setDescription(dtoGroup.getDescription());

        return group;
    }



    public DtoGroup toDtoGroup(Group group){
        DtoGroup dtoGroup = new DtoGroup();

        dtoGroup.setId(group.getId());
        dtoGroup.setName(group.getName());
        dtoGroup.setDescription(group.getDescription());

        return dtoGroup;
    }






}
