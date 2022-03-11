package uz.jurayev.academy.service;

import uz.jurayev.academy.domain.StudentGroup;
import uz.jurayev.academy.model.Result;
import uz.jurayev.academy.rest.GroupDto;
import java.util.List;

public interface GroupService {
    Result save(GroupDto groupsDto);

    List<StudentGroup> getAll(int page, int size);

    StudentGroup getOne(Integer id);

    Result edit(Integer id, GroupDto groupDto);

    Result delete(Integer id);
}
