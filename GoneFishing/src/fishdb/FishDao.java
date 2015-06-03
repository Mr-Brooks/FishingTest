package fishdb;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.dao.DataAccessException;

import fish.FishAddress;
import fish.FishInfo;
import fish.Fish;

public class FishDao {
	private JdbcTemplate jdbcTemplate;
	

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
		this.jdbcTemplate = jdbcTemplate;
	}

	public int savePoliseaHolders(Fish g){
		FishInfo e = g.getFishInfo();
		FishAddress f = g.getFishAddress();
		String query="insert into poliseaholders values('"+e.getFirst()+"','"+
				e.getLast()+"','"+e.getAge()+ "" + f.getOcean()+ "" + f.getReef() +
				"" + f.getDepth() + "')";
		return jdbcTemplate.update(query);
	}
	/*public int updatePoliseaHolders(FishMain e){
		String query="update poliseaholders set ='"++"' ";
		return jdbcTemplate.update(query);
	}
	public int deletePoliseaHolders(FishMain e){
		String query="delete from poliseaholders where ='"++"' ";
		return jdbcTemplate.update(query);
	}*/
}
