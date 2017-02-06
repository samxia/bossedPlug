CREATE PROCEDURE x_getExcludeCategoryByUser
@userName varchar(50)
--@returnValue varchar(50) output
AS

DECLARE @exCode varchar(50)
DECLARE My_Cursor CURSOR --定义游标
FOR
(
select exclude_category_code from
(x_user_role inner JOIN x_role_exclude_contacts ON x_user_role.role_id = x_role_exclude_contacts.role_id) 
			inner join sm_caozuoyuan on(sm_caozuoyuan.Id=x_user_role.user_id)
            WHERE (sm_caozuoyuan.caozuoyuan_xm =@userName)--'a'
)
OPEN My_Cursor; --打开游标
FETCH NEXT FROM My_Cursor INTO @exCode; --读取第一行数据(将MemberAccount表中的UserId放到@UserId变量中)
declare @tmp_table table
(
   kehulb_dm nvarchar(50)
)

WHILE @@FETCH_STATUS = 0
    BEGIN
        --PRINT @exCode; --打印数据(打印MemberAccount表中的UserId)
	    insert @tmp_table
	    select distinct kehulb_dm from kehu where kehulb_dm like @exCode+'%'
       -- UPDATE dbo.MemberService SET ServiceTime = DATEADD(Month, 6, getdate()) WHERE UserId = @UserId; --更新数据
        FETCH NEXT FROM My_Cursor INTO @exCode; --读取下一行数据(将MemberAccount表中的UserId放到@UserId变量中)
    END
CLOSE My_Cursor; --关闭游标
DEALLOCATE My_Cursor; --释放游标

select kehulb_dm from @tmp_table

GO
