﻿select sum(station_id)/count(*) as a,sum(passenger_flow) as b,flow_timestamp from station_time_sharing_passenger_flow where station_id=114 and section=30 and flow_timestamp>='2017-05-01 00:00:00' and  flow_timestamp<='2017-05-01 23:59:59' group by flow_timestamp order by flow_timestamp asc