select t.create_name as nameList,sum(t.price*t.check_num) as  valueList
from (
select bc.*,c.name,c.type,c.price,b.project_name,b.unit_code,b.unit_name,b.create_name
from t_b_business b,t_b_catalogdata c,t_b_busi_catalog bc
where b.id = bc.business_id and bc.catalog_id = c.id
) t
group by t.create_name
order by   valueList  asc;