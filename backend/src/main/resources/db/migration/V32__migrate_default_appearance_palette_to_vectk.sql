alter table platform_users
    alter column color_palette set default 'vectk';

alter table tenant_users
    alter column color_palette set default 'vectk';

update platform_users
set color_palette = 'vectk'
where color_palette not in ('vectk', 'terracotta', 'indigo');

update tenant_users
set color_palette = 'vectk'
where color_palette not in ('vectk', 'terracotta', 'indigo');
