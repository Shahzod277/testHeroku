package uz.jurayev.academy.util.responsemapper;

import org.springframework.stereotype.Component;
import uz.jurayev.academy.domain.StudentGroup;
import uz.jurayev.academy.rest.GroupDto;
import uz.jurayev.academy.util.Mapper;

@Component
public class StudentGroupResponseMapper implements Mapper<StudentGroup, GroupDto> {

    @Override
    public GroupDto mapFrom(StudentGroup entity) {
        GroupDto groupDto = new GroupDto();
        groupDto.setId(entity.getId());
        groupDto.setGroupName(entity.getGroupName());

        return groupDto;
    }
}
