/*触发器：
	1、新增事件文章（tb_event_article）数据时，事件源文章数（tb_source_article_num）新增1
*/
create Trigger t_afterinsert_on__tb_event_article_add1
after insert on tb_event_article
for each row
begin

	update tb_source_article_num sn set sn.num = num + 1 where sn.event_id = new.event_id and sn.table_id = new.table_id;
end;
/*触发器：
	2、删除事件文章（tb_event_article）数据时，事件源文章数（tb_source_article_num）减1
*/
create Trigger t_afterdelete_on__tb_event_article_delete1
after delete on tb_event_article
for each row
begin

	update tb_source_article_num sn set sn.num = num - 1 where sn.event_id = old.event_id and sn.table_id = old.table_id;
end;

/*删除触发器*/
/*
drop trigger t_afterinsert_on__tb_event_article_add1;
drop trigger t_afterdelete_on__tb_event_article_delete1;
*/