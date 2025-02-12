package com.wf.data.dao.datarepo;


import com.wf.core.persistence.CrudDao;
import com.wf.core.persistence.MyBatisDao;
import com.wf.data.dao.datarepo.entity.DatawareFinalChannelConversion;

import java.util.List;
import java.util.Map;

@MyBatisDao(tableName = "dataware_final_channel_conversion")
public interface DatawareFinalChannelConversionDao extends CrudDao<DatawareFinalChannelConversion> {

    long getCountByTime(Map<String, Object> map);

    List<DatawareFinalChannelConversion> getByChannelAndDate(Map<String, Object> params);

    int deleteByDate(Map<String, Object> map);
}
