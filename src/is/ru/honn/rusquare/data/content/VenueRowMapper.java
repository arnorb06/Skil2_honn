/**
 * @(#)Skil2_honn Nov 7, 2010 Thordur Arnarson
 *
 * Copyright (c) Thordur Arnarson
 */
package is.ru.honn.rusquare.data.content;

import is.ruframework.data.RuAbstractRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdom.Content;

/**
 * @author Thordur Arnarson
 * @version 1.0 Nov 7, 2010
 */
public class VenueRowMapper extends RuAbstractRowMapper{
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		Object venue = new VenueDTO(		rs.getInt(1), 		//id
										rs.getString(2), 	//name
										rs.getString(3), 	//street
										rs.getString(4),	//city
										rs.getString(5),	//country
										rs.getString(6),	//postalCode
										rs.getString(7),	//venuetype
										rs.getInt(8) 		//totalcheckins
										);
		add(venue);
		return venue;
	}

}
