package com.luo.dao;

import com.luo.domain.ResultSize;
import java.util.List;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface WelcomeDao {
  @Select({"select * from ResultSize ORDER BY TestTime desc  LIMIT 5"})
  List<ResultSize> findAllResultSize();
}


/* Location:              D:\Downloads\ROOT.war!\WEB-INF\classes\com\luo\dao\WelcomeDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */