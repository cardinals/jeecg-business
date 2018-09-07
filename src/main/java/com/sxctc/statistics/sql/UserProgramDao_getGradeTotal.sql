/*统计各个层的服务费用排名*/
select cc.type as nameList,
case when tt.sum1 is null then 0 else tt.sum1 end as valueList
from
(select DISTINCT type from t_b_catalogdata
)as cc LEFT JOIN
(	select t.type ,sum(t.price*t.check_num) as  sum1
	from (
	select bc.*,c.name,c.type,c.price,b.project_name,b.unit_code,b.unit_name,b.create_name
	from t_b_business b,t_b_catalogdata c,t_b_busi_catalog bc
	where b.id = bc.business_id and bc.catalog_id = c.id and b.create_by = :userCode
	) t
	group by t.type

)as tt
 on cc.type = tt.type
order by nameList  asc