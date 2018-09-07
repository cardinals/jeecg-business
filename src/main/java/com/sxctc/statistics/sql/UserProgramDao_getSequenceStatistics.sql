select
CONCAT_WS(',',MIN(a),MIN(b),MIN(c),MIN(d),MIN(e),MIN(f),MIN(g),
avg(a),avg(b),avg(c),avg(d),avg(e),avg(f),avg(g),
max(a),max(b),max(c),max(d),max(e),max(f),max(g))
from (
select
DATEDIFF(bus_join_time,bus_create_time) as a,
DATEDIFF(demand_time,bus_join_time) as b,
DATEDIFF(plan_time,demand_time) as c,
DATEDIFF(resource_time,plan_time) as d,
DATEDIFF(test_time,resource_time) as e,
DATEDIFF(protocol_time ,test_time) as f,
DATEDIFF(finish_time,protocol_time) as g
from t_b_business where create_by = :userCode
) t
