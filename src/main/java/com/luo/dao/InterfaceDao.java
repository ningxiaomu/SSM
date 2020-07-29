package com.luo.dao;

import com.luo.domain.InterfaceBodyInfo;
import com.luo.domain.InterfaceHeaderInfo;
import com.luo.domain.InterfaceInfo;
import com.luo.domain.InterfaceReturnDataInfo;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface InterfaceDao {
  @Select({"select * FROM case.interface"})
  List<InterfaceInfo> findAllInterface();
  
  @Select({"select * FROM case.interface where interfaceId = #{interfaceId}"})
  List<InterfaceInfo> findInterfaceById(String paramString);
  
  @Select({"select * from case.interface_body where interfaceId=#{interfaceId}"})
  List<InterfaceBodyInfo> findInterfaceBodyById(String paramString);
  
  @Select({"select * from case.interface_returndata where interfaceId=#{interfaceId}"})
  List<InterfaceReturnDataInfo> findInterfaceReturnDataById(String paramString);
  
  @Update({"update case.interface set interfaceName=#{interfaceName},project=#{project},domain=#{domain},requestAddress=#{requestAddress},method=#{method},creator=#{creator},joinTime=now() where interfaceId=#{interfaceId}"})
  void editBasicInformation(InterfaceInfo paramInterfaceInfo);
  
  @Select({"select * from case.interface where interfaceId=#{interfaceId}"})
  InterfaceInfo findInterceInfoByIdInfo(String paramString);
  
  @Delete({"delete from case.interface where interfaceId=#{interfaceId}"})
  void delSelectInterface(String paramString);
  
  @Insert({"insert case.interface(interfaceId,interfaceName,project,domain,method,requestAddress,creator,joinTime) values(replace(uuid(),'-',''),#{interfaceName},#{project},#{domain},#{method},#{requestAddress},#{creator},now())"})
  void addInterface(InterfaceInfo paramInterfaceInfo);
  
  @Insert({"insert case.interface_body(body_id,interfaceId,parameterName_body,type_body,is_required_body,defaultValue_body,remark_body) values(replace(uuid(),'-',''),#{interfaceId},#{parameterName_body},#{type_body},#{is_required_body},#{defaultValue_body},#{remark_body})"})
  void addInterfaceBody(InterfaceBodyInfo paramInterfaceBodyInfo);
  
  @Delete({"delete from case.interface_body where interfaceId=#{interfaceid}"})
  void delInterfaceBody(String paramString);
  
  @Delete({"delete from case.interface_returndata where interfaceId=#{substring}"})
  void delInterfaceReturnData(String paramString);
  
  @Insert({"insert case.interface_returndata(returndata_id,interfaceId,parameterName_return,type_return,is_required_return,defaultValue_return,remark_return) values (replace(uuid(),'-',''),#{interfaceId},#{parameterName_return},#{type_return},#{is_required_return},#{defaultValue_return},#{remark_return})"})
  void addInterfaceReturnData(InterfaceReturnDataInfo paramInterfaceReturnDataInfo);
  
  @Select({"SELECT * FROM case.interface_header where interfaceId=#{interfaceid}"})
  List<InterfaceHeaderInfo> findInterfaceHeaderById(String paramString);
  
  @Delete({"delete from case.interface_header where interfaceId=#{substring}"})
  void delInterfaceHeader(String paramString);
  
  @Insert({"insert case.interface_header(header_id,interfaceId,name,value,is_must,remark) values(replace(uuid(),'-',''),#{interfaceId},#{name},#{value},#{is_must},#{remark})"})
  void addInterfaceHeader(InterfaceHeaderInfo paramInterfaceHeaderInfo);
}


/* Location:              D:\Downloads\ROOT.war!\WEB-INF\classes\com\luo\dao\InterfaceDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */