/**
 * @Skilaverkefni2 Nov 9, 2010 Arn—r Barkarson
 *
 * Copyright (c) Arn—r Barkarson
 */
package is.ru.honn.rusquare.data.content;

import java.sql.ResultSet;
import java.sql.SQLException;

import is.ruframework.data.RuAbstractRowMapper;

/**
 * @author Arn—r Barkarson
 *
 * @version 1.0, Nov 9, 2010
 */
public class UsernameMapper extends RuAbstractRowMapper {

	/* (non-Javadoc)
	 * @see is.ruframework.data.RuAbstractRowMapper#mapRow(java.sql.ResultSet, int)
	 */
	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			String name =rs.getString(1); //Username
			add(name);
			return name;
	}

}
