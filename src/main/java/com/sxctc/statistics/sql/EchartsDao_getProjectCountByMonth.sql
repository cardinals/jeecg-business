select
  count(1)
from
  t_b_business t
where 1=1
<#if id ?exists && id ?length gt 0>
	and t.create_by = :id
</#if>
<#if months ?exists && months ?length gt 0>
	and t.bus_join_time like concat(trim(:months),'%')
</#if>