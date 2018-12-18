SELECT DISTINCT
	u.realname AS nameList,
	u.username AS valueList
FROM
	t_s_role_user t,
	t_s_base_user u,
	t_s_role r
WHERE
  t.roleid = r.ID
  AND t.userid = u.ID
<#if manageType ?exists && manageType ?length gt 0>
	AND r.rolecode = :manageType
</#if>