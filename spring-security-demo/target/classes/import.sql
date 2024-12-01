use springsecurity;
-- 插入用户信息
insert into `user`(`id`, `username`, `password`, `salt`, `gmt_create`, `gmt_modified`)
select
    NULL, 'admin', '$2a$10$SR0CEWNvXFUCOqc4i4w14uZVkZ0.kPQt12IXI3BnPv0/alv7AOBzK', '', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP
where not exists (
    select 1 from `user` where `username` = 'admin'
);

-- 插入权限信息
insert into `permission`(`id`, `name`, `gmt_create`, `gmt_modified`)
select
    NULL, 'user:list', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP
where not exists (
    select 1 from `permission` where `name` = 'user:list'
);

-- 插入角色信息
insert into `role`(`id`, `name`, `gmt_create`, `gmt_modified`)
select
    NULL, 'system', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP
where not exists (
    select 1 from `role` where `name` = 'system'
);

-- 关联用户和角色
with t as (
    select
        u.`id` as `user_id`, r.`id` as `role_id`
    from `user` u, `role` r
    where u.`username` = 'admin' and r.`name` = 'system'
)
insert into `user_role`(`id`, `user_id`, `role_id`, `gmt_create`, `gmt_modified`)
select
    NULL, `user_id`, `role_id`, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP
from t
where not exists (
    select 1 from `user_role` ur
    where ur.`user_id` = t.`user_id` and ur.`role_id` = t.`role_id`
);

-- 关联角色和权限
with t as (
    select
        r.`id` as `role_id`, p.`id` as `permission_id`
    from `permission` p, `role` r
    where p.`name` = 'user:list' and r.`name` = 'system'
)
insert into `role_permission`(`id`, `role_id`, `permission_id`, `gmt_create`, `gmt_modified`)
select
    NULL, `role_id`, `permission_id`, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP
from t
where not exists (
    select 1 from `role_permission` rp
    where rp.`role_id` = t.`role_id` and rp.`permission_id` = t.`permission_id`
);
