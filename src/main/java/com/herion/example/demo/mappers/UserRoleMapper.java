package com.herion.example.demo.mappers;


import com.herion.example.demo.dto.UserRoleDto;
import com.herion.example.demo.entity.Role;
import com.herion.example.demo.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

/**
 * @Mapper 定义这是一个MapStruct对象属性转换接口，在这个类里面规定转换规则
 *          在项目构建时，会自动生成改接口的实现类，这个实现类将实现对象属性值复制
 */
@Mapper(componentModel = "spring")
public interface UserRoleMapper {


    /**
     * 这个方法就是用于实现对象属性复制的方法
     *
     * @param user 这个参数就是源对象，也就是需要被复制的对象
     * @return 返回的是目标对象，就是最终的结果对象
     * @Mapping 用来定义属性复制规则 source 指定源对象属性 target指定目标对象属性
     */
    @Mappings({
            @Mapping(source = "id", target = "userId"),
            @Mapping(source = "username", target = "name"),
            @Mapping(source = "role.roleName", target = "roleName")
    })
    UserRoleDto toUserRoleDto(User user);

    /**
     * 多个参数中的值绑定
     *
     * @param user 源1
     * @param role 源2
     * @return 从源1、2中提取出的结果
     */
    @Mappings({
            // 把user中的id绑定到目标对象的userId属性中
            @Mapping(source = "user.id", target = "userId"),
            // 把user中的username绑定到目标对象的name属性中
            @Mapping(source = "user.username", target = "name"),
            // 把role对象的roleName属性值绑定到目标对象的roleName中
            @Mapping(source = "role.roleName", target = "roleName")
    })
    UserRoleDto toUserRoleDto(User user, Role role);

    /**
     * 直接使用参数作为值
     * @param user
     * @param myRoleName
     * @return
     */
    @Mappings({
            // 把user中的id绑定到目标对象的userId属性中
            @Mapping(source = "user.id", target = "userId"),
            // 把user中的username绑定到目标对象的name属性中
            @Mapping(source = "user.username", target = "name"),
            // 把role对象的roleName属性值绑定到目标对象的roleName中
            @Mapping(source = "myRoleName", target = "roleName")
    })
    UserRoleDto useParameter(User user, String myRoleName);


    /**
     * 在之前的例子中UserRoleDto useParameter(User user, String myRoleName);都是通过类似上面的方法来生成一个对象。而MapStruct提供了另外一种方式来更新一个对象中的属性。@MappingTarget
     * @param userRoleDto
     * @param user
     */
    @Mappings({
            @Mapping(source = "userId", target = "id"),
            @Mapping(source = "name", target = "username"),
            @Mapping(source = "roleName", target = "role.roleName")
    })
    void updateDto(UserRoleDto userRoleDto, @MappingTarget User user);


    /**
     * @MappingTarget标注的类UserRoleDto 为目标类，user类为源类，调用此方法，会把源类中的属性更新到目标类中。更新规则还是由@Mapping指定。
     * @param user
     * @param userRoleDto
     */
    @Mappings({
            @Mapping(source = "id", target = "userId"),
            @Mapping(source = "username", target = "name"),
            @Mapping(source = "role.roleName", target = "roleName")
    })
    void update(User user, @MappingTarget UserRoleDto userRoleDto);

}

