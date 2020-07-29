package com.luo.dao;

import com.luo.domain.MocoInfo;
import java.util.List;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface MocoDao {
  @Select({"select * from moco"})
  List<MocoInfo> findAllMoco();
  
  @Select({"select returnValue from moco where url=#{url}"})
  String findReturnValue(String paramString);
  
  @Select({"select * from moco where url=#{url}"})
  MocoInfo findMocoInfo(String paramString);
}


/* Location:              D:\Downloads\ROOT.war!\WEB-INF\classes\com\luo\dao\MocoDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */