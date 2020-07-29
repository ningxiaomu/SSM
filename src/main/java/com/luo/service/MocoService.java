package com.luo.service;

import com.luo.domain.MocoInfo;
import java.util.List;

public interface MocoService {
  List<MocoInfo> findAllMoco();
  
  String findReturnValue(String paramString);
  
  MocoInfo findMocoInfo(String paramString);
}


/* Location:              D:\Downloads\ROOT.war!\WEB-INF\classes\com\luo\service\MocoService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */