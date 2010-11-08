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

/**
 * @author Thordur Arnarson
 * @version 1.0 Nov 6, 2010
 */
public class CheckinGateway extends RuGenericDataAccess implements DataGateway {

	/* (non-Javadoc)
	 * @see is.ru.honn.rusquare.data.content.DataGateway#add()
	 */
	public int add(ContentDTO cDTO) {
		SimpleJdbcInsert insertContent = new SimpleJdbcInsert(getDataSource()).withTableName("checkin").usingGeneratedKeyColumns("id");
		Map<String, Object> parameters = new HashMap<String, Object>(4);
		parameters.put("title", ((CheckinDTO) cDTO).getTitle());
		parameters.put("checkinDate", ((CheckinDTO) cDTO).getCheckinDate());
		parameters.put("username", ((CheckinDTO) cDTO).getUsername());
		parameters.put("venueId", ((CheckinDTO) cDTO).getVenueId());
		return insertContent.executeAndReturnKey(parameters).intValue();

	}

	/* (non-Javadoc)
	 * @see is.ru.honn.rusquare.data.content.DataGateway#getContent()
	 */
	@Override
	public List getContent() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
		CheckinRowMapper mapper = new CheckinRowMapper();
		jdbcTemplate.query("select * from checkin", mapper);
		return mapper.getResults();
	}

	/* (non-Javadoc)
	 * @see is.ru.honn.rusquare.data.content.DataGateway#getContentByName()
	 */
	@Override
	public ContentDTO getContentByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
