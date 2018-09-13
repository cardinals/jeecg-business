SELECT
	a.check_num AS checkNum,
	b.price
FROM
	t_b_busi_catalog a
LEFT JOIN t_b_catalogdata b ON a.catalog_id = b.id
LEFT JOIN t_b_business c ON a.business_id = c.id
WHERE
	c.join_status IN (6,7)