select
  sum(project_server)
from
  t_b_chance_pool
where 1=1
  and winning_result = 0
<#if createBy ?exists && createBy ?length gt 0>
  and create_by = :createBy
</#if>