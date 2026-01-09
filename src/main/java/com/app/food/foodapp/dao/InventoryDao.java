package com.app.food.foodapp.dao;

import com.app.food.foodapp.model.Inventory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class InventoryDao {
    private JdbcTemplate jdbcTemplate;

    public InventoryDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Inventory inventory){
        jdbcTemplate.update("INSERT INTO " +
                        "inventory Values(?,?,?)",
                inventory.getId(),
                inventory.getName(),
                inventory.getPrice());
    }
    public void update(Inventory inventory){
        jdbcTemplate.update("UPDATE  inventory SET" +
                "name = ?,price= ? WHERE id = ? ",
                inventory.getName(),
                inventory.getPrice(),
                inventory.getId()
                );
    }
    RowMapper<Inventory> inventoryRowMapper = (rs,rowNum) ->{
        Inventory i = new Inventory();
        i.setId(rs.getInt("id"));
        i.setName(rs.getString("name"));
        i.setPrice(rs.getDouble("price"));
        return i;
    };
    public List<Inventory> findAll(int limit,int pageNo){
        return jdbcTemplate.query("SELECT * FROM inventory",inventoryRowMapper);
    }

    public void deleteById(int id){
        jdbcTemplate.update("DELETE FROM inventory WHERE id=?",id);
    }
    public Inventory findById(int id){
        return jdbcTemplate.queryForObject("SELECT * FROM inventory WHERE id=?",
                new Object[]{id},
                (rs,rowNum)->{
            Inventory inv = new Inventory();
            inv.setId(id);
            inv.setName(rs.getString("name"));
            inv.setPrice(rs.getDouble("price"));
            return inv;
        });
    }
}
