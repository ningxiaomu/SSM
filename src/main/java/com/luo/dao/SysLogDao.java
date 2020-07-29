package com.luo.dao;

import com.luo.domain.SysLog;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface SysLogDao {
  @Insert({"insert sysLog(id,username,ip,url,method,visitTime) values(replace(uuid(),'-',''),#{username},#{ip},#{url},#{method},#{visitTime})"})
  void save(SysLog paramSysLog);
  
  @Select({"select * from sysLog"})
  List<SysLog> findAllLog();
}


/* Location:              D:\Downloads\ROOT.war!\WEB-INF\classes\com\luo\dao\SysLogDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */