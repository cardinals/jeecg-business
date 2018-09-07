select
CONCAT_WS(',',a,b,c,d,e,f,g)
from (
select
DATEDIFF(bus_join_time,bus_create_time) as a,
DATEDIFF(demand_time,bus_join_time) as b,
DATEDIFF(plan_time,demand_time) as c,
DATEDIFF(resource_time,plan_time) as d,
DATEDIFF(test_time,resource_time) as e,
DATEDIFF(protocol_time ,test_time) as f,
DATEDIFF(finish_time,protocol_time) as g
from t_b_business where id = :businessId
) t
