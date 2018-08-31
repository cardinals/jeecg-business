select
  sum(profit_target)
from
  t_b_profit_target
where 1=1
<#if createBy ?exists && createBy ?length gt 0>
  and create_by = :createBy
</#if>