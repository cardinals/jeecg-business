select DISTINCT u.realname as nameList ,u.username as valueList
from t_s_role_user t,t_s_base_user u,t_s_role r
where r.rolecode = 'manager' and t.roleid = r.ID and t.userid = u.ID ;