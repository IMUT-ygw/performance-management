package com.abc.performancemanagement.mapper;

import com.abc.performancemanagement.pojo.Department;
import com.abc.performancemanagement.pojo.Performance;
import com.abc.performancemanagement.pojo.PerformanceResult;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

//员工绩点详情
@Mapper
public interface PerformanceMapper {


    //获取某个员工每个月份的绩点
    @Select("SELECT DATE_FORMAT(per_date ,'%Y-%m') as 'date' , SUM(per_value) as 'value', per_user as user from  performance WHERE per_user = #{perUser}  GROUP BY  date ; ")
    List<PerformanceResult> getPerByUser(String perUser);


    //添加每个员工的加减分情况
    @Insert("insert into performance values(#{perKind},#{perValue},#{perDate},#{perDescribe},#{perUser})")
    @Options(keyColumn = "per_id",keyProperty = "perId",useGeneratedKeys = true)
    Integer addPerformance(Performance performance);
}