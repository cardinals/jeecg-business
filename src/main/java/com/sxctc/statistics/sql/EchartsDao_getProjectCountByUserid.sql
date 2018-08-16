select
  count(1)
from
  t_b_business t
where 1=1
<#if id ?exists && id ?length gt 0>
	and t.create_by = :id
</#if>
<#if optFlag ?exists && optFlag ?length gt 0>
	and t.join_status = :optFlag
</#if>