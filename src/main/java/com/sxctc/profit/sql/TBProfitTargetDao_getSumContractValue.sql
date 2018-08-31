select
  sum(contract_value)
from
  t_b_profit_target
where 1=1
<#if createBy ?exists && createBy ?length gt 0>
  and create_by = :createBy
</#if>