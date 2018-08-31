/*统计各个层的服务费用排名*/
select t.type as nameList,sum(t.price*t.check_num) as  valueList
from (
select bc.*,c.name,c.type,c.price,b.project_name,b.unit_code,b.unit_name,b.create_name
from t_b_business b,t_b_catalogdata c,t_b_busi_catalog bc
where b.id = bc.business_id and bc.catalog_id = c.id
) t
group by t.type
order by nameList  asc;