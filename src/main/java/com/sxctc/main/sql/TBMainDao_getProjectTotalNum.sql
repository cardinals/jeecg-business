select
  count(1)
from
  t_b_business t
where 1=1
<#if userName ?exists && userName ?length gt 0>
	and t.create_by = :userName
</#if>