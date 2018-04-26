package com.avp.mems.backstage.repositories.report;

import com.avp.mems.backstage.entity.report.FaultDistributionLineWeek;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by Amber Wang on 2017-06-19 下午 03:51.
 */
public interface FaultDistributionLineWeekRepository extends PagingAndSortingRepository<FaultDistributionLineWeek, Integer> {

    FaultDistributionLineWeek findByWeekOfYearAndLocationId(@Param("weekOfYear") String weekOfYear, @Param("locationId") Integer locationId);

    Integer countByWeekOfYearAndLocationId(@Param("weekOfYear") String weekOfYear,@Param("locationId") Integer locationId);
}
