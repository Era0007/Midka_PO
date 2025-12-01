package Std.controller;

import Std.dto.DtoGroup;
import Std.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/groups")
@RequiredArgsConstructor
public class GroupController {

    private final GroupService groupService;

    @GetMapping
    public List<DtoGroup> getAllGroups() {
        return groupService.getAll();
    }

    @GetMapping("/{id}")
    public DtoGroup getGroupById(@PathVariable Long id) {
        return groupService.getById(id);
    }

    @PostMapping
    public void createGroup(@RequestBody DtoGroup dtoGroup) {
        groupService.addDtoGroup(dtoGroup);
    }

    @PutMapping("/{id}")
    public void updateGroup(@PathVariable Long id, @RequestBody DtoGroup dtoGroup) {
        groupService.updateDtoGroup(id, dtoGroup);
    }

    @DeleteMapping("/{id}")
    public void deleteGroup(@PathVariable Long id) {
        groupService.delete(id);
    }
}