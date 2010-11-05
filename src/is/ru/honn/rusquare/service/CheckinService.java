package is.ru.honn.rusquare.service;

import is.ru.honn.rusquare.domain.Checkin;


public interface CheckinService
{
  public Checkin checkin(String username, String venuename);
}
