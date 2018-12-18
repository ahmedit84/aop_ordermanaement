package com.learning.aop.repository;

import com.learning.aop.model.Order;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;



@Repository
public class OrderRepositoryImpl implements OrderRepository {
	private JdbcTemplate template;
	private RowMapper<Order> rowMapper = new OrderRowMapper();
	private static final String SEARCH = "select * from orders where orderId = ?";
	
	
	public OrderRepositoryImpl() {}
	
	public OrderRepositoryImpl(DataSource dataSource) {
		this.template = new JdbcTemplate(dataSource);
	}
	
	public Order getOrder(int id) {
		return template.queryForObject(SEARCH, rowMapper, id);
	}
        
        public List<Order> allOrder() {
		return template.query("select * from orders ", rowMapper);
	}
        
        @Override
        public void saveOrder(Order order){
            template.update("INSERT INTO orders values(?,?,?)",order.getOrderId(),order.getDescription(),order.getCustomerId());
        }
	
	private class OrderRowMapper implements RowMapper<Order> {
		public Order mapRow(ResultSet rs, int i) throws SQLException {
			Order order = new Order();
			order.setOrderId(rs.getInt("orderId"));
			order.setDescription(rs.getString("description"));
			order.setCustomerId(rs.getInt("customerId"));
			return order;
		}
	}
}
