/*统计各个层的服务费用排名*/
select cc.name as nameList,
case when tt.sum1 is null then 0 else tt.sum1 end as valueList
from
(
select  c2.catalog_code,c2.name from  t_b_catalogdata c2 where length(c2.catalog_code)=8 and c2.catalog_code like :rootType
)as cc LEFT JOIN
(
select t.type1 ,sum(t.price*t.check_num) as  sum1
	from (
	select bc.*,c.name,c.type,substr(catalog_code ,1,8) type1,c.price,b.project_name,b.unit_code,b.unit_name,b.create_name
	from t_b_business b,t_b_catalogdata c,t_b_busi_catalog bc
	where b.id = bc.business_id and bc.catalog_id = c.id  and c.catalog_code like :rootType
	) t
	group by t.type1
)as tt
 on cc.catalog_code = tt.type1
order by valueList  desc
limit 0,8;