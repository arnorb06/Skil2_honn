/**
 * @(#)Skil2_honn Nov 6, 2010 Thordur Arnarson
 *
 * Copyright (c) Thordur Arnarson
 */
package is.ru.honn.rusquare.data.content;

import java.util.List;

/**
 * @author Thordur Arnarson
 * @version 1.0 Nov 6, 2010
 */
public interface DataGateway {
	public int add(ContentDTO contentDTO);
	public List getContent();
	public ContentDTO getContentByName(String name);
	public ContentDTO getContentById(int id);
	public List getUsersByVenueId(int id);
}
