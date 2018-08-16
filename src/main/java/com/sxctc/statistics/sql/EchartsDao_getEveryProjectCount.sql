SELECT
	create_name as createName,
	COUNT( 1 ) as projectCount
FROM
	t_b_business
GROUP BY
	create_by