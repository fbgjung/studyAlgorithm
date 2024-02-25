select i.item_id, i.item_name
from item_info as i, item_tree as t
where i.item_id = t.item_id
and t.parent_item_id is null
order by item_id