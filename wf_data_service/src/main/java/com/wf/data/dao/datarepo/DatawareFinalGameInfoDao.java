package com.wf.data.dao.datarepo;


import com.wf.core.persistence.CrudDao;
import com.wf.core.persistence.MyBatisDao;
import com.wf.data.dao.datarepo.entity.DatawareFinalGameInfo;

import java.util.List;
import java.util.Map;

@MyBatisDao(tableName = "dataware_final_game_info")
public interface DatawareFinalGameInfoDao extends CrudDao<DatawareFinalGameInfo> {

    int getCountByDate(Map<String, Object> paramMap);

    void deleteByDate(Map<String, Object> param);

    DatawareFinalGameInfo getInfoByDateAndGameType(Map<String, Object> param);

    List<DatawareFinalGameInfo> findInfoByDate(Map<String, Object> map);

    List<DatawareFinalGameInfo> findListByDate(Map<String, Object> map);

    List<String> findDateList(Map<String, Object> map);
}
