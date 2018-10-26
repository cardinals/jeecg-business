SELECT
	a.unit_code AS unitCode,
	a.ID AS businessId,
	a.project_name AS systemName,
	b.confirm_income AS projectCount
FROM
	t_b_business a
LEFT JOIN
	t_b_profit_target b
ON
	a.ID = b.business_id
WHERE
  1=1
/*<#if t.businessDate ?exists && t.businessDate ?length gt 0>
	and (a.finish_time like concat(trim(:t.businessDate),'%') OR b.sign_time like concat(trim(:t.businessDate),'%'))
</#if>*/
<#if t.businessDate_begin ?exists && t.businessDate_begin ?length gt 0>
AND (a.finish_time >= :t.businessDate_begin AND a.finish_time <= :t.businessDate_end OR b.sign_time >= :t.businessDate_begin AND b.sign_time <= :t.businessDate_end)
</#if>
<#if t.unitCode ?exists && t.unitCode ?length gt 0>
	and a.unit_code = :t.unitCode
</#if>
<#if t.systemName ?exists && t.systemName ?length gt 0>
	and a.project_name like concat('%',trim(:t.systemName),'%')
</#if>
ORDER BY a.unit_code