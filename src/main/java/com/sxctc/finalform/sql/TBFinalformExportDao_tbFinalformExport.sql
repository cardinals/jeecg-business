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
