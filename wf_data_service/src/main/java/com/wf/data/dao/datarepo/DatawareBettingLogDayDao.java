package com.wf.data.dao.datarepo;


import com.wf.core.persistence.CrudDao;
import com.wf.core.persistence.MyBatisDao;
import com.wf.data.dao.datarepo.entity.DatawareBettingLogDay;
import com.wf.data.dao.datarepo.entity.DatawareFinalChannelInfoAll;
import com.wf.data.dto.TcardDto;
import com.wf.data.dto.UserDetailsDto;

import java.util.List;
import java.util.Map;

@MyBatisDao(tableName = "dataware_betting_log_day")
public interface DatawareBettingLogDayDao extends CrudDao<DatawareBettingLogDay> {

    long getCountByTime(Map<String, Object> map);

    TcardDto getTcardBettingByday(Map<String, Object> params);

    List<Long> getBettingUserIds(Map<String, Object> params);

    DatawareFinalChannelInfoAll getBettingByDate(Map<String, Object> params);

    List<Long> getBettingUserIdByDate(Map<String, Object> params);

    int deleteByDate(Map<String, Object> params);

    List<Long> getBettingUserIdListByDate(Map<String, Object> bettingParams);

    DatawareBettingLogDay getInfoByUser(Map<String, Object> baseParam);

    Long getBettingCountByUser(Map<String, Object> baseParam);

    TcardDto getBettingByUserIdAndGameType(Map<String, Object> params);

    DatawareBettingLogDay getByUserIdAndGameType(Map<String,Object> params);

    DatawareBettingLogDay getBettingInfoByDate(Map<String, Object> bettingParam);

    List<Long> getBettingUserIdByDateRange(Map<String, Object> param);

    List<UserDetailsDto> getCMUserDetails(Map<String, Object> map);
}
