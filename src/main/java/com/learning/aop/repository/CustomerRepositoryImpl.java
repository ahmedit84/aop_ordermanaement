package com.learning.aop.repository;

import com.learning.aop.model.Customers;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;



@Repository
public class CustomerRepositoryImpl implements CustomerRepository {
	private JdbcTemplate template;
	private RowMapper<Customers> rowMapper = new ClientRowMapper();
	private static final String SEARCH = "select * from customers where customerId = ?";
	
	public CustomerRepositoryImpl() {}
	
	public CustomerRepositoryImpl(DataSource dataSource) {
		this.template = new JdbcTemplate(dataSource);
	}
	
	public Customers getClient(int id) {
		return template.queryForObject(SEARCH, rowMapper, id);
	}
        
        public List<Customers> getAllCustomer() {
		return template.query("select * from customers", rowMapper);
	}
        
        public void addCustomer(Customers customer){
            template.update("INSERT INTO customers values(?,?)",customer.getCustomersId(),customer.getName());
        }
	
	private class ClientRowMapper implements RowMapper<Customers> {
		public Customers mapRow(ResultSet rs, int i) throws SQLException {
			Customers client = new Customers();
			client.setCustomersId(rs.getInt("customerId"));
			client.setName(rs.getString("name"));
			
			return client;
		}
	}
}
