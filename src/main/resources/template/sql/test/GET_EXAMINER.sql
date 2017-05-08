select
	T1.id			as id
	,T1.userid		as userid
	,T1.name		as examinerName
	,T1.companyid	as companyid
	,T1.title		as title
	,T1.status		as examinerStatus
	,T2.id			as companyid
	,T2.name		as companyName
	,T2.status		as companyStatus
from 
	examiner T1
left join 
	company T2
on
	T1.companyid = T2.id::varchar
where
        T1.status='Y'
and
        T2.status='Y'
