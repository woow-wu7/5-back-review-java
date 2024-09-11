package com.example.backreviewjava.mapper;

import com.example.backreviewjava.model.MusicMybatisModel;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface MusicMybatisMapper {
//    @Insert("insert into music (id, name, singer, album, date) values (#{id}, #{name}, #{singer}, #{album}, #{date})")
//    void insert(MusicMybatisModel music);

    // 1
    // selectMusics
    @Select(
            "SELECT * from music where"
                    + " name like CONCAT('%',#{searchKey},'%') or "
                    + " album like CONCAT('%',#{searchKey},'%') or "
                    + " singer like CONCAT('%',#{searchKey},'%')"
                    + " limit #{offset},#{pageSize}"
    )
    public List<MusicMybatisModel> selectMusics(Integer pageSize, Integer offset, String searchKey); // 查找 - 分页 + 条件模糊查询


    // 2
    // selectMusicsOnlyPagination
//    @Results(value = {
//            @Result(column = "name", property = "name"),
//            // 主要用来解决 ( 数据库中的column字段 ) 和 ( bean对象中的属性字段 ) 不一致的情况
//            // 比如：数据库中叫user_name，而bean对象中叫userName
//    })
    @Select("SELECT * from music limit #{offset},#{pageSize}")
    public List<MusicMybatisModel> selectMusicsOnlyPagination(Integer pageSize, Integer offset); // 查找 - 分页查询


    // 3
    // selectAllMusics
    @Select("SELECT * from music")
    public List<MusicMybatisModel> selectAllMusics(); // 查找 - 总数据



}
