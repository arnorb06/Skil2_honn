package is.ru.honn.rusquare.service;

import is.ru.honn.rusquare.data.content.VenueDTO;

import java.util.Collection;


public interface VenueService
{
  public void addNewVenue(VenueDTO venue, String username);  
  public Collection getVenues();
  public VenueDTO getVenue(String name);
}
