/**
 * @(#)Skil2_honn Nov 6, 2010 Thordur Arnarson
 *
 * Copyright (c) Thordur Arnarson
 */
package is.ru.honn.rusquare.data.content;

import is.ruframework.data.RuGenericDataAccess;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

/**
 * @author Thordur Arnarson
 * @version 1.0 Nov 6, 2010
 */
public class VenueGateway extends RuGenericDataAccess implements DataGateway{
	public int add(ContentDTO cDTO) {
		SimpleJdbcInsert insertContent = new SimpleJdbcInsert(getDataSource()).withTableName("venues").usingGeneratedKeyColumns("id");
		Map<String, Object> parameters = new HashMap<String, Object>(7);
		parameters.put("name", ((VenueDTO) cDTO).getName());
		parameters.put("street", ((VenueDTO) cDTO).getStreet());
		parameters.put("city", ((VenueDTO) cDTO).getCity());
		parameters.put("country", ((VenueDTO) cDTO).getCountry());
		parameters.put("postalCode", ((VenueDTO) cDTO).getPostalCode());
		parameters.put("venuetype", ((VenueDTO) cDTO).getVenueType());
		parameters.put("totalcheckins", ((VenueDTO) cDTO).getTotalCheckins());
		return insertContent.executeAndReturnKey(parameters).intValue();

}

	/* (non-Javadoc)
	 * @see is.ru.honn.rusquare.data.content.DataGateway#getContent()
	 */
	@Override
	public List getContent() {
		JdbcTemplate jdbc = new JdbcTemplate(getDataSource());
		VenueRowMapper mapper = new VenueRowMapper(); 
		jdbc.query("select * from venues", mapper); 
		return mapper.getResults();
	}
	
	public VenueDTO getContentByName(String name) {
		JdbcTemplate jdbc = new JdbcTemplate(getDataSource());
		
		//work when there is a single instance of name, not when there are multiple entries with name
		return (VenueDTO)jdbc.queryForObject("select * from venues where name=" + name, new VenueRowMapper());
	}
	
	public VenueDTO getVenueIdByName(String venueName) {
		
		int retValue = 0;
		SimpleJdbcTemplate jdbc = new SimpleJdbcTemplate(getDataSource());
		
		return (VenueDTO)jdbc.queryForObject("SELECT * FROM venues WHERE name=?", new VenueRowMapper(), venueName);
	}

	/* (non-Javadoc)
	 * @see is.ru.honn.rusquare.data.content.DataGateway#getContentById(int)
	 */
	@Override
	public ContentDTO getContentById(int id) {
		SimpleJdbcTemplate jdbc = new SimpleJdbcTemplate(getDataSource());
		
		return (VenueDTO)jdbc.queryForObject("SELECT * FROM venues WHERE id=?", new VenueRowMapper(), id);
	}
	
	public int updateTotalCheckins(VenueDTO venueDTO) {
		SimpleJdbcInsert insertContent = new SimpleJdbcInsert(getDataSource()).withTableName("venues").usingGeneratedKeyColumns("id");
		SimpleJdbcTemplate jdbc = new SimpleJdbcTemplate(getDataSource());

		return jdbc.update("UPDATE venues SET totalCheckins=? WHERE id=?", new Object[] {venueDTO.getTotalCheckins(), venueDTO.getId()}); 
	}


	/* (non-Javadoc)
	 * @see is.ru.honn.rusquare.data.content.DataGateway#getUsersByVenueId(int)
	 */
	@Override
	public List getUsersByVenueId(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}