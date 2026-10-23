alter table platform_users
    alter column color_palette set default 'veckt';

alter table tenant_users
    alter column color_palette set default 'veckt';

update platform_users
set color_palette = 'veckt'
where color_palette not in ('veckt', 'terracotta', 'indigo');

update tenant_users
set color_palette = 'veckt'
where color_palette not in ('veckt', 'terracotta', 'indigo');
