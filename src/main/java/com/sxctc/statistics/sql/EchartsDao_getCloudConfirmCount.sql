SELECT
	aa.*,
	cc.price AS price
FROM
	(
SELECT
	a.id AS businessId,
	b.catalog_id AS catalogId,
	b.check_num AS checkNum
FROM
	t_b_business a
	LEFT JOIN t_b_busi_catalog b ON a.id = b.business_id
WHERE
	a.join_status IN ( 6, 7 )
	) aa
	LEFT JOIN t_b_catalogdata cc ON aa.catalogId = cc.id
