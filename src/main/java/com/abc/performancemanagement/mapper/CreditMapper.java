package com.abc.performancemanagement.mapper;

import com.abc.performancemanagement.pojo.Credit;
import com.abc.performancemanagement.pojo.Post;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;
//加分项
@Mapper
public interface CreditMapper {

    @Select("select * from credit")
    List<Credit> getAll();


    @Insert("insert into credit values(#{cId},#{cName},#{cBranch},#{cPrice},#{cDepart})")
    @Options(keyColumn = "c_id",keyProperty = "cId",useGeneratedKeys = true)
    Integer addCredit(Credit credit);

    //获取某个部分绩点钱数
    @Select("select c_price from credit where c_depart = #{cDepart}")
    Integer getPrice(String cPrice);

}
